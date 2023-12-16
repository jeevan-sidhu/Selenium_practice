package sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli_test {

	public static void main(String[] args) throws FindFailed, InterruptedException {
//		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		driver.get("https://google.com");
//		driver.manage().window().maximize();
		Thread.sleep(5000);
		Screen s = new Screen();
		Pattern p = new Pattern("D:\\Capture1.png");
		s.click(p);
	}

}
