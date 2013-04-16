package co.ntier.examples.sdmongo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext( Demo.class.getPackage().getName() );
		DemoRepository repo = ctx.getBean(DemoRepository.class);
		
		DemoPerson person = new DemoPerson();
		person.setFirstName("David");
		person.setLastName("Welch");
		repo.save(person);
		
		for(DemoPerson p : repo.findAll() ){
			String msg = String.format("Got %s %s (%s)", p.getFirstName(), p.getLastName(), p.getId());
			System.out.println( msg );
		}
	}
}
