package PakietSerwisowy;


public class Time  implements Runnable{

        int dzien;
        boolean rozrusznik = true;

        int day;

        public void setRozrusznik(boolean rozrusznik) {
            this.rozrusznik = rozrusznik;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getDay() {
            return day;
        }

        public void run() {
            dzien = 0;
            while (rozrusznik) {
                dzien++;
                try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setDay(dzien);

            }
        }

    }

