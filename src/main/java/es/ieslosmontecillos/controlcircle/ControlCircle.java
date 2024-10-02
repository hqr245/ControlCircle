package es.ieslosmontecillos.controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlCircle extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Setting up the Scene
        Group root = new Group();
        Scene scene = new Scene(root, 330, 240);
        stage.setTitle("ControlCircle");
        stage.setScene(scene);
        //Adding the pane where our components belongs
        FlowPane flowPane = new FlowPane();

        //creating a container

        VBox vbox = new VBox();

        HBox hbox = new HBox();

        Circle circle = new Circle();
        circle.setRadius(100);
        circle.setFill(scene.getFill());
        circle.setStroke(Color.BLACK);
        //creating both the buttons
        Button btnIncrease = new Button("Increase");

        EventHandler<ActionEvent> increaseEv = new EventHandler() {
            @Override
            public void handle(Event event) {
                circle.setRadius(circle.getRadius() + 10);
                stage.setHeight(stage.getHeight() +20);
                stage.setWidth(stage.getWidth() +20);
            }
        };
        btnIncrease.setOnAction(increaseEv);

        circle.radiusProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue.intValue()<0){
                circle.setRadius(0);

                stage.setHeight(stage.getHeight() +20);
                stage.setWidth(stage.getWidth() +20);
            }

        });

        Button decrease = new Button("Decrease");
        EventHandler<ActionEvent> decreaseEv = new EventHandler() {
            @Override
            public void handle(Event event) {
                circle.setRadius(circle.getRadius() - 10);
                stage.setHeight(stage.getHeight() - 20);
                stage.setWidth(stage.getWidth() - 20);


            }

        };
        decrease.setOnAction(decreaseEv);



        hbox.getChildren().add(btnIncrease);
        hbox.getChildren().add(decrease);

        vbox.getChildren().add(circle);
        vbox.getChildren().add(hbox);


        flowPane.getChildren().add(vbox);
        scene.setRoot(flowPane);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}