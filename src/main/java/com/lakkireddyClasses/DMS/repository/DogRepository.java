package com.lakkireddyClasses.DMS.repository;
import java.util.List;

/*
 * @author s558939
 */
import org.springframework.data.repository.CrudRepository;

import com.lakkireddyClasses.DMS.Models.Dog;
/*
 * @author s558939
 */

public interface DogRepository extends CrudRepository<Dog, Integer> {

	List<Dog> findByName(String name);
}
