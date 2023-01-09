package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private final String title = "Student Registration Form";
    private
        SelenideElement firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        dateOfBirthInput = $("#dateOfBirthInput"),
        addressInput = $("#currentAddress"),
        subjectInput = $("#subjectsInput"),
        genderInput = $("#genterWrapper"),
        numberInput = $("#userNumber"),
        hobbyInput = $("#hobbiesWrapper"),
        fileUpload = $("#uploadPicture");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text(title));
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName (String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail (String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender (String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumber (String value){
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate (String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears (){
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult (String key, String value){
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage setSubject (String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby (String value){
        hobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFile (String value){
        fileUpload.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateAndCityComponent.setUserState(value);
        return this;
    }

    public RegistrationPage setCity (String value){
        stateAndCityComponent.setUserCity(value);
        return this;
    }

    public RegistrationPage setSubmit(){
        $("#submit").pressEnter();
        return this;
    }

}
