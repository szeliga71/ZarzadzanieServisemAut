package Service;



import users.Uzytkownik;

import java.util.*;

public class Service {


    private String name;
    private String adres;
    int id;


    private static ServiceWarehouse ServiceWarehouse;



    //Map<Integer, Integer> allService;
    List<Uzytkownik>uzytkownicy;
    List<CarServiceSpot>carSpot;
    List<ConsumerWarehouse>consumerWarehouses;
    List<IndependentCarServiceSpot>IndCarSpot;
    List<ParkingSpace> parking;

    public Service(String name, String adres) {

        this.id=hashCode();
        this.name = name;
        this.adres = adres;

        //this.allService = new HashMap<>();
        this.carSpot=new ArrayList<>();
        this.consumerWarehouses=new ArrayList<>();
        this.IndCarSpot=new ArrayList<>();
        this.parking=new ArrayList<>();
        this.uzytkownicy=new ArrayList<>();

       ServiceWarehouse= new ServiceWarehouse(name,adres);

    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getAdres() {
        return adres;
    }



    public ServiceWarehouse getServiceWarehouse() {
        return ServiceWarehouse;
    }

    //public Map<Integer, Integer> getAllService() {return allService}

    public List<CarServiceSpot> getCarSpot() {
        return carSpot;
    }

    public List<ConsumerWarehouse> getConsumerWarehouses() {
        return consumerWarehouses;
    }

    public List<IndependentCarServiceSpot> getIndCarSpot() {
        return IndCarSpot;
    }

    public List<ParkingSpace> getParking() {
        return parking;
    }

    public List<Uzytkownik> getUzytkownicy() {
        return uzytkownicy;
    }

    public List<ConsumerWarehouse>showFreeWarehoses(List<ConsumerWarehouse>cwList){
        List<ConsumerWarehouse>freeWarehouses=new ArrayList<>();
        for(ConsumerWarehouse cw: cwList){
            if(cw.getIdCustomer()==0){
                freeWarehouses.add(cw);
            }
        }
        return freeWarehouses;}

    public List<ParkingSpace>showFreeParkings(List<ParkingSpace>pList){
        List<ParkingSpace>freeParkings=new ArrayList<>();
        for(ParkingSpace p: pList){
            if(p.getCarId()==0){
                freeParkings.add(p);
            }
        }
        return freeParkings;}


    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
