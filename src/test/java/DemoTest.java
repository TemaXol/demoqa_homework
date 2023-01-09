import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void qaDemoTest() {
        open("/automation-practice-form");

        $("input#firstName").setValue("First");

        $("input#lastName").setValue("Last");

        $("input#userEmail").setValue("test@test.com");

        $(".custom-control-label").shouldHave(text("Male")).click();

        $("input#userNumber").setValue("8123123343");

        $("input#dateOfBirthInput").click();

        $(byText("23")).click();

        $("input#subjectsInput").setValue("english").pressEnter();

        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("82762.jpg");

        $("textarea#currentAddress").setValue("test message test messagetest messagetest messagetest messagetest message ");

        $("input#react-select-3-input").setValue("NCR").pressEnter();
        $("input#react-select-4-input").setValue("Noida").pressEnter();

        $("button#submit").click();

// Проверка заполнения полей
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("First Last"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("test@test.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("8123123343"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("23 January,2023"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("82762.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("test message test messagetest messagetest messagetest messagetest message "));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("NCR Noida"));


    }
}
