/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entities.Ingredient;
import entities.Recipe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rarui
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
    
    List<Ingredient> findByRecipe(Recipe recipe);
    
}
