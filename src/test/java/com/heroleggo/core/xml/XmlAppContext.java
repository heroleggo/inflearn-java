package com.heroleggo.core.xml;

import static org.assertj.core.api.Assertions.*;

import com.heroleggo.core.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        assertThat(userService).isInstanceOf(UserService.class);
    }

}
