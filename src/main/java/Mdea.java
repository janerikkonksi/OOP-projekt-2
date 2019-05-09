import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;

public class Mdea extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage peaLava) throws Exception {

        BorderPane juur = new BorderPane();
        juur.setMinSize(400,300);
        Scene scene = new Scene(juur,600,400);
        peaLava.setScene(scene);


        GridPane valikuteRuudustik = new GridPane();
        valikuteRuudustik.setHgap(5);
        valikuteRuudustik.setVgap(5);
        juur.setCenter(valikuteRuudustik);


        ColumnConstraints veerg1 = new ColumnConstraints();
        veerg1.setPercentWidth(20);
        ColumnConstraints veerg2 = new ColumnConstraints();
        veerg2.setPercentWidth(20);
        ColumnConstraints veerg3 = new ColumnConstraints();
        veerg3.setPercentWidth(20);
        ColumnConstraints veerg4 = new ColumnConstraints();
        veerg4.setPercentWidth(20);
        ColumnConstraints veerg5 = new ColumnConstraints();
        veerg5.setPercentWidth(20);
        valikuteRuudustik.getColumnConstraints().addAll(veerg1,veerg2,veerg3,veerg4,veerg5);

        RowConstraints rida0 = new RowConstraints();
        rida0.setPercentHeight(20);
        RowConstraints rida1 = new RowConstraints();
        rida1.setPercentHeight(20);
        RowConstraints rida2 = new RowConstraints();
        rida2.setPercentHeight(20);
        RowConstraints rida3 = new RowConstraints();
        rida3.setPercentHeight(20);
        RowConstraints rida4 = new RowConstraints();
        rida4.setPercentHeight(20);
        RowConstraints rida5 = new RowConstraints();
        rida5.setPercentHeight(20);
        valikuteRuudustik.getRowConstraints().addAll(rida0,rida1,rida2,rida3,rida4,rida5);


    /*    // teemad
        Text teema1 = new Text("Teema1");
        Text teema2 = new Text("Teema2");
        Text teema3 = new Text("Teema3");
        Text teema4 = new Text("Teema4");
        Text teema5 = new Text("Teema5");

        List<Text> teemad = Arrays.asList(teema1,teema2,teema3,teema4,teema5);
        for (int i = 0; i < teemad.size(); i++) {
            Text teema = teemad.get(i);
            valikuteRuudustik.add(teema,i,0);
        }*/

        Button teema1 = new Button("Teema 1");
        Button teema2 = new Button("Teema 2");
        Button teema3 = new Button("Teema 3");
        Button teema4 = new Button("Teema 4");
        Button teema5 = new Button("Teema 5");

        List<Button> teemadeNupud = Arrays.asList(teema1,teema2,teema3,teema4,teema5);
        teemadeNupud.forEach(nupp -> nupp.setBackground(Background.EMPTY));
        lisaNupud(teemadeNupud,valikuteRuudustik,0);


        // 1. rea küsimused
        Button küsimus100_1 = new Button("100");
        Button küsimus100_2 = new Button("100");
        Button küsimus100_3 = new Button("100");
        Button küsimus100_4 = new Button("100");
        Button küsimus100_5 = new Button("100");

        List<Button> esimeseReaNupud = Arrays.asList(küsimus100_1,küsimus100_2,küsimus100_3,küsimus100_4,küsimus100_5);
        lisaNupud(esimeseReaNupud,valikuteRuudustik,1);


        // 2. rea küsimused
        Button küsimus200_1 = new Button("200");
        Button küsimus200_2 = new Button("200");
        Button küsimus200_3 = new Button("200");
        Button küsimus200_4 = new Button("200");
        Button küsimus200_5 = new Button("200");

        List<Button> teiseReaNupud = Arrays.asList(küsimus200_1,küsimus200_2,küsimus200_3,küsimus200_4,küsimus200_5);
        lisaNupud(teiseReaNupud,valikuteRuudustik,2);


        // 3. rea küsimused
        Button küsimus300_1 = new Button("300");
        Button küsimus300_2 = new Button("300");
        Button küsimus300_3 = new Button("300");
        Button küsimus300_4 = new Button("300");
        Button küsimus300_5 = new Button("300");

        List<Button> kolmandaReaNupud = Arrays.asList(küsimus300_1,küsimus300_2,küsimus300_3,küsimus300_4,küsimus300_5);
        lisaNupud(kolmandaReaNupud,valikuteRuudustik,3);


        // 4. rea küsimused
        Button küsimus400_1 = new Button("400");
        Button küsimus400_2 = new Button("400");
        Button küsimus400_3 = new Button("400");
        Button küsimus400_4 = new Button("400");
        Button küsimus400_5 = new Button("400");

        List<Button> neljandaReaNupud = Arrays.asList(küsimus400_1,küsimus400_2,küsimus400_3,küsimus400_4,küsimus400_5);
        lisaNupud(neljandaReaNupud,valikuteRuudustik,4);


        // 5. rea küsimused
        Button küsimus500_1 = new Button("500");
        Button küsimus500_2 = new Button("500");
        Button küsimus500_3 = new Button("500");
        Button küsimus500_4 = new Button("500");
        Button küsimus500_5 = new Button("500");

        List<Button> viiendaReaNupud = Arrays.asList(küsimus500_1,küsimus500_2,küsimus500_3,küsimus500_4,küsimus500_5);
        lisaNupud(viiendaReaNupud,valikuteRuudustik,5);

        peaLava.show();
    }

    public static void lisaNupud(List<Button> nupud, GridPane valikuteRuudustik, int reaNr){
        for (int i = 0; i < nupud.size(); i++) {
            Button nupp = nupud.get(i);
            valikuteRuudustik.add(nupp,i,reaNr);
            nupp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        }
    }

}
