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
        String gender = "Male";
        String number = "1234567890";
        String day = "03";
        String month = "April";
        String year = "1995";
        String nameKey = "Student Name";
        String subject = "Maths";
        String hobby = "Music";
        String path = "IMG/1.png";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage().
                setFirstName(userName).
                setLastName(lastName).
                setEmail(userEmail).
                setGender(gender).
                setNumber(number).
                setBirthDate(day, month, year).
                setAddress(address).
                setSubject(subject).
                setHobby(hobby).
                uploadFile(path).
                setState(state).
                setCity(city).
                setSubmit();


        registrationPage.verifyResultsModalAppears()
                .verifyResult(nameKey, userName + " " + lastName);


    }

}
