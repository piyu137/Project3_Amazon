package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
	}

	@BeforeTest
	public void LoginBtn() {
	Actions A=new Actions(driver);
	WebElement Login=driver.findElement(By.xpath("//div[@id='navbar']/child::div/child::div[3]/div/a[2]"));
	A.moveToElement(Login).build().perform();

	WebElement SignIn=driver.findElement(By.xpath("//div[@id='nav-al-container']/child::div[1]/div[1]/a"));
	SignIn.click();


	}
  @Test
  public void LoginData() {
	  WebElement SignInTitle=driver.findElement(By.xpath("//div[@class='a-box']/child::div/h1"));
	  System.out.println(SignInTitle.getText()+"    "+SignInTitle.isDisplayed());

	  WebElement Email=driver.findElement(By.xpath("//div[@class='a-row a-spacing-base']/child::input[1]"));
	  Email.sendKeys("poojagaikwad0137@gmail.com");

	  WebElement Continue=driver.findElement(By.xpath("//div[@class='a-section']/child::span/span/input[1]"));
	  Continue.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	  WebElement Password=driver.findElement(By.xpath("//div[@class='a-section a-spacing-large']/child::input[1]"));
	  Password.sendKeys("Pooja@0137");

	  WebElement Button=driver.findElement(By.xpath("//div[@class='a-section']/child::span/span/input[1]"));
	  Button.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	  WebElement UserLoggedIn=driver.findElement(By.xpath("//div[@id='nav-belt']/child::div[3]/div/a[2]/div/span[1]"));
	  System.out.println(UserLoggedIn.getText()+"     "+UserLoggedIn.isDisplayed());

  }

  @BeforeMethod
  public void LoggedIn() {
	  WebElement Home=driver.findElement(By.xpath("//div[@id='nav-belt']/child::div/div/a"));
	  System.out.println(Home.isDisplayed());
	  System.out.println(Home.getAttribute("aria-label"));
      System.out.println("___User Navigated to HomePage____");
  }
}
