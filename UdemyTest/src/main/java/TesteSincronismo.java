import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteSincronismo {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	@Ignore
	public void deveUtilizarEsperaFixa() throws InterruptedException {
		driver.findElement(By.id("buttonDelay")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("novoCampo")).sendKeys("test");
	}
	@SuppressWarnings("deprecation")
	@Test
	
	public void deveUtilizarEsperaImplicita() throws InterruptedException {
		driver.findElement(By.id("buttonDelay")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("novoCampo")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	@Test
	
	public void deveUtilizarEsperaExplicita() throws InterruptedException {
		driver.findElement(By.id("buttonDelay")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		driver.findElement(By.id("novoCampo")).sendKeys("test");
		
}
}
