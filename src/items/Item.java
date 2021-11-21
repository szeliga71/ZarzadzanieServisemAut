package items;

public class Item {




        private String nazwa;
        private double szerokosc;
        private double dlugosc;
        private double wysokosc;

        public Item(String nazwa, double szerokosc, double dlugosc, double wysokosc) {
            this.nazwa = nazwa;
            this.szerokosc = szerokosc;
            this.dlugosc = dlugosc;
            this.wysokosc = wysokosc;
        }

        public double rozmiar(){
            double s=this.szerokosc;
            double d=this.dlugosc;
            double w=this.wysokosc;
            double rozmiar=0;
            rozmiar=s*d*w;
            return rozmiar;}

        public String getNazwa() {
            return nazwa;
        }


    }

