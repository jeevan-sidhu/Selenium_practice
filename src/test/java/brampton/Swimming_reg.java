package brampton;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Swimming_reg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		Open Web site Sign-in Page
		driver.get("https://cityofbrampton.perfectmind.com/Menu/MemberRegistration/MemberSignIn");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
//		Login
		driver.findElement(By.id("textBoxUsername")).sendKeys("jvn.sidhu@gmail.com");
		driver.findElement(By.id("textBoxPassword")).sendKeys("Js@407800");
		driver.findElement(By.id("buttonLogin")).click();
		
//		Click on Program Registration link
		driver.findElement(By.xpath("//div[@id=\"ApplicationMenuContainer\"]/ul/li[4]")).click();
		
//		Scroll to end of the page
		List<WebElement> all_programs = driver.findElements(By.xpath("//a[@class=\"bm-category-calendar-link enabled\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", all_programs.get(all_programs.size()-1));
//		WebElement last_el = driver.findElement(By.xpath("//*[@id=\"bm-categories\"]/div[13]/div/ul/li[7]/div/a[1]"));		
//		js.executeScript("arguments[0].scrollIntoView(true);", last_el);
		
//		Click on Parent and Child (4 Months to 3 Years) - Learn to Swim
		all_programs.get(61).click();
//		WebElement swim_parent_child = driver.findElement(By.xpath("//*[@id=\"bm-categories\"]/div[13]/div/ul/li[6]/div/a[1]"));
//		swim_parent_child.click();
		
//		Click on Splash Parent and Child (2 to 3 Years)
		WebElement splash_2to3 = driver.findElement(By.xpath("//*[@id]/div/div/ul/course-service[3]/li/div[1]/div/div[3]/div[2]/div[2]/div/span"));
//		js.executeScript("arguments[0].scrollIntoView(true);", swim_cat);
		splash_2to3.click();
		
//		Get all Program links
		List<WebElement> links = driver.findElements(By.xpath("//li[@class=\"bm-group-item-row\"]/div/div[3]/div[2]/a"));
		WebElement swim_casie_fri = links.get(12);
		
//		Scroll to desired Program and click
		js.executeScript("arguments[0].scrollIntoView(true);", swim_casie_fri);
		swim_casie_fri.click();
		
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
		family_members.get(0).click();
	}
}
