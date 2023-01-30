package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.randomEmail;
import static utils.RandomUtils.randomString;
import static utils.RandomUtils.randomNumber;
import static utils.RandomUtils.randomPhone;

public class RegistrationWithRandomUtilsTests extends TestBase {



    @Test
    void successfulRegistrationTest(){

        String userName = randomString(10);
        String lastName = randomString(10);
        String userEmail = randomEmail(10);
        String address = randomString(10);
        String phoneNumber = randomPhone("8",9000000000L, 9999999999L);

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(phoneNumber);
        $("#currentAddress").setValue(address);
        $("#genterWrapper").$(byText("Other")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("IMG/1.png");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").pressEnter();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
       // $(".table-responsive").shouldHave(text(userName), text(userEmail), text(address));

    }

}
