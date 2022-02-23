
import org.junit.Assert;
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
       driver.findElement(amount).sendKeys("25");
       driver.findElement(numberDebitSource).sendKeys("4506909324274797");
       driver.findElement(expireDebitSource).sendKeys("12-23");
       driver.findElement(cvv).sendKeys("123");
       driver.findElement(firstName).sendKeys("Bude");
       driver.findElement(lastName).sendKeys("Dobre");

       Thread.sleep(1500);

       driver.findElement(By.xpath(".//button[contains(text(), 'Додати в кошик')]")).click();

       By category =By.xpath("//div[@data-qa-node='category']");
       By details =By.xpath("//div[@data-qa-node='details']");
       By card =By.xpath("//td class[@data-qa-node='card']");
       By operator =By.xpath("//span[@data-qa-node='nameB']");
       By sum =By.xpath("//div[@data-qa-node='amount']");
       By commission =By.xpath("//span[@data-qa-node='commission']");
       By currency =By.xpath("//span[@data-qa-node='commission-currency']");


       Assert.assertEquals( "Поповнення мобільного", driver.findElement(category).getText());
       Assert.assertEquals( "Поповнення телефону. На номер +380952820770", driver.findElement(details).getText());
       Assert.assertEquals( "4506909324274797", driver.findElement(card).getText());
       Assert.assertEquals( "Vodafone", driver.findElement(operator).getText());
       Assert.assertEquals( "25 UAH", driver.findElement(sum).getText());
       Assert.assertEquals( "2", driver.findElement(commission).getText());
       Assert.assertEquals( "UAH", driver.findElement(currency).getText());

    driver.findElement(By.xpath(".//button[contains(text(), 'Сплатити')]")).click();


    // driver.findElement(By.xpath(".//button[contains(text(), 'Видалити')]")).click();

     //  By otmena =By.xpath("//button[@data-qa-node='popup-confirm-button']");
     //  By udaliti =By.xpath("//button[@data-qa-node='popup-confirm-button']");

     //  Assert.assertEquals( "Скасувати", driver.findElement(otmena).getText());
     //  Assert.assertEquals( "Видалити", driver.findElement(udaliti).getText());


   }
}