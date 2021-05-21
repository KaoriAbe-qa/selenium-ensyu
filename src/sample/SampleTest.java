package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
	WebDriver driver = new ChromeDriver(); //ChromeDriver�̍쐬
	driver.get ("http://www.google.com/xhtml"); //get()�Ńu���E�U�N��
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO �����������ꂽ catch �u���b�N
		e.printStackTrace();
	} //�������~(����m�F�̈�)
	//�u���E�U�̗v�f���w��@���\�b�h�����킩��₷���ł���ˁB
	WebElement searchBox = driver.findElement(By.name("q"));
	searchBox.sendKeys("ChromeDriver");
	searchBox.submit();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO �����������ꂽ catch �u���b�N
		e.printStackTrace();
	}		
	driver.quit(); //�u���E�U�����B

	}

}
