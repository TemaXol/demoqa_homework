package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;

import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoTest extends TestBase{

    @Test
    void qaDemoTest() {
        String firstName = "First";
        String lastName = "Last";

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("test@test.com")
                .setGender("Male")
                .setPhone("8123123343")
                .setBirthDate("17", "July", "2012")
                .setSubject("English")
                .setHobbies("Sports")
                .setPicture("82762.jpg")
                .setAddress("test message test messagetest messagetest messagetest messagetest message ")
                .setState("NCR")
                .setCity("Noida")
                .submitClick();

// Проверка заполнения полей

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", "test@test.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8123123343")
                .verifyResult("Date of Birth", "17 July,2012")
                .verifyResult("Subjects", "English")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "82762.jpg")
                .verifyResult("Address", "test message test messagetest messagetest messagetest messagetest message ")
                .verifyResult("State and City", "NCR Noida");


    }
}
