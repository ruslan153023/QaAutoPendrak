package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeTest;
import pages.FindPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;


public class BaseTest {

    private final String URI = "https://appleinsider.ru/";
    MainPage mainPage = new MainPage();
    FindPage findPage = new FindPage();

    @BeforeTest
    public void setup() {
        SelenideLogger.addListener("", new AllureSelenide().screenshots(true));
        open(URI);
    }
}
