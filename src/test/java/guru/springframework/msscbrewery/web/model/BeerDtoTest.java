package guru.springframework.msscbrewery.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@JsonTest
class BeerDtoTest extends BaseTest {


    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializedDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        log.info(jsonString);



    }


    @Test
    void testDeserializedDto() throws JsonProcessingException {

        String json = "{\"id\":\"fa5b5e15-2c7e-47d3-8a2a-154f5654e5dc\",\"beerName\":\"BeerName\",\"beerStyle\":\"Style\",\"upc\":1324234567,\"price\":11,\"createdDate\":\"2022-01-22T19:31:42.2967234+02:00\",\"lastUpdatedDate\":\"2022-01-22T19:31:42.2977191+02:00\"}";
        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        //Assertions.assertSame("BeerName", beerDto.getBeerName());

        log.info(String.valueOf(beerDto));

    }

}
