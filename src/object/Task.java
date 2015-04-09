package object;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "TASK" )
public class Task {

	@Id
	private int id;
	@Column(name = "OLIMPID")    
	private int olimpId;	 
	private String description;	
	private Level level;
	
	enum Level {
		beginer,
		expert		
	}; 

	
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
	 
	 @Column(name = "DESCRIPRTION")   
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

