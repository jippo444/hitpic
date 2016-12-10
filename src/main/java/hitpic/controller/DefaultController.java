package hitpic.controller;

import hitpic.domain.Account;
import hitpic.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
public class DefaultController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository userDetailsRepository;

    @PostConstruct
    public void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        if (userDetailsRepository.findByUsername("maxwell") != null) {
            return;
        }
        String activeProfile = "none";
        if (System.getenv("SPRING_PROFILES_ACTIVE") != null) {
            activeProfile = System.getenv("SPRING_PROFILES_ACTIVE");
        }
        if (activeProfile.equals("production")) {
            Account user = new Account();
            user.setUsername("reino");
            user.setPassword(passwordEncoder.encode("huopatossu"));

            user = userDetailsRepository.save(user);
        } else {
            Account user2 = new Account();
            user2.setUsername("maxwell");
            user2.setPassword(passwordEncoder.encode("smart"));
            user2 = userDetailsRepository.save(user2);
        }
        System.out.println(userDetailsRepository.findAll());

    }


    @RequestMapping("*")
    public String handleDefault() {
        return "index";
    }
}
