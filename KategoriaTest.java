package NazwaPackage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class KategoriaTest 
{
	private String opis="Pozwala ³adowaæ telefon w ka¿dym miejscu.";
	private Kategoria kategoria;
	
	@Before
	public void setUp() 
	{
		kategoria=new Kategoria("Powerbank");
		assertNotNull(kategoria);
	}
	
	@Test
	public void aktualizuj_kategorieTest()
	{
		kategoria.aktualizuj_kategorie(opis);
		assertEquals(opis, kategoria.wyswietl_opis());
	}
	

}
