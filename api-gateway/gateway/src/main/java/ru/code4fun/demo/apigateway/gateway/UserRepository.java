package ru.code4fun.demo.apigateway.gateway;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository /* extends JpaRepository<User, Long> */ {

    /**
     * Фиктивный метод, который всегда возвращает true.
     * В реальности нужно проверить наличие в БД записи о пользователе с указанным телефонным номером
     *
     * @param phoneNumber Номер телефона пользователя
     * @return true, если пользователь найден, иначе - false
     */
    public boolean isExistsByPhoneNumber(String phoneNumber) {
        return true;
    }
}
