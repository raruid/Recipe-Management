/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entities.Ingredient;
import entities.Recipe;
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
    
}
