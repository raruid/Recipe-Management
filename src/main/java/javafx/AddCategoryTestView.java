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
public class AddCategoryTestView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Layout principal
        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        // Campos de texto
        Label nameLabel = new Label("Category Name:");
        TextField nameField = new TextField();

        // Botón de guardar
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            // Lógica para guardar el category
            String name = nameField.getText();

            // Mostrar lo que se ha guardado en la consola
            System.out.println("Saved category: " + name);
        });

        // Añadir los elementos al layout
        layout.getChildren().addAll(nameLabel, nameField, saveButton);

        // Crear la escena
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("Add Category");
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
