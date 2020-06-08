package NazwaPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZamowienieTest {

	String nazwa_produktu="nazwa produktu";
	String nazwa_kategorii="nazwa kategorii";
	int ilosc=3;
	int dlugosc_gwarancji=1;
	Zamowienie zamowienie;
	Klient klient;
	@Test
	public void setUp() 
	{
		zamowienie=new Zamowienie(nazwa_produktu,nazwa_kategorii,ilosc,dlugosc_gwarancji,klient);
		assertNotNull(zamowienie);
		assertEquals(nazwa_produktu,zamowienie.wyswietlNazweProduktu());
		assertEquals(nazwa_kategorii,zamowienie.wyswietlNazweKategorii());
		assertEquals(ilosc,zamowienie.wyswietlIlosc());
		assertEquals(dlugosc_gwarancji,zamowienie.wyswietlGwarancje());
	}
	
	
}
