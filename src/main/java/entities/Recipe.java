/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author rarui
 */

@Entity
@Table(name = "recipes")
public class Recipe {
    
    /*ATRIBUTES*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "preparation_time", nullable = false)
    private int preparationTime;
    
    @Column(name = "difficulty_level", nullable = false)
    private int difficultyLevel;
    
    //Relations
    
    //Relation recipe-ingredient
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
    
    //Relation recipe-step
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Step> steps;
    
    //Relation recipe-category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    /****************/
    
    //Default constructor
    public Recipe() {
    }

    //Constructor
    public Recipe(String name, String description, int preparationTime, int difficultyLevel, List<Ingredient> ingredients, List<Step> steps, Category category) {
        this.name = name;
        this.description = description;
        this.preparationTime = preparationTime;
        this.difficultyLevel = difficultyLevel;
        this.ingredients = ingredients;
        this.steps = steps;
        this.category = category;
    }
    
    //GETS
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public Category getCategory() {
        return category;
    }
    
    
    
    //SETS
    public void setId(long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //ToString
    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", description=" + description + ", preparationTime=" + preparationTime + ", difficultyLevel=" + difficultyLevel + ", ingredients=" + ingredients + ", steps=" + steps + ", category=" + category + '}';
    }
  
}
