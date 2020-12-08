package proektna173038.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proektna173038.demo.model.Cars;
import proektna173038.demo.repository.CarsRepository;
import proektna173038.demo.service.CarsService;

import java.util.List;

@Service
public class CarServiceImpl implements CarsService {

    CarsRepository carsRepository;

    @Autowired
    public CarServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public void save(Cars cars) {
        carsRepository.save(cars);
    }

    @Override
    public List<Cars> getallCars() {
        return carsRepository.findAll();
    }

    @Override
    public Cars getCarByID(Long id) {
        return carsRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id,Cars car) {
        Cars cars=this.getCarByID(id);
        cars.setAvailable(car.getAvailable());
        cars.setChassisNo(car.getChassisNo());
        cars.setPrice(car.getPrice());
        cars.setRegisterNo(car.getRegisterNo());
        cars.setType(car.getType());

        this.save(cars);
    }

    @Override
    public void deleteByID(Long id) {
        this.carsRepository.deleteById(id);

    }
}
