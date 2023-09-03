package rahulshettyacademy.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest 
	public void config() {
     String path = System.getProperty("user.dir") + "\\reports\\index.html";
 	ExtentSparkReporter reporterr= new ExtentSparkReporter(path);
	reporterr.config().setDocumentTitle("Test Results");
	reporterr.config().setReportName("Extent Reports");
	
	extent=new ExtentReports();
	
	extent.attachReporter(reporterr);///attaching report to main test
	extent.setSystemInfo("Tester", "Nisha Hashmi");
	

	
	}
	
	
	
	
	
	@Test
	 public void InitialDemo() {
		ExtentTest test =extent.createTest("InitialDemo");
		WebDriver driver =new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver.get("http://the-internet.herokuapp.com/");
		System.out.println(driver.getTitle());
		driver.close();
//		test.fail("Fail test");
		extent.flush();
		
		
	}
	

}
