package systemAcceptanceTests.pageObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
/**
 * This class is used as a special class that configures the web driver and 
 * adds one more level of abstraction to this framework
 * 
 * Only the author can modify this class.
 * @author Gasan Nazer
 * **/
public class PageObject {
	public static WebDriver driver;
	
	public PageObject() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void goToPage(String url) {
		driver.get(url);
	}
	
	public void takeScreenShot(String picName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("./ScreenShots/" + picName +".png"));
		System.out.println("Screen shot taken");
	}

	public WebElement findByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement findByCssSelector(String css) {
		return driver.findElement(By.cssSelector(css));
	}
	
	public WebElement findByName(String name) {
		return driver.findElement(By.name(name));
	}

	public WebElement findById(String id) {
		return driver.findElement(By.id(id));
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitDriver() {
		driver.close();
	}
}
