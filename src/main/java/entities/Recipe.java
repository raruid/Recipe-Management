/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rarui
 */
@Entity
@Table(name = "recipe")
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;
    private String description;
    private int preparationTime;
    private int difficultyLevel;

    
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
    
    
    //SETS
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

    public Recipe() {
    }

    public Recipe(int id, String name, String description, int preparationTime, int difficultyLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.preparationTime = preparationTime;
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", description=" + description + ", preparationTime=" + preparationTime + ", difficultyLevel=" + difficultyLevel + '}';
    }
    
    
}
