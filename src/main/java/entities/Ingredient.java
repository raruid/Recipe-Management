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
@Table(name = "ingredients")
public class Ingredient {

    /*ATRIBUTES*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Column(name = "quantity", nullable = false)
    private float quantity;
    
    //Enum for measure units
    @Column(name = "unit_of_measure", nullable = false)
    private UnitOfMeasure unitOfMeasure;
    
    //Relations
    //Relation ingredients-recipe
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    
    //Default constructor    
    public Ingredient() {
    }

    public Ingredient(String name, float quantity, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.name = name;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }
    
    //Gets
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getAmount() {
        return quantity;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public Recipe getRecipe() {
        return recipe;
    }


    //Sets
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(float amount) {
        this.quantity = amount;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    
    
    //toString
    @Override
    public String toString() {
        return "Ingredient{" + "id=" + id + ", name=" + name + ", amount=" + quantity + ", unitOfMeasure=" + unitOfMeasure + ", recipe=" + recipe.getName() + '}';
    }

    
}
