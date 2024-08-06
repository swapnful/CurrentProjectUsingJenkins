package Test001;

import static org.testng.Assert.assertEquals;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class F1 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testThankYouMessage() throws InterruptedException {
        // Login
        driver.get("https://www.ashidiamonds.com/LoginPage.aspx");

        By loginelement = By.name("ctl00$ContentPlaceHolder1$JewelerIDss");
        WebElement loginele = wait.until(ExpectedConditions.visibilityOfElementLocated(loginelement));
        loginele.sendKeys("CARTJA11720");

        By emailelement = By.name("ctl00$ContentPlaceHolder1$EmailID");
        WebElement emailele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailelement));
        emailele.sendKeys("avalontester1@gmail.com");

        By passelement = By.name("ctl00$ContentPlaceHolder1$Password");
        WebElement passele = wait.until(ExpectedConditions.visibilityOfElementLocated(passelement));
        passele.sendKeys("CARTJA12345");

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_A1")).click();
        System.out.println("Login Successful on Website");
        Thread.sleep(7000);

        By listpageelement = By.xpath("(//span[contains(text(),'Shop Now')])[1]");
        WebElement listpageele = wait.until(ExpectedConditions.visibilityOfElementLocated(listpageelement));
        listpageele.click();
        Thread.sleep(7000);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 300);");
//        Thread.sleep(1000);
        
        
    	WebElement elementToScroll2 = driver.findElement(By.xpath("(//*[name()='svg'][@class='icon_cart'])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll2);
		Thread.sleep(400);
		
		//(//*[name()='svg'][@id='Layer_1'])[10]   (//img[@id='ImagechangeListdata_1'])[1]
        By mainListImageelement = By.xpath("(//*[name()='svg'][@id='Layer_1'])[10]");
        WebElement mainListImageele = wait.until(ExpectedConditions.visibilityOfElementLocated(mainListImageelement));
        mainListImageele.click();

        By detailpageemailelement = By.xpath("(//span[@class='icon_wishlist WishListIcon DIcon Email01'])[1]");
        WebElement detailpageemailele = wait.until(ExpectedConditions.visibilityOfElementLocated(detailpageemailelement));
        detailpageemailele.click();
        
        Thread.sleep(2000);


        By emailpopupCPelement = By.xpath("(//input[@id='CP'])[1]");
        WebElement emailpopupCPele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailpopupCPelement));
        emailpopupCPele.click();

        driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_txtFriendName'])[1]")).sendKeys("Test User");
        Thread.sleep(500);
        driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_txtFreindsEmail'])[1]")).sendKeys("avalontest1234@gmail.com");
        Thread.sleep(500);
        driver.findElement(By.xpath("(//textarea[@id='ctl00_ContentPlaceHolder1_txtMsg'])[1]")).sendKeys("This is Test Email (DetailPage), Please ignore this.");
        Thread.sleep(500);
        driver.findElement(By.xpath("(//a[@class='btn-orange'][normalize-space()='Email'])[1]")).click();
        Thread.sleep(500);
        System.out.println("All code done");

        By thankYouMessageElement = By.xpath("//div[@id='EmailMainPopConfirm']//p");
        WebElement thankYouMessageEle = wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessageElement));
        String actualMessage = thankYouMessageEle.getText();

        // Define the expected message
        String expectedMessage = "Thank You for sharing Style information.";

        // Assert that the actual message matches the expected message
        assertEquals(expectedMessage, actualMessage, "The thank you message is not as expected.");
    }

    // Additional helper methods can be added here
}
