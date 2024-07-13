package org.lessons.pizzeria.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredienti")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ingrediente", nullable = false)
	private String ingrediente;

	@ManyToMany(mappedBy = "ingredienti")
	private Set<Pizza> pizza;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Set<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(Set<Pizza> pizza) {
		this.pizza = pizza;
	}
	
	
}
