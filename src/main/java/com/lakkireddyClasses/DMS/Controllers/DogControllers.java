package com.lakkireddyClasses.DMS.Controllers;

import java.util.List;
import java.util.Optional;

/*
 * @author s558939
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lakkireddyClasses.DMS.Models.Dog;
import com.lakkireddyClasses.DMS.Models.Trainer;
import com.lakkireddyClasses.DMS.repository.DogRepository;
import com.lakkireddyClasses.DMS.repository.TrainerRepository;


@Controller
public class DogControllers {
	ModelAndView mv = new ModelAndView();
	@Autowired
	DogRepository dogRepo;
	@Autowired
	TrainerRepository trainerRepo;
//	@RequestMapping("dogHome")
//	public String home() {
//		return "home";
//	}
	@RequestMapping("dogHome")
	public ModelAndView home() {
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView add() {
		mv.setViewName("addNewDog.html");
		Iterable<Trainer> trainerList = trainerRepo.findAll();
		mv.addObject("trainers", trainerList );
		return mv;
	}
	
	@RequestMapping("addNewDog")
	public ModelAndView addNewDog(Dog dog,@RequestParam("trainerId") int id) {
		Trainer trainer = trainerRepo.findById(id).orElse(null);
		dog.setTariner(trainer);
		dogRepo.save(dog);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("addTrainer")
	public ModelAndView addTrainer() {
		mv.setViewName("addNewTrainer");
		return mv;
	}
	
	@RequestMapping("trainerAdded")
	public ModelAndView addNewTrainer(Trainer trainer) {
		trainerRepo.save(trainer);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("viewModifyDelete")
	public ModelAndView viewDogs(Dog dog) {
		mv.setViewName("viewDogs");
		Iterable<Dog> dogList = dogRepo.findAll();
		mv.addObject("dogs",dogList);
		return mv;
	}
	
	@RequestMapping("editDog")
	public ModelAndView editDog(Dog dog) {
		dogRepo.save(dog);
		mv.setViewName("editDog");
		return mv;
	}
	
	@	RequestMapping("deleteDog")
	public ModelAndView deleteDog(Dog dog) {
		//based on id
//		Optional<Dog> dogFound = dogRepo.findById(dog.getId());
//		if(dogFound.isPresent()) {
//			dogRepo.delete(dog);
//		}
//		return home();
		
		//based on the name
		
//		List<Dog> dogsFound =dogRepo.findByName(dog.getName());
//		for(Dog d:dogsFound) {
//			dogRepo.delete(d);
//		}
//		return home();
		
		Dog d = dogRepo.findById(dog.getId()).orElse(new Dog());
		dogRepo.delete(d);
		return home();
		
		
}
	
	
	@RequestMapping("search")
	public ModelAndView searchById(int Id) {
		
		Dog dogFound =dogRepo.findById(Id).orElse(new Dog());
		mv.addObject(dogFound);
		mv.setViewName("searchResults");
		return mv;
	}
	
    
}
