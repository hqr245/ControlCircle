package es.ieslosmontecillos.controlcircle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlCircle extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Setting up the Scene
        Group root = new Group();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("ControlCircle");
        stage.setScene(scene);

        //Adding the pane where our components belongs
        FlowPane flowPane = new FlowPane();


        //creating a container

        VBox vbox = new VBox();

        HBox hbox = new HBox();

        Circle circle = new Circle();
        circle.setRadius(100);
        //creating both the buttons
        Button increase = new Button("Increase");
        increase.setOnAction(e -> {circle.setRadius(circle.getRadius() + 10);});

        Button decrease = new Button("Decrease");
        decrease.setOnAction(e -> {circle.setRadius(circle.getRadius() - 10);});



        hbox.getChildren().add(increase);
        hbox.getChildren().add(decrease);

        vbox.getChildren().add(hbox);
        vbox.getChildren().add(circle);


        flowPane.getChildren().add(vbox);
        scene.setRoot(flowPane);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}