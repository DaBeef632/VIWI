package org.perscholas.viwi.services;


import org.perscholas.viwi.DAO.BottleRepository;
import org.perscholas.viwi.DAO.UserRepository;
import org.perscholas.viwi.models.Bottle;
import org.perscholas.viwi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BottleService {
    private final BottleRepository bottleRepository;

    @Autowired
    public BottleService(BottleRepository bottleRepository){
        this.bottleRepository = bottleRepository;
    }
    @GetMapping
    public List<Bottle> getBottles() {
        return bottleRepository.findAll();
    }

    public void addNewBottle(Bottle bottle) {
        Optional<Bottle> bottleOptional = bottleRepository.findBottleById(bottle.getBottleId());
        if (bottleOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        bottleRepository.save(bottle);
    }

    public void deleteBottle(Long bottleId) {
        boolean exists = bottleRepository.existsById(bottleId);
        if (!exists){
            throw new IllegalStateException(
                    "bottle with id " + bottleId + " does not exist"
            );
        }
        bottleRepository.deleteById(bottleId);
    }

    @Transactional
    public void updateBottle(Long bottleId, String bottleName, float currentPrice) {
        Bottle bottle = bottleRepository.findById(bottleId).orElseThrow(()-> new IllegalStateException(
                "bottle with id " + bottleId + " does not exist"
        ));

        if (bottleName != null && bottleName.length() > 0 && !Objects.equals(bottle.getBottleName(), bottleName)){
            bottle.setBottleName(bottleName);
        }

        if (currentPrice > 0 && !Objects.equals(bottle.getCurrentPrice(), currentPrice)){
            bottle.setCurrentPrice(currentPrice);
        }
    }
}
