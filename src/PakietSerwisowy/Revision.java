package PakietSerwisowy;


import Service.Service;
import users.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Revision implements Runnable{


    Time t;
    LocalDate startDate;
    Set<Service>serviceGarage=new HashSet<>();



    boolean rozrusznik1=true;

    List<Person> persons;
    List<Service>service;


    public Revision(Time t, LocalDate startDate) {
        this.t = t;
        this.startDate = startDate;
        service=new ArrayList<>();
        persons = new ArrayList<>();

    }




    @Override
    public void run () {


        while (rozrusznik1) {

            try {
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           // for(int i=0;i<osiedla.size();i++){

            //osiedla.get(i).znajdzPrzedawnienieMieszkania(osiedla.get(i).pokazNieruchomosciM(),getPersons());

            //osiedla.get(i).znajdzPrzedawnienieGarazu(osiedla.get(i).pokazNieruchomosciG(),getPersons());
        }
        }


    public List<Person> getPersons() {
        return persons;
    }

    public List<Service> getService() {
        return service;
    }

    public Set<Service> getServiceGarage() {
        return serviceGarage;
    }

    public void setRozrusznik1(boolean rozrusznik1) {
        this.rozrusznik1 = rozrusznik1;
    }
}
