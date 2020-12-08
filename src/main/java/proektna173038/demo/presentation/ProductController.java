package proektna173038.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import proektna173038.demo.model.Cars;
import proektna173038.demo.model.Manufacturer;
import proektna173038.demo.service.CarsService;
import proektna173038.demo.service.ManufacturerService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    CarsService carsService;
    ManufacturerService manufacturerService;

    @Autowired
    public ProductController(CarsService carsService,ManufacturerService manufacturerService) {
        this.carsService = carsService;
        this.manufacturerService=manufacturerService;
    }


    @GetMapping
    public String getProductPage(Model model){
        List<Cars> carsList=carsService.getallCars();
        model.addAttribute("cars",carsList);
        return "productIndex";
    }
    @GetMapping("/product")
    List<Cars> getAll(){
        return carsService.getallCars();
    }

    @GetMapping("/product/{id}")
    Cars getById(@PathVariable Long id){
        return carsService.getCarByID(id);
    }

    @GetMapping("/add-new")
    public String addNewProductPage(Model model) {
        List<Cars> cars = this.carsService.getallCars();
        List<Manufacturer> manufacturerList=this.manufacturerService.getall();
        model.addAttribute("cars",  cars);
        model.addAttribute("manufacturers", manufacturerList);
        model.addAttribute( "newCar", new Cars());

        return "product";
    }

    @PostMapping
    public String saveProduct(Cars cars) {

        this.carsService.save(cars);

        return "redirect:/product";
    }


}
