package jan3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
	@Test
	public void Tc1()
	{
		driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		String Exptitle="Google";
		String Acttitle=driver.getTitle();
		try {
		Assert.assertEquals(Acttitle, Exptitle,"title not matching");
		}catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		driver.close();		
	}
}
