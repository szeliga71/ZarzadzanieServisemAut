package users;

import Service.ConsumerWarehouse;
import Service.ParkingSpace;
import items.Pojazd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Uzytkownik <T> extends Person {

    private T place;
    private Person p;


    private int id;


    public Uzytkownik(T place, Person p) {


        this.id = hashCode();
        this.place = place;
        this.p = p;

    }


    public T getPlace() {
        return place;
    }

    public Person getPerson() {
        return p;
    }

    public void rentWarehouse(ConsumerWarehouse x, LocalDate currentDate, Person p, int day) {
        x.setRental(currentDate);
        x.setIdCustomer(p.getIdP());
        x.setEndRental(currentDate.plusDays(day));
        if (p.getDataPierwszegoNajmu() == null)
            p.setDataPierwszegoNajmu(currentDate);

    }

    public void rentParking(ParkingSpace x, LocalDate currentDate, Pojazd pojazd, int day, Person p) {
        x.setRental(currentDate);
        x.setCarId(pojazd.getId());
        x.setAuto(pojazd);
        x.setEndRental(currentDate.plusDays(day));
        p.getAuta().remove(pojazd);
    }
    public List<Uzytkownik> leaveParkingList(Person p, List<Uzytkownik> lista) {

        List<Uzytkownik> pslist = new ArrayList<>();
        for (Uzytkownik u : lista) {

            if ((p.getIdP() == u.getPerson().getIdP()) && u.getPlace().getClass().equals(ParkingSpace.class)) {
                pslist.add(u);
            }
        }
        return pslist;}


    public void leaveParking(List<Uzytkownik>lista,Uzytkownik u,Person p){
        ParkingSpace x=(ParkingSpace)u.getPlace();
        Pojazd auto=x.getAuto();
        p.getAuta().add(auto);
        x.setRental(null);
        x.setEndRental(null);
        lista.remove(u);
    }
    public void leaveWarehouse(List<Uzytkownik>lista,Uzytkownik u){
        ConsumerWarehouse x=(ConsumerWarehouse) u.getPlace();
        u.getPerson().getItems().addAll(x.getItems());

        x.getItems().clear();

        x.setRental(null);
        x.setEndRental(null);
        lista.remove(u);
    }


    @Override
        public String toString () {
            return "Uzytkownik{" +
                    "place=" + place +
                    ", startDate=";
        }
    }

