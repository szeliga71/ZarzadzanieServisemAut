package items;

public class Pojazd   {


    private int id;
    private String marka;
    private String model;

    RodzajPaliwa paliwo;
    Naped naped;


    public Pojazd(String marka, String model) {
        this.id=hashCode();
        this.marka = marka;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
