package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는별도의 설정 클래스를 만들자
@Configuration//Configuration이 없으면 CGLIB이 아닌 순수 자바코드로 돌아서 싱글톤깨진다.
public class  AppConfig {
    /*public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
        }

       public OrderService orderService() {
         return new OrderServiceImpl(
         new MemoryMemberRepository(),
         new FixDiscountPolicy());
       }*/
    //cnt alt m 으로 리펙토링 해준다
    //new MemoryMemberRepository() 이 부분이 중복 제거되었다. 이제 MemoryMemberRepository 를 다른 구현체로 변경할 때 한 부분만 변경하면 된다.
    //AppConfig 를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다.
    @Bean//스프링컨테이너에 등록된다
    public MemberService memberService() {
//        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
//        System.out.println("callAppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //싱글톤이 깨지나?

}
