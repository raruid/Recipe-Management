/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entities.Category;
import entities.Recipe;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import repository.IngredientRepository;
import repository.RecipeRepository;
import repository.StepRepository;

/**
 *
 * @author rarui
 */

@Service
public class RecipeService {
    
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private StepRepository stepRepository;


    public Recipe saveRecipe(Recipe recipe) {
        // Validar y guardar ingredientes
        if (recipe.getIngredients() != null) {
            recipe.getIngredients().forEach(ingredientRepository::save);
        }
        
        // Validar y guardar pasos
        if (recipe.getSteps()!= null) {
            recipe.getSteps().forEach(stepRepository::save);
        }

        // Validar y asignar categoría
        if (recipe.getCategory() != null) {
            Category category = categoryRepository.findById(recipe.getCategory().getId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            recipe.setCategory(category);
        }

        // Guardar la receta
        return recipeRepository.save(recipe);
    }
    
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    
    public Recipe getRecipeById(Long id){        
        return recipeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
    }
    
    public void deleteRecipe(Long id){
        if(recipeRepository.existsById(id)){
            recipeRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException("Recipe not found");
        }
    }
    
    public List<Recipe> findByDifficulty(int difficultyLevel){
        return recipeRepository.findByDifficultyLevel(difficultyLevel);
    }
    
    public Recipe findByCategory(Category category){
        return recipeRepository.findByCategory(category);
    }
    
}
