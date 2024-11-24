/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entities.Category;
import entities.Recipe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rarui
 */

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
    
    
    List<Recipe> findByDifficultyLevel(Integer difficultyLevel);
    Recipe findByCategory(Category category);
    
}
