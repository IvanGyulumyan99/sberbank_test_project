package API.petstore.base;

import API.petstore.steps.PetStoreSteps;
import org.junit.jupiter.api.BeforeEach;

public class PetStoreBaseTest {
    public PetStoreSteps petStoreSteps;

    @BeforeEach
    public void setup() {
        this.petStoreSteps = new PetStoreSteps();
    }

}
