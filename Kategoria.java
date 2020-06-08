package NazwaPackage;

public class Kategoria {
	String nazwa;
	String opis;
	Pracownik pracownik;
	Kategoria(String n)
	{
		nazwa=n;
	}
	Kategoria(String n,Pracownik p)
	{
		nazwa=n;
		pracownik=p;
	}
	public void aktualizuj_kategorie(String o)
	{
		opis=o;
	}
	public String wyswietl_opis()
	{
		return opis;
	}
	public void wyswieltKategorie()
	{
		if(nazwa!=null)
		System.out.println("nazwa kategorii: " + nazwa);
		if(opis!=null)
		System.out.println("opis: " + opis);
	}
	public String wyswietlNazwe()
	{
		return nazwa;
	}
	public Pracownik zwrocPracownika()
	{
		return pracownik;
	}
}
