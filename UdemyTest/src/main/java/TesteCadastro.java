import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteCadastro {
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	
	public void DeveCadastrarUsuario(){
		
		page.setNome("Wagner");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Superior");
		
		driver.findElement(By.xpath("//*[@id=\"elementosForm:esportes\"]/option[2]")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		/*Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).getText());
		Assert.assertEquals("Wagner", driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals("Silva", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Carne", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Futebol", driver.findElement(By.id("//*[@id=\\\"elementosForm:esportes\\\"]/option[2]")).getText());*/
		
		driver.findElement(By.xpath("//*[@id='resultado']/span")).getText();
		System.out.println(driver.findElement(By.xpath("//*[@id='resultado']/span")).getText());

}
}
