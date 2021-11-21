
import PakietSerwisowy.Revision;
import PakietSerwisowy.Time;
import Service.ConsumerWarehouse;
import Service.ParkingSpace;
import Service.CarServiceSpot;
import Service.IndependentCarServiceSpot;

import Service.Service;

import items.Pojazd;
import users.Person;
import users.Uzytkownik;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Time time = new Time();
        executorService.submit(time);
        LocalDate startDate = LocalDate.now();
        LocalDate currentDate = startDate.plusDays(time.getDay());

        Revision revision = new Revision(time, startDate);
        executorService.submit(revision);
        //  podmioty i aktorzy


        Service s1 = new Service("Pan Kolo", "Wroclaw");
        Service s2 = new Service("Bez Dyszla", "Krakow");

        revision.getServiceGarage().add(s1);
        revision.getServiceGarage().add(s2);

        revision.getService().add(s1);
        revision.getService().add(s2);

        Person.getP().add(new Person("Jan", "Kowalski", "7509308856", "30-09-1975", "Warszawa", null));
        Person.getP().add(new Person("Piotr", "Nowak", "7307159935", "15-07-1973", "Poznan", null));
        Person.getP().add(new Person("Tadeusz", "Konopka", "7509109815", "10-09-1975", "Szczecin", null));


        ConsumerWarehouse w1 = new ConsumerWarehouse(s1.getId(), 4, 35, null, null, 0);
        ConsumerWarehouse w2 = new ConsumerWarehouse(s1.getId(), 4, 48, null, null, 0);
        ConsumerWarehouse w3 = new ConsumerWarehouse(s1.getId(), 4, 15, null, null, 0);
        ConsumerWarehouse w4 = new ConsumerWarehouse(s1.getId(), 4, 46, null, null, 0);
        ConsumerWarehouse w5 = new ConsumerWarehouse(s1.getId(), 4, 64, null, null, 0);
        ConsumerWarehouse w6 = new ConsumerWarehouse(s1.getId(), 4, 22, null, null, 0);


        ParkingSpace p1 = new ParkingSpace(s1.getId(), 0, null, null);
        ParkingSpace p2 = new ParkingSpace(s1.getId(), 0, null, null);
        ParkingSpace p3 = new ParkingSpace(s1.getId(), 0, null, null);
        ParkingSpace p4 = new ParkingSpace(s1.getId(), 0, null, null);
        ParkingSpace p5 = new ParkingSpace(s1.getId(), 0, null, null);

        CarServiceSpot cs1 = new CarServiceSpot(s1.getId(), 0, null, null);
        CarServiceSpot cs2 = new CarServiceSpot(s1.getId(), 0, null, null);
        CarServiceSpot cs3 = new CarServiceSpot(s1.getId(), 0, null, null);
        CarServiceSpot cs4 = new CarServiceSpot(s1.getId(), 0, null, null);


        IndependentCarServiceSpot ics1 = new IndependentCarServiceSpot(s1.getId(), 0, null, null);
        IndependentCarServiceSpot ics2 = new IndependentCarServiceSpot(s1.getId(), 0, null, null);


        // dodanie do poszczegolnych setow


        s1.getConsumerWarehouses().add(w1);
        s1.getConsumerWarehouses().add(w2);
        s1.getConsumerWarehouses().add(w3);
        s1.getConsumerWarehouses().add(w4);
        s1.getConsumerWarehouses().add(w5);
        s1.getConsumerWarehouses().add(w6);

        s1.getParking().add(p1);
        s1.getParking().add(p2);
        s1.getParking().add(p3);
        s1.getParking().add(p4);
        s1.getParking().add(p5);

        s1.getCarSpot().add(cs1);
        s1.getCarSpot().add(cs2);
        s1.getCarSpot().add(cs3);
        s1.getCarSpot().add(cs4);

        s1.getIndCarSpot().add(ics1);
        s1.getIndCarSpot().add(ics2);

        //  przedmioty


        Pojazd am1 = new Pojazd("Ford ", "Focus");
        Pojazd am2 = new Pojazd("Fiat", "Punto");
        Pojazd am3 = new Pojazd("Skoda", "Fabia");

        Person.getP().get(0).getAuta().add(am1);
        Person.getP().get(1).getAuta().add(am2);
        Person.getP().get(2).getAuta().add(am3);

        //  przypisanie  do uzytkownikow przedmiotow


        menu();
        System.out.println();

        Scanner scan = new Scanner(System.in);

        String opcja = "0";
        Person uzytkownik = null;
        ConsumerWarehouse cs = null;
        Service service = null;
        Pojazd auto = null;
        boolean dalej=true;
        ParkingSpace parking = null;
        CarServiceSpot spot = null;
        Uzytkownik miejsce = null;


        while (!opcja.equals("21")) {

            System.out.println();
            System.out.println("       MENU GLOWNE" + '\n');
            System.out.println(" Pozycja '19' wyswietlenie MENU " + '\n');
            System.out.print(" Wybierz opcje :");
            System.out.println();

            opcja = scan.nextLine();

            switch (opcja) {

                case "1":

                    System.out.println("Prosze wybrac Serwis ");
                    wyswietlListe(revision.getService());
                    dalej=true;
                    while(dalej){
                        int wyb= wybor();
                        if (wyb >= 1 && wyb <= revision.getService().size()) {
                            service = revision.getService().get(wyb - 1);
                            dalej = false;
                        } else {
                            System.out.println("Nie ma pod wpisanym znakiem zadnego obiektu  ");
                        }
                    }
                    break;

                case "2":

                    System.out.println("Uzytkownicy :");
                    wyswietlListe(Person.getP());
                    uzytkownik = wyborOsoby(Person.getP().size(), Person.getP());

                    break;
                case "3":
                    if (uzytkownikNull(uzytkownik)) {

                    } else
                        System.out.println(uzytkownik);
                    System.out.println();
                    System.out.println("Czy zmienic lub zalogowac  uzytkownika ?  [1] TAK/ [ kazdy inny klawisz ] NIE ");
                    String wybor = scan.nextLine();
                    if (wybor.equals("1")) {
                        uzytkownik = null;
                        System.out.println("uzytkownik zostal wylogowany !");
                    } else {
                        if (uzytkownik == null) {
                            System.out.println("Prosze zalogowac sie jako nowy uzytkownik !");
                        } else
                            System.out.println("Jestes zalogowany jako :" + uzytkownik + '\n');
                    }

                    break;
                case "4":
                    if (czyWybranyServiss(service)) {
                    } else {
                        System.out.println(" wyswietlenie wolnych magazynow na terenie serwisu "+'\n');

                        if (!service.showFreeWarehoses(service.getConsumerWarehouses()).isEmpty()) {
                            System.out.println(" wolne magazyny do wynajecia " +'\n');
                            wyswietlListe(service.showFreeWarehoses(service.getConsumerWarehouses()));
                        } else {
                            System.out.println("brak wolnch magazynow "+'\n');
                        }
                    }
                    break;
                case "5":
                    if (czyWybranyServiss(service)) {
                    } else {
                        System.out.println(" wyswietlenie wolnych miejsc parkingowych na terenie serwisu "+'\n');

                        if (!service.showFreeParkings(service.getParking()).isEmpty()) {
                            System.out.println(" wolne miejsca parkingowe "+'\n');
                            wyswietlListe(service.showFreeParkings(service.getParking()));
                        } else {
                            System.out.println("brak wolnch magazynow "+'\n');
                        }
                    }
                    break;
                case "6":
                    System.out.println("  wynajecie magazynu  "+'\n');

                    if (uzytkownikNull(uzytkownik)) {

                    } else if (czyWybranyServiss(service)) {
                    } else {
                        System.out.println(" wyswietlenie wolnych magazynow na terenie serwisu "+'\n');

                        if (!service.showFreeWarehoses(service.getConsumerWarehouses()).isEmpty()) {
                            System.out.println(" wolne magazyny do wynajecia "+'\n');
                            wyswietlListe(service.showFreeWarehoses(service.getConsumerWarehouses()));
                            dalej=true;
                            while(dalej) {
                                int wyb = wybor();
                                if (wyb >= 1 && wyb <= service.showFreeWarehoses(service.getConsumerWarehouses()).size()) {
                                    cs = service.showFreeWarehoses(service.getConsumerWarehouses()).get(wyb - 1);
                                    Uzytkownik<ConsumerWarehouse> u = new Uzytkownik(cs,uzytkownik);
                                    u.rentWarehouse(cs, currentDate, uzytkownik, 30);
                                    service.getUzytkownicy().add(u);

                                    dalej = false;
                                } else {
                                    System.out.println("Nie ma pod wpisanym znakiem zadnego obiektu  "+'\n');
                                }
                            }
                        } else {
                            System.out.println("nie ma wolnych mieszkan do wynajecia");
                        }
                    }

                    break;
                case "7":
                    System.out.println(" 7: zajecie miejsca parkingowego "+'\n');

                    if (uzytkownikNull(uzytkownik)) {

                    } else if (czyWybranyServiss(service)) {
                    } else {
                        System.out.println(" wyswietlenie wolnych miejsc parkingowych na terenie serwisu " + '\n');

                        if (!service.showFreeParkings(service.getParking()).isEmpty()) {
                            System.out.println(" wolne miejsca parkingowe  " + '\n');
                            wyswietlListe(service.showFreeParkings(service.getParking()));


                            dalej = true;
                            while (dalej) {
                                int wyb = wybor();
                                if (wyb >= 1 && wyb <= service.showFreeParkings(service.getParking()).size()) {
                                    parking = service.showFreeParkings(service.getParking()).get(wyb - 1);
                                    dalej = false;
                                } else {
                                    System.out.println("Nie ma pod wpisanym znakiem zadnego parkingu ");
                                }

                            }
                        } else {
                            System.out.println("Nie ma wolnych parkingow  ");
                        }


                        if (uzytkownik.getAuta().isEmpty()) {
                            System.out.println("uzytkownik nie ma zadnego pojazdu " + '\n');
                        } else {

                            wyswietlListe(uzytkownik.getAuta());

                            dalej= true;
                            while (dalej) {
                                int wyb1 = wybor();
                                if (wyb1 >= 1 && wyb1 <= uzytkownik.getAuta().size()) {
                                    auto = uzytkownik.getAuta().get(wyb1 - 1);
                                    Uzytkownik<ParkingSpace> ps = new Uzytkownik<>(parking,uzytkownik);
                                    ps.rentParking(parking, currentDate, auto.getId(), 14);
                                    uzytkownik.getAuta().remove(auto);
                                    service.getUzytkownicy().add(ps);

                                    dalej = false;
                                } else {
                                    System.out.println("Nie ma pod wpisanym znakiem zadnego auta ");
                                }
                            }

                        }

                    }

                    break;
                case "8":

                    System.out.println(" 8: opuszczenie miejsca parkingowego");


                    if (uzytkownikNull(uzytkownik)) {

                    } else if (czyWybranyServiss(service)) {
                    }else {
                                  if(uzytkownik.leaveParkingList(uzytkownik,service.getUzytkownicy()).isEmpty()){
                                    System.out.println(" uzytkownik nie zajmuje zadnego miejsca parkingowego ");

                                  }else {

                                      wyswietlListe(uzytkownik.leaveParkingList(uzytkownik, service.getUzytkownicy()));

                                      System.out.println(" wybierz miejsce parkingowe ktore chcesz zwolnic ");

                                      dalej = true;
                                      while (dalej) {
                                          int wyb = wybor();
                                          if (wyb >= 1 && wyb <= uzytkownik.leaveParkingList(uzytkownik, service.getUzytkownicy()).size()) {
                                              miejsce = uzytkownik.leaveParkingList(uzytkownik, service.getUzytkownicy()).get(wyb - 1);

                                              // auto musi wracac do person
                                              service.getUzytkownicy().remove(miejsce);

                                              dalej = false;
                                          }


                                      }
                                  }
                    }




                    break;


               case "9":

        System.out.println(" 9: przedluzenie najmu magazynu");




                /*    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.czyPrzekroczonyTerminM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId())).size() == 0) {
                        System.out.println(uzytkownik + " nie ma jeszcze przekroczonych terminow  ");
                    } else {

                        System.out.println("lista mieszkan uzytkownika " + uzytkownik);
                        osiedle.wyswietlM(osiedle.czyPrzekroczonyTerminM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId())));


                        dalej = true;

                        while (dalej) {

                            System.out.println(" wybierz mieszkanie  ktorego najem chcesz przedluzyc  ");

                            String text = scan.nextLine();
                            int wyb = 0;
                            try {
                                wyb = Integer.parseInt(text);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb >= 1 && wyb <= o1.czyPrzekroczonyTerminM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId())).size()) {
                                mieszkanie = osiedle.czyPrzekroczonyTerminM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId())).get(wyb - 1);
                                mieszkanie.ustawDaty(startDate.plusDays(time.getDay()));
                                osiedle.usunFileZListyUsera(uzytkownik,mieszkanie.getId());
                                osiedle.getWynajem().put(mieszkanie, uzytkownik.getId());

                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego mieszkania  ");

                            }
                        }
                    }
                    break;

                case "10":
                System.out.println(" 10: rezygnacja z najmu magazynu");



                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size() == 0) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych garazy ");
                    } else {
                        System.out.println("lista garazy uzytkownika " + uzytkownik);

                        osiedle.wyswietlG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()));


                        dalej = true;

                        while (dalej) {

                            System.out.println(" wybierz garaz z ktorego chcesz zrezygnowac   ");

                            String text = scan.nextLine();
                            int wyb = 0;
                            try {
                                wyb = Integer.parseInt(text);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb >= 1 && wyb <=osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) {

                                garaz = osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).get(wyb - 1);

                                for (Items item : garaz.getItems()) {
                                    uzytkownik.getItems().add(item);
                                }
                                garaz.getItems().clear();
                                garaz.usunIdNajemcy();
                                garaz.ustawDatyNull();
                                osiedle.usunFileZListyUsera(uzytkownik,garaz.getId());
                                osiedle.getWynajem().put(garaz, null);

                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnych wolnych garazy  ");

                            }
                        }
                    }


                    break;


                case "11":
                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.czyPrzekroczonyTerminG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId())).size() == 0) {
                        System.out.println(uzytkownik + " nie ma jeszcze przekroczonych terminow  ");
                    } else {

                        System.out.println("lista garazy uzytkownika " + uzytkownik);
                        osiedle.wyswietlG(osiedle.czyPrzekroczonyTerminG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId())));


                        dalej = true;

                        while (dalej) {

                            System.out.println(" wybierz garaz ktorego najem chcesz przedluzyc  ");

                            String text = scan.nextLine();
                            int wyb = 0;
                            try {
                                wyb = Integer.parseInt(text);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb >= 1 && wyb <= osiedle.czyPrzekroczonyTerminG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId())).size()) {
                                garaz = osiedle.czyPrzekroczonyTerminG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId())).get(wyb - 1);
                                garaz.ustawDaty(startDate.plusDays(time.getDay()));
                                osiedle.usunFileZListyUsera(uzytkownik,garaz.getId());
                                osiedle.getWynajem().put(garaz, uzytkownik.getId());

                                dalej= false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu  ");

                            }
                        }
                    }


                    break;


                case "12":

                    if (uzytkownikNull(uzytkownik)) {
                    } else if (osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size() == 0) {
                        System.out.println(uzytkownik + " nie ma jeszcze wynajetch zadnych mieszkan ");
                    } else {
                        System.out.println("lista mieszkan uzytkownika " + uzytkownik);

                        osiedle.wyswietlM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()));


                        dalej = true;

                        while (dalej) {

                            System.out.println(" wybierz mieszkanie do  ktorego chcesz zameldowac osobe  ");

                            String text = scan.nextLine();
                            int wyb = 0;
                            try {
                                wyb = Integer.parseInt(text);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }


                            if (wyb >= 1 && wyb <= osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()) {
                                mieszkanie = osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).get(wyb - 1);

                                System.out.println(" Lista osob");
                                int v = 0;
                                for (Person per : service.getPersons()) {
                                    v++;
                                    System.out.println(v + "." + " " + per.toString());
                                }
                                osiedle.zamelduj(mieszkanie, wyborOsoby(service.getPersons().size(), service.getPersons()));

                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego miwszkania  ");

                            }
                        }


                    }



                    break;
                case "13":
                    if(uzytkownikNull(uzytkownik)){
                    }
                    else if(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()==0){
                        System.out.println( uzytkownik + " nie ma jeszcze wynajetch zadnych mieszkan "  );
                    } else {
                        System.out.println("lista mieszkan uzytkownika " + uzytkownik);

                        osiedle.wyswietlM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()));

                        dalej = true;

                        while (dalej) {

                            System.out.println(" wybierz mieszkanie z ktorego chcesz wymeldowac osobe  ");

                            String text = scan.nextLine();
                            int wyb = 0;
                            try {
                                wyb = Integer.parseInt(text);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb >= 1 && wyb <= osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()) {
                                mieszkanie = osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).get(wyb - 1);
                                dalej=false;

                            }else {
                                  System.out.println("Nie ma pod wpisanym znakiem zadnego mieszkania  ");
                            }
                        }



                         if(mieszkanie.getLokatorzy().isEmpty()){
                         System.out.println("w mieszkaniu nie ma zameldowanych zadnych lokatorow ");
                          }else{

                                System.out.println(" wybierz osobe ktora chcesz wymeldowac ");

                                int z = 0;
                                for (Object per : mieszkanie.getLokatorzy().toArray()) {
                                    z++;
                                    System.out.println(z + "." + " " + per.toString());
                                }


                                dalej=true;

                                while(dalej){

                                System.out.println(" wcisnij odpowiedni numer ");

                                String text1 = scan.nextLine();
                                int wyb1 = 0;
                                try {
                                    wyb1 = Integer.parseInt(text1);
                                } catch (NumberFormatException e) {
                                    System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                                }

                                if (wyb1 >= 1 && wyb1 <= mieszkanie.getLokatorzy().size()) {
                                    Person p = (Person) mieszkanie.getLokatorzy().toArray()[wyb1 - 1];
                                    mieszkanie.getLokatorzy().remove(p);
                                    dalej=false;
                                }

                        }
                      }
                    }



                    break;



                case "14":
                    if(uzytkownikNull(uzytkownik)){
                    }
                    else if(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()==0){
                        System.out.println( uzytkownik + " nie ma jeszcze wynajetch zadnych garazy "  );
                    } else {
                        System.out.println("lista garazy uzytkownika " + uzytkownik);

                        osiedle.wyswietlG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()));

                        System.out.println(" wybierz garaz do  ktorego chcesz wlozyc przedmiot  ");

                        dalej=true;

                        while(dalej){

                            System.out.println(" wcisnij odpowiedni numer ");

                            String text1 = scan.nextLine();
                            int wyb1 = 0;
                            try {
                                wyb1 = Integer.parseInt(text1);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb1 >= 1 && wyb1 <= osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()){
                            garaz = osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).get(wyb1 - 1);
                            dalej= false;
                            }   else {
                            System.out.println("Nie ma pod wpisanym znakiem zadnego garazu   ");
                        }
                        }






                       if(uzytkownik.getItems().size()==0){

                            System.out.println("wszystkie przedmioty uzytkownika zostaly rozmieszczone w wynajetych garazach lub uzytkownik nie posiada zadnych przedmiotow ");
                        }
                          else {



                            System.out.println(" wybierz ktory przedmiot chcesz wlozyc do wybranego garazu ");
                            int z = 0;
                            for (Object item : uzytkownik.getItems().toArray()) {
                                z++;
                                System.out.println(z + "." + " " + item.toString());
                            }


                                dalej = true;
                                while(dalej){


                            System.out.println(" wcisnij odpowiedni numer ");
                                    String text2 = scan.nextLine();
                                    int wyb2 = 0;
                                    try {
                                        wyb2 = Integer.parseInt(text2);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                                    }

                                    if (wyb2 >= 1 && wyb2 <= uzytkownik.getItems().size()){
                                        Items it = (Items) uzytkownik.getItems().toArray()[wyb2 - 1];
                                        dalej= false;

                                        try{
                            garaz.wlozDoGarazu(garaz,it,uzytkownik);}
                            catch(TooManyThingsException e) {
                               }
                          }
                    }


                          }

                    }
                    break;
                case "15":
                    if(uzytkownikNull(uzytkownik)){
                    }
                    else if(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()==0){
                        System.out.println( uzytkownik + " nie ma jeszcze wynajetch zadnych garazy "  );
                    } else {
                        System.out.println("lista garazy uzytkownika " + uzytkownik);

                        osiedle.wyswietlG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()));

                        System.out.println(" wybierz garaz z ktorego chcesz wyjac przedmiot  ");

                        dalej = true;

                        while (dalej) {

                            System.out.println(" wcisnij odpowiedni numer ");

                            String text1 = scan.nextLine();
                            int wyb1 = 0;
                            try {
                                wyb1 = Integer.parseInt(text1);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb1 >= 1 && wyb1 <= osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) {
                                garaz = osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).get(wyb1 - 1);
                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu   ");
                            }
                        }


                        System.out.println(" wybierz ktory przedmiot chcesz wyjac z wybranego garazu ");
                        int z = 0;
                        for (Object item : garaz.getItems().toArray()) {
                            z++;
                            System.out.println(z + "." + " " + item.toString());
                        }

                        dalej = true;
                        while (dalej) {


                            System.out.println(" wcisnij odpowiedni numer ");
                            String text2 = scan.nextLine();
                            int wyb2 = 0;
                            try {
                                wyb2 = Integer.parseInt(text2);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb2 >= 1 && wyb2 <= uzytkownik.getItems().size()) {
                                Items it = (Items) garaz.getItems().toArray()[wyb2 - 1];
                                garaz.getItems().remove(it);
                                uzytkownik.getItems().add(it);
                                dalej = false;
                            }

                        }
                    }


                    break;
                case "16":

                    if(uzytkownikNull(uzytkownik)){
                    }
                    else if(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()==0){
                        System.out.println( uzytkownik + " nie ma jeszcze wynajetch zadnych mieszkan "  );
                    } else{
                        System.out.println("lista mieszkan uzytkownika "+ uzytkownik );

                        osiedle.wyswietlM(osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()));

                        System.out.println(" wybierz mieszkanie w ktorym chcesz sprawdzic liste zameldowanych osob  ");

                        dalej = true;

                        while (dalej) {

                            System.out.println(" wcisnij odpowiedni numer ");

                            String text1 = scan.nextLine();
                            int wyb1 = 0;
                            try {
                                wyb1 = Integer.parseInt(text1);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb1 >= 1 && wyb1 <= osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).size()) {
                                mieszkanie = osiedle.pokazMieszkaniaUzytkownika(uzytkownik.getId()).get(wyb1-1);
                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu   ");
                            }
                        }


                        int z=0;
                        for(Object per : mieszkanie.getLokatorzy().toArray()){
                            z++;
                            System.out.println(z+"."+" "+per.toString());}
                    }
                       break;
                case "17":

                    if(uzytkownikNull(uzytkownik)){
                    }
                    else if(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()==0){
                        System.out.println( uzytkownik + " nie ma jeszcze wynajetch zadnych garazy "  );
                    } else{
                        System.out.println("lista garazy uzytkownika "+ uzytkownik );

                        osiedle.wyswietlG(osiedle.pokazGarazeUzytkownika(uzytkownik.getId()));

                        System.out.println(" wybierz garaz w ktorym chcesz sprawdzic liste umieszczonych w nim przedmiotow  ");


                        dalej = true;

                        while (dalej) {

                            System.out.println(" wcisnij odpowiedni numer ");

                            String text1 = scan.nextLine();
                            int wyb1 = 0;
                            try {
                                wyb1 = Integer.parseInt(text1);
                            } catch (NumberFormatException e) {
                                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
                            }

                            if (wyb1 >= 1 && wyb1 <= osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).size()) {
                                garaz= osiedle.pokazGarazeUzytkownika(uzytkownik.getId()).get(wyb1-1);
                                dalej = false;
                            } else {
                                System.out.println("Nie ma pod wpisanym znakiem zadnego garazu   ");
                            }
                        }

                        if(garaz.getItems().size()==0){
                          System.out.println(" w garazu nie ma zadnych przedmiotow ");
                        }else{
                        int z=0;
                        for(Object per : garaz.getItems().toArray()){
                            z++;
                            System.out.println(z+"."+" "+per.toString());}


                    }
            }

                    break;
                case "18":


                    if(osiedle==null){
                        System.out.println(" prosze wybrac osiedle ");
                    }else {
                        System.out.println(" nastapil zapis informacji o osiedlu " + osiedle+ " do pliku "+'\n');
                        osiedle.zapisDoPliku(osiedle.stringDoPliku(osiedle.pokazListeMieszkanOsiedla(), osiedle.pokazListeGarazyOsiedla(), service.getPersons()), osiedle);
                    }


                    break;
*/

                case "19":
                    menu();
                    break;
                case "20":
                    System.out.println("Czy wylogowac  uzytkownika ?  [1] TAK / [ kazdy inny klawisz ] Powrot do MENU GLOWNEGO  ");
                    String wybierz = scan.nextLine();
                    if (wybierz.equals("1")) {
                        uzytkownik = null;
                        System.out.println("uzytkownik zostal wylogowany !" + '\n');
                        System.out.println("nacisnij dowolny klawisz aby przejsc do MENU GLOWNEGO ! ");
                        scan.nextLine();
                    }
                    break;
                case "21":
                    time.setRozrusznik(false);
                    revision.setRozrusznik1(false);
                    executorService.shutdown();
                    System.out.println("Zakonczenie programu ");
                    break;
                default:
                    System.out.println("PROSZE PODAC WLASCIWA OPCJE !");

            }
        }


    }


    public static void menu() {

        System.out.println();

        System.out.println();
        System.out.println("Prosze wybrac nastepujaca opcje :");
        System.out.println(" 1: wybor serwisu ");
        System.out.println(" 2: wskazanie osoby  ");
        System.out.println(" 3: wypisanie danych osobowych uzytkownika ");
        System.out.println(" 4: wyswietlenie wolnych magazynow na terenie serwisu ");
        System.out.println(" 5: wyswietlenie wolnych miejsc parkingowych na terenie serwisu ");
        System.out.println(" 6: wynajecie magazynu ( po uprzednim wybraniu) ");
        System.out.println(" 7: zajecie miejsca parkingowego ");

        System.out.println(" 8: opuszczenie miejsca parkingowego");
        System.out.println(" 9: przedluzenie najmu magazynu");
        System.out.println(" 10: rezygnacja z najmu magazynu");
        System.out.println(" 11: ");

        System.out.println(" 12: rozpoczecie naprawy pojazdu");
        System.out.println(" 13: ");
        System.out.println(" 14: wlozenie nowych przedmiotow do magazynu ");
        System.out.println(" 15: wyjecie przedmiotow z magazynu ");
        System.out.println(" 16: pokazanie magazynu ktory wynajmuje dana osoba i wyswietlenie jego zawartosci ");
        System.out.println(" 17: przekazanie uprawnien do dostepu do magazynu innej osobie");
        System.out.println(" 18: zapis stanu aplikacji do pliku");
        System.out.println(" 19: wyswietlenie menu");
        System.out.println(" 20: wylogowanie uzytkownika ");
        System.out.println(" 21: zakonczenie programu");
        System.out.println();
    }

    public static Person wyborOsoby(int size, List<Person> per) {
        Person p = null;
        boolean dalej = true;

        while (dalej) {

            System.out.println("Prosze wybarc uzytkownika/osobe :");
            Scanner scan = new Scanner(System.in);
            String text = scan.nextLine();
            int nrUzytkownika = 0;
            try {
                nrUzytkownika = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Prosze podac liczbe odnoszaca sie do osoby ");
            }

            if (nrUzytkownika >= 1 && nrUzytkownika <= size) {
                p = per.get(nrUzytkownika - 1);
                dalej = false;
            } else {
                System.out.println("Nie ma pod wpisanym znakiem zadnego uzytkownika ");

            }
        }
        return p;
    }


    public static boolean uzytkownikNull(Person person) {
        Scanner scan1 = new Scanner(System.in);
        boolean uNull = false;
        if (person == null) {
            uNull = true;
            System.out.println("musisz byc zalogowany ");
            System.out.println("nacisnij enter ");
            scan1.nextLine();
        } else {
            System.out.println(" jestes zalogowany jako " + person);

        }

        return uNull;
    }


    public static boolean czyWybranyServiss(Service s) {
        boolean czy = false;
        if (s == null) {
            System.out.println("musisz wybrac serwis");
            czy = true;
        }
        return czy;
    }

    public static void wyswietlListe(List p) {

        for (int i = 0; i < p.size(); i++) {

            System.out.println((i + 1) + "." + " " + p.get(i));
        }
    }

    public static int wybor() {

        int wybor = 0;
        boolean dalej = true;
        Scanner scan = new Scanner(System.in);


        while (dalej) {

            System.out.println(" wybierz  odpowiednia opcje  ");

            String text = scan.nextLine();

            try {
                wybor = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Prosze podac liczbe odnoszaca sie do obiektu ");
            }
            dalej=false;
        }

   return wybor; }


}




