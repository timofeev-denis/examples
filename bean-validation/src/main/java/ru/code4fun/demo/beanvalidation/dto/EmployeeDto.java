package ru.code4fun.demo.beanvalidation.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * Created by: Denis Timofeev
 * Date: 01.09.2019
 */

@Data
@Builder
public class EmployeeDto {

    @NotBlank(message = "Имя является обязательным полем")
    private String name;

    @NotBlank(message = "Email является обязательным полем")
    @Email(message = "Email должен быть корректным адресом электронной почты")
    private String email;

    @NotBlank(message = "Телефон является обязательным полем")
    @Pattern(regexp = "\\+7[0-9]{10}", message = "Телефонный номер должен начинаться с +7, затем - 10 цифр")
    private String phone;

    @NotNull(message = "Возраст является обязательным полем")
    @Min(value = 18, message = "Возраст сотрудника не должен быть меньше 18 лет")
    private Integer age;
}
