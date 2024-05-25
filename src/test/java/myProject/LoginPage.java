package myProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	public boolean isStringArraySorted(String[] str) {
		  for (int i = 1; i < str.length; i++) {
		    if (str[i].compareTo(str[i - 1]) < 0) {
		      return false;
		    }
		  }
		  return true;
		}

	 WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException{
		
		Properties pro = new Properties();
		
		FileInputStream File = new FileInputStream("C:\\Users\\Manisha\\Documents\\workspace-spring-tool-suite-4-4.21.1.RELEASE\\WingifyDemoProject\\src\\test\\resources\\wingify.properties");
	
		pro.load(File);
		
		//set the browser
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(pro.getProperty("DemoAppUrl"));
			
}
	@Test(priority = 1)
	public void assertion() throws InterruptedException {
		String expected_title = "Demo App";
		String actual_title = "Demo App";
		
		// ---------Soft Assertion---------
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(expected_title, actual_title);
		
		//if my soft assertion got fail still the further script will run
		driver.findElement(By.id("username")).sendKeys("Manisha");
		
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 2)
	public void validTest1() throws InterruptedException {
		
		//first I want to scroll down the page
		
        JavascriptExecutor jE = (JavascriptExecutor) driver; //type casting javascriptExecutor
		
		WebElement fbImg = driver.findElement(By.xpath("//img[@src='img/facebook.png']"));
		
		jE.executeScript("arguments[0].scrollIntoView();", fbImg);
		
		Thread.sleep(5000);
			
	    driver.findElement(By.id("username")).sendKeys("Manisha");
	    Thread.sleep(2000);
	
	    driver.findElement(By.id("password")).sendKeys("admin");
	    Thread.sleep(2000);
	
	    driver.findElement(By.id("log-in")).click();
	    Thread.sleep(4000);
	    
	   //--------clicking on remember me checkbox--------
	    
	    //driver.findElement(By.xpath("//input[@class='form-check-input']")).click();

}
     @Test(priority = 3)
	public void negativetest1() throws InterruptedException {
    	 
    	//-----------will scroll down the page----------
 		
         JavascriptExecutor jE = (JavascriptExecutor) driver; //type casting javascriptExecutor
 		
 		WebElement fbImg = driver.findElement(By.xpath("//img[@src='img/facebook.png']"));
 		
 		jE.executeScript("arguments[0].scrollIntoView();", fbImg);
 		
 		Thread.sleep(5000);
 		
 	    driver.findElement(By.id("username")).sendKeys("Manisha");
 	    Thread.sleep(2000);
 	
 	    driver.findElement(By.id("password")).sendKeys("");
 	    Thread.sleep(2000);
 	
 	    driver.findElement(By.id("log-in")).click();
 	    Thread.sleep(4000);
	}
     @Test(priority = 4)
     public void negativeTest2() throws InterruptedException {
    	
    	//----------will scroll down the page----------
  		
         JavascriptExecutor jE = (JavascriptExecutor) driver; //type casting javascriptExecutor
 		
 		WebElement fbImg = driver.findElement(By.xpath("//img[@src='img/facebook.png']"));
 		
 		jE.executeScript("arguments[0].scrollIntoView();", fbImg);
 		
 		Thread.sleep(5000);
 		
 	    driver.findElement(By.id("username")).sendKeys("");
 	    Thread.sleep(2000);
 	
 	    driver.findElement(By.id("password")).sendKeys("admin");
 	    Thread.sleep(2000);
 	
 	    driver.findElement(By.id("log-in")).click();
 	    Thread.sleep(4000);
     }
	 @Test(priority = 5)
     public void negativeTest3() throws InterruptedException {
		 
    	//--------will scroll down the page--------
  		
         JavascriptExecutor jE = (JavascriptExecutor) driver; //type casting javascriptExecutor
 		
 		WebElement fbImg = driver.findElement(By.xpath("//img[@src='img/facebook.png']"));
 		
 		jE.executeScript("arguments[0].scrollIntoView();", fbImg);
 		
 		Thread.sleep(5000);
 		
 	    driver.findElement(By.id("username")).sendKeys("");
 	    Thread.sleep(2000);
 	
 	    driver.findElement(By.id("password")).sendKeys("");
 	    Thread.sleep(2000);
 	
 	    driver.findElement(By.id("log-in")).click();
 	    Thread.sleep(4000);
     }
	@Test(priority = 6)
	public void isAmountSorted() throws InterruptedException {
		
		//--------------will login the page----------------
		
		driver.findElement(By.id("username")).sendKeys("Manisha");
	    Thread.sleep(2000);
	
	    driver.findElement(By.id("password")).sendKeys("admin");
	    Thread.sleep(2000);
	
	    driver.findElement(By.id("log-in")).click();
	    Thread.sleep(4000);
	   
		//-------------will get text from table-------------
	    
	     driver.findElement(By.id("amount")).click();
	     Thread.sleep(4000);
	    
		 String row1 = driver.findElement(By.xpath("//*[@id='transactionsTable']//tbody/tr[1]/td[5]")).getText();
		
		 String row2 = driver.findElement(By.xpath("//*[@id='transactionsTable']//tbody/tr[2]/td[5]")).getText();
		 
		 String row3 = driver.findElement(By.xpath("//*[@id='transactionsTable']//tbody/tr[3]/td[5]")).getText();
	
		 String row4 = driver.findElement(By.xpath("//*[@id='transactionsTable']//tbody/tr[4]/td[5]")).getText();
		
		 String row5 = driver.findElement(By.xpath("//*[@id='transactionsTable']//tbody/tr[5]/td[5]")).getText();
		
		 String row6 = driver.findElement(By.xpath("//*[@id='transactionsTable']//tbody/tr[6]/td[5]")).getText();
		 
		
		System.out.println(row1);
		System.out.println(row2);
		System.out.println(row3);
		System.out.println(row4);
		System.out.println(row5);
		System.out.println(row6);
		
		//--------will store it in a String array---------
		
		String[] str = {"row1", "row2", "row3", "row4", "row5", "row6",};
		
		//--------will check it is sorted or not-----------
		
		if(isStringArraySorted(str)) {
			System.out.println("Table is sorted");
		}else {
			System.out.println("Table is not sorted");
		}
			
	}
	
	@AfterMethod
	    public void tearDown() {
	        
	            driver.quit();
	      
	    }
}