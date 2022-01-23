package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService ;
    OrderService orderService ;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() {
        Long memberId = 1L;//Long을 사용하는 이유 NULL이 들어갈수있다 long은 안된다 . 이후에 db사용 가능하기때문
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    /*@Test
    @DisplayName("필드주입일때의 테스트")
    void fieldInjectionTest() {
        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1L, "itemA", 10000);//필드주입시에는 이처럼 NullPointerException이 발생한다. 테스트 하기 어려움 최근에는 사용안한다.
        org.junit.jupiter.api.Assertions.assertThrows(NullPointerException.class,
                () -> orderService.createOrder(1L, "itemA", 10000));

    }*/
}
