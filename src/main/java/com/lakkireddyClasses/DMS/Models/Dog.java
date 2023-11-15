package com.lakkireddyClasses.DMS.Models;

/*
 * @author s558939
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dog {

	@Id
	private int id;
	private String name;
	private String breed;
	@ManyToOne
	private Trainer tariner;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Trainer getTariner() {
		return tariner;
	}
	public void setTariner(Trainer tariner) {
		this.tariner = tariner;
	}
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", tariner=" + tariner + "]";
	} 
	
	
}
