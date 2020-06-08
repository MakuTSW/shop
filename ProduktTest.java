package NazwaPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProduktTest {

	String nazwa="nazwa";
	Produkt produkt;
	
	@Before
	public void setUp() {
		produkt=new Produkt(nazwa);
		assertNotNull(produkt);
		assertEquals(nazwa,produkt.wyswietlNazwe());
	}
	
	@Test
	public void zmien_iloscTest()
	{
		produkt.zmien_ilosc(5);
		assertEquals(5,produkt.wyswietlIlosc());
	}
	
	@Test
	public void zmien_gwarancjeTest()
	{
		produkt.zmien_gwarancje(2);
		assertEquals(2,produkt.wyswietlGwarancje());
	}
	
}
