package apitest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demo_testng2 {
	
	 @BeforeClass
	 public void BC()
	 {
		 System.out.println("This is my second class");
	 }
	 
	 @BeforeMethod
	 public void BM()
	 {
		 System.out.println("This is before method");
	 }
	 @Test
	 public void testCase3()
	 {
		 System.out.println("This is my second testcase");
	 }


	 @AfterTest
	 public void AT()
	 {
		 System.out.println("This will execute after all the test");
		 
	 }
	 
	 @AfterSuite
	 public void AS()
	 {
		 System.out.println("This will execute at the end");
	 }
}
