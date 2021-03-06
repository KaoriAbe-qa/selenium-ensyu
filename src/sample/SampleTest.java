package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
	WebDriver driver = new ChromeDriver(); //ChromeDriverの作成
	driver.get ("http://www.google.com/xhtml"); //get()でブラウザ起動
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	} //処理を停止(動作確認の為)
	//ブラウザの要素を指定　メソッド名がわかりやすいですよね。
	WebElement searchBox = driver.findElement(By.name("q"));
	searchBox.sendKeys("ChromeDriver");
	searchBox.submit();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}		
	driver.quit(); //ブラウザを閉じる。

	}

}
