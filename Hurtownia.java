package NazwaPackage;

public class Hurtownia {
	private String nazwa;
	private String numer;
	private String email;
	private String miejscowosc;
	Pracownik pracownik;
	public Hurtownia(String n,String m)
	{
		nazwa=n;
		miejscowosc=m;
	}
	public Hurtownia(String n,String m,Pracownik p)
	{
		nazwa=n;
		miejscowosc=m;
		pracownik=p;
	}
	public void zmienNumer(String nr)
	{
		numer=nr;
	}
	public void zmienEmail(String e)
	{
		email=e;
	}
	public String wyswietlNumer()
	{
		return numer;
	}
	public String wyswietlEmail()
	{
		return email;
	}
	public boolean sprwadz(String n,String m,String nr,String e)
	{
		if(n.equals(nazwa))
			if(m.equals(miejscowosc))
				if(nr.equals(numer))
					if(e.equals(email))
						return true;
		return false;
	}
	public void wyswietlHurtownie()
	{
		if(nazwa!=null)
		System.out.println("nazwa hurtowni: " + nazwa);
		if(miejscowosc!=null)
		System.out.println("miejscowosc: " + miejscowosc);
		if(numer!=null)
		System.out.println("numer telefonu: " + numer);
		if(email!=null)
		System.out.println("email: " + email);
	}
	public String wyswietlMiejscowosc()
	{
		return miejscowosc;
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
