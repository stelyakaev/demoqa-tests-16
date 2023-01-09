package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {
    public void setUserState(String value){
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }

    public void setUserCity(String value){
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}
