package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulRegistrationTest(){

        String userName = "Alex";
        String lastName = "Ivanov";
        String userEmail = "ivanov@hmail.com";
        String address = "current address";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(address);
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Other")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("IMG/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

    }

}
