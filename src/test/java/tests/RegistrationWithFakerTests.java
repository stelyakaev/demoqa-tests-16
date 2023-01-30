package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RegistrationWithFakerTests extends TestBase {


    @Test
    void successfulRegistrationTest() {

       Faker faker = new Faker(new Locale("ru"));
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
       String[] birthday = dateFormat.format(faker.date().birthday()).split(" ");

     String userName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress("ru"),
            address = faker.address().fullAddress(),
            gender = "Male",
            number = faker.phoneNumber().subscriberNumber(10),
            day = birthday[0],
            month = birthday[1],
            year = birthday[2],
            nameKey = "Student Name",
            subject = "Maths",
            hobby = "Music",
            path = "IMG/1.png",
            state = "NCR",
            city = "Delhi",
            emailKey = "Student Email",
            genderKey = "Gender",
            mobileKey = "Mobile",
            birthKey = "Date of Birth",
            subjectKey = "Subjects",
            hobbyKey = "Hobbies",
            fileKey = "Picture",
            addressKey = "Address",
            stateAndCityKey = "State and City",
            substrPath = path.substring(4);



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
