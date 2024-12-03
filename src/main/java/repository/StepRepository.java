/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entities.Recipe;
import entities.Step;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rarui
 */
public interface StepRepository extends JpaRepository<Step, Long>{
    List<Step> findByRecipe(Recipe recipe);
    // Encuentra un paso por su nombre dentro de una receta específica.
    Optional<Step> findByNameAndRecipe(String name, Recipe recipe);
    // Encuentra un paso por su ID dentro de una receta específica
    Optional<Step> findByIdAndRecipe(Long id, Recipe recipe);
    // Elimina un paso por su ID y la receta a la que pertenece
    void deleteByIdAndRecipe(Long id, Recipe recipe);
}
