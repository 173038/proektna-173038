package proektna173038.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proektna173038.demo.model.Manufacturer;
import proektna173038.demo.repository.ManufacturerRepository;
import proektna173038.demo.service.ManufacturerService;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public void save(Manufacturer manufacturer) {
        this.manufacturerRepository.save(manufacturer);
    }

    @Override
    public List<Manufacturer> getall() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getByID(Long id) {
        return this.manufacturerRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id,Manufacturer manufacturer) {
        Manufacturer pomManufacturer=this.getByID(id);

        pomManufacturer.setAddress(manufacturer.getAddress());
        pomManufacturer.setName(manufacturer.getName());

        this.save(pomManufacturer);
    }

    @Override
    public void deleteByID(Long id) {
        this.manufacturerRepository.deleteById(id);
    }
}
