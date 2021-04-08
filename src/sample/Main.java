package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Optional;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {


        TextInputDialog inputDialog = new TextInputDialog();

        inputDialog.setTitle("拉丁方阵");
        inputDialog.setContentText("请输入方阵维度n：");
        Optional<String> input = inputDialog.showAndWait();
        String str = input.get();
        int n = Integer.parseInt(str);

        Canvas cv = new Canvas(100*n,100*n);
        var gc = cv.getGraphicsContext2D();
        Latine.LatineInfo[][] square = Latine.generateLatine(n);
        drawSquare(gc,square,n);

        var pane = new Pane();
        pane.getChildren().addAll(cv);
        var scene = new Scene(pane,10+75*n,10+95*n);
        primaryStage.setTitle("拉丁方阵");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawSquare(GraphicsContext gc, Latine.LatineInfo[][] square, int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                gc.setStroke(Color.BLACK);
                gc.strokeRect(10+i*70,10+j*90,70,90);
                gc.setFill(Color.web(square[i][j].color));
                gc.fillRect(10+i*70,10+j*90,70,90);
                gc.setFill(Color.BLACK);
                gc.fillText(square[i][j].text,65+i*70,90+j*90);
                gc.fillText(square[i][j].pic,18+i*70,28+j*90);
            }
        }

    }

    public static void main(String[] args) {launch(args);}
}
