/**
 * Created by mohammaduddin on 2/5/17.
 */


package BuildAppFramework;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import BuildAppFramework.PageObjects;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.Keys;


public class PaymentAsGuestTest extends ReusablMethods{
	
    private static BigDecimal webSubtotal = null;
    private static BigDecimal webTax = null;
    private static BigDecimal webGrandtotal = null;
    
    // storing searching item name in the array
    String[] shopItem = {"Suede Kohler K66266U", "Cashmere Kohler K66266U", "Kohler K-5180-ST"};

    
    
private WebDriver driver;
	
	@Before
	public void setUp() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		
		driver = new ChromeDriver();
		
		// maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void paymentTest() throws Exception{
		try {
	        
			//FirefoxDriver driver = new FirefoxDriver();
			driver.navigate();
	        driver.get("https://www.build.com/");
	        Thread.sleep(5000);
	    } catch (NoClassDefFoundError ex) {
	        System.out.println("error: " + ex.getStackTrace());
	    }
               
                for(int i=0; i<shopItem.length; i++) {

                    // typing an item in the finding shop text box
                	PageObjects.search_text_box(driver).sendKeys(shopItem[i]);
                    Thread.sleep(2000);

                    // click on the search icon
                    PageObjects.search_icon(driver).click();
                    Thread.sleep(2000);

                    // assert item type such as While, Suede, Cashmere
                    if(PageObjects.item_type_text(driver).getText().contains("Suede")
                            || PageObjects.item_type_text(driver).getText().contains("Cashmere")
                            || PageObjects.item_type_text(driver).getText().contains("Stainless Steel")){

                    	syso("Found -- " + shopItem[i]);

                        if(shopItem[i].contains("Kohler K-5180-ST")) {

                            // add more quantity to the cart for the item
                        	PageObjects.item_qty_txt(driver).click();
                            Thread.sleep(2000);

                            ((RemoteWebDriver) driver).getKeyboard().pressKey(Keys.ARROW_UP);
                            Thread.sleep(2000);

                        }

                        // adding shop item to the card
                        Thread.sleep(1000);
                        PageObjects.add_to_card_btn(driver).click();
                        Thread.sleep(3000);
                    }else {
                        syso("Not found -- " + shopItem[i]);
                    }

                }


                /*
                // login to the account with an existing user
                buildPageObj.email_address_txt(driver).sendKeys("muddin2429@gmail.com");
                Thread.sleep(1000);
                buildPageObj.password_txt(driver).sendKeys("P@ssword1");
                Thread.sleep(1000);
                buildPageObj.login_btn(driver).click();
                Thread.sleep(1000);
                */


            // check out as guest

            PageObjects.checkout_btn(driver).click();
            Thread.sleep(1000);

            // process the order as an guest account
            PageObjects.guest_Login_submit_btn(driver).click();
            Thread.sleep(1000);

            // filling out "shipping address" form
            PageObjects.shipping_first_name_txt(driver).sendKeys("Mohammad");
            PageObjects.shipping_last_name_txt(driver).sendKeys("Uddin");
            PageObjects.shipping_street_address_txt(driver).sendKeys("2800 Riverview Rd");
            PageObjects.shipping_zip_code_txt(driver).sendKeys("35242");
            PageObjects.shipping_city_txt(driver).sendKeys("Birmingham");

            Select StateDropdown = new Select(PageObjects.shipping_state_select(driver));
            StateDropdown.selectByVisibleText("Alabama");
            Thread.sleep(2000);

            PageObjects.shipping_phone_number_txt(driver).sendKeys("646-662-2429");
            PageObjects.shipping_email_address_txt(driver).sendKeys("muddin2429@gmail.com");

            // fill up "credit card" form
            PageObjects.cc_card_number_txt(driver).sendKeys("4111111111111111");

            Select ccExpireDropdown = new Select(PageObjects.cc_expire_select(driver));
            ccExpireDropdown.selectByVisibleText("07");
            Thread.sleep(2000);

            Select ccYearDropdown = new Select(PageObjects.cc_year_select(driver));
            ccYearDropdown.selectByVisibleText("2019");
            Thread.sleep(2000);

            PageObjects.cc_name_on_card_txt(driver).sendKeys("Mohammad uddin");
            PageObjects.cc_security_code_txt(driver).sendKeys("123");
            PageObjects.review_order_btn(driver).click();
            Thread.sleep(2000);

            String webExtractSubtotal = PageObjects.subtotal_txt(driver).getText();
            Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Matcher matcher = regex.matcher(webExtractSubtotal.replace("$", ""));
            while (matcher.find()) {
                webSubtotal = new BigDecimal(matcher.group(1));
            }

            String webExtractTax = PageObjects.tax_txt(driver).getText();
            matcher = regex.matcher(webExtractTax.replace("$", ""));
            while (matcher.find()) {
                webTax = new BigDecimal(matcher.group(1));
            }

            String webExtractGrandtotal = PageObjects.grandtotal_txt(driver).getText();
            matcher = regex.matcher(webExtractGrandtotal.replace("$", ""));
            while (matcher.find()) {
                webGrandtotal = new BigDecimal(matcher.group(1));
            }


            // calculating tax and grandtotal
                //Alabama tax rate 8%
                double taxRate = 0.08;

            DecimalFormat df = new DecimalFormat("#.00");

            BigDecimal calTax = webSubtotal.multiply(BigDecimal.valueOf(taxRate));
            calTax = new BigDecimal(df.format(calTax));

            BigDecimal calGrandtotal = webSubtotal.add(calTax);
            calGrandtotal = new BigDecimal(df.format(calGrandtotal));


            // asserting tax amount
            assertEquals(calTax, webTax);
            
            // asserting grand total amount
            assertEquals(calGrandtotal, webGrandtotal);


            // close browser
    		driver.quit();
    	}
    }

