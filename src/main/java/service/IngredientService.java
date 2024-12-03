/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entities.Ingredient;
import entities.Recipe;
import entities.UnitOfMeasure;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IngredientRepository;
import repository.RecipeRepository;

/**
 *
 * @author rarui
 */

@Service
public class IngredientService {
    
    @Autowired
    private IngredientRepository ingredientRepository;
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    public Ingredient saveIngredient(Ingredient ingredient, Long recipeId){
        
        //Buscamos la receta
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
 
        //Asignamos la receta al ingrediente
        ingredient.setRecipe(recipe);
        
        //Guardamos el ingrediente
        return ingredientRepository.save(ingredient);
    }
    
    //CAMBIAR A RECIPESERVICE SI NECESARIO
    public List<Ingredient> getRecipeIngredients(Long recipeId){       
        //Buscamos la receta
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
    
        return ingredientRepository.findByRecipe(recipe);
    }
    
    //Recuperar un ingrediente concreto de una receta a traves de su nombre.
    public Ingredient getIngredientByName(Long recipeId, String ingredientName) {       
        //Busca la receta
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        
        return ingredientRepository.findByNameAndRecipe(ingredientName, recipe)
                .orElseThrow(() -> new RuntimeException("Ingredient not found in the recipe"));
    }
    
    //Recuperar un ingrediente concreto de una receta a traves de su id.
    public Ingredient getIngredientById(Long recipeId, Long ingredientId) {        
        //Busca la receta
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        
        return ingredientRepository.findByIdAndRecipe(ingredientId, recipe)
                .orElseThrow(() -> new RuntimeException("Ingredient not found in the recipe"));
    }
    
    public void deleteIngredient(Long recipeId, Long ingredientId){ 
        //Busca la receta
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        
        // Validar y eliminar el ingrediente en el contexto de la receta
        ingredientRepository.deleteByIdAndRecipe(ingredientId, recipe);      
    }
    
    public List<Ingredient> findByMeasureUnit(UnitOfMeasure measureUnit) {
        // Devuelve la lista de ingredientes que coincidan con la unidad de medida
        return ingredientRepository.findByMeasureUnit(measureUnit);
    }
    
}
