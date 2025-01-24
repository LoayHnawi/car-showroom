package cars.service;

import cars.home.*;
import cars.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;
@Service
public class SellService {

    @Autowired
    private SellRepository sellRepository;

    private static final Logger logger = Logger.getLogger(SellService.class.getName());

    public Sell saveSell(Sell sell) {
        return sellRepository.save(sell);

    }

    public Iterable<Sell> findCarsSell()
    {
        return sellRepository.findAll();
    }

    public void deleteCarSell(Integer id) {
        Sell sell = sellRepository.getOne(id);
        sellRepository.deleteById(id);
        logger.log(Level.INFO,"Deleting : "+sell.getName()+" Car From The Sold List of Cars ");
    }

}
