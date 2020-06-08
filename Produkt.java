package NazwaPackage;

public class Produkt {
	String nazwa;
	int ilosc;
	int gwarancja;
	Kategoria kategoria;
	Hurtownia hurtownia;
	Pracownik pracownik;
	Produkt(String n)
	{
		nazwa=n;
	}
	Produkt(String n,Kategoria k,Hurtownia h,Pracownik p)
	{
		nazwa=n;
		kategoria=k;
		hurtownia=h;
		pracownik=p;
	}
	Produkt(String n,Kategoria k,Hurtownia h)
	{
		nazwa=n;
		kategoria=k;
		hurtownia=h;
	}
	public void zmien_ilosc(int x)
	{
		ilosc=x;
	}
	public void zmien_gwarancje(int x)
	{
		gwarancja=x;
	}
	public String wyswietlNazwe()
	{
		return nazwa;
	}
	public int wyswietlIlosc()
	{
		return ilosc;
	}
	public int wyswietlGwarancje()
	{
		return gwarancja;
	}
	public void wyswietlProdukt()
	{
		System.out.println("nazwa produktu: " + nazwa);
		System.out.println("ilosc: " + ilosc);
		System.out.println("dlugosc gwarancji: " + gwarancja);
	}
	public Kategoria zwrocKategorie()
	{
		return kategoria;
	}
	public Hurtownia zwrocHurtownie()
	{
		return hurtownia;
	}
	public void dodaj(int x)
	{
		ilosc+=x;
	}
	public void usun(int x)
	{
		if(x<=ilosc)
			ilosc-=x;
		else ilosc=0;
	}
	public Pracownik zwrocPracownika()
	{
		return pracownik;
	}
}
