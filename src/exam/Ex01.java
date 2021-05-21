package exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		
		//ChromeDriver�̍쐬(Chrome�N��)
		WebDriver driver = new ChromeDriver(); 
		
		//http://www.google.com/�ւ̃A�N�Z�X
		driver.get("http://www.google.com/"); //get()�Ńu���E�U�N��
		
		//�����{�b�N�X�̗v�f��ID����������擾
		WebElement element = driver.findElement(By.name("q"));
		
		//�����e�L�X�g�{�b�N�X�ɕ���������
		element.sendKeys("selenium");
		
		//Enter����
		element.submit();
		
		//�������ʂ̈�ԏ�̕������R���\�[���o��
		WebElement element2 = driver.findElement(By.cssSelector("div.yuRUbf > a > h3"));
		System.out.println(element2.getText());
	
		//�u���E�U����
		driver.quit();
	}

}


