import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PrimeFaces {
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		
	}
	
	@After
	public void finaliza() {
		//driver.quit();
	}
	@Test
	public void testaPrimeFace() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=ae724");
		driver.findElement(By.xpath("//*[@id=\"j_idt311:option_label\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"j_idt311:option_1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"j_idt311:lazy_label\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"j_idt311:lazy_20\"]")).click();
		
	}

}
