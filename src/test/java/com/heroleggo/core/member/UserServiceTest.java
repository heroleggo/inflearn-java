package com.heroleggo.core.member;

import com.heroleggo.core.user.entity.Type;
import com.heroleggo.core.user.entity.User;
import com.heroleggo.core.user.service.UserService;
import com.heroleggo.core.user.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    void joinTest() {
        // given
        User user = new User(1L, "A", Type.VIP);
        // when
        userService.join(user);
        User found = userService.findUser(1L);

        // then
        Assertions.assertThat(user).isEqualTo(found);
    }
}
