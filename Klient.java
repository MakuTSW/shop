package NazwaPackage;

public class Klient extends Uzytkownik {
	String email=null;
	String numer_telefonu=null;
	public Klient(String l,String h)
	{
		super(l,h);
	}
	public void zmienNumer(String n)
	{
		numer_telefonu=n;
	}
	public void zmienEmail(String e)
	{
		email=e;
	}
	public void wyswietlKlienta()
	{
		System.out.println("login: " + login);
		if(numer_telefonu!=null)
		System.out.println("Numer telefonu: " + numer_telefonu);
		if(email!=null)
		System.out.println("Email: " + email);
	}
	public Zamowienie dodajZamowienie(String nazwaP,String nazwaK,int i,int d)
	{
		Zamowienie zamowienie= new Zamowienie(nazwaP,nazwaK,i,d,this);
		return zamowienie;
	}
	public Zamowienie dodajZamowienie(Produkt produkt,int i)
	{
		Zamowienie zamowienie= new Zamowienie(produkt,i,this);
		return zamowienie;
	}
}
