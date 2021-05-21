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
		
		//ChromeDriver�̍쐬(Chrome�N��)
		WebDriver driver = new ChromeDriver();
		
		//http://www.google.com/�ւ̃A�N�Z�X
		driver.get("http://rakuplus.jp/");
		
		//ID���̓{�b�N�X�̗v�f��ID����������擾
		WebElement idBox = driver.findElement(By.id("user_login"));
				
		//ID���̓{�b�N�X�ɕ���������
		idBox.sendKeys("�_�~�[ID");
				
		//PW���̓{�b�N�X�̗v�f��ID����������擾
		WebElement passBox = driver.findElement(By.id("user_pass"));
						
		//PW���̓{�b�N�X�ɕ���������
		passBox.sendKeys("�_�~�[PW");
				
		//���O�C���{�b�N�X�̗v�f��ID����������擾
		WebElement loginBox = driver.findElement(By.id("user_pass"));
		
		//Enter����
		loginBox.submit();
		
		//�X�N���[���V���b�g���擾
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(file.toPath(), new File("C:/eclipse/" + file.getName()).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
