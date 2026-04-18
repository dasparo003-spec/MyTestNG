package LogInProject.LogInProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
	
	private WebDriver driver;
	
	public AlertPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By textName = By.xpath("//input[@name=\"enter-name\"]");
	private By button = By.id("alertbtn");
	
	public String alertActionMethod(String a) {
		driver.findElement(textName).sendKeys(a);
		driver.findElement(button).click();
		Alert alert = driver.switchTo().alert();
		 String store = alert.getText();
		alert.accept();
		return store;
	}

}
