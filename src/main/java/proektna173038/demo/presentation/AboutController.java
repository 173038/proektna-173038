
package proektna173038.demo.presentation;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proektna173038.demo.repository.RentRepository;

@Controller
@RequestMapping("/aboutus")
public class AboutController {
    
    RentRepository rentRepository;


    @GetMapping
    public String getAboutUs(){
        return "aboutus";
    }
}
