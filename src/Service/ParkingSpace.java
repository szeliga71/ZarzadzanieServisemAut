package Service;

import items.Pojazd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {

    int id;
    int carId;
    int serviceId;
    LocalDate rental;
    LocalDate endRental;
    Pojazd auto;

    public ParkingSpace(int serviceId, int carId, LocalDate rental, LocalDate endRental,Pojazd auto) {

        this.id = hashCode();
        this.serviceId=serviceId;
        this.carId=carId;
        this.rental = rental;
        this.endRental = endRental;
        this.auto=auto;
    }

    public int getId() {
        return id;
    }

    public int getCarId() {
        return carId;
    }

    public LocalDate getRental() {
        return rental;
    }

    public LocalDate getEndRental() {
        return endRental;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setRental(LocalDate rental) {
        this.rental = rental;
    }

    public void setEndRental(LocalDate endRental) {
        this.endRental = endRental;
    }

    public Pojazd getAuto() {
        return auto;
    }

    public void setAuto(Pojazd auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "id=" + id +
                ", carId=" + carId +
                ", rental=" + rental +
                ", endRental=" + endRental +
                '}';
    }


}
