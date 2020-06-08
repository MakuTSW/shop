package NazwaPackage;

public class Uzytkownik {
	String login;
	String haslo;
	boolean status=false;
	public Uzytkownik(String l,String h)
	{
		login=l;
		haslo=h;
	}
	public boolean logowanie(String l,String h)
	{
		if(login.equals(l))
			if(haslo.equals(h))
			{
				status=true;
				return true;
			}
		return false;
	}
	public void wylogowanie()
	{
		status=false;
		System.out.print("Zostales pomyslnie wylogowany.");
	}
	public boolean zwrocStatus()
	{
		return status;
	}
	public String zwrocLogin()
	{
		return login;
	}
	public String zwrocHaslo()
	{
		return haslo;
	}
}
