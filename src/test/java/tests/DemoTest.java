package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utils.RandomeData;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DemoTest extends TestBase {

    RandomeData randomeData = new RandomeData();



    @Test
    void qaDemoTest() {

        registrationPage
                .openPage()
                .setFirstName(randomeData.firstName)
                .setLastName(randomeData.lastName)
                .setEmail(randomeData.email)
                .setGender(randomeData.sex)
                .setPhone(randomeData.phone)
                .setBirthDate(randomeData.day, randomeData.month, randomeData.year)
                .setSubject(randomeData.subject)
                .setHobbies(randomeData.hobbie)
                .setPicture(randomeData.image)
                .setAddress(randomeData.address)
                .setState(randomeData.state)
                .setCity(randomeData.city)
                .submitClick();

// Проверка заполнения полей

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", randomeData.firstName + " " + randomeData.lastName)
                .verifyResult("Student Email", randomeData.email)
                .verifyResult("Gender", randomeData.sex)
                .verifyResult("Mobile", randomeData.phone)
                .verifyResult("Date of Birth", randomeData.day + " " + randomeData.month + "," + randomeData.year)
                .verifyResult("Subjects", randomeData.subject)
                .verifyResult("Hobbies", randomeData.hobbie)
                .verifyResult("Picture", randomeData.image)
                .verifyResult("Address", randomeData.address)
                .verifyResult("State and City", randomeData.state + " " + randomeData.city);


    }
}
