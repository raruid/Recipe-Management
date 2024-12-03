/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import entities.Category;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.CategoryService;

/**
 * FXML Controller class
 *
 * @author rarui
 */

@Controller
public class CategoryController{ 
    
    @FXML
    private TextField categoryNameField;  // Campo para ingresar el nombre de la categoría

    @Autowired
    private CategoryService categoryService;  // Servicio que maneja la lógica de la base de datos

    // Método que se invoca cuando el usuario presiona el botón "Save Category"
    public void saveCategory() {
        String categoryName = categoryNameField.getText().trim();  // Obtener el texto del campo

        if (categoryName.isEmpty()) {
            // Si el nombre de la categoría está vacío, mostrar un mensaje de error
            showAlert("Error", "Category name cannot be empty!");
        } else {
            // Si el nombre no está vacío, guardar la categoría en la base de datos
            Category category = new Category();
            category.setName(categoryName);
            categoryService.saveCategory(category);

            // Mostrar un mensaje de éxito
            showAlert("Success", "Category saved successfully!");

            // Limpiar el campo de entrada
            categoryNameField.clear();
        }
    }
    
    // Método para mostrar un mensaje de alerta (éxito o error)
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
