package phase2_TestNG_Basics001;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Phase2_TestNG001 {
	
	@Test (groups = {"regression"})
	public void tMethod1() {
		System.out.println("Hello world! @Test 5");
		System.out.println("----------------------------------------");
	}
	
	@Test (groups = {"regression"})
	public void tMethod8() {
		System.out.println("Hello world! @Test 8");
		System.out.println("----------------------------------------");
	}
	
	@AfterMethod (groups = {"smoke"})
	public void tMethod9() {
		System.out.println("After method 9");
		System.out.println("----------------------------------------");
	}
	
	@AfterMethod (groups = {"smoke"})
	public void tMethod6() {
		System.out.println("After method 6");
		System.out.println("----------------------------------------");
	}
	
	@BeforeMethod (groups = {"regression", "smoke"})
	public void tMethod7() {
		System.out.println("Before method 4");
		System.out.println("----------------------------------------");
	}
	
	@BeforeTest (groups = {"regression"})
	public void tMethod2() {
		System.out.println("Before test 2");
		System.out.println("----------------------------------------");
//		Assert.fail();
	}
	
	@AfterClass (groups = {"regression"})
	public void tMethod3() {
		System.out.println("After class 7");
		System.out.println("----------------------------------------");
	}
	
	@BeforeSuite (groups = {"regression", "smoke"})
	public void tMethod4() {
		System.out.println("Before suite 1");
		System.out.println("----------------------------------------");
	}
	
	@BeforeClass (groups = {"regression", "smoke"})
	public void tMethod5() {
		System.out.println("Before class 3");
		System.out.println("----------------------------------------");
	}
}
