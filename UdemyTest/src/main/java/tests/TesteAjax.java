package tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TesteAjax {
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=7fdec");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	public void verificaAjax() {
		driver.findElement(By.id("j_idt311:name")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id=\"j_idt311:j_idt315\"]/span")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt85:display"), "Test"));
		Assert.assertEquals("Test", driver.findElement(By.id("j_idt85:display")).getText());
	}

}
