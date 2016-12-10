package hitpic.controller;

import hitpic.domain.Account;
import hitpic.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (userDetailsRepository.findByUsername("maxwell") != null) {
            return;
        }

        Account user = new Account();
        user.setUsername("maxwell");
        user.setPassword(passwordEncoder.encode("smart"));

        user = userDetailsRepository.save(user);

    }
    @ResponseBody
    @RequestMapping("*")
    public String handleDefault() {
        return "Hello World!";
    }
}
