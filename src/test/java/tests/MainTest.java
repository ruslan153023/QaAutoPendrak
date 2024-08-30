package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void checkFind() {
        mainPage.setValueAtInputAndEnter("Чем iPhone 13 отличается от iPhone 12");
        findPage.chekContainsOfHref("iphone-13");
    }
}
