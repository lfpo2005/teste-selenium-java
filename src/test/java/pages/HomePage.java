package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import supports.Utils;

public class HomePage extends Utils {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarAplicacao() {
        driver.manage().window().maximize();
        driver.get("https://qazando.com.br/curso.html");
       // esperarElementoEstarPresente(By.id("btn-ver-cursos"), 10); // wait quando o elemento demora para carregar
        Assert.assertEquals("Não acessou a aplicação",true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());
    }

    public void scrollDown() { //não usado só de exemplo, se o clique do botão nao ocorrer antes do scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 20000)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void preencherEmail(String email) {
       // driver.findElement(By.id("email")).sendKeys("lfpo2005@yahoo.com.br");
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void ganharCupom() {
//        driver.findElement(By.id("button")).click(); //usar junto com o metodo scrollDown()
        driver.findElement(By.id("button")).sendKeys(Keys.ENTER);
    }
    public void verDesconto() {
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        Assert.assertEquals("O cupom está errado","QAZANDO15OFF", texto_cupom);
    }

}
