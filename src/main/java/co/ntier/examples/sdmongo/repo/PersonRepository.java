package co.ntier.examples.sdmongo.repo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.ntier.examples.sdmongo.model.Person;

/**
 * An example repository interface that inherits the default CRUD methods from {@link MongoRepository}.
 *   
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, ObjectId>{
	
	
	List<Person> findByFirstNameAndLastName(String firstName, String lastName);
	
	@Query("{ 'lastName' : ?0 } ")
	List<Person> exampleOfCustomQueryUsingLastName(String someLastName);
}
