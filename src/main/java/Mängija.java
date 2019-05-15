public class Mängija {

    private String nimi;
    private int punktid;

    public Mängija(String nimi) {
        this.nimi = nimi;
        this.punktid = 0;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPunktid() {
        return punktid;
    }

    public void suurendaPunkte(int küsimuseVäärtus) {
        this.punktid += küsimuseVäärtus;
    }
    public void vähendaPunkte(int küsimuseVäärtus){
        this.punktid -= küsimuseVäärtus;
    }

    @Override
    public String toString() {
        return nimi + punktid;
    }
}
