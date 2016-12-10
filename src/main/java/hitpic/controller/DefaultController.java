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
import java.util.Arrays;

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
            user.setPassword("$2a$10$3fT4VDT7t7N4bUtdajXa4ekC6NzAj9EO/08u920sR66wDFonlV.au");
            user.setAuthorities(Arrays.asList("ADMIN"));
            user = userDetailsRepository.save(user);

            Account user2 = new Account();
            user2.setUsername("maxwell");
            user2.setPassword(passwordEncoder.encode("smart"));
            user.setAuthorities(Arrays.asList("USER"));
            user2 = userDetailsRepository.save(user2);
        } else {
            Account user = new Account();
            user.setUsername("reino");
            user.setPassword(passwordEncoder.encode("huopatossu"));
            user.setAuthorities(Arrays.asList("ADMIN"));
            user = userDetailsRepository.save(user);

            Account user2 = new Account();
            user2.setUsername("maxwell");
            user2.setPassword(passwordEncoder.encode("smart"));
            user2.setAuthorities(Arrays.asList("USER"));
            user2 = userDetailsRepository.save(user2);
        }
        for (Account account : userDetailsRepository.findAll()) {
            System.out.println("Username: " + account.getUsername());
            System.out.println("Password: " + account.getPassword());
            System.out.println("Authorities: " + account.getAuthorities().toString());
        }


    }

    @RequestMapping("*")
    public String handleDefault() {
        return "redirect:/index";
    }
}
