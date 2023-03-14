import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class Image_upload {
	static WebDriver driver=null;
	static String filename;
	static int select;
	static String projectDirpath = System.getProperty("user.dir");
	

public static void main(String[] args) throws IOException {
			System.out.println("Select 1 for chrome and 2 for Mozilla");
			Scanner sc=new Scanner(System.in);
			select=sc.nextInt();
			if (select==1) 
			{
			// For chrome Browser	
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Gajendra\\Downloads\\chromedriver_win32\\chromedriver.exe");

			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			//Open the google search page in the specified Browser
			driver.navigate().to("http://www.google.com");
			
			System.out.println("Opening webpage in Chrome.");

			//Displaying title of the page
			System.out.println(driver.getTitle());
			
			//Maximizing the window
			driver.manage().window().maximize();
			
			//Verifying title of the page
			Assert.assertEquals(driver.getTitle(),"Google");
			System.out.println("Title of the Page: "+driver.getTitle());
			
			//Navigate to the image link to search for image 
			driver.findElement(By.linkText("Images")).click();

			//Taking screenshot of image link page
			takescreenshot(driver,"image");

			//Navigate to the image upload page  
			 driver.findElement(By.className("LM8x9c")).click();

			//Taking screenshot of upload page
			 takescreenshot(driver,"image");

			 //Select upload option in image search page
			  driver.findElement(By.linkText("Upload an image")).click();

			//Taking screenshot of upload page
			  takescreenshot(driver,"image");

			//uploading image
			String imagePath = projectDirpath + "\\screenshots\\img1.jpg";
			driver.findElement(By.xpath("//input[@id='awyMjb']")).sendKeys(imagePath);
			
			//Validating the result
			WebElement verify = driver.findElement(By.xpath("//div[@id='result-stats']")); 
			String val = verify.getText();
			System.out.println(val);
			
			//Taking screenshot of Result
			takescreenshot(driver,"image");
			 
		   //finding number of links in the result page
			  List<WebElement> links=driver.findElements(By.tagName("a"));
			  System.out.println("No of Links: "+links.size());
		  
		  // Closing the Browser
		       driver.close();  
	}
			else{
				 System.setProperty("webdriver.gecko.driver","C:\Users\user\Desktop\Driver File");

					WebDriver drivers=new FirefoxDriver();
					drivers.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
					
					//Open the google search page in the specified Browser
					drivers.navigate().to("http://www.google.com");
					
					System.out.println("Opening webpage in FireFox.");

					//Displaying title of the page
					System.out.println(drivers.getTitle());
					
					//Maximizing the window
					drivers.manage().window().maximize();
					
					//Verifying title of the page
					Assert.assertEquals(drivers.getTitle(),"Google");
					System.out.println("Title of the Page: "+drivers.getTitle());
					
					//Navigate to the image link to search for image 
					drivers.findElement(By.linkText("Images")).click();

					//Taking screenshot of image link page
					takescreenshot(drivers,"image");

					//Navigate to the image upload page  
					 drivers.findElement(By.className("LM8x9c")).click();

					//Taking screenshot of upload page
					 takescreenshot(drivers,"image");

					 //Select upload option in image search page
					  drivers.findElement(By.linkText("Upload an image")).click();

					//Taking screenshot of upload page
					  takescreenshot(drivers,"image");

								
					//uploading image
					  String imagePath = projectDirpath + "\\screenshots\\img1.jpg";
					drivers.findElement(By.xpath("//input[@id='awyMjb']")).sendKeys(imagePath);
			       
					//Validating the result
					WebElement verifys = drivers.findElement(By.xpath("/html/body/div[7]/div/div[7]/div/div/div/div"));
					String val1 = verifys.getText();
					System.out.println(val1);
					
					//Taking screenshot of Result
					takescreenshot(drivers,"image");
					 
				
					//finding number of links in the result page
					  List<WebElement> link=drivers.findElements(By.tagName("a"));
					  System.out.println("No of Links: "+link.size());
					  
				  
					  //Closing the Browser
					  drivers.close();
				
			}}

		public static void takescreenshot(WebDriver driver, String name) throws IOException
		 {
			Random randNumber = new Random();
			String filename = name + String.valueOf(randNumber.nextInt());
		  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(file, new File(projectDirpath + "\\screenshots\\"+filename + ".jpg"));
		 }
}
