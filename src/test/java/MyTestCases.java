import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyTestCases {

    WebDriver driver = new ChromeDriver();
    String signUpPage = "https://automationteststore.com/index.php?rt=account/create";
    String Password = "Yzn@123";
    Random rand = new Random();

    @BeforeTest
    public void mySetup(){

        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void SignUp() throws InterruptedException {
        driver.navigate().to(signUpPage);
        //Element
        WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
        WebElement LastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
        WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
        WebElement TelephoneInput = driver.findElement(By.id("AccountFrm_telephone"));
        WebElement FaxInput = driver.findElement(By.id("AccountFrm_fax"));
        WebElement CompanyInput = driver.findElement(By.id("AccountFrm_company"));
        WebElement Address1Input = driver.findElement(By.id("AccountFrm_address_1"));
        WebElement Address2Input = driver.findElement(By.id("AccountFrm_address_2"));
        WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
        WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
        WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
        WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
        WebElement ConfirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
        WebElement CheckBox =driver.findElement(By.id("AccountFrm_agree"));
        WebElement selectCountry=driver.findElement(By.id("AccountFrm_country_id"));
        WebElement selectstate = driver.findElement(By.id("AccountFrm_zone_id"));
        WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));

        //Data
        int RandomEmailNumber= rand.nextInt(7000);
        String[] FirstNames={"Yazan","Tareq","Mohammad","Zaid","Ahmad"};
        int IndexFirstName = rand.nextInt(FirstNames.length);
        String RandomFirstName = FirstNames[IndexFirstName];
        String[] LastNames={"Sarhan","Assad","Khalil","Sultan","Waleed"};
        int IndexLastName = rand.nextInt(LastNames.length);
        String RandomLastName = LastNames[IndexLastName];
        String Email = RandomFirstName+RandomLastName+RandomEmailNumber+"@gmail.com";
        String LoginName= RandomFirstName+RandomLastName+RandomEmailNumber;


        //Action
        FirstNameInput.sendKeys(FirstNames[IndexFirstName]);
        LastNameInput.sendKeys(LastNames[IndexLastName]);
        EmailInput.sendKeys(Email);
        TelephoneInput.sendKeys("00962776824372");
        FaxInput.sendKeys("1009");
        CompanyInput.sendKeys("ABC");
        Address1Input.sendKeys("Amman");
        Address2Input.sendKeys("Airpot St");
        CityInput.sendKeys("Amman");
        PostalCodeInput.sendKeys("11682");
        LoginNameInput.sendKeys(LoginName);
        PasswordInput.sendKeys(Password);
        ConfirmPasswordInput.sendKeys(Password);
        CheckBox.click();


        //RandomCountry
        Select selectMyCountry = new Select(selectCountry);
        int TotalCountries = selectCountry.findElements(By.tagName("Option")).size();
        int randomCountry = rand.nextInt(1,TotalCountries);
        selectMyCountry.selectByIndex(randomCountry);


        Thread.sleep(3000);


        //RandomState
        Select selectMyState = new Select(selectstate);
        int TotalStates = selectstate.findElements(By.tagName("Option")).size();
        int randomState= rand.nextInt(1,TotalStates);
        selectMyState.selectByIndex(randomState);

        ContinueButton.click();

        driver.navigate().to("https://automationteststore.com/index.php?rt=account/account");





            }
        };










