package amazon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Final_testmethod {
	 WebDriver driver;

	@BeforeSuite
	public void LaunchBrowser() throws InterruptedException {
		System.setProperty("web.chrome.driver", "D:\\SELENIUM\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

  @Test(priority=1)
  public void Homedisplay() throws IOException {
	  HomePage hp=new HomePage(driver);
	  hp.Logo();
	  hp.Homefunctions();
	  hp.Reccomendations();

  }
  @Test (priority=2)
  public void SignUpPage() {
	  SignUp Si=new SignUp(driver);
	  Si.SignUpBtn();
	  Si.NewAccount();
	  Si.MainPage();
  }
  @Test(priority=3)
  public void LoginPage() {
	  Login L=new Login(driver);
	  L.LoginBtn();
	  L.LoginData();
	  L.LoggedIn();
  }
  @Test(priority=4)
  public void Productpage() {
	  Products P=new Products(driver);
	  P.SearchProduct();
	  P.Product();
	  P.Back();
  }
  @Test(priority=5)
  public void Cartpage() {
	  Cart C=new Cart(driver);
	  C.AddToCart();
	  C.Cart_Page();
	  C.Delete();
  }

  public void Buy() {
	  Buy_Checkout b=new Buy_Checkout(driver);
	  b.product();
	  b.BuyNow();
	  b.GetBack();
  }

}

