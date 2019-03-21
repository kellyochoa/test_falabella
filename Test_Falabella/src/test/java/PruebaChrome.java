import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.sleep;

/* @author Kelly_Esthefania */
public class PruebaChrome {
    private WebDriver driver;
    private String baseUrl;
    
    @Before
    public void Iniciar() {
        //Para Chrome    
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe"); 
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
    }
        
    @After
    public void Cerrar() {
       driver.quit();
    }

    @Test
    public void Comprar() throws InterruptedException {
        //Abrir navegador
        driver.get(baseUrl);
        driver.findElement(By.name("q")).sendKeys("falabella");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);           
        //Clic en opción Falabella.com - Mejor Compra Online
        driver.findElement(By.xpath("//div[@id='rso']/div[1]/div/div/div/div/div[1]/a/h3")).click();
        sleep(2000);
        //Buscar producto
        driver.findElement(By.id("searchQuestionSolr")).sendKeys("notebook");
        driver.findElement(By.id("searchQuestionSolr")).sendKeys(Keys.ENTER);
        //Seleccionar producto
        driver.findElement(By.xpath("//div[@id='all-pods']/div[3]/div[2]/a[1]/div")).click();
        sleep(2000);
        //Agregar a la bolsa
        driver.findElement(By.xpath("//div[@id='fbra_browseMainProduct']/div/div/div[2]/div/div[8]/button")).click();
        sleep(2000);
        driver.findElement(By.xpath("(//div[@id='fb-modal-add']/div[3]/div[2]/a)[2]")).click();
        sleep(2000);
        //Aumentar producto
        driver.findElement(By.xpath("//div[@id='fb-basket-products']/div[3]/section/section/form/section/div[2]/div/button[2]")).click();
        
        //Seleccionar garantia
        driver.findElement(By.xpath("//div[@id='fb-basket-products']/div[3]/section/section/section/div/div/div/div/form/div/a")).click();
        driver.findElement(By.xpath("//div[@id='fb-basket-products']/div[3]/section/section/section/div/div/div/div/form/div/div/ul/li[3]/a")).click();
        
        //Ir a comprar
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[3]/div/div[1]/form/div[2]/div[2]/div[2]/button")).click();
        sleep(3000);
    }
}
