package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AutowiredLab2 implements InitializingBean, DisposableBean {
    public AutowiredLab2() {
        System.out.println(2);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("AutowiredLab2.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AutowiredLab2.afterPropertiesSet");
    }
}
