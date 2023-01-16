package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private SelenideElement
            firstNameInput = $("input#firstName"),
            lastNameInput = $("input#lastName"),
            emailInput = $("input#userEmail"),
            genderInput = $(".custom-control-label"),
            phoneInput = $("input#userNumber"),
            dateOfBirthInput = $("input#dateOfBirthInput"),
            subjectInput = $("input#subjectsInput"),
            sportChackbox = $("#hobbiesWrapper").$(byText("Sports")),
            readingCheckbox = $("#hobbiesWrapper").$(byText("Reading")),
            musicCheckbox = $("#hobbiesWrapper").$(byText("Music")),
            setPicture = $("#uploadPicture"),
            setAddress = $("textarea#currentAddress"),
            setState = $("input#react-select-3-input"),
            setCity = $("input#react-select-4-input"),
            submitClick = $("button#submit");


    public RegistrationPage openPage() {

        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.shouldHave(text(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppeares();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies() {
        sportChackbox.click();
//       readingCheckbox.setValue(value).click();
//       musicCheckbox.setValue(value).click();
//        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#hobbiesWrapper").$(byText("Reading")).click();
//        $("#hobbiesWrapper").$(byText("Music")).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        setPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        setAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        setState.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value) {
        setCity.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage submitClick() {
        submitClick.click();

        return this;
    }
}
