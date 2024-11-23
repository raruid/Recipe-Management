/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RecipeRepository;

/**
 *
 * @author rarui
 */

@Service
public class RecipeService {
    
@Autowired
private RecipeRepository recipeRepository;
    
}
