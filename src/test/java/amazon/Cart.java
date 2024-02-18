package amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cart {
	WebDriver driver;
	public Cart(WebDriver driver) {
		this.driver=driver;

	}
	@BeforeMethod
	public void AddToCart() {
		driver.findElement(By.xpath("//div[@id='nav-search']/child::form/div[2]/div/input")).sendKeys("Shirts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//div[@id='nav-search']/child::form/div[3]/div/span/input")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[@class='puis-card-container s-card-container s-overflow-hidden aok-relative puis-expand-height puis-include-content-margin puis puis-v1edbe4bhq8wue299td5uj4h2b9 s-latency-cf-section puis-card-border']/descendant::div[8]/child::h2[1]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ArrayList<String>Handle=new ArrayList(driver.getWindowHandles());
		   Iterator itr=Handle.iterator();
		   String ParentWindow=(String) itr.next();
		   String window1=(String) itr.next();
		   String window2=(String)itr.next();
		  driver.switchTo().window(window2);

        driver.findElement(By.xpath("//div[@id='addToCart_feature_div'][2]/child::div/span/span/span/input")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



	}
  @Test
  public void Cart_Page() {
       driver.findElement(By.xpath("//div[@id='nav-tools']/child::a[5]")).click();
       WebElement ShoppingCart=driver.findElement(By.xpath("//div[@id='sc-active-cart']/child::div/div/div/h1"));
       System.out.println(ShoppingCart.getText()+"   "+ShoppingCart.isDisplayed());

       WebElement Title=driver.findElement(By.xpath("//div[@class='sc-item-content-group']/child::ul/li/span/a/span/span/span[1]"));
       System.out.println("ProductTitle:    "+Title.getText());

       WebElement Availability=driver.findElement(By.xpath("//div[@class='sc-grid-content-tail']/child::li/span/span[1]"));
       System.out.println("Availability:   "+Availability.getText());

       WebElement Modelname=driver.findElement(By.xpath("//div[@class='sc-grid-content-tail']/child::li[4]/span/span[2]"));
       System.out.println("Model Name:    "+Modelname.getText());

       
       driver.findElement(By.xpath("//div[@class='a-popover-wrapper']/child::div/ul/li[4]/a")).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

       WebElement Price=driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']/child::span/span"));
       System.out.println("Price:   "+Price.getText());
  }

  @AfterMethod
 public void Delete() {
	  driver.findElement(By.xpath("//div[@class='a-row sc-action-links']/child::span[2]/span/input")).click();
	  System.out.println("Product Deleted!!!");
	  List<WebElement>Dltmsg=driver.findElements(By.xpath("//div[@class='sc-list-item-removed-msg']/child::div/span/a"));
	  for(WebElement msg:Dltmsg) {
       System.out.println(msg.getText());
	  }

	  WebElement CartEmpty=driver.findElement(By.xpath("//div[@class='a-row sc-cart-header']/child::div/h1"));
	  System.out.println(CartEmpty.getText());
	  driver.navigate().back();
  }
}
