package foo.bar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import foo.bar.Config.SpringConfig;

public class HelloApp {
    public static void main(String[] args) {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	context.register(SpringConfig.class);
    	context.refresh();
        System.out.println("Computer");
        Computer computer = context.getBean(Computer.class);
        System.out.println(computer);
        
        System.out.println();
        System.out.println("Smartphone");
        Smartphone smartphone = (Smartphone)context.getBean(Smartphone.class);
        System.out.println(smartphone);
        
        System.out.println();
        Notebook notebook = context.getBean(Notebook.class);
        notebook.getGraphics("Radeon HD 6470M x64" , "Radeon HD 6520G");
        
        
    }
}
