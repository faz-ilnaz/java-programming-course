package foo.bar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        
        System.out.println("Computer");
        Computer computer = context.getBean(Computer.class);
        System.out.println(computer);
        
        System.out.println();
        System.out.println("Smartphone");
        Smartphone smartphone = (Smartphone)context.getBean("nexus_4");
        System.out.println(smartphone);
        
        
    }
}
