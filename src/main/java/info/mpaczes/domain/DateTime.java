package info.mpaczes.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DateTime {
	
	@Id
	private long id;
	
	// w Javie raczej nie korzytsa sie z tych klas, bo sa to wrapery poniszych klas :
	private java.sql.Date date;
	
	private java.sql.Time time;
	
	private java.sql.Timestamp timestamp;
	
	// w Javie korzysta sie raczej z tych klas :
	
	@Temporal(TemporalType.DATE)					// chcemy przechowywac tylko date
	private java.util.Date utilDate;
	
	@Temporal(TemporalType.TIME)					// chcemy przechowywac tylko czas
	private java.util.Date utilTime;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date utilTimeStamp;
	
	// kalendarz ma duzo wieksze mozliwosci
	
	@Temporal(TemporalType.DATE)					// chcemy przechowywac tylko date
	private java.util.Calendar calendar;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Time getTime() {
		return time;
	}

	public void setTime(java.sql.Time time) {
		this.time = time;
	}

	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	public java.util.Date getUtilTime() {
		return utilTime;
	}

	public void setUtilTime(java.util.Date utilTime) {
		this.utilTime = utilTime;
	}

	public java.util.Date getUtilTimeStamp() {
		return utilTimeStamp;
	}

	public void setUtilTimeStamp(java.util.Date utilTimeStamp) {
		this.utilTimeStamp = utilTimeStamp;
	}

	public java.util.Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(java.util.Calendar calendar) {
		this.calendar = calendar;
	}

}
