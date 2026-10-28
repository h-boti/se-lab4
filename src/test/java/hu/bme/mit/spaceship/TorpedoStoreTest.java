package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test 
    void fire_Failure(){
        TorpedoStore store = new TorpedoStore(1,1.0);

        boolean result = store.fire(1);

        assertEquals(false, result);
    }

    @Test
    void firing_Decreases_number_of_Torpedos(){
        TorpedoStore store = new TorpedoStore(1);

        store.fire(1);

        assertEquals(0, store.getTorpedoCount());
    }

    @Test 
    void firing_More_than_available(){
        TorpedoStore store = new TorpedoStore(0);

        assertThrows(IllegalArgumentException.class, () -> store.fire(1) );
    }


}
