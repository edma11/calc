package Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class AllTest extends TestParams {
	
	
	
	
	
	//Registracija pozityvi
	
		 @Test 
			
		 public	void RegistrationPoz() throws InterruptedException {
			    driver.navigate().to("http://localhost:8080/");//atidaryti svetinæ
		 		driver.findElement(By.cssSelector("h4.text-center > a:nth-child(1)")).click();//Spaudziu registruotis
		 		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("pavandenis1@mail.com");//Įvedame vardà
		 		driver.findElement(By.cssSelector("#password")).sendKeys("101010");//Įvedame slaptaþodį
		 		driver.findElement(By.cssSelector("#passwordConfirm")).sendKeys("101010");//Patvirtiname slaptažodį
		 		driver.findElement(By.cssSelector(".btn")).click();//click Login
		 		Thread.sleep(3000); //Pauzė 
		 		driver.findElement(By.cssSelector("ul.nav:nth-child(3) > a:nth-child(2)"));//Tikrinam ar yra log aut mygtukas
		 		//driver.quit();
		 		
		}
	
	
	//Registracija negatyvi
	
		 @Test 	
		 public	void RegistrationNeg() throws InterruptedException {
			    driver.navigate().to("http://localhost:8080/prisijungti");//atidaryti svetinę
		 		driver.findElement(By.cssSelector("h4.text-center > a:nth-child(1)")).click();//Spaudziu registruotis
		 		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("pavandenis@mail.com");//Įvedame vardą
		 		driver.findElement(By.cssSelector("#password")).sendKeys("101010");//Įvedame slaptažodį
		 		driver.findElement(By.cssSelector("#passwordConfirm")).sendKeys("101010");//Patvirtiname slaptaþodį
		 		driver.findElement(By.cssSelector(".btn")).click();//click Login
		 		
		 		String warningmsg = driver.findElement(By.xpath("//*[@id=\"username.errors\"]")).getText();//Randam klaidos tekstą
		 		System.out.println(warningmsg);//spausdinam rastą kalaidos tekstą
		        assertEquals("Toks vartotojo vardas jau egzistuoja",warningmsg);//Palyginam klaidos tekstą,su numatytu txt
		        // System.out.println("Toks vartotojo vardas jau egzistuoja"+warningmsg);
		       
		        
		 } 
	
	//Vartotojo prisijungimas pozityvus
	
		  	   @Test 	
			 public	void UserLoginPoz() throws InterruptedException {
				    driver.navigate().to("http://localhost:8080/prisijungti");//atidaryti svetinæ
			 		driver.findElement(By.cssSelector("input.form-control:nth-child(2)")).sendKeys("pavandenis@mail.com");//Įvedame vardą
			 		driver.findElement(By.cssSelector("input.form-control:nth-child(3)")).sendKeys("101010");//Ávedame Slaptaþodá
			 		driver.findElement(By.cssSelector(".btn")).click();//Spaudžiam Prisijungti
			 		driver.findElement(By.cssSelector("ul.nav:nth-child(3) > a:nth-child(2)"));//Tikrinam ar prisijungė Randam log uot
			 		Thread.sleep(2000); //Pauzė 
			 		
			}
		
		  	   
	//Vartotojo prisijungimas negatyvus
			
		   @Test 
		 public	void UserLoginNeg() throws InterruptedException {
			    driver.navigate().to("http://localhost:8080/prisijungti");//atidaryti svetinæ
		 		driver.findElement(By.cssSelector("input.form-control:nth-child(2)")).sendKeys("pavandenis@mail.com");//Įvedame vardą
		 		driver.findElement(By.cssSelector("input.form-control:nth-child(3)")).sendKeys("10101010");//Ávedame Slaptaþodá
		 		driver.findElement(By.cssSelector(".btn")).click();//Spaudþiam Prisijungti
		 		Thread.sleep(2000); //Pauzė 
		 		String warningmsg = driver.findElement(By.xpath("/html/body/div/form/div/span[2]")).getText();
		 		System.out.println(warningmsg);
		        assertEquals("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi",warningmsg);
		      // System.out.println(Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi"+warningmsg);
	
		   	}
		   

	 	//Vartotojo atsijungimas pozityvus
	
	 	   	  @Test 		
	 		 public	void UserLogOut() throws InterruptedException {
	 			    driver.navigate().to("http://localhost:8080/prisijungti?logout");//atidaryti svetinæ
	 			    driver.findElement(By.cssSelector("input.form-control:nth-child(2)")).sendKeys("pavandenis@mail.com");//Įvedame vardą
	 			    driver.findElement(By.cssSelector("input.form-control:nth-child(3)")).sendKeys("101010");//Įvedame Slaptažodį
	 			    driver.findElement(By.cssSelector(".btn")).click();//Spaudþiam Prisijungti
	 		 		driver.findElement(By.cssSelector("ul.nav:nth-child(3) > a:nth-child(2)")).click();//Spaudþiame log uot
	 		 		String warningmsg = driver.findElement(By.xpath("/html/body/div/form/div/span[1]")).getText();
	 		 		System.out.println(warningmsg);
	 		        assertEquals("Sėkmingai atsijungėte",warningmsg);
	 		      // System.out.println("Įvestas prisijungimo vardas ir/ arba slaptaþodis yra neteisingi"+warningmsg);
	 		       driver.quit();
	 	   	  }

	
	

}
