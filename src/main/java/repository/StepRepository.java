/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rarui
 */
public interface StepRepository extends JpaRepository<Step, Long>{
    
}
