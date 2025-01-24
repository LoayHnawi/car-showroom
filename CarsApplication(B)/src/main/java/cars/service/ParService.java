package cars.service;

import cars.home.Parameter;
import cars.repository.ParRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParService {

    @Autowired
    private ParRepository parRepository;

    @Cacheable(value = "Parameter", key = "'Parameter'+#keyPar+'_'+#value")
    public Iterable<Parameter> findAllPar()
    {
        return parRepository.findAll();
    }

    @Cacheable(value = "Parameter", key = "'Parameter'+#id")
    public Optional<Parameter> findPar(Integer id) throws InterruptedException {
        Thread.sleep(1000);
        return parRepository.findById(id);
    }

    @Cacheable(value = "Parameter", key = "'Parameter'+#parameter")
    public Parameter savePar(Parameter parameter) throws InterruptedException {
        Thread.sleep(1000);
        return parRepository.save(parameter);
    }

    @Cacheable(value = "Parameter", key = "'Parameter'+#id")
    public void deleteParCar(Integer id) throws InterruptedException {
        Thread.sleep(1000);
        parRepository.deleteById(id);
    }

}
