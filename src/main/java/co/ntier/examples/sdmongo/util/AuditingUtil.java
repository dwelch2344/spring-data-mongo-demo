package co.ntier.examples.sdmongo.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Component;

import com.mongodb.DBObject;

import co.ntier.examples.sdmongo.model.Person;

/**
 * A simple utility that updates an {@link Auditable} to reflect whoever change it last. 
 * 
 * @see Auditable
 */
@Component
public class AuditingUtil extends AbstractMongoEventListener<Auditable>{
	
	/**
	 * Called just before our model object is converted to a DBObject
	 */
	@Override
	public void onBeforeConvert(Auditable a) {
		a.setLastUpdatedBy( getCurrentUser() );
		a.setLastUpdatedOn( new Date() );
	}
	
	/**
	 * Called just before our DBObject is saved to the database, 
	 * after {@link AuditingUtil#onBeforeConvert(Auditable)}.
	 * 
	 * Note that changes to 'source' will not be persisted, but changes to 'dbo' will. 
	 * 
	 */
	@Override
	public void onBeforeSave(Auditable source, DBObject dbo) {
		dbo.put("foobar", "some random property");
	}
	
	
	/**
	 * Just a simple convenience method for getting a string that identifies the current user.
	 * You'd normally get this from your security framework / service.
	 */
	private String getCurrentUser(){
		// just for demo; ideally you'd get your currentUser from your security framework
		Person currentUser = (Person) ctx.getBean("currentUser");
		return currentUser.toString();
	}
	
	@Autowired
	private ApplicationContext ctx;
}
