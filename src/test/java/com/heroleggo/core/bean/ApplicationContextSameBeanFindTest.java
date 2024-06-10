package com.heroleggo.core.bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.heroleggo.core.config.AppConfig;
import com.heroleggo.core.user.repository.MemoryUserRepository;
import com.heroleggo.core.user.repository.UserRepository;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 둘 이상의 빈이 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(UserRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 둘 이상의 빈이 있으면, 빈 이름을 지정")
    void findBeanByName() {
        UserRepository userRepository = ac.getBean("userRepository1", UserRepository.class);
        assertThat(userRepository).isInstanceOf(UserRepository.class);
    }

    @Test
    @DisplayName("타입으로 모두 조회")
    void findAllBeanByType() {
        Map<String, UserRepository> beansOfType = ac.getBeansOfType(UserRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public UserRepository userRepository1() {
            return new MemoryUserRepository();
        }

        @Bean
        public UserRepository userRepository2() {
            return new MemoryUserRepository();
        }
    }
}
