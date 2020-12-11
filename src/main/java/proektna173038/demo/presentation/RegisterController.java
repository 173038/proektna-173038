package proektna173038.demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proektna173038.demo.model.Cars;
import proektna173038.demo.model.Customer;
import proektna173038.demo.model.exceptions.InvalidUserCredentialsException;
import proektna173038.demo.service.CustomerService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private CustomerService customerService;

    @GetMapping
    public String getRegisterPage(){
        return "register";
    }
   /* @PostMapping
    public String saveProduct(Cars cars) {

        this.carsService.save(cars);

        return "redirect:/product";
    } */
/*
    @PostMapping
    public String saveCustomer(Customer customer){

        this.customerService.save(customer);

        return "redirect:/login";
    } */
    @PostMapping
    public String register(HttpServletRequest request, Model model){
        Customer customer = null;
        try {
            customer=this.customerService.register(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("customer", customer);
            return "redirect:/product";
        }
        catch (InvalidUserCredentialsException exception){
            return "register";
        }
    }


}
