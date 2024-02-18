package amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Products {
	WebDriver driver;
	public Products(WebDriver driver) {
		this.driver=driver;
	}

	@BeforeMethod
	public void SearchProduct() {
		WebElement SearchBar=driver.findElement(By.xpath("//div[@id='nav-search']/child::form/div[2]/div/input"));
		System.out.println("Search bar is Displayed:   "+SearchBar.isDisplayed());
		SearchBar.sendKeys("Tops");
		System.out.println(driver.getTitle());

		WebElement SearchBtn=driver.findElement(By.xpath("//div[@id='nav-search']/child::form/div[3]/div/span/input"));
		System.out.println("Search Button is Displayed:    "+SearchBtn.isDisplayed());
		SearchBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		List<WebElement>Tops=driver.findElements(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-micro puis-padding-right-micro']/child::div/h2/a/span"));
		System.out.println("User is able to view the products for 'Tops'");
		for(WebElement List:Tops) {
			System.out.println(List.getText());
		}

	}
  @Test
  public void Product() {
	  List<WebElement>ProductLists=driver.findElements(By.xpath("//div[@class='a-row a-size-base a-color-secondary']/child::h2/span"));
	  for (WebElement Lists:ProductLists) {
		  System.out.println(Lists.getText());
	  }
	  driver.navigate().back();
	   driver.findElement(By.xpath("//div[@id='nav-search']/child::form/div[2]/div/input")).sendKeys("Women Dresses");
	   System.out.println(driver.getTitle());
	    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

	   driver.findElement(By.xpath("//div[@class='a-section a-spacing-base a-text-center']/child::div/div/span/a[1]")).click();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	   ArrayList<String>Handle=new ArrayList(driver.getWindowHandles());
	   Iterator itr=Handle.iterator();
	   String ParentWindow=(String) itr.next();
	   String window1=(String) itr.next();
	   driver.switchTo().window(window1);

	   WebElement ProductPage=driver.findElement(By.xpath("//div[@id='centerCol']/child::div/div[2]/div/div[1]/h1/span[1]"));
	   System.out.println(ProductPage.getText()+"     "+ProductPage.isDisplayed());
	   System.out.println(driver.getTitle());

	   WebElement Brand=driver.findElement(By.xpath("//div[@id='centerCol']/child::div/div/div/div[1]/a[1]"));
	   System.out.println(Brand.getText()+"   "+Brand.isDisplayed());



	   WebElement OfferPrice=driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/child::div[1]/span[1]"));
	   System.out.println(OfferPrice.getText()+"   "+OfferPrice.isDisplayed());

	   WebElement MRP_price=driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/child::div[2]/child::span[1]/span/span[1]"));
	   System.out.println(MRP_price.getText()+"   "+MRP_price.isDisplayed());

	   WebElement ProductDetails=driver.findElement(By.xpath("//div[@id='productFactsDesktopExpander']/child::div/h3[1]"));
	   System.out.println(ProductDetails.getText()+"   "+ProductDetails.isDisplayed());

	   List<WebElement>DetailList=driver.findElements(By.xpath("//div[@id='productFactsDesktopExpander']/child::div/div/child::div/div/span/span"));
	   for(WebElement List:DetailList) {
		   System.out.println(List.getText() );
	   }

	   WebElement CartBtn=driver.findElement(By.xpath("//div[@class='a-button-stack'][1]/child::span/span/span/input[1]"));
	   System.out.println(CartBtn.getText()+"   "+CartBtn.isDisplayed());

	   WebElement BuyNow=driver.findElement(By.xpath("//div[@id='buyNow']/child::span/span/input[1]"));
	   System.out.println(BuyNow.getText()+"   "+BuyNow.isDisplayed());

  }
  public void ProductImage() {
	  WebElement Image=driver.findElement(By.xpath("//div[@id='imgTagWrapperId']/child::img"));
	  System.out.println(Image.isDisplayed());

	  Actions A=new Actions(driver);
	  WebElement Img1=driver.findElement(By.xpath("//div[@id='altImages']/child::ul/li[3]/span/span/span/span/img"));
	  A.moveToElement(Img1).build().perform();
	  Img1.click();
	  System.out.println(Img1.getAttribute("data-a-manual-replacement"));

	  WebElement Img2=driver.findElement(By.xpath("//div[@id='altImages']/child::ul/li[4]/span/span/span/span/img"));
	  A.moveToElement(Img2).build().perform();
	  Img2.click();
	  System.out.println(Img1.getAttribute("data-a-manual-replacement"));

	  WebElement Img3=driver.findElement(By.xpath("//div[@id='altImages']/child::ul/li[5]/span/span/span/span/img"));
	  A.moveToElement(Img3).build().perform();
	  Img3.click();
	  System.out.println(Img1.getAttribute("data-a-manual-replacement"));

	  WebElement Img4=driver.findElement(By.xpath("//div[@id='altImages']/child::ul/li[6]/span/span/span/span/img"));
	  A.moveToElement(Img4).build().perform();
	  Img4.click();
	  System.out.println(Img1.getAttribute("data-a-manual-replacement"));

	  WebElement WishListBtn=driver.findElement(By.xpath("//div[@id='add-to-wishlist-button-group']/child::span/span/input"));
	  System.out.println(WishListBtn.getText()+"   "+WishListBtn.isDisplayed());
	  WishListBtn.click();

	  WebElement Heading=driver.findElement(By.xpath("//div[@class='a-popover-wrapper']/child::header/h4"));
	  System.out.println(Heading.getText()+"    "+Heading.isDisplayed());

	  WebElement Cancel=driver.findElement(By.xpath("//div[@class='a-form-actions a-spacing-none']/child::span/span/span/input[1]"));
	  Cancel.click();

  }
  @AfterMethod
  public void Back() {
	  driver.navigate().back();
	  System.out.println(driver.getTitle());
	  ArrayList<String>Handle=new ArrayList(driver.getWindowHandles());
	   Iterator itr=Handle.iterator();
	   String ParentWindow=(String) itr.next();
	   String window1=(String) itr.next();
	   driver.switchTo().window(ParentWindow);
	   driver.navigate().back();

  }
}
