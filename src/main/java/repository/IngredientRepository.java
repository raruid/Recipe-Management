/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entities.Ingredient;
import entities.Recipe;
import entities.UnitOfMeasure;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rarui
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
    
    List<Ingredient> findByRecipe(Recipe recipe);
    // Encuentra un ingrediente por su nombre dentro de una receta específica.
    Optional<Ingredient> findByNameAndRecipe(String name, Recipe recipe);
    // Encuentra un ingrediente por su ID dentro de una receta específica
    Optional<Ingredient> findByIdAndRecipe(Long id, Recipe recipe);
    // Elimina un ingrediente por su ID y la receta a la que pertenece
    void deleteByIdAndRecipe(Long id, Recipe recipe);
    // Buscar ingredientes por unidad de medida (general)
    List<Ingredient> findByMeasureUnit(UnitOfMeasure measureUnit);
    
}
