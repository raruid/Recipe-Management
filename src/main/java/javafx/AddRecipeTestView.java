/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafx;

import java.awt.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent; // Para manejar eventos de acción
import javafx.scene.control.ComboBox;

/**
 *
 * @author rarui
 */
public class AddRecipeTestView extends javafx.application.Application{

    /** Inicializa la vista FX
     * @param args parametros de comando
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    /** Ejecuta la vista de usuario
     * @param primaryStage es el escenario donde se montara todo
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Crear los elementos de la vista
        Label nameLabel = new Label("Recipe Name:");
        TextField nameField = new TextField();
        
        Label descriptionLabel = new Label("Description:");
        TextField descriptionField = new TextField();
        
        Label prepTimeLabel = new Label("Preparation Time (min):");
        TextField prepTimeField = new TextField();
        
        Label difficultyLabel = new Label("Difficulty:");
        ComboBox<String> difficultyComboBox = new ComboBox<>();
        difficultyComboBox.getItems().addAll("Easy", "Medium", "Hard");
        
        Button saveButton = new Button("Save Recipe");

        // Acción del botón Save
        saveButton.setOnAction(event -> {
            // Aquí se podrían capturar los valores de los campos y guardarlos
            String name = nameField.getText();
            String description = descriptionField.getText();
            String prepTime = prepTimeField.getText();
            Integer difficulty = this.convertDifficulty(difficultyComboBox.getValue());

            // Mostrar los datos (esto sería el paso para guardar en base de datos)
            System.out.println("Recipe Saved:");
            System.out.println("Name: " + name);
            System.out.println("Description: " + description);
            System.out.println("Preparation Time: " + prepTime);
            System.out.println("Difficulty: " + difficulty);
            
            //Guardar en una clase Recipe
            
        });

        // Organizar la interfaz en un VBox
        
        VBox vbox = new VBox(10); // 10 es el espacio entre los elementos
        vbox.getChildren().addAll(nameLabel, nameField, descriptionLabel, descriptionField, 
                                  prepTimeLabel, prepTimeField, difficultyLabel, difficultyComboBox, saveButton);
        vbox.setStyle("-fx-padding: 20px;");
        
        // Crear la escena y añadirla al stage
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Add Recipe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Integer convertDifficulty(String difficulty){
        
        Integer dif = 1;
        
        if(difficulty == "Medium"){
            dif = 2;
        }else if(difficulty == "Hard"){
            dif = 3;
        }
        
        return dif;
    }
    
}
