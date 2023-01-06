import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
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
        $("input#userNumber").setValue("81231233436");
        $("input#dateOfBirthInput").click();
        $(byText("23")).click();


//
//        $(By.xpath("//*[@id='subjectsContainer']")).setValue("s");

        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        File file = new File("C:/Users/Artem/Desktop/82762.jpg");
        $("#uploadPicture").uploadFile(file);

    }
}
