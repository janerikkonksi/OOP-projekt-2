import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("Duplicates")
public class Mdea extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage peaLava) throws Exception {

        //Selle võib teha eraldi meetodiks
        TextInputDialog dialog = new TextInputDialog("Mari Mustikas");
        dialog.setTitle("Nime küsimine");
        dialog.setHeaderText("Kuldvillak");
        dialog.setContentText("Palun sisesta oma nimi: ");

        String nimi = "";
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            nimi = result.get();
        }
        else {
            System.exit(0);
        }

        //Loon sisendi põhjal uue mängija
        Mängija uus_mängija = new Mängija(nimi);

        BorderPane juur = new BorderPane();
        Scene scene = new Scene(juur, 600, 400);
        peaLava.setScene(scene);

        // mänguakna minimaalne suurus
        peaLava.setMinWidth(600);
        peaLava.setMinHeight(400);
        // suurust muutes säilitab kõrguse-laiuse suhte
        peaLava.minWidthProperty().bind(scene.heightProperty().multiply(1.5));
        peaLava.minHeightProperty().bind(scene.widthProperty().divide(1.5));


        // mänguruudustiku loomine
        GridPane valikuteRuudustik = new GridPane();
        valikuteRuudustik.setHgap(5);
        valikuteRuudustik.setVgap(5);
        juur.setCenter(valikuteRuudustik);


        // kõik veerud on sama laiusega
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
        valikuteRuudustik.getColumnConstraints().addAll(veerg1, veerg2, veerg3, veerg4, veerg5);

        // kõik read on sama k�rgusega
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
        valikuteRuudustik.getRowConstraints().addAll(rida0, rida1, rida2, rida3, rida4, rida5);


        // teemade sildid
        Label teema1 = new Label("Sport");
        Label teema2 = new Label("Ajalugu");
        Label teema3 = new Label("Varia");
        Label teema4 = new Label("Sekslelud");
        Label teema5 = new Label("Autod");


        // lisame teemade sildid mängulauale
        List<Labeled> teemad = Arrays.asList(teema1, teema2, teema3, teema4, teema5);
        lisaRitta(teemad, valikuteRuudustik, 0);
        teemad.forEach(teema -> teema.setAlignment(Pos.CENTER));


        // loeme failist sisse küsimused
        List<Küsimus> küsimused = loeKüsimused();


        // 1. teema küsimused
        Button küsimus100_1 = new Button("100"); //Sport
        Button küsimus200_1 = new Button("200");
        Button küsimus300_1 = new Button("300");
        Button küsimus400_1 = new Button("400");
        Button küsimus500_1 = new Button("500");

        // lisame 1. teema küsimused mängulauale
        List<Labeled> esimeseTeemaNupud = Arrays.asList(küsimus100_1, küsimus200_1, küsimus300_1, küsimus400_1, küsimus500_1);
        lisaVeergu(esimeseTeemaNupud, valikuteRuudustik, 1);

        // 2. teema küsimused
        Button küsimus100_2 = new Button("100");
        Button küsimus200_2 = new Button("200");
        Button küsimus300_2 = new Button("300");
        Button küsimus400_2 = new Button("400");
        Button küsimus500_2 = new Button("500");

        // lisame 2. teema küsimused mängulauale
        List<Labeled> teiseTeemaNupud = Arrays.asList(küsimus100_2, küsimus200_2,küsimus300_2,küsimus400_2,küsimus500_2 );
        lisaVeergu(teiseTeemaNupud, valikuteRuudustik, 2);


        // 3. teema küsimused
        Button küsimus100_3 = new Button("100");
        Button küsimus200_3 = new Button("200");
        Button küsimus300_3 = new Button("300");
        Button küsimus400_3 = new Button("400");
        Button küsimus500_3 = new Button("500");

        // lisame 3. teema küsimused mängulauale
        List<Labeled> kolmandaTeemaNupud = Arrays.asList(küsimus100_3,küsimus200_3,küsimus300_3,küsimus400_3,küsimus500_3);
        lisaVeergu(kolmandaTeemaNupud, valikuteRuudustik, 3);

        // 4. teema küsimused
        Button küsimus100_4 = new Button("100");
        Button küsimus200_4 = new Button("200");
        Button küsimus300_4 = new Button("300");
        Button küsimus400_4 = new Button("400");
        Button küsimus500_4 = new Button("500");

        // lisame 4. teema küsimused mängulauale
        List<Labeled> neljandaTeemaNupud = Arrays.asList(küsimus100_4,küsimus200_4,küsimus300_4,küsimus400_4,küsimus500_4);
        lisaVeergu(neljandaTeemaNupud, valikuteRuudustik, 4);

        // 5. teema küsimused
        Button küsimus100_5 = new Button("100");
        Button küsimus200_5 = new Button("200");
        Button küsimus300_5 = new Button("300");
        Button küsimus400_5 = new Button("400");
        Button küsimus500_5 = new Button("500");

        // lisame 5. teema küsimused mängulauale
        List<Labeled> viiendaTeemaNupud = Arrays.asList(küsimus100_5,küsimus200_5,küsimus300_5,küsimus400_5,küsimus500_5);
        lisaVeergu(viiendaTeemaNupud, valikuteRuudustik, 5);



        // Sündmuste lisamine küsimuste peale vajutades
        //Kuidagi peab ikka vist parem moodus olema, kuidas seda teha
        // Teema: sport
        nupuvajutus(küsimus100_1, "Sport", 100, küsimused);
        nupuvajutus(küsimus200_1,"Sport", 200, küsimused);
        nupuvajutus(küsimus300_1,"Sport", 300, küsimused);
        nupuvajutus(küsimus400_1,"Sport", 400, küsimused);
        nupuvajutus(küsimus500_1,"Sport", 500, küsimused);


        // aknasündmuse lisamine
        peaLava.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                // luuakse teine lava
                Stage kusimus = new Stage();
                // küsimuse ja kahe nupu loomine
                Label label = new Label("Kas soovite tõesti mängimise lõpetada?");
                Button okButton = new Button("Jah");
                Button cancelButton = new Button("Ei");

                // sündmuse lisamine nupule Jah
                okButton.setOnAction(event1 -> kusimus.hide());

                // sündmuse lisamine nupule Ei
                cancelButton.setOnAction(event12 -> {
                    peaLava.show();
                    kusimus.hide();
                });

                // nuppude grupeerimine
                FlowPane pane = new FlowPane(10, 10);
                pane.setAlignment(Pos.CENTER);
                pane.getChildren().addAll(okButton, cancelButton);

                // küsimuse ja nuppude gruppi paigutamine
                VBox vBox = new VBox(10);
                vBox.setAlignment(Pos.CENTER);
                vBox.getChildren().addAll(label, pane);

                //stseeni loomine ja näitamine
                Scene stseen2 = new Scene(vBox, 300, 100);
                kusimus.setScene(stseen2);
                kusimus.setResizable(false);
                kusimus.show();
            }
        }); //siin lõpeb aknasündmuse kirjeldus

        peaLava.show();
    }


    public static void lisaRitta(List<Labeled> nupud, GridPane valikuteRuudustik, int reaNr) {
        for (int i = 0; i < nupud.size(); i++) {
            Labeled silt = nupud.get(i);
            valikuteRuudustik.add(silt, i, reaNr);
            silt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        }
    }


    public static void lisaVeergu(List<Labeled> nupud, GridPane valikuteRuudustik, int veeruNr) {
        for (int i = 0; i < nupud.size(); i++) {
            Labeled nupp = nupud.get(i);
            valikuteRuudustik.add(nupp, veeruNr-1, i+1);
            nupp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        }
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
                    System.out.println(rida + " - OLI VALESTI KOOSTATUD");
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

        return küsimute_list;
    }

    public void nupuvajutus(Button nimi, String teema, int väärtus, List<Küsimus> küsimused) {
        nimi.setOnMouseClicked(event -> {
            Küsimus uus = loosi_suvaline_küsimus(teema, väärtus, küsimused);
            küsimuseAken(uus);
        });
    }

    public Küsimus loosi_suvaline_küsimus(String teema, int väärtus, List<Küsimus> küsimused) {

        Küsimus loositav_küsimus;

        // No see lahendus suht halb, pigem võiks sisselugemisel juba teemade ja väärtuste järgi jagada
        // aga noh tuleks liiga palju liste ja see töötab xd :D :D
        while (true) {
            int max = küsimused.size();
            int min = 0;
            int range = max - min;

                int rand = (int)(Math.random() * range) + min;

                loositav_küsimus = küsimused.get(rand);

                if (teema.equals(loositav_küsimus.getTeema()) && loositav_küsimus.getVäärtus() == väärtus) {
                    return loositav_küsimus;
                }

        }
    }
    public void küsimuseAken(Küsimus uus_küsimus) {

        //Mängija uus_mängija = mängija; //mdea lisan punkte mängijale
        Stage newStage = new Stage();
        Group juur = new Group();

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20));

        Text tekst = new Text(uus_küsimus.getKüsimus());
        tekst.setFont(new Font(13));

        CheckBox valik1 = new CheckBox(uus_küsimus.getVastus1());
        CheckBox valik2 = new CheckBox(uus_küsimus.getVastus2());
        CheckBox valik3 = new CheckBox(uus_küsimus.getVastus3());
        CheckBox valik4 = new CheckBox(uus_küsimus.getVastus4());

        Button nupp = new Button();
        nupp.setPrefSize(50, 30);
        nupp.setText("Vasta");


        Text tekst2 = new Text();

        class Käsitleja implements EventHandler<MouseEvent> {
            private Button nupp;

            public Käsitleja(Button nupp) {
                this.nupp = nupp;
            }

            public void handle(MouseEvent me) {

            }
        }
        nupp.setOnMouseClicked(event -> tagasiside(nupp,valik1,valik2,valik3,valik4,vbox,tekst2, uus_küsimus));


        vbox.getChildren().addAll(tekst,valik1, valik2, valik3,valik4, nupp, tekst2);
        juur.getChildren().add(vbox);



        Scene stageScene = new Scene(juur, 550, 350);
        newStage.setScene(stageScene);
        newStage.setTitle("Küsimus");
        newStage.setResizable(false);
        newStage.show();



    }

    //Siin klassis veits palju kordusi
    public static void tagasiside(Button nupp,CheckBox valik1, CheckBox valik2, CheckBox valik3,CheckBox valik4, VBox vbox, Text tekst, Küsimus küsimus){
        if(valik1.isSelected() && küsimus.getÕige_vastuse_nr() == 0){
            tekst.setText("Sinu vastus on õige. Said juurde: " + küsimus.getVäärtus() + " punkti");
            tekst.setFill(Color.GREEN);
            valik1.setTextFill(Color.GREEN);
            valik2.setTextFill(Color.RED);
            valik3.setTextFill(Color.RED);
            valik4.setTextFill(Color.RED);
            nupp.setDisable(true);
        } else if(valik2.isSelected() && küsimus.getÕige_vastuse_nr() == 1) {
            tekst.setText("Sinu vastus on õige. Said juurde: " + küsimus.getVäärtus() + " punkti");
            tekst.setFill(Color.GREEN);
            valik2.setTextFill(Color.GREEN);
            valik1.setTextFill(Color.RED);
            valik3.setTextFill(Color.RED);
            valik4.setTextFill(Color.RED);
            nupp.setDisable(true);
        } else if(valik3.isSelected() && küsimus.getÕige_vastuse_nr() == 2) {
            tekst.setText("Sinu vastus on õige. Said juurde: " + küsimus.getVäärtus() + " punkti");
            tekst.setFill(Color.GREEN);
            valik3.setTextFill(Color.GREEN);
            valik2.setTextFill(Color.RED);
            valik1.setTextFill(Color.RED);
            valik4.setTextFill(Color.RED);
            nupp.setDisable(true);
        } else if(valik4.isSelected() && küsimus.getÕige_vastuse_nr() == 3) {
            tekst.setText("Sinu vastus on õige. Said juurde: " + küsimus.getVäärtus() + " punkti");
            tekst.setFill(Color.GREEN);
            valik4.setTextFill(Color.GREEN);
            valik1.setTextFill(Color.RED);
            valik3.setTextFill(Color.RED);
            valik2.setTextFill(Color.RED);
            nupp.setDisable(true);
        }
        else{
            tekst.setText("Sinu vastus on vale.");
            tekst.setFill(Color.RED);
            Text õigeVastus = new Text("Õige(d) vastused:" + System.lineSeparator() + "\t" + küsimus.getÕigeVastus());
            vbox.getChildren().add(õigeVastus);
            valik1.setDisable(true);
            valik2.setDisable(true);
            valik3.setDisable(true);
            valik4.setDisable(true);
            nupp.setDisable(true);
        }


    }



}
