package LogInProject.LogInProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	private WebDriver driver;
	
	public LogInPage(WebDriver driver){
		this.driver = driver;
	}
	
	private By userName = By.id("username");
	private By passWord = By.id("password");
	private By submit = By.id("submit");
	
	public void enterCredentials(String a, String b) {
		driver.findElement(userName).sendKeys(a);
		driver.findElement(passWord).sendKeys(b);
		driver.findElement(submit).click();
		}

}
