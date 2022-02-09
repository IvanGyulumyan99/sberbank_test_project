package APItests;

import API.ipApi.base.IpAPIBaseTest;
import API.ipApi.utils.RandomUSAIpAddressGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

@Epic("API")
@DisplayName("Ip API")
public class IpAPITest extends IpAPIBaseTest {

    /**
     * Check USA IP addresses resource gives IP addresses only from USA
     * 1. Get several random IP addresses from USA IP addresses resource
     * 2. Using other API check that IP belongs to USA
     */
    @Test
    @Story("Check IP address from list is from USA")
    @DisplayName("Check IP address from list is from USA")
    public void checkIpAddressFromUSA() throws IOException {
        List<String> randomIPAddresses = RandomUSAIpAddressGenerator.generateRandomIPAddressesFromUSAAddresses(5);
        ipAPISteps.checkAllIpAddressesFromListAreFromCountry("United States", randomIPAddresses);

    }
}

