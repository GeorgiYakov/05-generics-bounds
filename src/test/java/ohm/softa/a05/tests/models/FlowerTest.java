package ohm.softa.a05.tests.models;

import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.PlantColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlowerTest {
    private final Logger logger = LogManager.getLogger();
    @Test
    void FlowersAreNotGreenTest(){
        logger.info("Flower can't be green");
        assertThrows(IllegalArgumentException.class, () -> new Flower( "Rosa", "Abracadabra", 0.5, PlantColor.GREEN));
    }
}
