package assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Handling_Alerts {

	public static void main(String[] args) throws InterruptedException {
		//Open browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jvnsi\\eclipse-workspace\\Logintest\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Open the URL
		driver.get("https://demoqa.com/alerts");
		
		//Handling simple alert button
		driver.findElement(By.id("alertButton")).click();
		Alert a = driver.switchTo().alert();
		Thread.sleep(2000);
		a.accept();
		
		//Handling alert with wait
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.alertIsPresent());
		a = driver.switchTo().alert();
		Thread.sleep(2000);
		a.accept();
		
		//Handling alert with confirmation box
		driver.findElement(By.id("confirmButton")).click();
		a = driver.switchTo().alert();
		Thread.sleep(2000);
		a.dismiss();
		
		//Handling alert with prompt box
		driver.findElement(By.id("promtButton")).click();
		a = driver.switchTo().alert();
		a.sendKeys("Jeevan");
		Thread.sleep(2000);
		a.accept();
		
		//Handling authenticate pop-up
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
}