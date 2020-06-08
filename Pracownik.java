package NazwaPackage;

public class Pracownik extends Uzytkownik {
	public Pracownik(String l,String h)
	{
		super(l,h);
	}
	public Produkt dodajProdukt(String nazwaP,Kategoria kategoria,Hurtownia hurtownia)
	{
		Produkt produkt=new Produkt(nazwaP,kategoria,hurtownia,this);
		return produkt;
	}
	public Kategoria dodajKategorie(String nazwa)
	{
		Kategoria kategoria=new Kategoria(nazwa,this);
		return kategoria;
	}
	public Hurtownia dodajHurtownie(String nazwa,String miejscowosc)
	{
		Hurtownia hurtownia=new Hurtownia(nazwa,miejscowosc,this);
		return hurtownia;
	}
}
