package oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Kalkulaator extends Application {

    public void start(Stage peaLava) throws Exception {
        // Tekitame üldisema akna struktuuri:
        BorderPane juur = new BorderPane();
        Scene scene = new Scene(juur);
        peaLava.setScene(scene);
        peaLava.setResizable(false);
        // Lisame ülemise arvusid näitava sisestuskasti:
        TextField tekstiRida = new TextField ();
        tekstiRida.setMinWidth(300);
        tekstiRida.setAlignment(Pos.BASELINE_RIGHT);
        juur.setTop(tekstiRida);
        // Ruudustikus olevad nupud:
        // Numbrid:
        Button num0 = new Button("0");
        Button num1 = new Button("1");
        Button num2 = new Button("2");
        Button num3 = new Button("3");
        Button num4 = new Button("4");
        Button num5 = new Button("5");
        Button num6 = new Button("6");
        Button num7 = new Button("7");
        Button num8 = new Button("8");
        Button num9 = new Button("9");
        // Matemaatilised operaatorid:
        Button nuppJagamine = new Button("/");
        Button nuppKorrutamine = new Button("*");
        Button nuppLahutamine = new Button("-");
        Button nuppLiitmine = new Button("+");
        Button nuppRuutjuur = new Button("sqrt");
        Button nuppJääk = new Button("%");
        Button nuppPöördarv = new Button("1/x");
        // Muud operaatorid:
        Button nuppVõrdusmärk = new Button("=");
        Button nuppNegatiivnePositiivne = new Button("+/-");
        Button nuppKomakoht = new Button(",");
        // Ülemised nupud:
        Button nuppBackspace = new Button("Backspace");
        Button nuppKustutaKõik = new Button("CE");
        Button nuppKustuta = new Button("C");

        // SIIA JÄRELE VÕIKS LISADA SÜNDMUSTE KÄITLEMISE.
        // Ei peaks olema vaja siit ülevalpool midagi muuta.
        // Erandiks see, kui on soov määrata isendimuutuja eelmise
        // teksti/arvu meelde jätmiseks.


        // Näidiseks üks sündmuse töötlemine nupule 1 vajutades:
        num1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String vanaTekst = tekstiRida.getText();
                tekstiRida.setText(vanaTekst + "1");
            }
        });
        // edasi võiks tulla töötlus ka teiste nuppude kohta:









        // SIIT ÜLESPOOLE VÕIKS LISADA SÜNDMUSTE KÄITLEMISE.
        // Ei peaks olema vaja siit allpool midagi muuta.

        // Vahepealne nupurida:
        // Vasem backspace nupp. Tekitame jaotise, milles on see üks nupp:
        HBox vasemadNupud = new HBox();
        vasemadNupud.setPadding(new Insets(3,3,3,3));
        nuppBackspace.setTextFill(Color.RED);
        vasemadNupud.getChildren().add(nuppBackspace);
        juur.setLeft(vasemadNupud);
        // Parempoolsed C ja CE nupud:
        HBox paremadNupud = new HBox();
        paremadNupud.setSpacing(2);
        paremadNupud.setPadding(new Insets(3,3,3,3));
        nuppKustutaKõik.setTextFill(Color.RED);
        nuppKustuta.setTextFill(Color.RED);
        paremadNupud.getChildren().addAll(nuppKustutaKõik, nuppKustuta);
        juur.setRight(paremadNupud);
        // Tekitan alumise ruudustiku numbrite ja operaatoritega.
        // Seejärel Lisan kokku pandud ruudustiku juurele:
        GridPane nupuRuudustik = new GridPane();
        nupuRuudustik.setVgap(2);
        nupuRuudustik.setHgap(2);
        nupuRuudustik.setPadding(new Insets(3,3,3,3));
        juur.setBottom(nupuRuudustik);
        // Määran ära veergude laiused. Kuna veergusid on kokku 5,
        // siis iga veerg on 20% kogu laiusest.
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
        nupuRuudustik.getColumnConstraints().addAll(veerg1,veerg2,veerg3,veerg4,veerg5);
        // Jaotan nupud õigetesse jagudesse ruudustikul ning määrane,
        // et nad täidaksid kogu ruudu maksimaalses ulatuses.
        //Rida 0:
        nupuRuudustik.add(num7, 0,0);
        nupuRuudustik.add(num8, 1,0);
        nupuRuudustik.add(num9, 2,0);
        nupuRuudustik.add(nuppJagamine, 3, 0);
        nupuRuudustik.add(nuppRuutjuur, 4, 0);
        num7.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        num8.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        num9.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppJagamine.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppRuutjuur.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppJagamine.setTextFill(Color.RED);
        // Rida 1:
        nupuRuudustik.add(num4, 0,1);
        nupuRuudustik.add(num5, 1,1);
        nupuRuudustik.add(num6, 2,1);
        nupuRuudustik.add(nuppKorrutamine, 3, 1);
        nupuRuudustik.add(nuppJääk, 4, 1);
        num4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        num5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        num6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppKorrutamine.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppJääk.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppKorrutamine.setTextFill(Color.RED);
        // Rida 2:
        nupuRuudustik.add(num1, 0,2);
        nupuRuudustik.add(num2, 1,2);
        nupuRuudustik.add(num3, 2,2);
        nupuRuudustik.add(nuppLahutamine, 3, 2);
        nupuRuudustik.add(nuppPöördarv, 4, 2);
        num1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        num2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        num3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppLahutamine.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppPöördarv.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppLahutamine.setTextFill(Color.RED);
        // Rida 3:
        nupuRuudustik.add(num0, 0, 3);
        nupuRuudustik.add(nuppNegatiivnePositiivne, 1, 3);
        nupuRuudustik.add(nuppKomakoht, 2, 3);
        nupuRuudustik.add(nuppLiitmine, 3, 3);
        nupuRuudustik.add(nuppVõrdusmärk, 4, 3);
        num0.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppNegatiivnePositiivne.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppKomakoht.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppLiitmine.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppVõrdusmärk.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nuppLiitmine.setTextFill(Color.RED);
        nuppVõrdusmärk.setTextFill(Color.RED);

        peaLava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
