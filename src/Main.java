import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;

import java.awt.*;

public class Main extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }

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
            "*_______________*"};

    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "pachimon" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 900, 1000 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();


        gc.setFill( Color.RED );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );

        Image back = new Image( "back_green.jpg",1400,0,true,false );
        gc.drawImage( back, 0, 0 );

        gc.fillText( "Hello, World!", 63, 51 );
        gc.strokeText( "Hello, World!", 60, 50 );

        Image kusa = new Image("w.png",100, 0, true, false);
        Image Wood = new Image("Wood.png", 100, 0, true, false);
        for(int j= 0;j<Map.length;j++) {
            for (int i = 0; i < Map[j].length(); i++) {
                if (Map[j].charAt(i) == '*') {
                    gc.drawImage(Wood, i * 50, j*50);
                }
                if (Map[j].charAt(i) == 'w') {
                    gc.drawImage(kusa, i * 50, j*50);
                }
            }
        }

        theStage.show();




    }
}