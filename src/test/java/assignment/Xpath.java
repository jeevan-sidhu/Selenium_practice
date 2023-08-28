package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Xpath {

	public static void main(String[] args) {
		//Open browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jvnsi\\eclipse-workspace\\Logintest\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Open the URL
		driver.get("https://www.roicians.com/");
		
		boolean res1 = driver.findElement(By.xpath("/html/body/header/div/section[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[1]/a")).isDisplayed();
		System.out.println(res1);
		
		boolean res2 = driver.findElement(By.xpath("//*[@id=\"premium-nav-menu-item-18\"]/a")).isDisplayed();
		System.out.println(res2);
	}

}
