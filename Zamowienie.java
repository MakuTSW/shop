package NazwaPackage;

public class Zamowienie {
	String nazwa_produktu;
	String nazwa_kategorii;
	int ilosc;
	int dlugosc_gwarancji;
	Produkt produkt=null;
	Klient klient=null;
	Zamowienie(String nazwaP,String nazwaK,int i,int d,Klient k)
	{
		nazwa_produktu=nazwaP;
		nazwa_kategorii=nazwaK;
		ilosc=i;
		dlugosc_gwarancji=d;
		klient=k;
	}
	Zamowienie(Produkt p,int i,Klient k)
	{
		produkt=p;
		ilosc=i;
		klient=k;
	}
	public String wyswietlNazweProduktu()
	{
		if(produkt==null)
		return nazwa_produktu;
		else return produkt.wyswietlNazwe();
	}
	public String wyswietlNazweKategorii()
	{
		if(produkt==null)
		return nazwa_kategorii;
		else return produkt.zwrocKategorie().wyswietlNazwe();
	}
	public int wyswietlIlosc()
	{
		return ilosc;
	}
	public int wyswietlGwarancje()
	{
		return dlugosc_gwarancji;
	}
	public Klient wyswietlKlienta()
	{
		return klient;
	}
	public void wyswietlZamowienie()
	{
		System.out.println("Zamowienie: ");
		if(produkt!=null) produkt.wyswietlProdukt();
		else
		{
			System.out.println("Nazwa produktu: " + nazwa_produktu);
			System.out.println("Nazwa kategorii: " + nazwa_kategorii);
		}
		System.out.println("Ilosc: " + ilosc);
		if(dlugosc_gwarancji>-1)
		System.out.println("Dlugosc gwarancji: " + dlugosc_gwarancji);
	}
	public void zmniejszZamowienie(int v)
	{
		if(v<=ilosc) ilosc-=v;
		else ilosc=0;
	}
}
