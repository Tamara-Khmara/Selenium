
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MobileTest {
   @Test
    public void checkMobilePayment () throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver1.exe");

       WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);
      driver.get("https://next.privat24.ua/mobile");

       By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
       By amount = By.xpath("//input[@data-qa-node='amount']");
       By numberDebitSource = By.xpath("//input[@data-qa-node= 'numberdebitSource']");
       By expireDebitSource = By.xpath("//input[@data-qa-node='expiredebitSource']");
       By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
       By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
       By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");


       driver.findElement(phoneNumber).sendKeys("952820770");
       driver.findElement(amount).sendKeys("10");
       driver.findElement(numberDebitSource).sendKeys("4506909324274797");
       driver.findElement(expireDebitSource).sendKeys("12-23");
       driver.findElement(cvv).sendKeys("123");
       driver.findElement(firstName).sendKeys("Taras");
       driver.findElement(lastName).sendKeys("Shevchenko");

       Thread.sleep(1500);

       driver.findElement(By.xpath(".//button[contains(text(), 'Додати в кошик')]")).click();





   }
}