package proektna173038.demo.service;

import proektna173038.demo.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    //CRUD
    void save(Manufacturer manufacturer);

    List<Manufacturer> getall();

    Manufacturer getByID(Long id);

    void update(Long id,Manufacturer manufacturer);

    void deleteByID(Long id);
}
