package Calendar.App;

public class EventList {
	private int id;
	private String name,eventname,eventdate,email,msg;
	
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
		this.name=name;
	}
	
	public String getEventName() {
		return eventname;
	}
	public void setEventName(String ename) {
		this.eventname=ename;
	}
	
	public String getEventDate() {
		return eventdate;
	}
	public void setEventDate(String date) {
		this.eventdate=date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getMessage() {
		return msg;
	}
	public void setMessage(String msgg) {
		this.msg=msgg;
	}
}
