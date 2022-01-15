package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping(BeerController.BEER_ENDPOINT)
@RestController
public class BeerController {


    public static final String BEER_ENDPOINT = "/api/v1/beer";

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") final UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> handlePost(@Valid @RequestBody final BeerDto beerDto) {

        BeerDto beerDto1 = beerService.saveNewBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", BEER_ENDPOINT + "/" + beerDto1.getId().toString());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping({"/response"})
    public ResponseEntity<BeerDto> handlePostResponseBody(@Valid @RequestBody final BeerDto beerDto) {
        BeerDto beerDto1 = beerService.saveNewBeer(beerDto);
        return new ResponseEntity<>(beerDto1, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> handlePut(@PathVariable("beerId") final UUID beerId, @Valid @RequestBody final BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping({"/{beerId}/withResponse"})
    public ResponseEntity<BeerDto> handlePutWithResponse(@PathVariable("beerId") final UUID beerId, @Valid @RequestBody final BeerDto beerDto) {
        BeerDto beerDto1 = beerService.updateBeerWithResponse(beerId, beerDto);
        return new ResponseEntity<>(beerDto1, HttpStatus.OK);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") final UUID beerId) {
        beerService.deleteById(beerId);
    }

}
