package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.*;

public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void successfulRegistrationTest() {

/*        String userName = "Alex";
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
        String emailKey = "Student Email";
        String genderKey = "Gender";
        String mobileKey = "Mobile";
        String birthKey = "Date of Birth";
        String subjectKey = "Subjects";
        String hobbyKey = "Hobbies";
        String fileKey = "Picture";
        String addressKey = "Address";
        String stateAndCityKey = "State and City";
        String substrPath = path.substring(4);*/



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
                .verifyResult(nameKey, userName + " " + lastName)
                .verifyResult(emailKey, userEmail)
                .verifyResult(genderKey, gender)
                .verifyResult(mobileKey, number)
                .verifyResult(birthKey, day + " " + month + "," + year)
                .verifyResult(subjectKey, subject)
                .verifyResult(hobbyKey, hobby)
                .verifyResult(fileKey, substrPath)
                .verifyResult(addressKey, address)
                .verifyResult(stateAndCityKey, state + " " + city);


    }

}
