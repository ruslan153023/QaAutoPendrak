package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CollectionTest extends BaseTest {
    String assertMessage = "Элемент Сбербанк отображается в браузере Chrome";

    @Test(retryAnalyzer = Retry.class)
    @Step("Проверить переход по ссылкам меню хедера")
    public void checkIterationCollectionFirst() {
        for (int i = 0; i < mainPage.articles.size(); i++) {

            SelenideElement article = mainPage.articles.get(i);

            if (article.is(Condition.visible)) {
                String articleText = article.getText().replaceAll("\uD83C\uDF4F", "").trim().toLowerCase();
                article.click();
                Assert.assertTrue(mainPage.pageTitle.getText().trim().toLowerCase().contains(articleText));
            }

            if (mainPage.articles.last().is(Condition.visible)) {
                Assert.fail(assertMessage);
            }

        }
    }

    @Test(retryAnalyzer = Retry.class)
    @Step("Проверить переход по ссылкам меню хедера вторым методом")
    public void checkIterationCollectionSecond() {
        int i = 0;
        for (SelenideElement element : mainPage.articles) {

            SelenideElement article = mainPage.articles.get(i);

            if (article.is(Condition.visible)) {
                String articleText = article.getText().replaceAll("\uD83C\uDF4F", "").trim().toLowerCase();
                article.click();
                Assert.assertTrue(mainPage.pageTitle.getText().trim().toLowerCase().contains(articleText));
            }

            if (mainPage.articles.last().is(Condition.visible)) {
                Assert.fail(assertMessage);
            }
            i++;

        }
    }

    @Test(retryAnalyzer = Retry.class)
    @Step("Проверить переход по ссылкам меню хедера третьим методом")
    public void checkIterationCollectionThird() {
        for (SelenideElement article : mainPage.articles){
            if(visible(article)){
                String articleText = article.getText().replaceAll("\uD83C\uDF4F", "").trim().toLowerCase();
                article.click();
                Assert.assertTrue(mainPage.pageTitle.getText().trim().toLowerCase().contains(articleText));
            }
            if (visible(mainPage.articles.last())) {
                Assert.fail(assertMessage);
            }
        }
    }

    boolean visible(SelenideElement element){
        try {
            return element.isDisplayed();
        } catch (StaleElementReferenceException e){
            return false;
        }
    }
}
