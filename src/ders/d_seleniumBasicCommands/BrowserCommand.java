package ders.d_seleniumBasicCommands;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserCommand {
    //chrome session olusturur. Bos bir chrome sayfasi acilir.
    //new ChromeDriver(); constructor methodu ayni anda chromedriver.exe'yi kutuphanesinde barindirir ve calistirir.
    //JSON Dilinde nasil calistigini da gorduk
    //driver mor renktedir, cunku her methodtan erisilebilir.
    public static WebDriver driver=new ChromeDriver();

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        //basicDriverMethods();
        // driverNavigateMethods();
        //driverManageWindowMethods();
       tearDownMethods();
    }
    private static void basicDriverMethods() throws InterruptedException {
        //parametre olarak verilen String ifadeyi oku, o websitesini chrome'da aç
        //Json dilindeki karşılığı-> http://localhost:9515/session(postman)
        driver.get("http://www.google.com");
        //mouse ile uzerine gel, ctrl tikla, pop-up cikacak
        //Return type'i String, yani bu method string bir değer dondururur.
        driver.getTitle();//returns a String. also we can print it
        String pageTitle = driver.getTitle();//Google
        System.out.println("pageTitle = " + pageTitle);//pageTitle = Google
        //return type:String açık olan tabin urlsini getirir.
        String urlAdresi = driver.getCurrentUrl();
        System.out.println("urlAdresi = " + urlAdresi);//urlAdresi = https://www.google.com/?gws_rd=ssl

        //Return type:String
        //Webte acilan sayfanin kodlarini yazdirir.
        //driver objesi WebDriver isimli interface'in objesidir.
        //driver. dedigim an WebDriver Interface'indeki tum method/variablelara erisebilirim
        String sayfaKaynagi = driver.getPageSource();
        //System.out.println("sayfaKaynagi = " + sayfaKaynagi);// sayfa kaynak kodu geliyor sayfalarca
        Thread.sleep(3000);
        driver.close();
    }
    private static void driverNavigateMethods() throws InterruptedException, MalformedURLException {
        //driver.get("https://www.amazon.com"); den farkı
        //ileri git, geri git, sayfayı refresh et gibi emirleri yapar.
        driver.navigate().to("https://www.amazon.com");
        URL udemyUrl=new URL("https://www.udemy.com");
        driver.navigate().to(udemyUrl); //udemyde//Parametresi URL classina ait bir object olmali
        driver.navigate().to("https://www.twitter.com");
        driver.navigate().back();//udemy'e geri donecek
        Thread.sleep(3000);//Bu emir kendi isletim sistemimi 3 saniye bekletir
        //bunu kullanma sebebimizi, olur da chrome yavas calisir bizim satir satir yazdigimiz
        // kodlara/emirlere yetisemezse diye
        driver.navigate().forward();//twitter'a ileri gidecek
        Thread.sleep(2000);
        //bulundugumuz page'i refresh yapar
        driver.navigate().refresh();
    }

    private static void driverManageWindowMethods() {
        //Asagidaki methodlarin aciklamasi bu documentation'da ->
        //https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.Window.html
        driver.get("https://www.google.com");
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        driver.manage().window().maximize();
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        driver.manage().window().minimize(); //page'imizi minimize deriz. bu methodun icinde default bir degere gore
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        //Browser size'ini istedigimiz gibi ayarlamak icin
        Dimension dimension=new Dimension(550,400);//Dimension 'dan nesne oluşturduk.
        driver.manage().window().setSize(dimension);
        //dimension isimli Dimension Class'inin objesi(nesnesi) icinde 550,400 koordinatlarini tutuyor
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        //500 horizantal - yatay
        //200 vertical - dikey
        Point solUstKoseKoor= driver.manage().window().getPosition();
        System.out.println("solUstKoseKoor = " + solUstKoseKoor);
        Point IstenenSolUstKose=new Point(500,200);
        driver.manage().window().setPosition(IstenenSolUstKose);
        System.out.println("IstenenSolUstKose = " + IstenenSolUstKose);
        driver.manage().window().fullscreen();//cinema mode
        /*
driver.manage().window().getSize() = (1050, 708)
driver.manage().window().getSize() = (1382, 744)
driver.manage().window().getSize() = (1050, 708)
driver.manage().window().getSize() = (550, 400)
solUstKoseKoor = (10, 10)
IstenenSolUstKose = (500, 200) */
    }
    private static void tearDownMethods() {
        driver.close();//browserdaki tab'i kapatır. sadece 1 tab açıksa close yazınca browserda kapanır.
        driver.quit();//browserda birden fazla tab açıksa pop-up dahil hepsini kapatır.
    } }
