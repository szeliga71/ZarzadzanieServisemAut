package Service;

import java.time.LocalDate;

public class ParkingSpace {

    int id;
    int carId;
    int serviceId;
    LocalDate rental;
    LocalDate endRental;

    public ParkingSpace(int serviceId, int carId, LocalDate rental, LocalDate endRental) {

        this.id = hashCode();
        this.serviceId=serviceId;
        this.carId=carId;
        this.rental = rental;
        this.endRental = endRental;
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
