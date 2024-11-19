/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rarui
 */
public class AddIngredientTestView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
 // Layout principal
        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        // Campos de texto
        Label nameLabel = new Label("Ingredient Name:");
        TextField nameField = new TextField();

        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();

        /*
        Label unitLabel = new Label("Unit of Measure:");
        TextField unitField = new TextField();
        */
        
        Label unitLabel = new Label("Measure unit:");
        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("GRAMS", "LITERS", "CUPS", "TEASPOONS", "TABLESPOONS", "OUNCES");

        // Botón de guardar
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            // Lógica para guardar el ingrediente
            String name = nameField.getText();
            String quantity = quantityField.getText();
            String unit = unitComboBox.getValue();

            // Mostrar lo que se ha guardado en la consola
            System.out.println("Saved Ingredient: " + name + ", " + quantity + " " + unit);
        });

        // Añadir los elementos al layout
        layout.getChildren().addAll(nameLabel, nameField, quantityLabel, quantityField, unitLabel, unitComboBox, saveButton);

        // Crear la escena
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("Add Ingredient");
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
