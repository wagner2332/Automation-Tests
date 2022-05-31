import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TesteRegradeNegocio {
	
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
	public void DeveValidarNomeObrigatorio(){
		driver.findElement(By.id("elementosForm:Cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		

}
	@Test
	public void DeveValidarSobrenomeObrigatorio(){
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Wagner");
		driver.findElement(By.id("elementosForm:Cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		
}
	@Test
	public void DeveValidarSexoObrigatorio(){
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Wagner");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
		driver.findElement(By.id("elementosForm:Cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		
}
	@Test
	public void DeveValidarComidaVegetariana(){
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Wagner");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:Cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		
}
	@Test
	public void DeveValidarEsportistaIndeciso(){
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Wagner");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.xpath("//*[@id=\"elementosForm:esportes\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"elementosForm:esportes\"]/option[5]")).click();
		driver.findElement(By.id("elementosForm:Cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		
}
}