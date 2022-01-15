package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(beerId)
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
            .id(beerDto.getId())
            .beerName(beerDto.getBeerName())
            .beerStyle(beerDto.getBeerStyle())
            .upc(beerDto.getUpc())
            .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

        BeerDto beerDto1 = getBeerById(beerId);

        if (beerDto1 != null) {
            beerDto1.setBeerName(beerDto.getBeerName());
            beerDto1.setBeerStyle(beerDto.getBeerStyle());
            beerDto1.setUpc(beerDto.getUpc());
        } else {
            log.error("Object does not exist, save it first.");
        }
    }

    @Override
    public BeerDto updateBeerWithResponse(UUID beerId, BeerDto beerDto) {

        BeerDto beerDto1 = getBeerById(beerId);

        if (beerDto1 != null) {
            beerDto1.setId(beerDto1.getId());
            beerDto1.setBeerName(beerDto.getBeerName());
            beerDto1.setBeerStyle(beerDto.getBeerStyle());
            beerDto1.setUpc(beerDto.getUpc());
            return beerDto1;
        } else {
            log.info("Object does not exist, save it first.");
            return null;
        }
    }

    @Override
    public void deleteById(UUID beerId) {
        log.info("Deleting a beer...");
    }
}
