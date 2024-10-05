package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FindPage extends BasePage {
    private ElementsCollection articles = $$x("//main/article//a");
    private SelenideElement article = $x("//main/article");

    @Step("Проверить href первой первой найденной статьи")
    public String chekContainsOfHref(){
        article.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return articles.first().getAttribute("href");
    }

    @Step("Поймано исключение StaleElementReferenceException")
    public void errorAllurePrint(){}
}
