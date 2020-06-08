package NazwaPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HurtowniaTest {

	private Hurtownia hurtownia;
	String numer="123 000 222";
	String email="hurtownia@gmail.com";
	@Before
	public void setUp() 
	{
		hurtownia=new Hurtownia("nazwa","miejscowosc");
		assertNotNull(hurtownia);
	}
	
	@Test
	public void zmien_nrtelefonuTest()
	{
		hurtownia.zmienNumer(numer);
		assertEquals(numer,hurtownia.wyswietlNumer());
	}
	
	@Test
	public void zmien_emailTest()
	{
		hurtownia.zmienEmail(email);
		assertEquals(email,hurtownia.wyswietlEmail());
	}

}
