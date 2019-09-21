package ru.code4fun.demo.beanvalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class EmployeeDto {

    @NotBlank(message = "Необходимо указать имя")
    private String name;

    @Email(message = "Email должен быть корректным адресом электронной почты")
    private String email;

    @Pattern(regexp = "\\+7[0-9]{10}", message = "Телефонный номер должен начинаться с +7, затем - 10 цифр")
    private String phone;

    @Past(message = "Дата приёма на работу не должна быть больше текущей")
    private Date hireDate;
}
