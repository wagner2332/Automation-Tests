import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestAlert {
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
	public void DeveInteragircomAlertsSimples(){
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		


}
	@Test
	public void DeveInteragircomAlertsComplexos(){
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		//driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		Assert.assertEquals("Confirmado",alert.getText() );
		alert.accept();
		
		
		
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado",alerta.getText() );
		alerta.dismiss();
		
		
}
	@Test
	@Ignore
	public void DeveInteragircomPrompts(){
		
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("10");
		alert.accept();
		Assert.assertEquals("Era 10?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D",alert.getText());
		alert.accept();
		
		
}
	
}