package tests;

import org.testng.annotations.BeforeTest;
import pages.FindPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;


public class BaseTest {

    MainPage mainPage = new MainPage();
    FindPage findPage = new FindPage();

    @BeforeTest
    public void setup() {
        open(mainPage.URI);
    }
}
