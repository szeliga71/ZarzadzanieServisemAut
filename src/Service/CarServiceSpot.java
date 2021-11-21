package Service;

import java.time.LocalDate;

public class CarServiceSpot {

    int id;
    int serviceId;
    int carId;
    LocalDate rental;
    LocalDate endRental;

    public CarServiceSpot(int serviceId,int carId, LocalDate rental, LocalDate endRental) {

        this.id = hashCode();
        this.serviceId=serviceId;
        this.carId=carId;
        this.rental = rental;
        this.endRental = endRental;
    }

    public int getId() {
        return id;
    }

    public int getServiceId() {
        return serviceId;
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

    @Override
    public String toString() {
        return "CarServiceSpot{" +
                "id=" + id +
                ", carId=" + carId +
                ", rental=" + rental +
                ", endRental=" + endRental +
                '}';
    }
}
