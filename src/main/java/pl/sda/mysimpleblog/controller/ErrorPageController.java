package pl.sda.mysimpleblog.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController implements ErrorController {
    @Override
    public String getErrorPath() {
        return null;
    }

    @GetMapping("/error")
    public String errorPage (Model model){
        model.addAttribute("info", "Nie ma takego adresu");
        return "error";
    }

    @GetMapping("/errorLogin")
    public String errorLogin (Model model){
        model.addAttribute("info", "Nie ma takego Loginu");
        return "error";
    }
}
