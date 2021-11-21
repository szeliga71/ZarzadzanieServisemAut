package items;

public interface Ruch {


    void ruch();

    default void plyn(){
        System.out.println(" plynie ");

    }
default void jedz(){
    System.out.println(" jedzie ");
}


}
