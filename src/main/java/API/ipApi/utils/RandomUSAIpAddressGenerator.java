package API.ipApi.utils;

import API.ipApi.steps.USAAPISteps;

import java.util.ArrayList;

public class RandomUSAIpAddressGenerator {
    public static ArrayList<String> generateRandomIPAddressesFromUSAAddresses(int size) {
        USAAPISteps usaapiSteps = new USAAPISteps();
        ArrayList<String> listOfIpAddresses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listOfIpAddresses.add(usaapiSteps.getRandomIpAddress());
        }
        return listOfIpAddresses;
    }
}
