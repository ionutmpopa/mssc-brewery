package guru.springframework.msscbrewery.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    BeerDto getDto() {
        return BeerDto.builder()
            .beerName("BeerName")
            .beerStyle("Style")
            .id(UUID.randomUUID())
            .createdDate(OffsetDateTime.now())
            .lastUpdatedDate(OffsetDateTime.now())
            .price(new BigDecimal("11"))
            .upc(1324234567L)
            .build();
    }
}
