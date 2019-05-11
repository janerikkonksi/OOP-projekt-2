import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("Duplicates")
public class test {

    public static void main(String[] args) {
        List<Küsimus> uus = loeKüsimused();
        System.out.println(uus);
    }
    public static List<Küsimus> loeKüsimused() {
        List<Küsimus> küsimute_list = new ArrayList<>();

        try (FileInputStream sisendVoog = new FileInputStream("küsimused.txt");
             InputStreamReader lugeja = new InputStreamReader(sisendVoog, "UTF-8");
             BufferedReader puhvriga_lugeja = new BufferedReader(lugeja)) {
            //Sulgeb ise vood pärast

            while (true) {
                String rida = puhvriga_lugeja.readLine();
                if (rida == null) {
                    break;
                }

                String[] tükid = rida.split(";");

                if (tükid.length == 8) { // igaksjuhuks, äkki küsimus on valesti koostatud, siis jätab vahele, mitte ei jookse kokku
                    Küsimus uus_küsimus = new Küsimus(tükid[0], tükid[1], tükid[2], tükid[3], tükid[4], tükid[5], Integer.parseInt(tükid[6]), Integer.parseInt(tükid[7]));
                    küsimute_list.add(uus_küsimus);
                }
                if (tükid.length != 8) {
                    System.out.println(rida + " - oli valesti koostatud");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }


        return küsimute_list;
    }
}
