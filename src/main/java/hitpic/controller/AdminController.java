package hitpic.controller;

import hitpic.domain.Account;
import hitpic.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.GET)

    public String showUsers(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        System.out.println("Trying to fetch user details");

        return "userlist";
    }
}
