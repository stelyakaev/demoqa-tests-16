package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void successfulRegistrationTest() {

        String userName = "Alex";
        String lastName = "Ivanov";
        String userEmail = "ivanov@hmail.com";
        String address = "current address";

        registrationPage.openPage().
                setFirstName(userName).
                setLastName(lastName).
                setEmail(userEmail).
                setGender("Other").
                setNumber("1234567890").
                setBirthDate("03", "April", "1995");


        $("#currentAddress").setValue(address);

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

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName);
        $(".table-responsive").shouldHave(text(userName), text(userEmail), text(address));

    }

}
