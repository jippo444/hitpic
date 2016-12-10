package hitpic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tonisala on 10.12.2016.
 */
@SpringBootApplication
@ComponentScan
public class HitPicApplication {

    public static void main(String[] args) {
        SpringApplication.run(HitPicApplication.class, args);
    }
}
