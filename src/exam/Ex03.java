package exam;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex03 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		
		//ChromeDriver�̍쐬(Chrome�N��)
		WebDriver driver = new ChromeDriver();
		
		//URL�ւ̃A�N�Z�X
		driver.get("https://www.e-procurement.metro.tokyo.jp/");
		
		//�����N�e�L�X�g�����w�肵�ėv�f���擾
		WebElement element = driver.findElement(By.linkText("���D���T�[�r�X"));
		
		//���Ƃ̃n���h�����L��
		String Handle = driver.getWindowHandle();
		
		//�摜�̃����N���N���b�N
		element.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//�J��
		//�^�u�̐����J��Ԃ��ā@�V�����n���h���ɂ���
		String newHandle = null;
		for(String id : driver.getWindowHandles()) {
			if(!id.equals(Handle)) {
				newHandle = id;
			}
		}
		//newHandle�Ƀn���h����n��
		driver.switchTo().window(newHandle);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//�Ƃ񂾐�ŃN���b�N
		WebElement element2 = driver.findElement(By.cssSelector("#topMenuBtn03 > a"));
		element2.click();
		
		//����
		//�����N�e�L�X�g�����w�肵�ĕ��������́F�ߘa�Z�N
		WebElement element3 = driver.findElement(By.name("StartDateYY"));
		element3.sendKeys("3");
		
		//�����N�e�L�X�g�����w�肵�ĕ��������́F�Z��
		WebElement element4 = driver.findElement(By.name("StartDateMM"));
		element4.sendKeys("5");
		
		//�����N�e�L�X�g�����w�肵�ĕ��������́F�Z��
		WebElement element5 = driver.findElement(By.name("StartDateDD"));
		element5.sendKeys("21");
		
		//�����N�e�L�X�g�����w�肵�ĕ��������́F�ߘa�Z�N
		WebElement element6 = driver.findElement(By.name("EndDateYY"));
		element6.sendKeys("3");
			
		//�����N�e�L�X�g�����w�肵�ĕ��������́F�Z��
		WebElement element7 = driver.findElement(By.name("EndDateMM"));
		element7.sendKeys("6");
		
		//�����N�e�L�X�g�����w�肵�ĕ��������́F�Z��
		WebElement element8 = driver.findElement(By.name("EndDateDD"));
		element8.sendKeys("30");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//�������s
		WebElement elementSearch = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"));
		elementSearch.click();
		
		//�J��
		ArrayList<String> newTab =new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		
		//�m�F�p
		System.out.println("���ڂ̑J�ڂ�OK");
		
		
		//�e�[�u������l���擾
		//�܂��e�[�u���̍s�����擾
		int row = driver.findElement(By.className("list-data")).findElements(By.tagName("tr")).size();
		
		//row�̐��J��Ԃ�(1�̓^�C�g���Ȃ̂ŏ��O)
		for(int i = 2; i <= row; i++) {
			String xpath = "/html/body/div[3]/div/form/table[5]/tbody/";
			
			String xp = xpath + "tr[" + i + "]/";
			
			//��Fxp = /html/body/div[3]/div/form/table[5]/tbody/tr[2]/td[1]
			for(int j = 1; j <= 3; j++) {
				
				String ypath = xp + "td[" + j + "]";
				
                //�R���\�[���ւ̏����o��
                System.out.print(driver.findElement(By.xpath(ypath)).getText());
			}
			//1�s���I���������s
            System.out.println("\n");
            
            try {
    			Thread.sleep(500);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}		
		
	}

}
