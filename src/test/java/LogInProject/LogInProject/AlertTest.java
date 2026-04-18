package LogInProject.LogInProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AlertTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless=new");
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");
		
		driver = new ChromeDriver(opt);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
		driver.manage().window().maximize();
		System.out.println("Hi");
	}
	@Test(dataProvider = "getData1")
	public void logIn(String value) throws InterruptedException{
		AlertPage alertPage = new AlertPage(driver);
		String store = alertPage.alertActionMethod(value);
		System.out.println(store);
		
	}
	@DataProvider(name = "getData1")
	public Object[][] getData1() throws IOException{
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\Desktop\\ExcelData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheet("Alert");
		int rowCount = sh.getLastRowNum();
		int columnCount = 1;
		Object[][] obj = new Object[rowCount][columnCount];
		for(int i=1; i<=rowCount; i++) {
			obj[i-1][0] = sh.getRow(i).getCell(0).toString();
		}
		return obj;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
