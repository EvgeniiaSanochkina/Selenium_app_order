import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestOrder {

    private WebDriver driver;

    @BeforeEach
    void createBrowser() {
        driver = new ChromeDriver();
    }

  @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testOne() {
       driver.get("http://localhost:9999/");
       List<WebElement> inputFields = driver.findElements(By.className("input__control"));
       inputFields.get(0).sendKeys("лапенко");
       inputFields.get(1).sendKeys("+79998887766");
       driver.findElement(By.className("checkbox__box")).click();
       driver.findElement(By.className("button")).click();
       String actual = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
       String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
       assertEquals(expected, actual.strip());
    }
}
