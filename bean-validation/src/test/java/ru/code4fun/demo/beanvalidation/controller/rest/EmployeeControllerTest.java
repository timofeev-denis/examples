package ru.code4fun.demo.beanvalidation.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.code4fun.demo.beanvalidation.dto.EmployeeDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
@DisplayName("Тестирование контроллера работы с сотрудниками")
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;
    private static ObjectMapper mapper;

    @BeforeAll
    static void setUp() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(df);
    }

    @Test
    @DisplayName("Добавление (позитивный сценарий)")
    void add() throws Exception {
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(buildValidEmployeeDto())))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Добавление. Имя должно быть заполнено")
    void addWithEmptyName() throws Exception {
        MvcResult response = mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{}"))
                .andExpect(status().isBadRequest())
                .andReturn();

        String message = requireNonNull(response.getResolvedException(), "Не получено сообщение от контроллера").getMessage();
        assertTrue(message.contains("default message [name]"));
        assertTrue(message.contains("default message [Необходимо указать имя]"));
    }

    @Test
    @DisplayName("Добавление. Email должен быть валидным")
    void addWithInvalidEmail() throws Exception {
        EmployeeDto employee = buildValidEmployeeDto();
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

    @Test
    @DisplayName("Добавление. Дата приёма на работу не должна быть больше текущей")
    void addWithHireDateInTheFuture() throws Exception {
        EmployeeDto employee = buildValidEmployeeDto();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        employee.setHireDate(calendar.getTime());

        MvcResult response = mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andReturn();

        String message = requireNonNull(response.getResolvedException(), "Не получено сообщение от контроллера").getMessage();
        assertTrue(message.contains("default message [hireDate]"));
        assertTrue(message.contains("default message [Дата приёма на работу не должна быть больше текущей]"));
    }

    @Test
    @DisplayName("Принудительная валидация находит ошибку")
    void manualValidationTest() {
        EmployeeDto emp = new EmployeeDto(null, "email@server.com", null, null);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<EmployeeDto>> violations = validator.validate(emp);

        ConstraintViolation<EmployeeDto> violation = violations.stream().findFirst().orElseThrow(() -> new RuntimeException(""));
        assertEquals("name", violation.getPropertyPath().toString());
        assertEquals("Необходимо указать имя", violation.getMessageTemplate());
    }

    /**
     * Подготовка валидного ДТО сотрудника
     */
    private EmployeeDto buildValidEmployeeDto() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.roll(Calendar.YEAR, -2);
        return EmployeeDto.builder().name("Вася Пупкин").email("vasya@server.com").phone("+79990000000").hireDate(calendar.getTime()).build();
    }
}
