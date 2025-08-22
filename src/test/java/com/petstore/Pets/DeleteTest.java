package com.petstore.Pets;

import com.petstore.TestBase;
import com.petstore.models.Pet;
import com.petstore.utils.ApiClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteTest extends TestBase {

    @Test
    @DisplayName("Удаление питомца")
    public void testDeletePet() {
        Pet newPet = testDataGenerator.generatePet();
        Response createResponse = ApiClient.post("/pet", newPet);
        Pet createdPet = createResponse.as(Pet.class);

        Response getResponse = ApiClient.get("/pet/" + createdPet.getId());
        Pet retrievedPet = getResponse.as(Pet.class);

        Response deleteResponse = ApiClient.delete("/pet/" + createdPet.getId());

        assertEquals(createdPet.getId(), retrievedPet.getId());
        assertEquals(HTTP_OK, deleteResponse.getStatusCode());
    }
}
