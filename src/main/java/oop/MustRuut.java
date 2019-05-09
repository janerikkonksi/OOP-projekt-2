package oop;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.awt.*;

public class MustRuut extends Application {

    @Override
    public void start(Stage peaLava) throws Exception {

        Group juur = new Group();
        Canvas lõuend = new Canvas(600, 300);
        GraphicsContext gc = lõuend.getGraphicsContext2D();
        juur.getChildren().add(lõuend);
        Scene stseen1 = new Scene(juur);
        peaLava.setScene(stseen1);


        gc.setFill(Color.rgb(0, 114, 206));
        gc.fillRect(0, 0, 600, 100);

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 100, 600, 100);

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 200, 600, 100);

        peaLava.setResizable(false);
        peaLava.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
