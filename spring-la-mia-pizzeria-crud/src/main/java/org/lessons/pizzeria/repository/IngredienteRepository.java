package org.lessons.pizzeria.repository;

import org.lessons.pizzeria.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{

}
