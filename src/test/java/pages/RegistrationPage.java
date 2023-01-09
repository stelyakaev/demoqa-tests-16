package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String title = "Student Registration Form";
    private
        SelenideElement firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        dateOfBirthInput = $("#dateOfBirthInput");

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

    public RegistrationPage setLastName (String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail (String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender (String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumber (String value){
        $("#userNumber").setValue(value);
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
}
