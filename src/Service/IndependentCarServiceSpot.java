package Service;

import java.time.LocalDate;

public class IndependentCarServiceSpot extends CarServiceSpot{

    int id;
    int serviceId;
    int carId;
    LocalDate rental;
    LocalDate endRental;

    public IndependentCarServiceSpot(int serviceId, int carId, LocalDate rental, LocalDate endRental) {
        super(serviceId, carId, rental, endRental);
        this.id=hashCode();
        this.serviceId = serviceId;
        this.carId = carId;
        this.rental = rental;
        this.endRental = endRental;
    }

    @Override
    public String toString() {
        return "IndependentCarServiceSpot{" +
                "id=" + id +
                ", carId=" + carId +
                ", rental=" + rental +
                ", endRental=" + endRental +
                '}';
    }
}
