package assignment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		//Open browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jvnsi\\eclipse-workspace\\Logintest\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Open the URL
		driver.get("https://www.roicians.com/");
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\Users\\jvnsi\\eclipse-workspace\\Sel_prac\\src\\test\\java\\assignment\\Screenshot.jpg"));

	}

}
