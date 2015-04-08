package dbo;

import java.util.Set;

import object.Olimpiad;
import object.Task;

public interface Service {

	public void addTask(Task task);
	public void updateTask(Task task);
	public void deleteTask(int id);
	public Set<Task> getAllTask(int olimpId);
	public Task getTaskById(int id);
	public void addOlimpiad(Olimpiad olimpiad);
	public Set <Olimpiad> getAllOlimpiad();
	
}
