package com.heroleggo.core.bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.heroleggo.core.order.service.DiscountService;
import com.heroleggo.core.order.service.RateDiscountService;
import com.heroleggo.core.order.service.TemporaryDiscountService;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextExtendsTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회, 자식이 둘 이상 있으면 중복 오류 발생")
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountService.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회, 자식이 둘 이상 있을 때 빈 이름 지정시 오류 미발생")
    void findBeanByParentTypeBeanName() {
        DiscountService discountService = ac.getBean("rateService", DiscountService.class);
        assertThat(discountService).isInstanceOf(RateDiscountService.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        RateDiscountService bean = ac.getBean(RateDiscountService.class);
        assertThat(bean).isInstanceOf(RateDiscountService.class);
    }

    @Test
    @DisplayName("부모 타입으로 전부 조회")
    void findAllBeanByParentType() {
        Map<String, DiscountService> beansOfType = ac.getBeansOfType(DiscountService.class);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회 - Object 사용")
    void findAllBeanByObject() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }


    @Configuration
    static class TestConfig {
        @Bean
        public DiscountService rateService() {
            return new RateDiscountService();
        }

        @Bean
        public DiscountService fixService() {
            return new TemporaryDiscountService();
        }
    }
}
