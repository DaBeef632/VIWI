package org.perscholas.viwi.controllers;

import org.perscholas.viwi.models.Bottle;
import org.perscholas.viwi.services.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/bottles")
public class BottleController {


        private final BottleService bottleService;

        @Autowired
        public BottleController(BottleService bottleService){
            this.bottleService= bottleService;
        }

        @GetMapping
        public List<Bottle> getBottle(){
            return bottleService.getBottles();
        }

        @PostMapping
        public  void registerNewBottle(@RequestBody Bottle bottle){
            bottleService.addNewBottle(bottle);
        }

        @DeleteMapping(path = "{bottleId}")
        public void deleteBottle(@PathVariable("bottleId") Long bottleId) {
            bottleService.deleteBottle(bottleId);
        }

        @PutMapping(path = "{bottleId}")
        public void updateBottle(
                @PathVariable("bottleId") Long bottleId,
                @RequestParam(required = false) String bottleName,
                @RequestParam(required = false) float currentPrice
        ){
            bottleService.updateBottle(bottleId, bottleName, currentPrice);
        }
}

