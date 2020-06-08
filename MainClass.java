package NazwaPackage;

import java.util.Scanner;
public class MainClass {
	public static void main(String[] args)
	{
		// Pseudo baza danych
		String admin="abc"; //haslo administratora potrzebne do rejestracji pracownika
		Klient[] klienci=new Klient[1000];
		int iloscKlientow=0;
		Pracownik[] pracownicy=new Pracownik[1000];
		int iloscPracownikow=0;
		Hurtownia[] hurtownie=new Hurtownia[1000];
		int iloscHurtowni=0;
		Kategoria[] kategorie=new Kategoria[1000];
		int iloscKategorii=0;
		Produkt[] produkty=new Produkt[1000];
		int iloscProduktow=0;
		Zamowienie[] zamowienia=new Zamowienie[1000];
		int iloscZamowien=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Witaj uzytkowniku! Wybierz jedna z ponizszych opcji");
		
		
		
		while(true)
		{
			System.out.println("1 - rejestracja klienta");
			System.out.println("2 - rejestracja pracownika");
			System.out.println("3 - logowanie klienta");
			System.out.println("4 - logowanie pracownika");
			System.out.println("5 - zamkniecie aplikacji");
			int x=scan.nextInt();
			if(x==1) // rejestracja klienta
			{
				while(true) 
				{
					System.out.println("Podaj login");
					scan.nextLine();
					String login=scan.nextLine();
					boolean flag=true;
					if(login.length()==0)
					{
						flag=false;
						System.out.println("Niepoprawny login, chcesz ponowic probe?");
					}
					else
					for(int i=0;i<iloscKlientow;i++)
					{
						if(login.equals(klienci[i].zwrocLogin()))
						{
							System.out.println("Podany login jest zajety, chcesz ponowic probe?");
							flag=false;
							break;
						}
					}
					if(flag==false) 
					{

						System.out.println("1 - tak");
						System.out.println("2 - nie");
						int y=scan.nextInt();
						if(y==2)break;
					}else
					{
						System.out.println("Podaj haslo");
						String haslo=scan.nextLine();
						klienci[iloscKlientow++]=new Klient(login,haslo);
						System.out.println("Udalo sie pomyslnie zarejestrowac");
						break;
					}
				}
			}else if(x==2) // rejestracja pracownika
			{
				while(true) 
				{
					String login="";
					System.out.print("Wpisz haslo administratora");
					scan.nextLine();
					String dostep=scan.nextLine();
					boolean flag=true;
					if(!dostep.equals(admin))
					{
						System.out.println("Brak dostepu,chcesz ponowic probe?");
						flag=false;
					}
					if(flag==true)
					{
						System.out.println("Podaj login");
						login=scan.nextLine();
						if(login.length()==0)
						{
							flag=false;
							System.out.println("Niepoprawny login, chcesz ponowic probe?");
						}
						if(flag==true)
						for(int i=0;i<iloscPracownikow;i++)
						{
							if(login.equals(pracownicy[i].zwrocLogin()))
							{
								System.out.println("Podany login jest zajety, chcesz ponowic probe?");
								flag=false;
								break;
							}
						}
					}
					if(flag==false) 
					{
						System.out.println("1 - tak");
						System.out.println("2 - nie");
						int y=scan.nextInt();
						if(y==2)break;
					}else
					{
						System.out.println("Podaj haslo");
						String haslo=scan.nextLine();
						pracownicy[iloscPracownikow++]=new Pracownik(login,haslo);
						System.out.println("Udalo sie pomyslnie zarejestrowac");
						break;
					}
				}
			}else if(x==3) // logowanie klienta i jego mozliwe dzialania (w tym zmiana swoich danych oraz skladanie zamowienia)
			{
				while(true)
				{
					System.out.println("Podaj login");
					scan.nextLine();
					String login=scan.nextLine();
					int flag=0;
					Klient klient=null;
					for(int i=0;i<iloscKlientow;i++)
					{
						if(klienci[i].zwrocLogin().equals(login))
						{
							System.out.println("Podaj haslo");
							String haslo=scan.nextLine();
							if(klienci[i].logowanie(login, haslo))
							{
								klient=klienci[i];
								flag=1;
							}else
							{
								flag=2;
								System.out.println("Nie poprawne haslo, chcesz ponowic probe?");
								break;
							}
							
						}
					}
					if(flag==1)
					{
						System.out.println("Zostales pomyslnie zalogowany");
						while(true)
						{
							System.out.println("Wybierz jedna z ponizszych opcji");
							System.out.println("1 - zmien swoj numer telefonu");
							System.out.println("2 - zmien swoj email");
							System.out.println("3 - zloz zamowienie");
							System.out.println("4 - wyloguj sie");
							int y=scan.nextInt();
							if(y==1)
							{
								System.out.println("Podaj nowy numer telefonu");
								scan.nextLine();
								String numer=scan.nextLine();
								klient.zmienNumer(numer);
							}else if(y==2)
							{
								System.out.println("Podaj nowy email");
								scan.nextLine();
								String email=scan.nextLine();
								klient.zmienEmail(email);
							}else if(y==3)
							{
								System.out.println("Podaj nazwe produktu");
								scan.nextLine();
								String nazwaProduktu=scan.nextLine();
								System.out.println("Podaj nazwe kategorii produktu");
								String nazwaKategorii=scan.nextLine();
								System.out.println("Podaj nazwe hurtowni produktu");
								String nazwaHurtowni=scan.nextLine();
								System.out.println("Podaj nazwe miejscowosci hurtowni");
								String miejscowosc=scan.nextLine();
								System.out.println("Podaj ilosc");
								int ilosc=scan.nextInt();
								boolean flag2=true;
								for(int i=0;i<iloscProduktow;i++)
								{
									if(produkty[i].wyswietlNazwe().equals(nazwaProduktu))
									{
										
										if(produkty[i].zwrocKategorie().wyswietlNazwe().equals(nazwaKategorii))
										{
											
											if(produkty[i].zwrocHurtownie().wyswietlNazwe().equals(nazwaHurtowni))
											{
												if(produkty[i].zwrocHurtownie().wyswietlMiejscowosc().equals(miejscowosc))
												{
													zamowienia[iloscZamowien++]=new Zamowienie(produkty[i],ilosc,klient);
													flag2=false;
													System.out.println("Zamowienie zostalo zlozone");
													break;	
												}
											}
												
										}
									}
								}
								if(flag2==true)
								{
									Kategoria kategoria=null;
									boolean flagk=false;
									Hurtownia hurtownia=null;
									boolean flagh=false;
									for(int i=0;i<iloscKategorii;i++)
									{
										if(kategorie[i].wyswietlNazwe().equals(nazwaKategorii))
										{
											flagk=true;
											kategoria=kategorie[i];
											break;
										}
									}
									if(flagk)
									for(int i=0;i<iloscHurtowni;i++)
									{
										if(hurtownie[i].wyswietlNazwe().equals(nazwaHurtowni))
										{
											if(hurtownie[i].wyswietlMiejscowosc().equals(miejscowosc))
											{
												flagh=true;
												hurtownia=hurtownie[i];
												break;
											}
										}
									}
									if(flagh && flagh) 
									{
										System.out.println("Jesli chcesz okreslic dlugosc gwarancji wpisz jej dlugosc jesli nie wpisz -1");
										int dlugosc=scan.nextInt();
										zamowienia[iloscZamowien++]=new Zamowienie(nazwaProduktu,kategoria.wyswietlNazwe(),ilosc,dlugosc,klient);
										System.out.println("Dodano zamowienie");
									}else if(!flagk)System.out.println("Nie znaleziono podanej kategorii");
									else if(!flagh)System.out.println("Nie znaleziono podanej hurtowni w danej miejscowosci");
								}
							}else if(y==4)
							{
								System.out.println("Zostales pomyslnie wylogowany");
								break;
							}
						}
						break;
						
					}else
					{
						if(flag==0)
							System.out.println("Nie poprawny login, chcesz ponowic probe?");
						System.out.println("1 - tak");
						System.out.println("2 - nie");
						int y=scan.nextInt();
						if(y==2)break;
					}
				}
			}else if(x==4) // logowanie pracownika i jego mozliwe dzialania
			{
				while(true) 
				{
					System.out.println("Podaj login"); 
					scan.nextLine();
					String login=scan.nextLine();
					int flag=0;
					for(int i=0;i<iloscPracownikow;i++)
					{
						if(pracownicy[i].zwrocLogin().equals(login))
						{
							System.out.println("Podaj haslo");
							String haslo=scan.nextLine();
							if(pracownicy[i].logowanie(login, haslo))
							{
								flag=1;
							}else
							{
								flag=2;
								System.out.println("Nie poprawne haslo, chcesz ponowic probe?");
								break;
							}
							
						}
					}
					if(flag==1)
					{
						System.out.println("Zostales pomyslnie zalogowany");
						while(true)
						{
							System.out.println("Wybierz jedna z ponizszych opcji");
							System.out.println("1 - dodaj produkt");
							System.out.println("2 - dodaj kategorie");
							System.out.println("3 - dodaj hurtownie");
							System.out.println("4 - edytuj produkt");
							System.out.println("5 - edytuj kategorie");
							System.out.println("6 - edytuj hurtownie");
							System.out.println("7 - wyswietl produkt");
							System.out.println("8 - wyswietl kategorie");
							System.out.println("9 - wyswietl hurtownie");
							System.out.println("10 - wyswietl wszystkie produkty");
							System.out.println("11 - wyswietl wszystkie kategorie");
							System.out.println("12 - wyswietl wszystkie hurtownie");
							System.out.println("13 - zrealizuj zamowienie");
							System.out.println("14 - wyloguj sie");
							int y=scan.nextInt();
							if(y==1)
							{
								System.out.println("Podaj nazwe produktu");
								scan.nextLine();
								String nazwaProduktu=scan.nextLine();
								System.out.println("Podaj nazwe kategorii produktu");
								String nazwaKategorii=scan.nextLine();
								System.out.println("Podaj nazwe hurtowni produktu");
								String nazwaHurtowni=scan.nextLine();
								System.out.println("Podaj nazwe miejscowosci hurtowni");
								String miejscowosc=scan.nextLine();
								boolean flag2=true;
								for(int i=0;i<iloscProduktow;i++)
								{
									if(produkty[i].wyswietlNazwe().equals(nazwaProduktu))
									{
										
										if(produkty[i].zwrocKategorie().wyswietlNazwe().equals(nazwaKategorii))
										{
											
											if(produkty[i].zwrocHurtownie().wyswietlNazwe().equals(nazwaHurtowni))
											{
												if(produkty[i].zwrocHurtownie().wyswietlMiejscowosc().equals(miejscowosc))
												{
													System.out.println("Podany produkt juz istnieje");
													flag2=false;
													break;	
												}
											}
												
										}
									}
								}
								if(flag2==true)
								{
									Kategoria kategoria=null;
									boolean flagk=false;
									Hurtownia hurtownia=null;
									boolean flagh=false;
									for(int i=0;i<iloscKategorii;i++)
									{
										if(kategorie[i].wyswietlNazwe().equals(nazwaKategorii))
										{
											flagk=true;
											kategoria=kategorie[i];
											break;
										}
									}
									if(flagk)
									for(int i=0;i<iloscHurtowni;i++)
									{
										if(hurtownie[i].wyswietlNazwe().equals(nazwaHurtowni))
										{
											if(hurtownie[i].wyswietlMiejscowosc().equals(miejscowosc))
											{
												flagh=true;
												hurtownia=hurtownie[i];
												break;
											}
										}
									}
									if(flagh && flagh) 
									{
										produkty[iloscProduktow++]=new Produkt(nazwaProduktu,kategoria,hurtownia);
										System.out.println("Dodano produkt");
									}else if(!flagk)System.out.println("Nie znaleziono podanej kategorii");
									else if(!flagh)System.out.println("Nie znaleziono podanej hurtowni w danej miejscowosci");
								}
							}else if(y==2)
							{
								System.out.println("Podaj nazwe kategorii");
								scan.nextLine();
								String nazwaKategorii=scan.nextLine();
								boolean flag2=true;
								for(int i=0;i<iloscKategorii;i++)
								{
									if(kategorie[i].wyswietlNazwe().equals(nazwaKategorii))
									{
										flag2=false;
										break;
									}
								}
								if(flag2==true)
								{
									kategorie[iloscKategorii++]=new Kategoria(nazwaKategorii);
									System.out.println("Dodano kategorie");
								}else
								{
									System.out.println("Kategoria o podanej nazwie juz istenieje");
								}
							
									
							}else if(y==3)
							{
								System.out.println("Podaj nazwe hurtowni");
								scan.nextLine();
								String nazwaHurtowni=scan.nextLine();
								System.out.println("Podaj miejscowosc");
								String miejscowosc=scan.nextLine();
								boolean flag2=true;
								for(int i=0;i<iloscHurtowni;i++)
								{
									if(hurtownie[i].wyswietlNazwe().equals(nazwaHurtowni))
									{
										if(hurtownie[i].wyswietlMiejscowosc().equals(miejscowosc))
										{
											flag2=false;
											break;
										}
									}
								}
								if(flag2==true)
								{
									hurtownie[iloscHurtowni++]=new Hurtownia(nazwaHurtowni,miejscowosc);
									System.out.println("Dodano hurtownie");
								}else
								{
									System.out.println("Hurtownia o podanej nazwie i miejscowosci juz istenieje");
								}
								
							}else if(y==4)
							{
								System.out.println("Podaj nazwe produktu");
								scan.nextLine();
								String nazwaProduktu=scan.nextLine();
								System.out.println("Podaj nazwe kategorii produktu");
								String nazwaKategorii=scan.nextLine();
								System.out.println("Podaj nazwe hurtowni produktu");
								String nazwaHurtowni=scan.nextLine();
								System.out.println("Podaj nazwe miejscowosci hurtowni");
								String miejscowosc=scan.nextLine();
								boolean flag2=true;
								for(int i=0;i<iloscProduktow;i++)
								{
									if(produkty[i].wyswietlNazwe().equals(nazwaProduktu))
									{
										
										if(produkty[i].zwrocKategorie().wyswietlNazwe().equals(nazwaKategorii))
										{
											
											if(produkty[i].zwrocHurtownie().wyswietlNazwe().equals(nazwaHurtowni))
											{
												if(produkty[i].zwrocHurtownie().wyswietlMiejscowosc().equals(miejscowosc))
												{
													System.out.println("co chcesz edytowac?");
													System.out.println("1 - edytuj gwarancje");
													System.out.println("2 - dodaj produkty");
													System.out.println("3 - usun produkty");
													int z=scan.nextInt();
													if(z==1)
													{
														System.out.println("Podaj nowa dlugosc gwarancji");
														int wartosc=scan.nextInt();
														produkty[i].zmien_gwarancje(wartosc);
													}else if(z==2)
													{
														System.out.println("Podaj ilosc");
														int wartosc=scan.nextInt();
														produkty[i].dodaj(wartosc);
													}else if(z==3)
													{
														System.out.println("Podaj ilosc");
														int wartosc=scan.nextInt();
														produkty[i].usun(wartosc);
													}
													flag2=false;
													break;	
												}
											}
												
										}
									}
									if(flag2)System.out.println("Nie znaleziono produktu");
								}
							}else if(y==5)
							{
								System.out.println("Podaj nazwe kategorii ktora chcesz edytowac");
								scan.nextLine();
								String nazwaKategorii=scan.nextLine();
								boolean flag2=false;
								for(int i=0;i<iloscKategorii;i++)
								{
									if(kategorie[i].wyswietlNazwe().equals(nazwaKategorii))
									{
										System.out.println("Podaj nowy opis");
										String opis=scan.nextLine();
										kategorie[i].aktualizuj_kategorie(opis);
										flag2=true;
									}
										
								}
								if(flag2==false)
								System.out.println("Nie znaleziono kategorii");
								else System.out.println("Poprawnie edytowano kategorie");
								
							}else if(y==6)
							{
								System.out.println("Podaj nazwe hurtowni ktora chcesz edytowac");
								scan.nextLine();
								String nazwaHurtowni=scan.nextLine();
								boolean flag2=false;
								for(int i=0;i<iloscHurtowni;i++)
								{
									if(hurtownie[i].wyswietlNazwe().equals(nazwaHurtowni))
									{
										System.out.println("Podaj miejscowosc");
										String miejscowosc=scan.nextLine();
										if(hurtownie[i].wyswietlMiejscowosc().equals(miejscowosc))
										{
											System.out.println("co chcesz edytowac?");
											System.out.println("1 - email");
											System.out.println("2 - numer telefonu");
											int z=scan.nextInt();
											if(z==1)
											{
												System.out.println("Podaj nowy email");
												scan.nextLine();
												String email=scan.nextLine();
												hurtownie[i].zmienEmail(email);
											}else if(z==2)
											{
												System.out.println("Podaj nowy numer");
												scan.nextLine();
												String numer=scan.nextLine();
												hurtownie[i].zmienNumer(numer);
											}
											flag2=true;
										}
									}
										
								}
								if(flag2==false)
								System.out.println("Nie znaleziono hurtowni");
								else System.out.println("Poprawnie edytowano hurtownie");
							}else if(y==7)
							{
								System.out.println("Podaj nazwe produktu");
								scan.nextLine();
								String nazwaProduktu=scan.nextLine();
								System.out.println("Podaj nazwe kategorii produktu");
								String nazwaKategorii=scan.nextLine();
								System.out.println("Podaj nazwe hurtowni produktu");
								String nazwaHurtowni=scan.nextLine();
								System.out.println("Podaj nazwe miejscowosci hurtowni");
								String miejscowosc=scan.nextLine();
								boolean flag2=true;
								for(int i=0;i<iloscProduktow;i++)
								{
									if(produkty[i].wyswietlNazwe().equals(nazwaProduktu))
									{
										
										if(produkty[i].zwrocKategorie().wyswietlNazwe().equals(nazwaKategorii))
										{
											
											if(produkty[i].zwrocHurtownie().wyswietlNazwe().equals(nazwaHurtowni))
											{
												if(produkty[i].zwrocHurtownie().wyswietlMiejscowosc().equals(miejscowosc))
												{
													flag2=false;
													produkty[i].wyswietlProdukt();
													break;	
												}
											}
												
										}
									}
								}
								if(flag2)System.out.println("Nie znaleziono produktu");
								
							}else if(y==8)
							{
								System.out.println("Podaj nazwe kategorii ktora chcesz wyswietlic");
								scan.nextLine();
								String nazwaKategorii=scan.nextLine();
								boolean flag2=false;
								for(int i=0;i<iloscKategorii;i++)
								{
									if(kategorie[i].wyswietlNazwe().equals(nazwaKategorii))
									{
										kategorie[i].wyswieltKategorie();
										flag2=true;
										break;
									}
										
								}
								if(flag2==false)
								System.out.println("Nie znaleziono kategorii");
								
							}else if(y==9)
							{
								System.out.println("Podaj nazwe hurtowni ktora chcesz wyswietlic");
								scan.nextLine();
								String nazwaHurtowni=scan.nextLine();
								boolean flag2=false;
								for(int i=0;i<iloscHurtowni;i++)
								{
									if(hurtownie[i].wyswietlNazwe().equals(nazwaHurtowni))
									{
										hurtownie[i].wyswietlHurtownie();
										flag2=true;
									}
										
								}
								if(flag2==false)
								System.out.println("Nie znaleziono hurtowni");
								
							}else if(y==10)
							{
								for(int i=0;i<iloscProduktow;i++)
								{
									produkty[i].wyswietlProdukt();
									System.out.println();
								}
							}else if(y==11)
							{
								for(int i=0;i<iloscKategorii;i++)
								{
									kategorie[i].wyswieltKategorie();
									System.out.println();
								}
							}else if(y==12)
							{
								for(int i=0;i<iloscHurtowni;i++)
								{
									hurtownie[i].wyswietlHurtownie();
									System.out.println();
								}
							}else if(y==13)
							{
								System.out.println("Podaj login klienta ktorego zamowienie chcesz zrealizowac");
								scan.nextLine();
								String klient=scan.nextLine();
								boolean flag2=false;
								for(int i=0;i<iloscZamowien;i++)
								{
									if(flag2==true)
									{
										zamowienia[i-1]=zamowienia[i];
									}else if(zamowienia[i].wyswietlKlienta().zwrocLogin().equals(klient))
									{
										System.out.println("Czy chcesz zrealizowac ponizsze zamowienie?");
										zamowienia[i].wyswietlZamowienie();
										System.out.println("1 - tak");
										System.out.println("2 - nie");
										int z=scan.nextInt();
										if(z==1)
										{
											for(int j=0;j<iloscProduktow;j++)
											{
												
												if(zamowienia[i].wyswietlNazweProduktu().equals(produkty[j].wyswietlNazwe()))
												{
													if(produkty[j].wyswietlIlosc()>=zamowienia[i].wyswietlIlosc())
													{
														System.out.println("Zrealizowano zamowienie");
														produkty[j].usun(zamowienia[i].wyswietlIlosc());
													 	flag2=true;
													}else
													{
														System.out.println("Zamowienie zostalo czesciowo zrealizowane");
														zamowienia[i].zmniejszZamowienie(produkty[j].wyswietlIlosc());
														produkty[j].zmien_ilosc(0);
													}
												}
											}
										}
										scan.nextLine();
									}
								}
								if(flag2==true)
								zamowienia[--iloscZamowien]=null;
							}else if(y==14)
							{
								System.out.println("Zostales pomyslnie wylogowany");
								flag=2;
								break;
								
							}
						}
					}else
					{
						if(flag==0)
							System.out.println("Nie poprawny login, chcesz ponowic probe?");
						System.out.println("1 - tak");
						System.out.println("2 - nie");
						int y=scan.nextInt();
						if(y==2)break;
					}
					if(flag==2)break;
				}
			}else if(x==5) 
			{
				System.out.println("Dziekujemy za skorzystanie z naszej aplikacji :)");
				break;
			}
			
		}
	}
}
