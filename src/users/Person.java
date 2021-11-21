package users;

import Service.ParkingSpace;
import items.Item;
import PakietSerwisowy.TenantAlert;
import items.Pojazd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Person   {


    private int id;
     private String imie;
     private String nazwisko;
     private String PESEL;
     private String urodzony;
     private String adres;
     private LocalDate dataPierwszegoNajmu;

     private List<TenantAlert>alertList;
    private List<Item> items;
    private  List<Pojazd>auta;
    private static List<Person>p= new ArrayList<>();



    public Person(String imie, String nazwisko, String PESEL, String urodzony, String adres,LocalDate dataPierwszegoNajmu) {

        this.id=hashCode();
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.urodzony = urodzony;
        this.adres = adres;
        this.dataPierwszegoNajmu=dataPierwszegoNajmu;
        this.alertList=new ArrayList<>();
        this.items=new ArrayList<>();
        this.auta=new ArrayList<>();

        }

    public Person() {

    }


    public static List<Person> getP() {
        return p;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getIdP() {
        return id;
    }

    public String getImie() {
        return imie;
    }


    public List<TenantAlert> getAlertList() {
        return alertList;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getUrodzony() {
        return urodzony;
    }

    public String getAdres() {
        return adres;
    }

    public LocalDate getDataPierwszegoNajmu() {
        return dataPierwszegoNajmu;
    }

    public void setDataPierwszegoNajmu(LocalDate dataPierwszegoNajmu) {
        this.dataPierwszegoNajmu = dataPierwszegoNajmu;
    }

    public List<Pojazd>getAuta() {
        return auta;
    }
    public List<Uzytkownik> leaveParkingList(Person p, List<Uzytkownik> lista) {

        List<Uzytkownik> pslist = new ArrayList<>();
        for (Uzytkownik u : lista) {

            if ((p.getIdP() == u.getPerson().getIdP()) && u.getPlace().getClass().equals(ParkingSpace.class)) {
                pslist.add(u);
            }
        }
        return pslist;}


    public void rentParking(ParkingSpace x, LocalDate currentDate, Pojazd pojazd, int day,Person p) {
        x.setRental(currentDate);
        x.setCarId(pojazd.getId());
        x.setAuto(pojazd);
        x.setEndRental(currentDate.plusDays(day));
        p.getAuta().remove(pojazd);
    }


    public void leaveParking(List<Uzytkownik>lista,Uzytkownik u,Person p){
        ParkingSpace x=(ParkingSpace)u.getPlace();
        Pojazd auto=x.getAuto();
        p.getAuta().add(auto);
        x.setRental(null);
        x.setEndRental(null);
        lista.remove(u);



    }

/*  @Override
    public String toString() {
        return  imie+" "+nazwisko + " "+ urodzony+" "+ adres;
}
*/

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", urodzony='" + urodzony + '\'' +
                ", adres='" + adres + '\'' +
                ", dataPierwszegoNajmu=" + dataPierwszegoNajmu +

                ", alertList=" + alertList +
                ", items=" + items +
                '}';
    }
}
