package items;

public class AutoMiejskie {

    private int id;
    private String marka;
    private String model;

    public AutoMiejskie(String marka, String model) {

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
        return "AutoMiejskie{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

