package LogInProject.LogInProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInTest {
	public WebDriver driver;

	@BeforeMethod
	public void setUpFunc() {
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
	}
	@Test(dataProvider = "getData")
	public void logInFunc(String userName, String passWord) {
		LogInPage classObj = new LogInPage(driver);
		classObj.enterCredentials(userName, passWord);
		}

	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\Desktop\\ExcelData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheet("Page1");
		int rowCount = sh.getLastRowNum();
		int columnCount = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCount][columnCount]; 

		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				obj[i-1][j] = sh.getRow(i).getCell(j).toString();
			}
		}
		return obj;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
