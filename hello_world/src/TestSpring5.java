import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void testHello(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        HelloWorld hello = context.getBean("hello", HelloWorld.class);
        hello.hello();
    }
}
