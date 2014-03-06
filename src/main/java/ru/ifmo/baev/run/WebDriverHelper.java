package ru.ifmo.baev.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.ifmo.baev.inverted.index.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 07.03.14
 */
public class WebDriverHelper {

    private WebDriver driver;

    public WebDriverHelper() {
        initDriver();
    }

    public List<Document> getDocumentsFrom(String url) {
        driver.get(url);

        List<Document> results = new ArrayList<>();

        List<WebElement> elements = driver.findElements(By.tagName("dd"));
        System.out.println(String.format("Found %s elements", elements.size()));

        int i = 0;
        for (WebElement element : elements) {
            Document doc = new Document(element.getText(), String.format("Document number %d", i++));
            results.add(doc);
        }

        return results;
    }

    public void initDriver() {
        driver = new PhantomJSDriver(new DesiredCapabilities());
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
