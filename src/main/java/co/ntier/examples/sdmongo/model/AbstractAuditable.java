package co.ntier.examples.sdmongo.model;

import java.util.Date;

import co.ntier.examples.sdmongo.util.Auditable;

public abstract class AbstractAuditable implements Auditable {
	
	private String lastUpdatedBy;
	private Date lastUpdatedOn;
	
	@Override
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	
	@Override
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	@Override
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	
	@Override
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
}
