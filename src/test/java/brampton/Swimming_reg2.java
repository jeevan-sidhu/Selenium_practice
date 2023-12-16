package brampton;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Swimming_reg2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		
//		Open Web site Sign-in Page
		driver.get("https://cityofbrampton.perfectmind.com/Menu/MemberRegistration/MemberSignIn");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
//		Login
		driver.findElement(By.id("textBoxUsername")).sendKeys("jvn.sidhu@gmail.com");
		driver.findElement(By.id("textBoxPassword")).sendKeys("Js@407800");
		driver.findElement(By.id("buttonLogin")).click();
		
//		Click on Program Registration link
		driver.findElement(By.xpath("//div[@id=\"ApplicationMenuContainer\"]/ul/li[4]")).click();
		
//		Click on Muscle and Strength Conditioning
//		WebElement muscle_and_strength = driver.findElement(By.xpath("//*[@id=\"bm-categories\"]/div[5]/div/ul/li[5]/div/a[1]"));
//		act.moveToElement(muscle_and_strength).build().perform();
//		muscle_and_strength.click();
		List<WebElement> muscle_and_strength = driver.findElements(By.xpath("//a[@class=\"bm-category-calendar-link enabled\"]"));
		act.moveToElement(muscle_and_strength.get(23)).build().perform();
		muscle_and_strength.get(23).click();
		
//		Click on Muscle Conditioning 14+
		WebElement muscle14 = driver.findElement(By.xpath("//*[@id]/div/div/ul/course-service[1]/li/div[1]/div/div[3]/div[2]/div[2]/div/span"));
		muscle14.click();
		
//		Get all Program links
		List<WebElement> links = driver.findElements(By.xpath("//li[@class=\"bm-group-item-row\"]/div/div[3]/div[2]/a"));
		WebElement muscle_gore_tue = links.get(3);
		
//		Scroll to desired Program and click
		js.executeScript("arguments[0].scrollIntoView(true);", muscle_gore_tue);
		muscle_gore_tue.click();
		
//		Click on Registration button
		boolean flag=true;
		while(flag) {
			try {
				driver.findElement(By.xpath("//a[@class=\"bm-button bm-book-button\"]")).click();
				flag=false;
			}
			catch(NoSuchElementException e) {
				driver.navigate().refresh();
				flag=true;
			}
		}
		
//		Held a spot
		Thread.sleep(1000);
		List<WebElement> family_members = driver.findElements(By.xpath("//input[@role=\"checkbox\"]"));
		family_members.get(1).click();
	}
}
