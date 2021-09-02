import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void firstTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").sendKeys("Jean");
        $("#lastName").sendKeys("Aria");
        $("#userEmail").sendKeys("myemail@jmail.cc");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").sendKeys("9112223344");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1958");
        $(".react-datepicker__month-select").selectOption("August");
        $(byText("29"), 1).click();
        $("#subjectsInput").setValue("Physics").pressEnter().setValue("Math").pressEnter().setValue("English").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/png.jpg"));
        $("#currentAddress").setValue("1st street 1st");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $("tbody").shouldHave(text("Jean Aria"),
                text("myemail@jmail.cc"),
                text("Female"),
                text("9112223344"),
                text("29 August,1958"),
                text("Physics"),
                text("Math"),
                text("English"),
                text("Sports"),
                text("png.jpg"),
                text("1st street 1st"),
                text("NCR"),
                text("Delhi")
        );
    }
}
