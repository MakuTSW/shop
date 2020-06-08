package NazwaPackage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class UzytkownikTest {

	String login="login132";
	String haslo="zaq12wsx";
	String nazwa="nazwa";
	Uzytkownik uzytkownik;
	
	@Before
	public void rejestracjaTest() 
	{
		uzytkownik= new Uzytkownik(login,haslo);
		assertNotNull(uzytkownik);
	}
	
	@Test 
	public void logowanieTest()
	{
		uzytkownik.logowanie(login,haslo);
		assertEquals(true,uzytkownik.zwrocStatus());
	}
	
	@Test 
	public void wylogowanieTest()
	{
		uzytkownik.wylogowanie();
		assertEquals(false,uzytkownik.zwrocStatus());
	}
	
	
}
