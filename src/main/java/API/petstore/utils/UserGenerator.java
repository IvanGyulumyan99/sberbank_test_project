package API.petstore.utils;

import API.petstore.requestDTO.User;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class UserGenerator {

    public static List<User> generateListOfUsersWithLength(int length) {
        List<User> listOfGeneratedUsers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            listOfGeneratedUsers.add(generateFakeUser());
        }
        return listOfGeneratedUsers;
    }

    private static User generateFakeUser() {
        Faker faker = new Faker();
        return User.builder()
                .username(faker.name().username() + faker.random().nextInt(0, 999))
                .firstName(faker.artist().name())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.animal().name() + faker.random().nextInt(0, 999))
                .phone(faker.phoneNumber().cellPhone())
                .userStatus(3)
                .build();
    }
}
