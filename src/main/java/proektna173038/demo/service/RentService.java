package proektna173038.demo.service;


import proektna173038.demo.model.Rent;

import java.util.List;

public interface RentService {
    //CRUD
    void save(Rent rent);

    List<Rent> getall();

    Rent getByID(Long id);

    void update(Long id,Rent rent);

    void deleteByID(Long id);
}
