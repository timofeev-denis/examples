package ru.code4fun.demo.beanvalidation.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.code4fun.demo.beanvalidation.dto.EmployeeDto;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
@DisplayName("Тестирование контроллера работы с сотрудниками")
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Добавление (позитивный сценарий)")
    void add() throws Exception {
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(buildEmployee())))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Добавление. Имя должно быть заполнено")
    void addWithEmptyName() throws Exception {
        EmployeeDto employee = buildEmployee();
        employee.setName(null); // Пустое имя

        MvcResult response = mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andReturn();

        String x = null;
        String message = requireNonNull(response.getResolvedException(), "Не получено сообщение от контроллера").getMessage();
        assertTrue(message.contains("default message [name]"));
        assertTrue(message.contains("default message [Имя является обязательным полем]"));
    }

    @Test
    @DisplayName("Добавление. Email должен быть валидным")
    void addWithInvalidEmail() throws Exception {
        EmployeeDto employee = buildEmployee();
        employee.setEmail("vasyapupkin.com"); // Невалидный email

        MvcResult response = mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andReturn();

        String message = requireNonNull(response.getResolvedException(), "Не получено сообщение от контроллера").getMessage();
        assertTrue(message.contains("default message [email]"));
        assertTrue(message.contains("default message [Email должен быть корректным адресом электронной почты]"));
    }

    /**
     * Подготовка валидного ДТО сотрудника
     */
    private EmployeeDto buildEmployee() {
        return EmployeeDto.builder().name("Вася Пупкин").email("vasya@server.com").phone("+79990000000").age(20).build();
    }
}
