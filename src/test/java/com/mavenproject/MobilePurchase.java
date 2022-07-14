package com.mavenproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class MobilePurchase {
	static WebDriver driver;
	static long start;
	
	@BeforeClass
	public static void browserLaunch()throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\selladurai\\eclipse-workspace\\SeleniumProject\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	System.out.println("browser launched");
	}
	  @AfterClass
			public static void browserQuit() {
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.quit();
				System.out.println("browser quit");
				}

   @Before
	public void startingTime() {
	     System.out.println("Before");
	     start = System.currentTimeMillis();
	   }
   

     @After
		public void endingTime() {
    	 long end = System.currentTimeMillis();
			System.out.println("After time taken is :"+ (end -start));
       }
   
    @Test
	public void method1() {
    	 driver.findElement(By.xpath("//button[text()='✕']")).click();
		System.out.println("method 1 - popup handled");
	  }
    @Test
	public void method2() {
    	
    	driver.findElement(By.name("q")).sendKeys("Iphone");
    	 driver.findElement(By.xpath("//button[@type='submit']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("method 2 - phone search is done");
	}
    @Test
  	  public void method3()throws Exception {
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebElement iphone= driver.findElement(By.xpath("(//*[@class='_4rR01T'])[1]"));
    	 String  s = iphone.getText();
    	 System.out.println(s);
    	 iphone.click();
    	 System.out.println("method 3 - phone click is done");
    	  
     	 File f = new File("C:\\Users\\selladurai\\Desktop\\MobileAndTv.xlsx");
    	 Workbook w = new XSSFWorkbook();
    	Sheet sh = w.createSheet("flipcart");
    	 Row r =  sh.createRow(1);
    	Cell c = r.createCell(0);
    	 c.setCellValue(s);
    	 FileOutputStream f1 = new FileOutputStream(f);
    	 w.write(f1);
    	 System.out.println("method 3 - xl write is done");
           
    }
    @Test
	public void method4()throws Exception {
    	String pwin= driver.getWindowHandle();
    	  Set<String> allwin = driver.getWindowHandles();
    	  for (String x : allwin) {
    		if (!x.equals(pwin)) {
    			driver.switchTo().window(x);
    		}}
    		System.out.println("method4 - windows handling is done");
   		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    		WebElement  phone = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
    		 String  s1 = phone.getText();
    		System.out.println(s1);
    		 File f = new File("C:\\Users\\selladurai\\Desktop\\MobileAndTv.xlsx");
        	 Workbook w = new XSSFWorkbook();
        	Sheet sh = w.createSheet("flipcart");
        	 Row r =  sh.createRow(3);
        	Cell c = r.createCell(0);
        	 c.setCellValue(s1);
        	 FileOutputStream f1 = new FileOutputStream(f);
        	 w.write(f1);
        	 System.out.println("method 4 - xl write is done");
    	
	}
    @Test
    	public void method5 ()throws Exception {
    		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    		TakesScreenshot tk = (TakesScreenshot)driver;
    		File source = tk.getScreenshotAs(OutputType.FILE);
    		File target = new File("C:\\Users\\selladurai\\eclipse-workspace\\JunitJuly\\screenshots\\flipcart.png");
    		FileUtils.copyFile(source,target);
    	System.out.println("method 5 - screenshot is done");
			}
}

		
    	


   


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

