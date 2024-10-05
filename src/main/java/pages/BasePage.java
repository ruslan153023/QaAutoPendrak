package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {
    public ElementsCollection articles = $$x("//ul[@id='menu-primary']/li/a[not(@title)]");
    public SelenideElement pageTitle = $x("//h1");
}
