package API.ipApi.base;

import API.ipApi.steps.IpAPISteps;
import org.junit.jupiter.api.BeforeEach;

public class IpAPIBaseTest {
    public IpAPISteps ipAPISteps;

    @BeforeEach
    public void setup() {
        this.ipAPISteps = new IpAPISteps();
    }

}
