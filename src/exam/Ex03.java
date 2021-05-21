package exam;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex03 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		
		//ChromeDriverの作成(Chrome起動)
		WebDriver driver = new ChromeDriver();
		
		//URLへのアクセス
		driver.get("https://www.e-procurement.metro.tokyo.jp/");
		
		//リンクテキスト名を指定して要素を取得
		WebElement element = driver.findElement(By.linkText("入札情報サービス"));
		
		//もとのハンドルを記憶
		String Handle = driver.getWindowHandle();
		
		//画像のリンクをクリック
		element.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//遷移
		//タブの数分繰り返して　新しいハンドルにする
		String newHandle = null;
		for(String id : driver.getWindowHandles()) {
			if(!id.equals(Handle)) {
				newHandle = id;
			}
		}
		//newHandleにハンドルを渡す
		driver.switchTo().window(newHandle);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//とんだ先でクリック
		WebElement element2 = driver.findElement(By.cssSelector("#topMenuBtn03 > a"));
		element2.click();
		
		//入力
		//リンクテキスト名を指定して文字列を入力：令和〇年
		WebElement element3 = driver.findElement(By.name("StartDateYY"));
		element3.sendKeys("3");
		
		//リンクテキスト名を指定して文字列を入力：〇月
		WebElement element4 = driver.findElement(By.name("StartDateMM"));
		element4.sendKeys("5");
		
		//リンクテキスト名を指定して文字列を入力：〇日
		WebElement element5 = driver.findElement(By.name("StartDateDD"));
		element5.sendKeys("21");
		
		//リンクテキスト名を指定して文字列を入力：令和〇年
		WebElement element6 = driver.findElement(By.name("EndDateYY"));
		element6.sendKeys("3");
			
		//リンクテキスト名を指定して文字列を入力：〇月
		WebElement element7 = driver.findElement(By.name("EndDateMM"));
		element7.sendKeys("6");
		
		//リンクテキスト名を指定して文字列を入力：〇日
		WebElement element8 = driver.findElement(By.name("EndDateDD"));
		element8.sendKeys("30");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//検索実行
		WebElement elementSearch = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"));
		elementSearch.click();
		
		//遷移
		ArrayList<String> newTab =new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		
		//確認用
		System.out.println("二回目の遷移もOK");
		
		
		//テーブルから値を取得
		//まずテーブルの行数を取得
		int row = driver.findElement(By.className("list-data")).findElements(By.tagName("tr")).size();
		
		//rowの数繰り返す(1はタイトルなので除外)
		for(int i = 2; i <= row; i++) {
			String xpath = "/html/body/div[3]/div/form/table[5]/tbody/";
			
			String xp = xpath + "tr[" + i + "]/";
			
			//例：xp = /html/body/div[3]/div/form/table[5]/tbody/tr[2]/td[1]
			for(int j = 1; j <= 3; j++) {
				
				String ypath = xp + "td[" + j + "]";
				
                //コンソールへの書き出し
                System.out.print(driver.findElement(By.xpath(ypath)).getText());
			}
			//1行分終わったら改行
            System.out.println("\n");
            
            try {
    			Thread.sleep(500);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}		
		
	}

}
