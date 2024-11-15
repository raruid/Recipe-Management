/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author rarui
 */

@Entity
@Table(name = "categories")
public class Category {
    
    /*ATRIBUTES*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    //Relations
    //Relation step-recipe
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Recipe> recipes;
    
    //Default constructor
    public Category() {
    }
    
    //Parameters constructor
    public Category(String name, List<Recipe> recipes) {
        this.name = name;
        this.recipes = recipes;
    }
    
    
    //Gets

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
    
    //Sets

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    
    
    //ToString
    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", recipes=" + recipes + '}';
    }


}
