public class Mängija {

    private int lõpp_punktid;
    private String nimi;

    public Mängija(String nimi) {
        this.nimi = nimi;
    }

    public void setLõpp_punktid(int lisanduvad) {
        this.lõpp_punktid += lisanduvad;
    }

    @Override
    public String toString() {
        return nimi + lõpp_punktid;
    }
}
