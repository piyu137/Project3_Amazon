package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUp {
	WebDriver driver;
	public SignUp(WebDriver driver) {
		this.driver=driver;
	}
	@BeforeMethod
	public void SignUpBtn() {
		Actions a=new Actions(driver);
		  WebElement SignUp=driver.findElement(By.xpath("//div[@id='navbar']/child::div/div[3]/div/a[2]"));
		  a.moveToElement(SignUp).build().perform();
		  driver.findElement(By.xpath("//div[@id='nav-al-container']/child::div[1]/div[1]/a")).click();
		  System.out.println(driver.getTitle());
		  WebElement title=driver.findElement(By.xpath("//div[@class='a-box']/child::div/h1"));
		  System.out.println(title.getText());
	}
  @Test
  public void NewAccount() {
	  WebElement CreateAcc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-base']/child::span[1]/span/a"));
	  System.out.println(CreateAcc.getText()+"    "+CreateAcc.isDisplayed());
	  CreateAcc.click();
	  System.out.println(driver.getTitle());

	  WebElement CreateTitle=driver.findElement(By.xpath("//div[@class='a-box a-spacing-extra-large']/child::div/h1"));
	  System.out.println(CreateTitle.getText()+"    "+CreateTitle.isDisplayed());

	  WebElement Name=driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
	  Name.sendKeys("Piyu Gaikwad");

	  WebElement CountryCode=driver.findElement(By.xpath("//div[@class='a-fixed-left-grid-col a-col-left']/child::span/span/span/span"));
	  CountryCode.click();
	  WebElement Country=driver.findElement(By.xpath("//div[@class='a-popover a-dropdown a-dropdown-common a-declarative']/child::div/div/ul/li[93]/a"));
	  Country.click();

	  WebElement MobNo=driver.findElement(By.xpath("//input[@id='ap_phone_number']"));
	  MobNo.sendKeys("9175480137");

	  WebElement Password=driver.findElement(By.xpath("//input[@id='ap_password']"));
	  Password.sendKeys("Piyu@2020");

	  WebElement Submit=driver.findElement(By.xpath("//div[@class='a-section a-spacing-extra-large ap_mobile_number_fields']/child::span/span/input"));
	  Submit.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

	  System.out.println(driver.getTitle());
      System.out.println("*****____User is Navigated to Aunthentication Page____*****");

  }
  @AfterMethod
  public void MainPage() {
           driver.navigate().back();
           driver.navigate().back();
           driver.navigate().back();

	}
  }
