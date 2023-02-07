package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomeData;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class DemoTest extends TestBase {

    RandomeData randomeData = new RandomeData();
    AttachmentsTest attachmentsTest = new AttachmentsTest();


    @Test
    @Tag("homework")
    public void qaDemoTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть форму регистрации", () -> {
            registrationPage.openPage();
            TestBase.removeScript();
        });
        step("Ввестти Имя и Фамилию" + randomeData.firstName + randomeData.lastName, () -> {
            registrationPage.setFirstName(randomeData.firstName)
                    .setLastName(randomeData.lastName);
        });
        step("Ввести почту " + randomeData.email, () -> {
            registrationPage.setEmail(randomeData.email);
        });
        step("Ввести гендер + Screenshot " + randomeData.sex, () -> {
            registrationPage.setGender(randomeData.sex);
            attachmentsTest.testattachments();
        });
        step("Ввести номер телефона  " + randomeData.phone, () -> {
            registrationPage.setPhone(randomeData.phone);

        });
        step("Ввести дату рождения " + randomeData.day + randomeData.month + randomeData.year, () -> {
            registrationPage.setBirthDate(randomeData.day, randomeData.month, randomeData.year);
        });
        step("Ввести субъект " + randomeData.subject, () -> {
            registrationPage.setSubject(randomeData.subject);
        });
        step("Ввести хобби + consoleLogs " + randomeData.hobbie, () -> {
            registrationPage.setHobbies(randomeData.hobbie);
            AttachmentsTest.browserConsoleLogs();
        });
        step("Ввести изображение + attachment source " + randomeData.image, () -> {
            registrationPage.setPicture(randomeData.image);
            attachment("Source", webdriver().driver().source());
        });
        step("Ввести адрес " + randomeData.address, () -> {
            registrationPage.setAddress(randomeData.address);
        });
        step("Ввести Штат и Город + attach video " + randomeData.state, () -> {
            registrationPage.setState(randomeData.state)
                    .setCity(randomeData.city);
            AttachmentsTest.addVideo();
        });
        step("Нажать Submit ", () -> {
            registrationPage.submitClick();
        });

        step("Проверка заполнения Имени и фамилии " + randomeData.firstName + " " + randomeData.lastName, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Student Name", randomeData.firstName + " " + randomeData.lastName);
        });
        step("Проверка заполнения почты " + randomeData.email, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Student Email", randomeData.email);
        });
        step("Проверка заполнения гендера " + randomeData.sex, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Gender", randomeData.sex);
        });
        step("Проверка заполнения номера телефона " + randomeData.phone, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Mobile", randomeData.phone);
        });
        step("Проверка заполнения даты рождения " + randomeData.day + " " + randomeData.month + "," + randomeData.year, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Date of Birth", randomeData.day + " " + randomeData.month + "," + randomeData.year);
        });
        step("Проверка заполнения субъекта " + randomeData.subject, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Subjects", randomeData.subject);
        });
        step("Проверка заполнения хобби " + randomeData.hobbie, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Hobbies", randomeData.hobbie);
        });
        step("Проверка заполнения Изображения " + randomeData.image, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Picture", randomeData.image);
        });
        step("Проверка заполнения Адреса " + randomeData.address, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("Address", randomeData.address);
        });
        step("Проверка заполнения Штата и города " + randomeData.state + " " + randomeData.city, () -> {
            registrationPage.verifyResultsModalAppears().verifyResult("State and City", randomeData.state + " " + randomeData.city);
        });
    }
}
