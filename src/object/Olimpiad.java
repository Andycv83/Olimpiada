package object;

import java.util.Date;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Olimpiad {
	  	  
   private Set <Task> tasks ;
	private int id;
	private String name;
	private Date start;
	private Date end;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	@XmlElement(name = "task")
	public Set<Task> getTasksList() {
		return tasks;
	}
	
public void setTasksList(Set<Task> tasks) {
	this.tasks = tasks;
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void addTask(Task t){
		tasks.add(t);
	}
}	


