package users;

import Service.ConsumerWarehouse;
import Service.ParkingSpace;
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

    public void rentParking(ParkingSpace x, LocalDate currentDate, int autoId, int day) {
        x.setRental(currentDate);
        x.setCarId(autoId);
        x.setEndRental(currentDate.plusDays(day));

    }
    public List<Uzytkownik> leaveParking(Person p, List<Uzytkownik> lista) {

        List<Uzytkownik> pslist = new ArrayList<>();
        for (Uzytkownik u : lista) {

            if ((p.getIdP() == u.getPerson().getIdP()) && u.getPlace().getClass().equals(ParkingSpace.class)) {
                pslist.add(u);
            }
        }
        return pslist;}


    public void leaveParking(List<Uzytkownik>lista,Uzytkownik u){


        lista.remove(u);



    }



    @Override
        public String toString () {
            return "Uzytkownik{" +
                    "place=" + place +
                    ", startDate=";
        }
    }

