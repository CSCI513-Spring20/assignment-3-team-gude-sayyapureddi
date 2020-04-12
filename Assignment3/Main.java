// SchedDemo.java
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Main  extends Application
{
	piCalc ce;
	Thread task1,task2;
    // Create the TextArea
    TextArea textArea = new TextArea();
     
    // Create the Label
    Label statusLabel = new Label("Not Started...");
     
    // Create the Buttons
    Button startButton = new Button("Start");
    Button exitButton = new Button("Exit");
     
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
     
    @Override
    public void start(final Stage stage) 
    {
        // Create the Event-Handlers for the Buttons
        startButton.setOnAction(new EventHandler <ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
            	
            	ce =  new piCalc("Task1");
            	task1 = new Thread(ce);
            	task1.start ();
            }
        });
 
        exitButton.setOnAction(new EventHandler <ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
                stage.close();
            }
        });
         
        // Create the ButtonBox     
        HBox buttonBox = new HBox(5, startButton, exitButton);
         
        // Create the VBox
        VBox root = new VBox(10, statusLabel, buttonBox, textArea);
         
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
 
        // Create the Scene
        Scene scene = new Scene(root,400,300);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("A simple Concurrency Example");
        // Display the Stage
        stage.show();       
    }
}