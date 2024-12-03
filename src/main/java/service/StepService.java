/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entities.Ingredient;
import entities.Recipe;
import entities.Step;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IngredientRepository;
import repository.RecipeRepository;
import repository.StepRepository;

/**
 *
 * @author rarui
 */
@Service
public class StepService {
    
    @Autowired
    private StepRepository stepRepository;
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    public Step saveStep(Step step, Long recipeId){
        
        //Buscamos la receta
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
 
        //Asignamos la receta al paso
        step.setRecipe(recipe);
        
        //Guardamos el paso
        return stepRepository.save(step);
    }
    
    public List<Step> getRecipeSteps(Long recipeId){       
        //Buscamos la receta
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
    
        return stepRepository.findByRecipe(recipe);
    }
    
    //Recuperar un paso concreto de una receta a traves de su nombre.
    public Step getStepByName(Long recipeId, String stepName) {       
        //Busca la receta
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        
        return stepRepository.findByNameAndRecipe(stepName, recipe)
                .orElseThrow(() -> new RuntimeException("Step not found in the recipe"));
    }
    
    //Recuperar un paso concreto de una receta a traves de su id.
    public Step getStepById(Long recipeId, Long stepId) {        
        //Busca la receta
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        
        return stepRepository.findByIdAndRecipe(stepId, recipe)
                .orElseThrow(() -> new RuntimeException("Step not found in the recipe"));
    }
    
    public void deleteStep(Long recipeId, Long stepId){ 
        //Busca la receta
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        
        // Validar y eliminar el ingrediente en el contexto de la receta
        stepRepository.deleteByIdAndRecipe(stepId, recipe);      
    }
    
}
