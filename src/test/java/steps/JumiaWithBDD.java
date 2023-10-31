package steps;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JumiaWithBDD {
	
	
	private WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("The user is able to Navigate to Jumia")
	public void the_user_is_able_to_navigate_to_jumia() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\Selenium\\src\\test\\java\\Webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get ("https://www.jumia.com.eg/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@aria-label=\'newsletter_popup_close-cta\']")).click();
		driver.findElement(By.xpath("//label[@class=\'trig -df -i-ctr -fs16\']")).click();	
	    driver.findElement(By.xpath("//a[@class=\'btn _prim -fw _md\']")).click();
	    

	}

	@When("The user is able to register with no issues")
	public void the_user_is_able_to_register_with_no_issues() {
		
		WebElement emailTxt= driver.findElement(By.xpath("//input[@class=\'mdc-text-field__input\']"));
		WebElement continueBtn = driver.findElement(By.className("mdc-button__touch"));
		emailTxt.clear();
		emailTxt.sendKeys("sarahnassereg@gmail.com");
		continueBtn.click();
        driver.findElement(By.xpath("//input[@name=\'password\']")).sendKeys("jumiajumia123456");
        
        driver.findElement(By.xpath("//*[@id=\"card_password\"]/div[4]/label/input")).sendKeys("jumiajumia123456");
        driver.findElement(By.xpath("//*[@id=\"card_password\"]/div[5]/div/button")).submit();
        System.out.println("Personal details");
        WebElement personalInfo = driver.findElement(By.className("mdc-text-field__input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", personalInfo);
        boolean personalInfo1 = personalInfo.isSelected();
        if (personalInfo1) {
            System.out.println("Checkbox is not checked");
         }else {
            System.out.println("Checkbox is checked");
         }
     
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("document.getElementsByName('first_name')[0].value= 'Selenium'");
        System.out.println("Selenium is the first name");
        
        JavascriptExecutor z = (JavascriptExecutor) driver;
        z.executeScript("document.getElementsByName('last_name')[0].value= 'BDD'"); 
        System.out.println("BDD is the last name");
     	        
    	        
    	        WebElement continueAgain = driver.findElement(By.className("mdc-text-field__input"));
    	        JavascriptExecutor ss = (JavascriptExecutor) driver;
    	        ss.executeScript("arguments[0].click();", continueAgain);
    	        boolean continueAgain1 = personalInfo.isSelected();
    	        if (continueAgain1 ) {
    	            System.out.println("Checkbox is not checked");
    	         }else {
    	            System.out.println("Checkbox is checked");
    	         }


	}

	
	@Then("The account is created successfully")
	public void The_account_is_created_successfully() {
       
   	 JavascriptExecutor f = (JavascriptExecutor) driver;
     f.executeScript("document.getElementsByName('gender')[0].value= 'female'");
    System.out.println("Gender is female");
    
   
   
	 JavascriptExecutor b = (JavascriptExecutor) driver;
 b.executeScript("document.getElementsByName('birth_date')[0].value= '07/27/1997'");
System.out.println("Birthday is checked successfully!");

JavascriptExecutor js = (JavascriptExecutor)driver;   
js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@id=\"acceptTC\"]")));
System.out.println("I read and consented to the Terms and Conditions!");



JavascriptExecutor fin = (JavascriptExecutor)driver;   
fin.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@id=\"confirmBtn\"]/span[3]")));
System.out.println("The Account is finally created !! ");

    driver.quit();
	}

}
