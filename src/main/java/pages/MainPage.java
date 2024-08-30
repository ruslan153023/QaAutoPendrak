package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {
    public final String URI = "https://appleinsider.ru/";
    private SelenideElement findInput = $x(" //input");

    public void setValueAtInputAndEnter(String value) {
        findInput
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .setValue(value)
                .shouldHave(Condition.exactValue(value))
                .sendKeys(Keys.ENTER);
    }
}
