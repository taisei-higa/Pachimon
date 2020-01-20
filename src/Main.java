import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;


public class Main extends Application {
    int x = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("pachimon");
        primaryStage.setScene(new Scene(root, 300, 275));

        Group host = new Group();
        Scene theScene = new Scene(host);
        primaryStage.setScene(theScene);


        Canvas canvas = new Canvas(900, 1000);
        host.getChildren().add(canvas);


        GraphicsContext gc = canvas.getGraphicsContext2D();


        player p = new player();
        p.player_Animation(gc);




        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}


class Map {
    String[] Map = {
            "*_______________*",
            "*_______________*",
            "*_______________*",
            "*_______________*",
            "*______www______*",
            "*______www______*",
            "*______www______*",
            "*______www______*",
            "*______www______*",
            "*_______________*",
            "*_______________*",
            "*_______________*",
            "*_______________*",
            "*_______________*"

    };

    public GraphicsContext criateMap(GraphicsContext gc) {
        Image kusa = new Image("w.png", 100, 0, true, false);
        Image Wood = new Image("Wood.png", 100, 0, true, false);
        for (int j = 0; j < Map.length; j++) {
            for (int i = 0; i < Map[j].length(); i++) {
                if (Map[j].charAt(i) == '*') {
                    gc.drawImage(Wood, i * 50, j * 50);
                }
                if (Map[j].charAt(i) == 'w') {
                    gc.drawImage(kusa, i * 50, j * 50);
                }
            }
        }
        return gc;
    }
}





class player{
    public GraphicsContext player_Animation(GraphicsContext gc){
        Image kusa = new Image("w.png", 100, 0, true, false);
        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double elapsedTime = (currentNanoTime - startNanoTime) / 1000000000.0;

                ArrayList<String> input = new ArrayList<String>();


                double x = 232 + 128 * Math.cos(elapsedTime);
                double y = 232 + 128 * Math.sin(elapsedTime);

                // Clear the canvas
                gc.clearRect(0, 0, 10000,10000);
                // background image clears canvas
                gc.drawImage( kusa, x, y );
                Map a=new Map();
                a.criateMap(gc);
            }
        }.start();
        return gc;
    }

}

