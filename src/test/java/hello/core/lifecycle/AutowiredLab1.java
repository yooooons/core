package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AutowiredLab1 implements InitializingBean, DisposableBean {
    public AutowiredLab1() {
        System.out.println(1);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("AutowiredLab1.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AutowiredLab1.afterPropertiesSet");
    }
}
