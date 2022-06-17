package SuiteTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.TestAlert;
import tests.TesteCadastro;
import tests.TesteGoogle;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteGoogle.class,
	TestAlert.class
})
public class SuiteTeste {

}
