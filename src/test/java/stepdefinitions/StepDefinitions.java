package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Login;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class StepDefinitions {

	public WebDriver driver;
	int minValue;
	@Given("I add four random items to my cart")
	public void i_add_four_random_items_to_my_cart() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	driver.findElement(By.xpath("//ul[@class='products columns-3']//li[2]//a[2]")).click();
    	driver.findElement(By.xpath("//ul[@class='products columns-3']//li[4]//a[2]")).click();
    	driver.findElement(By.xpath("//ul[@class='products columns-3']//li[7]//a[2]")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//ul[@class='products columns-3']//li[10]//a[2]")).click();
    	
    	//use page object model
    	Login loginPg = PageFactory.initElements(driver, Login.class);
		loginPg.submit.click();
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
    	
   }
	
	@When("I vew my cart")
	public void i_vew_my_cart() {
		driver.findElement(By.xpath("//*[@id='primary-menu']//li[1]/a")).click();
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle().trim(),"Cart – Katalon Shop");
	}
	
	@Then("i find total four items listed in my cart")
	public void i_find_total_four_items_listed_in_my_cart() {
		List<WebElement> elements=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']//tbody//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
		assertEquals(4,elements.size());
	}

	@When("I search for lowest price item")
	public void i_search_for_lowest_price_item() {
		List<WebElement> elements=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']//tbody//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
		System.out.println(elements.size());			
		List<Integer> intArray=new ArrayList<>();
		for(int i=1;i<=elements.size();i++) {
			String price=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']//tbody//tr["+i+"]//td[@class='product-price']//span")).getText().trim();

			String priceOne=price.replaceFirst("\\$","").replace(".00","");
			intArray.add(Integer.parseInt(priceOne));//		

		}
		
		minValue=intArray.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("lowest value is:"+minValue);
	}
	
	@When("I am able to remove the lowest price item from my cart")
	public void and_i_am_able_to_remove_the_lowest_price_item_from_my_cart() {
		List<WebElement> elements=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']//tbody//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
		for(int i=1;i<=elements.size();i++) {
			String price=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']//tbody//tr["+i+"]//td[@class='product-price']//span")).getText().trim();
			String priceOne=price.replaceFirst("\\$","").replace(".00","");
			if(Integer.parseInt(priceOne)==minValue) {
				driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']//tbody//tr["+i+"]//td[1]/a")).click();
			}
		}
	    
	}
	
	@Then("I am able to verify three items in my cart")
	public void i_am_able_to_verify_three_items_in_my_cart() throws Exception {
		Thread.sleep(2000);
		List<WebElement> elements=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']//tbody//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
		assertEquals(3,elements.size());
		System.out.println("Total Items in cart after removing the lowest item:"+elements.size());
	  }
		
}
