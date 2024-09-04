package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Проверка ссылки")
    public void checkFind() {
        Assert.assertTrue(
                mainPage.setValueAtInputAndEnterShort("Чем iPhone 13 отличается от iPhone 12")
                        .chekContainsOfHref()
                        .contains("iphone-13"));
    }


}
