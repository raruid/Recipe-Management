/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import javax.persistence.*;

/**
 *
 * @author rarui
 */
@Entity
@Table(name = "steps")
public class Step {
    
    /*ATRIBUTES*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "step_number", nullable = false)
    private int stepNumber;
        
    //Relations
    //Relation step-recipe
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    
    //Default constructor
    public Step() {
    }

    //Constructor
    public Step(String description, int stepNumber, Recipe recipe) {
        this.description = description;
        this.stepNumber = stepNumber;
        this.recipe = recipe;
    }
    
    //Gets

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public Recipe getRecipe() {
        return recipe;
    }


    
    //Sets

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    
    //ToString

    @Override
    public String toString() {
        return "Step{" + "id=" + id + ", description=" + description + ", stepNumber=" + stepNumber + ", recipe=" + recipe.getName() + '}';
    }


}
