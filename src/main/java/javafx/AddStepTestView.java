/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafx;

import entities.Step;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rarui
 */
public class AddStepTestView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       // Layout principal
        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        // Campos de texto
        Label nameLabel = new Label("Step name:");
        TextField nameField = new TextField();
        
        Label descriptionLabel = new Label("Step description:");
        TextField descriptionField = new TextField();
        
        Label stepNumberLabel = new Label("Step number:");
        TextField stepNumberField = new TextField();
        
        //Se crea el objeto de prueba
        Step step = new Step();

        // Botón de guardar
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            // Lógica para guardar el step
            String name = nameField.getText();
            String description = descriptionField.getText();
            Integer stepNumber = Integer.valueOf(stepNumberField.getText());
            
            step.setName(name);
            step.setDescription(description);
            step.setStepNumber(stepNumber);
            
            // Mostrar lo que se ha guardado en la consola
            System.out.println(step.toString());
            //System.out.println("Saved step: " + name + ", " + description + ", " + stepNumber + " step");
        });

        // Añadir los elementos al layout
        layout.getChildren().addAll(nameLabel, nameField, descriptionLabel, descriptionField, stepNumberLabel, stepNumberField, saveButton);

        // Crear la escena
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("Add Step");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
