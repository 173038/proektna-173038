package proektna173038.demo.service;

import proektna173038.demo.model.Cars;

import java.util.List;


public interface CarsService {
    //CRUD create read update delete
    void save(Cars cars);

    //List<Cars> getallCars();
    List<Cars> getallCars();

    Cars getCarByID(Long id);

    void update(Long id,Cars car);

    void deleteByID(Long id);
}
