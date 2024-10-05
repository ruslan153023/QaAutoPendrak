package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {

    private SelenideElement findInput = $x(" //input");

    @Step("Вставить текст в поиск на главной странице, нажать enter")
    public void setValueAtInputAndEnter(String value) {
        findInput
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .setValue(value)
                .shouldHave(Condition.exactValue(value))
                .sendKeys(Keys.ENTER);
    }

    @Step("Вставить текст в поиск на главной странице, нажать enter")
    public FindPage setValueAtInputAndEnterShort(String value){
        findInput
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .setValue(value)
                .shouldHave(Condition.exactValue(value))
                .sendKeys(Keys.ENTER);
        return new FindPage();
    }
}
