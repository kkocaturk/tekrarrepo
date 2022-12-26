package ders.b_settingSeleniumJar_BrowserDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SettingJarsAndDrivers {

    public static String driverType;
    public static String driverPath;
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //ben intellij'den chrome'a gitmek istiyorum.
        //bir hedefim istegim gorevim var, bunun icin bir methodlar olusturdum.
        navigateToGoogleChrome();
       //navigateToFirefox();
       //navigateToEDGE();
    }
    private static void navigateToEDGE() {
        //System.setProperty(Constants.MSEDGE,Constants.MSEDGE_PATH);//yeni sürümle kalktı
        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz
        //https://www.selenium.dev/blog/2022/introducing-selenium-manager/
        //resmi site aciklamasi
        driver =new EdgeDriver();
        driver.get("https://www.twitter.com");
    }
    private static void navigateToFirefox() {
       //setDriverPath(Constants.FIREFOX_PATH);
        //setDriverType(Constants.FIREFOX);
       // System.setProperty(Constants.FIREFOX_PATH,Constants.FIREFOX);
        //nasıl yazasan yaz fazla o yüzden constant sınıfına da gerek kalmadı.

        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz
        //https://www.selenium.dev/blog/2022/introducing-selenium-manager/
        //resmi site aciklamasi

         driver =new FirefoxDriver();//firefox browser'i ac
         driver.get("https://www.facebook.com");//facebook'a git
    }
    //javadaki bu methoduma yapmasi gereken tum gorevcikleri yazdim, simdi bu methodu main methodundan cagirayim/calistirayim.
    private static void navigateToGoogleChrome() {
        //EE method var ici bos nasil gitcem?
        //Selenium Api'i benim java-selenium kodlarimi alip chrome gitsin diye ilk string parametresi yazdim
        //selenium api'i chrome gidebilmek icin driver(surucu,araba) kullanmasi gerktigi icin driver pathini belirtmem gerek
        //NOVEMBER 04,2022'de Selenium 4.6.0 ile bu satiri yazmadan da browserlari launch edbiliyoruz
        //System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/OneDrive/Documents/seleniumDependencies/drivers/chromedriver.exe");

        //Bir websitesine gitmek istiyorum, ChromeDriver ile gitmek istiyorum.
        //Java OOP conceplerinden -> Polimorphism var burda
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://www.google.com");//gitmek istediğim urlyi gir

    }
    public SettingJarsAndDrivers() {    }
}
