package co.ntier.examples.sdmongo;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.ntier.examples.sdmongo.model.Person;
import co.ntier.examples.sdmongo.repo.PersonRepository;
import co.ntier.examples.sdmongo.util.SimpleIO;

public class Demo {
	
	private static final Logger log = LoggerFactory.getLogger( Demo.class );
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("MMMMM dd, yyyy hh:mm aaa");
	
	private final AnnotationConfigApplicationContext ctx;
	private final PersonRepository repo;
	private final SimpleIO io;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SimpleIO io = new SimpleIO(scanner, System.out);
		new Demo(io).execute();
	}
	
	public Demo(SimpleIO io){
		this.io = io;
		ctx = new AnnotationConfigApplicationContext( Demo.class.getPackage().getName() );
		repo = ctx.getBean(PersonRepository.class);
		
		// we'll create a fake "current user" for now 
		ctx.getBeanFactory().registerSingleton("currentUser", new Person("Current", "Userguy"));
	}
	
	public void execute(){
		createNewPerson();
		printAllPeople();
		findByLastName();
	}

	private void findByLastName() {
		io.banner("Enter a last name to find a person");
		
		String lastName = io.prompt("Last name: ");
		List<Person> matches = repo.exampleOfCustomQueryUsingLastName(lastName);
		
		if( matches.isEmpty() ){
			io.println("No matches found");
		}else{
			for(Person p : matches){
				printPerson(p);
			}
		}
		io.clearLines();
	}

	private void createNewPerson() {
		io.banner("Enter a person");
		
		String firstName = io.prompt("First name: ");
		String lastName = io.prompt("Last name: ");
		
		List<Person> matches = repo.findByFirstNameAndLastName(firstName, lastName);
		if( matches.isEmpty() ){
			Person person = new Person(firstName, lastName);
			repo.save(person);
		}else{
			log.warn("Could not create person; already have {} person(s) named {} {}!", matches.size(), firstName, lastName);
		}
		io.clearLines();
	}
	
	private void printAllPeople() {
		List<Person> people = repo.findAll();
		io.banner("Listing all system entries");
		
		for(Person p : people ){
			printPerson(p);
		}
		io.clearLines();
	}

	private void printPerson(Person p) {
		String lastUpdate = p.getLastUpdatedOn() == null ? "unknown" : FORMATTER.format(p.getLastUpdatedOn());
		
		String msg = String.format(" -> %s %s (%s) - updated by %s on %s", 
				p.getFirstName(), p.getLastName(), p.getId(), 
				p.getLastUpdatedBy(), lastUpdate );
		
		io.println( msg );
	}
	
	

}
