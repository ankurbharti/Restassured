package apitest;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo_testng {
   //before running any class/test if you want to run then we can use before suite
   //it can have a configuration/cannot have test
	@BeforeSuite
	 public void BS()
	 {
		System.out.println("This is going to execute before any test");
	 }
	
	 @BeforeTest
	 public void BT()
	 {
		 System.out.println("This will runa fter test suite");
		 
	 }
	 
	 @BeforeClass
	 public void BC()
	 {
		 System.out.println("This will excute before class");
	 }
	 
	 @BeforeMethod
	 public void BM()
	 {
		 System.out.println("This will execute before every test");
	 }
	 
	 @Test
	 public void testCase1()
	 {
		 System.out.println("Test is my tetscase");
		 Assert.assertEquals("ankur", "ankur");
	 }
	 
	 @Test
	  public void testCase2()
	  {
		 System.out.println("This is my second method");
	  }
	 @AfterMethod
	 public void AM()
	 {
		 System.out.println("This will execute after method");
	 }
	 
	 @AfterClass
	 public void AC()
	 {
		 System.out.println("This will execute after class");
	 }
	 
	 
}

