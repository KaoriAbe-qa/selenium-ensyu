package exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		
		//ChromeDriverの作成(Chrome起動)
		WebDriver driver = new ChromeDriver(); 
		
		//http://www.google.com/へのアクセス
		driver.get("http://www.google.com/"); //get()でブラウザ起動
		
		//検索ボックスの要素をID属性名から取得
		WebElement element = driver.findElement(By.name("q"));
		
		//検索テキストボックスに文字列を入力
		element.sendKeys("selenium");
		
		//Enter押下
		element.submit();
		
		//検索結果の一番上の文言をコンソール出力
		WebElement element2 = driver.findElement(By.cssSelector("div.yuRUbf > a > h3"));
		System.out.println(element2.getText());
	
		//ブラウザ閉じる
		driver.quit();
	}

}


