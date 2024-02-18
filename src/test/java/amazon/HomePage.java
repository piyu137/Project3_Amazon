package amazon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage {
  WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	@BeforeMethod
	public void Logo() throws IOException {
		WebElement Logo=driver.findElement(By.xpath("//div[@id='nav-logo']/child::a"));
		System.out.println(Logo.getAttribute("aria-label")+"   "+Logo.isDisplayed());
		File src=Logo.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\ScreenShots\\LogoSs.jpeg");
		FileHandler.copy(src, dest);
		System.out.println("__Screenshot Captured!!!____");
	}
  @Test
  public void Homefunctions() {

	  List< WebElement> Location=driver.findElements(By.xpath("//div[@id='nav-global-location-slot']/child::span/a/div[2]/span"));
	  for(WebElement list:Location) {
		  System.out.println(list.getText());
	  }
	  Actions a=new Actions(driver);
	  WebElement Lang=driver.findElement(By.xpath("//div[@class='nav-right']/child::div/a[1]"));
	  a.moveToElement(Lang).build().perform();

	  List<WebElement>Languages=driver.findElements(By.xpath("//div[@id='nav-flyout-icp']/child::div[2]/a/span"));
	  for (WebElement lang:Languages) {
		  System.out.println(lang.getText());
	  }

	WebElement Flag=driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/child::a[1]"));
	System.out.println("Flag Symbol is Displayed:   "+Flag.isDisplayed()+Flag.getAttribute("label"));

	  Actions a1=new Actions(driver);
	  WebElement SignIn=driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/child::a[2]/div/span"));
	  a1.moveToElement(SignIn).build().perform();
	  System.out.println(SignIn.getText()+"    "+SignIn.isDisplayed());

	  WebElement Acc_List=driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/child::a[2]/span "));
	  a1.moveToElement(Acc_List);
	  System.out.println(Acc_List.getText()+"   "+Acc_List.isDisplayed());

	  WebElement YourList=driver.findElement(By.xpath("//div[@id='nav-flyout-anchor']/child::div[2]/div[2]/div/div[2]/div"));
	  System.out.println(YourList.getText());
	  List<WebElement>List=driver.findElements(By.xpath("//div[@id='nav-flyout-anchor']/child::div[2]/div[2]/div/div[2]/a"));
	  for(WebElement yList:List) {
		  System.out.println(yList.getText());
	  }
	  WebElement YourAccount=driver.findElement(By.xpath("//div[@id='nav-flyout-anchor']/child::div[2]/div[2]/div/div[3]/div"));
	  System.out.println(YourAccount.getText());
	  List<WebElement>Account=driver.findElements(By.xpath("//div[@id='nav-flyout-anchor']/child::div[2]/div[2]/div/div[3]/a"));
	   for(WebElement AccList:Account) {
		   System.out.println(AccList.getText());
	   }
	   Actions a3=new Actions(driver);
	   WebElement Returns=driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/child::a[3]/span[1]"));
	   a3.moveToElement(Returns).build().perform();
	   System.out.println(Returns.getText());
	   WebElement Orders=driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/child::a[3]/span[2]"));
	   a3.moveToElement(Orders).build().perform();
	   System.out.println(Orders.getText());
	   WebElement Cart=driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/child::a[4]/div[2]/span[2]"));
	   a3.moveToElement(Cart).build().perform();
	   System.out.println(Cart.getText());
	   WebElement CartSymbol=driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/child::a[4]"));
	   a3.moveToElement(CartSymbol).build().perform();
	   System.out.println("Cart Symbol Displayed:   "+CartSymbol.isDisplayed());

	 List<WebElement>Products=driver.findElements(By.xpath("//div[@id='gw-layout']/child::div/div/div/div"));
	 for(WebElement ProdList:Products) {
		 System.out.println(ProdList.getText());
	 }

  }

  @AfterMethod
  public void Reccomendations() {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,350)", "");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));



	 List<WebElement> FooterHead=driver.findElements(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/child::div/div"));
	 for(WebElement Heading:FooterHead) {
	 System.out.println(Heading.getText()+"    "+Heading.isDisplayed());
	 }

	 List<WebElement>FooterContent=driver.findElements(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/child::div/ul/li"));
     for(WebElement Content:FooterContent) {
    	 System.out.println(Content.getText());
     }
	  WebElement Back=driver.findElement(By.xpath("//div[@class='navLeftFooter nav-sprite-v1']/child::a"));
	  System.out.println(Back.getText()+"   "+Back.isDisplayed());
	  Back.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
  }
}
