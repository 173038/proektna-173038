package proektna173038.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proektna173038.demo.model.Cars;
import proektna173038.demo.model.Manufacturer;
import proektna173038.demo.service.CarsService;

import java.util.List;


@Controller
@RequestMapping
public class HomeController {

    CarsService carsService;

    @Autowired
    public HomeController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    public String indexPage(Model model) {
        List<Cars> carsList=carsService.getallCars();
        model.addAttribute("cars",carsList);
        return "index";
    }


}