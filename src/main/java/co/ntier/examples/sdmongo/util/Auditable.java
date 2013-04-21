package co.ntier.examples.sdmongo.util;

import java.util.Date;

/**
 * A simple (naive) interface for keeping track of who updates an object last.
 *  
 */
public interface Auditable {

	String getLastUpdatedBy();

	void setLastUpdatedBy(String lastUpdatedBy);

	Date getLastUpdatedOn();

	void setLastUpdatedOn(Date lastUpdatedOn);

}