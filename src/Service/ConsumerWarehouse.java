package Service;

import items.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsumerWarehouse {

int id;
int serviceId;
double area;
double volume;
LocalDate rental;
LocalDate endRental;
int idCustomer;

List<Item> items;


    public ConsumerWarehouse(int serviceId, double height,double area, LocalDate rental, LocalDate endRental, int idCustomer) {


        id=hashCode();
        this.serviceId=serviceId;
        this.area = area;
        this.volume = height*area;
        this.rental = rental;
        this.endRental = endRental;
        this.idCustomer = idCustomer;
        items=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    public LocalDate getRental() {
        return rental;
    }

    public LocalDate getEndRental() {
        return endRental;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setRental(LocalDate rental) {
        this.rental = rental;
    }

    public void setEndRental(LocalDate endRental) {
        this.endRental = endRental;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "ConsumerWarehouse{" +
                "id=" + id +
                ", area=" + area +
                ", volume=" + volume +
                ", rental=" + rental +
                ", endRental=" + endRental +
                ", idCustomer=" + idCustomer +
                '}';
    }

    public void setStartRental(){

    }
}

