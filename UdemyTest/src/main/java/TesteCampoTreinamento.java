import java.util.List;

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



public class TesteCampoTreinamento {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	public void testeTextField() {
	
	dsl.escreve("elementosForm:nome", "Wagner");	
	//driver.findElement(By.id("elementosForm:nome")).sendKeys("Wagner");
	//driver.findElement(By.id("elementosForm:nome")).getAttribute(null);
	Assert.assertEquals("Wagner",driver.findElement(By.id("elementosForm:nome")).getAttribute("value") );
	}
	@Test
	public void DeveInteragircomTextArea(){
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste",driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value") );
	}
	@Test
	public void deveInteragircomRadioButton() {
	driver.findElement(By.id("elementosForm:sexo:0")).click();
	Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

}
	@Test
	public void deveInteragircomCheckbox() {
	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
	Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

}
	@Test
	public void testeSelectCombo() {
	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
	Select combo = new Select(element);
	//combo.selectByIndex(3);
	combo.selectByVisibleText("Superior");
	
	
}
	@Test
	public void testeVerificaValoresCombo() {
	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
	Select combo = new Select(element);
	combo.getOptions();
	List<WebElement> options = combo.getOptions();
	Assert.assertEquals(8, options.size());
	
	boolean encontrou = false;
	for(WebElement option: options) {
		if(option.getText().equals("Superior")) {
			encontrou = true;
			break;
		}
	}
	Assert.assertTrue(encontrou);
	
	
}
	@Test
	public void testeVerificaValoresComboMulti() {
	WebElement element = driver.findElement(By.id("elementosForm:esportes"));
	Select combo = new Select(element);
	combo.selectByVisibleText("Natacao");
	combo.selectByVisibleText("Corrida");
	
	
}
	@Test
	public void deveInteragircomBotoes() {
	//driver.findElement(By.id("buttonSimple")).click();
	WebElement botao = driver.findElement(By.id("buttonSimple"));
	botao.click();
	
	Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
}	
	@Test
	@Ignore
	public void deveInteragircomLinks() {
	driver.findElement(By.linkText("Voltar")).click();
	
	Assert.assertEquals("Voltou", driver.findElement(By.id("resultado")).getText());
}
	@Test
	public void deveVerificarTitulo() {
	//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento")) ;
	Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
	
	Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
}

	
}