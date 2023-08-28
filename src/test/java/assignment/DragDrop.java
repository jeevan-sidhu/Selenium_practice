package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) {
		//Open browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jvnsi\\eclipse-workspace\\Logintest\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Open the URL
		driver.get("https://demoqa.com/droppable");
		
		Actions act = new Actions(driver);
		act.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		
	}

}
