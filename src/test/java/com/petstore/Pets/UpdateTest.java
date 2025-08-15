package com.petstore.Pets;

import com.petstore.TestBase;
import com.petstore.models.Pet;
import com.petstore.utils.ApiClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateTest extends TestBase {

    @Test
    @DisplayName("Обновление информации о питомце")
    public void testUpdatePet() {
        Pet newPet = testDataGenerator.generatePet();
        Response createResponse = ApiClient.post("/pet", newPet);
        Pet createdPet = createResponse.as(Pet.class);

        Pet updatePet = Pet.builder()
                .id(createdPet.getId())
                .name("RONNY")
                .category(createdPet.getCategory())
                .photoUrls(createdPet.getPhotoUrls())
                .tags(createdPet.getTags())
                .status("Sold")
                .build();

        Response updateResponse = ApiClient.put("/pet", updatePet);

        Response getResponse = ApiClient.get("/pet/" + createdPet.getId());
        Pet retrievedPet = getResponse.as(Pet.class);

        assertEquals(HTTP_OK, createResponse.getStatusCode());
        assertEquals(HTTP_OK, updateResponse.getStatusCode());
        assertEquals(HTTP_OK, getResponse.getStatusCode());
        assertEquals("RONNY", retrievedPet.getName());
        assertEquals("Sold", retrievedPet.getStatus());
    }
}
