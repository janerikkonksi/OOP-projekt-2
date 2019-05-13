public class Küsimus {

    private String teema;
    private String küsimus;
    private String vastus1;
    private String vastus2;
    private String vastus3;
    private String vastus4;
    private int õige_vastuse_nr;
    private int väärtus;

    // KONSTRUKTOR


    public Küsimus(String teema, String küsimus, String vastus1, String vastus2, String vastus3, String vastus4,
                   int õige_vastuse_nr, int väärtus) {
        this.teema = teema;
        this.küsimus = küsimus;
        this.vastus1 = vastus1;
        this.vastus2 = vastus2;
        this.vastus3 = vastus3;
        this.vastus4 = vastus4;
        this.õige_vastuse_nr = õige_vastuse_nr;
        this.väärtus = väärtus;
    }

    public String getÕigeVastus() {
        if (õige_vastuse_nr == 0) {
            return vastus1;
        }
        if (õige_vastuse_nr == 1) {
            return vastus2;
        }
        if (õige_vastuse_nr == 2) {
            return vastus3;
        }
        else {
            return vastus4;
        }
    }

    public String getTeema() {
        return teema;
    }

    public String getKüsimus() {
        return küsimus;
    }

    public String getVastus1() {
        return vastus1;
    }

    public String getVastus2() {
        return vastus2;
    }

    public String getVastus3() {
        return vastus3;
    }

    public String getVastus4() {
        return vastus4;
    }

    public int getÕige_vastuse_nr() {
        return õige_vastuse_nr;
    }

    public int getVäärtus() {
        return väärtus;
    }

    @Override
    public String toString() {
        return küsimus;
    }
}
