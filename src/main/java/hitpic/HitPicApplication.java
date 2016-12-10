package hitpic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HitPicApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles(System.getenv("PROFILE"));
        if (System.getenv("SPRING_PROFILES_ACTIVE") != null) {
            context.getEnvironment().setActiveProfiles(System.getenv("SPRING_PROFILES_ACTIVE"));
        }
        SpringApplication.run(HitPicApplication.class, args);
    }
}
