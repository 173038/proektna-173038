package proektna173038.demo.service.impl;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proektna173038.demo.model.Rent;
import proektna173038.demo.repository.RentRepository;
import proektna173038.demo.service.RentService;

import java.util.List;
@Service
public class RentServiceImpl implements RentService {

    RentRepository rentRepository;

    @Autowired
    public RentServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public void save(Rent rent) {
        this.rentRepository.save(rent);
    }

    @Override
    public List<Rent> getall() {
        return this.rentRepository.findAll();
    }

    @Override
    public Rent getByID(Long id) {
        return this.rentRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id,Rent rent) {
        Rent pomRent =this.getByID(id);

        pomRent.setIssue(rent.getIssue());
        pomRent.setRentDate(rent.getRentDate());
        pomRent.setReturDate(rent.getReturDate());

        this.save(pomRent);
    }

    @Override
    public void deleteByID(Long id) {
        this.rentRepository.deleteById(id);
    }
}
