package BuildAppFramework;

/**
 * Created by mohammaduddin on 2/5/17.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObjects {

    private static WebElement element = null;

    public static WebElement search_text_box(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"search_txt\"]"));
        return element;

    }

    public static WebElement search_icon(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"site-search\"]/div/button"));
        return element;

    }

    public static WebElement item_header_text(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"heading\"]"));
        return element;

    }


    public static WebElement add_to_card_btn(WebDriver driver){
        element = driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]"));

        return element;

    }


    public static WebElement item_qty_txt(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"main-product-quantity\"]/div/input"));
        return element;

    }




    public static WebElement item_type_text(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/h2"));
        return element;

    }



    public static WebElement checkout_btn(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"cartNav\"]/a/span"));
        return element;

    }


    public static WebElement email_address_txt(WebDriver driver){
        element = driver.findElement(By.id("login_email"));
        return element;

    }

    public static WebElement password_txt(WebDriver driver){
        element = driver.findElement(By.id("login_password"));
        return element;

    }

    public static WebElement login_btn(WebDriver driver){
        element = driver.findElement(By.name("loginSubmit"));
        return element;

    }



    public static WebElement guest_Login_submit_btn(WebDriver driver){
        element = driver.findElement(By.name("guestLoginSubmit"));
        return element;

    }



    public static WebElement shipping_first_name_txt(WebDriver driver){
        element = driver.findElement(By.id("shippingfirstname"));
        return element;

    }


    public static WebElement shipping_last_name_txt(WebDriver driver){
        element = driver.findElement(By.id("shippinglastname"));
        return element;

    }



    public static WebElement shipping_street_address_txt(WebDriver driver){
        element = driver.findElement(By.id("shippingaddress1"));
        return element;

    }


    public static WebElement shipping_zip_code_txt(WebDriver driver){
        element = driver.findElement(By.id("shippingpostalcode"));
        return element;

    }

    public static WebElement shipping_city_txt(WebDriver driver){
        element = driver.findElement(By.id("shippingcity"));
        return element;

    }

    public static WebElement shipping_state_select(WebDriver driver){
        element = driver.findElement(By.id("shippingstate_1"));
        return element;

    }

    public static WebElement shipping_phone_number_txt(WebDriver driver){
        element = driver.findElement(By.id("shippingphonenumber"));
        return element;

    }

    public static WebElement shipping_email_address_txt(WebDriver driver){
        element = driver.findElement(By.id("emailAddress"));
        return element;

    }

    public static WebElement cc_card_number_txt(WebDriver driver){
        element = driver.findElement(By.id("creditCardNumber"));
        return element;

    }

    public static WebElement cc_expire_select(WebDriver driver){
        element = driver.findElement(By.id("creditCardMonth"));
        return element;

    }

    public static WebElement cc_year_select(WebDriver driver){
        element = driver.findElement(By.id("creditCardYear"));
        return element;

    }



    public static WebElement cc_name_on_card_txt(WebDriver driver){
        element = driver.findElement(By.id("creditcardname"));
        return element;

    }

    public static WebElement cc_security_code_txt(WebDriver driver){
        element = driver.findElement(By.id("creditCardCVV2"));
        return element;

    }


    public static WebElement review_order_btn(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"creditcard\"]/div[3]/input"));

        return element;

    }

    public static WebElement subtotal_txt(WebDriver driver){
        element = driver.findElement(By.id("subtotalamount"));
        return element;

    }

    public static WebElement tax_txt(WebDriver driver){
        element = driver.findElement(By.id("taxAmount"));
        return element;

    }



    public static WebElement grandtotal_txt(WebDriver driver){
        element = driver.findElement(By.id("grandtotalamount"));
        return element;

    }






}

