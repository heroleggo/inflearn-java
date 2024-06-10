package com.heroleggo.core.bean;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.heroleggo.core.config.AppConfig;
import com.heroleggo.core.user.service.UserService;
import com.heroleggo.core.user.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        UserService userService = ac.getBean("userService", UserService.class);
        Assertions.assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType() {
        UserService userService = ac.getBean(UserService.class);
        Assertions.assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회") // 구체 타입 -> 유연성 감소
    void findBeanByName2() {
        UserService userService = ac.getBean("userService", UserServiceImpl.class);
        Assertions.assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 불가")
    void findBeanByNameX() {
//        UserService notFound = ac.getBean("xxxxx", UserService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
            () -> ac.getBean("xxxxx", UserService.class));
    }
}
