package proektna173038.demo.presentation;
//
//
//import org.apache.catalina.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import proektna173038.demo.service.AuthService;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//
//    private final AuthService authService;
//
//    public LoginController(AuthService authService) {
//        this.authService = authService;
//    }
//
//
//
//    @GetMapping
//    public String getLoginPage() {
//        return "login";
//    }
//
//    @PostMapping
//    public String login(HttpServletRequest request, Model model) {
//        User user = null;
//        try{
//            user = this.authService.login(request.getParameter("username"),
//                    request.getParameter("password"));
//            request.getSession().setAttribute("user", user);
//            return "redirect:/home";
//        }
//        catch (InvalidUserCredentialsException exception) {
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", exception.getMessage());
//            return "login";
//        }
//    }
//}

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proektna173038.demo.model.Customer;
import proektna173038.demo.model.exceptions.InvalidUserCredentialsException;
import proektna173038.demo.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController{

    private final CustomerService customerService;

    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model){
        Optional<Customer> customer;
        try{
            customer=this.customerService.login(request.getParameter("id"),
                    request.getParameter("name"));
            request.getSession().setAttribute("customer", customer);
            return "redirect:/product";
        }
        catch(InvalidUserCredentialsException exception){
            return "login";
        }
    }
}