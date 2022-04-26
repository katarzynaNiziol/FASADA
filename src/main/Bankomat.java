package main;

import java.util.Scanner;

public class Bankomat {

    private BankomatFacade bankomatFacade = new BankomatFacade();
    private static Bankomat bankomat = new Bankomat();

    public static void main(String[] arg) {
        bankomat.bankomatStart();
    }

    public void bankomatStart() {
        int pin = 0;

        boolean autoryzacja = false;

        System.out.println("------------ Witaj w banku ---------------\n");
        System.out.println("---------- Włóż kartę i podaj kod PIN ----\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("kod PIN: ");
        pin = sc.nextInt();

        System.out.println("Autoryzacja...\n");

        autoryzacja = bankomatFacade.identyfikacja(1234567890, pin);
        if (autoryzacja) {
            bankomat.pokazMenu();
        } else {
            System.out.println("Autoryzacja nie powiodła się. Karta została zatrzymana. ");
            bankomat.koniec();
        }
    }

    public void pokazMenu() {
        System.out.println("=======MENU======");
        System.out.println("1.Stan konta");
        System.out.println("2.Wypłata gotówki");
        System.out.println("3.Koniec\n");

        System.out.println("Wybierz: ");

        Scanner sc = new Scanner(System.in);
        int wybor = sc.nextInt();

        switch (wybor) {
            case 1:
                bankomat.pokazStanKonta(123456789);
                break;
            case 2:
                bankomat.wyplacGotowke(260);
                break;
            case 3:
                bankomat.koniec();
                break;
            case 4:
                bankomat.pokazMenu();
        }
    }
    public void pokazStanKonta(long nrKarty) {
        System.out.println(bankomatFacade.sprawdzStanKontaBankomat(nrKarty));
        bankomat.pokazMenu();
    }
    public void wyplacGotowke(int kwota) {
        String wyplata = bankomatFacade.wyplacGotowke(kwota);
        System.out.println(wyplata);
        System.out.println("Odbierz kartę. ");
        bankomat.koniec();
    }
    public void koniec() {System.exit(0);}
}
