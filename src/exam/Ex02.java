package exam;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Ex02 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		
		//ChromeDriverの作成(Chrome起動)
		WebDriver driver = new ChromeDriver();
		
		//http://www.google.com/へのアクセス
		driver.get("http://rakuplus.jp/");
		
		//ID入力ボックスの要素をID属性名から取得
		WebElement idBox = driver.findElement(By.id("user_login"));
				
		//ID入力ボックスに文字列を入力
		idBox.sendKeys("ダミーID");
				
		//PW入力ボックスの要素をID属性名から取得
		WebElement passBox = driver.findElement(By.id("user_pass"));
						
		//PW入力ボックスに文字列を入力
		passBox.sendKeys("ダミーPW");
				
		//ログインボックスの要素をID属性名から取得
		WebElement loginBox = driver.findElement(By.id("user_pass"));
		
		//Enter押下
		loginBox.submit();
		
		//スクリーンショットを取得
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(file.toPath(), new File("C:/eclipse/" + file.getName()).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
