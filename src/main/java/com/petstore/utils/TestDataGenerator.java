package com.petstore.utils;

import com.github.javafaker.Faker;
import com.petstore.models.Category;
import com.petstore.models.Pet;
import com.petstore.models.Tag;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Генератор тестовых данных для PetStore API
 */
public class TestDataGenerator {

    private final Faker faker = new Faker();

    /**
     * Генерирует случайное имя для питомца
     */
    public String randomPetName() {
        return faker.funnyName().name();
    }

    /**
     * Генерирует случайный URL фото
     */
    public String randomPhotoUrl() {
        return "https://example.com/pets/" + faker.internet().uuid() + ".jpg";
    }

    /**
     * Генерирует случайный статус питомца (available, pending, sold)
     */
    public String randomStatus() {
        List<String> statuses = Arrays.asList("available", "pending", "sold");
        return statuses.get(ThreadLocalRandom.current().nextInt(statuses.size()));
    }

    /**
     * Генерирует случайную категорию для питомца
     */
    public Category randomCategory() {
        return Category.builder()
                .id(faker.number().randomNumber(5, false))
                .name(faker.animal().name())
                .build();
    }

    /**
     * Генерирует случайный тег для питомца
     */
    public Tag randomTag() {
        return Tag.builder()
                .id(faker.number().randomNumber(3, false))
                .name(faker.lorem().word())
                .build();
    }

    /**
     * Генерирует случайного питомца (Pet)
     */
    public Pet generatePet() {
        return Pet.builder()
                .id(faker.number().randomNumber(6, false))
                .category(randomCategory())
                .name(randomPetName())
                .photoUrls(Arrays.asList(randomPhotoUrl(), randomPhotoUrl()))
                .tags(Arrays.asList(randomTag(), randomTag()))
                .status(randomStatus())
                .build();
    }

    /**
     * Генерирует случайного питомца с указанным статусом
     */
    public Pet generatePetWithStatus(String status) {
        Pet pet = generatePet();
        pet.setStatus(status);
        return pet;
    }

    /**
     * Генерирует случайный ID (число)
     */
    public long randomId() {
        return faker.number().randomNumber(6, false);
    }
}