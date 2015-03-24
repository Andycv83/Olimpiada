package object;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "description", "level" , "olimpId"})

@XmlRootElement
public class Task {

	private int id;
	private int olimpId;	
	private String description;	
	private Level level;
	
	enum Level {
		beginer,
		expert		
	}; 
	
	
	@XmlElement(name = "question")
	
	 public int getId() {
		return id;
	}
	 public void setId(int id) {
		this.id = id;
	}
	
	public Level getLevel() {
		return level;
	}
	 
	 public void setLevel(Level level) {
		this.level = level;
	}
	 
	 public String getDescription() {
		return description;
	}
	 public void setDescription(String description) {
		this.description = description;
	}
	 public int getOlimpId() {
		return olimpId;
	}
	 public void setOlimpId(int olimpId) {
		this.olimpId = olimpId;
	}
}

