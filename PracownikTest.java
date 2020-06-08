package NazwaPackage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class PracownikTest {

	String login="login132";
	String haslo="zaq12wsx";
	Pracownik pracownik;
	String nazwa_produktu="nazwa produktu";
	int ilosc=3;
	int dlugosc_gwarancji=1;
	String nazwa_hurtowni="nazwa hurtowni";
	String miejscowosc="miejscowosc";
	String nazwa_kategorii="nazwa kategorii";
	
	@Before
	public void setup() {
		pracownik= new Pracownik(login,haslo);
		assertNotNull(pracownik);
	}
	
	@Test 
	public void dodaj_kategorieTest()
	{
		Kategoria kategoria=pracownik.dodajKategorie(nazwa_kategorii);
		assertEquals(pracownik,kategoria.zwrocPracownika());
	}
	
	@Test 
	public void dodaj_hurtownieTest()
	{
		Hurtownia hurtownia=pracownik.dodajHurtownie(nazwa_hurtowni,miejscowosc);
		assertEquals(pracownik,hurtownia.zwrocPracownika());
	}
	
	@Test 
	public void dodaj_produktTest()
	{
		Kategoria kategoria=pracownik.dodajKategorie(nazwa_kategorii);
		Hurtownia hurtownia=pracownik.dodajHurtownie(nazwa_hurtowni,miejscowosc);
		Produkt produkt=pracownik.dodajProdukt(nazwa_produktu,kategoria,hurtownia);
		assertEquals(pracownik,produkt.zwrocPracownika());
	}
	
	

}
