package NazwaPackage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class KlientTest {

	String nazwa_produktu="nazwa produktu";
	String nazwa_kategorii="nazwa kategorii";
	int ilosc=3;
	int dlugosc_gwarancji=1;
	String login="login132";
	String haslo="zaq12wsx";
	Klient klient;
	Zamowienie zamowienie;
	
	@Before
	public void setup() {
		klient= new Klient(login,haslo);
		assertNotNull(klient);
	}
	
	@Test
	public void dodajZamowienieTest()
	{
		zamowienie=klient.dodajZamowienie(nazwa_produktu,nazwa_kategorii,ilosc,dlugosc_gwarancji);
		assertEquals(klient,zamowienie.wyswietlKlienta());
	}

}
