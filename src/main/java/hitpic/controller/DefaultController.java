package hitpic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tonisala on 10.12.2016.
 */
@Controller
public class DefaultController {

    @RequestMapping(value = "*")
    @ResponseBody
    public String handleDefault() {
        return "Hello World!";
    }
}
