package amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Buy_Checkout {
	WebDriver driver;
	public Buy_Checkout(WebDriver driver) {
		this.driver=driver;
		}

	@BeforeMethod
	public void product() {
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/child::input")).sendKeys("Headphones");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//div[@class='puisg-row'][1]/child::div[2]/div/div/div[1]/h2[1]/a[1]")).click();

		WebElement title=driver.findElement(By.xpath("//div[@id='centerCol']/child::div/div/h1/span[1]"));
		System.out.println(title.getText());

		WebElement available=driver.findElement(By.xpath("//div[@id='availabilityInsideBuyBox_feature_div']/child::div/div/span"));
		System.out.println(available.getText());

		WebElement Cart=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		Cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));




	}
  @Test
  public void BuyNow() {
	  WebElement BuyNow=driver.findElement(By.xpath("//div[@id='sw-atc-bb'][1]/child::div/form/span/span/span/input[1]"));
	  BuyNow.click();

	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pooja@0137");
	  driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	  WebElement MobNo=driver.findElement(By.xpath("//div[@class='a-row'][1]/child::div/h1"));
	  System.out.println(MobNo.getText());
  }

  @AfterMethod
  public void GetBack() {
	  ArrayList<String>Handle=new ArrayList(driver.getWindowHandles());
	   Iterator itr=Handle.iterator();
	   String ParentWindow=(String) itr.next();
	   String window1=(String) itr.next();
	   String window2=(String)itr.next();
	  driver.switchTo().window(ParentWindow);

  }
}
