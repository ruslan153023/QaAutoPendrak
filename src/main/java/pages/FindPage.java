package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FindPage extends BasePage {
    private ElementsCollection articles = $$x("//main/article//a");
    private SelenideElement article = $x("//main/article");

    @Step("проверить href первой первой найденной статьи")
    public void chekContainsOfHref(String word){
        article.shouldBe(Condition.visible, Duration.ofSeconds(10));
        String href = articles.get(0).getAttribute("href");

        if (!href.contains(word)) {
            Assert.fail("Ссылка не содержит " + word);
        }
    }
}
