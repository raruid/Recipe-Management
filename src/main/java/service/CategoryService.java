/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entities.Category;
import entities.Recipe;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import repository.RecipeRepository;

/**
 *
 * @author rarui
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    public Category saveCategory(Category category) {
        
        // Validar y guardar recetas
        if (category.getRecipes() != null) {
            category.getRecipes().forEach(recipeRepository::save);
        }

        // Guardar la categoría
        return categoryRepository.save(category);
    }
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Category getCategoryById(Long id){        
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }
    
    public void deleteCategory(Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException("Category not found");
        }
    }
    
}
