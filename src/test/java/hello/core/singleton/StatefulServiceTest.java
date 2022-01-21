package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문***

//        statefulService1.order("userA",10000);//공유
        int userAPrice = statefulService1.order("userA",10000);//지역변수사용

        //ThreadB: B사용자 20000원 주문***

        int userBPrice = statefulService1.order("userB",20000);

        //ThreadA: 사용자A 주문 금액 조회***
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
        System.out.println("price = " + userAPrice);
    }

    static  class TestConfig{
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}