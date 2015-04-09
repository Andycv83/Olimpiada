package dbo;

import java.sql.Connection;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;

import object.Olimpiad;
import object.Task;
import util.HibernateUtil;
import util.connectDB;
import static util.HibernateUtil.getSessionFactory;

public class HibernateService implements Service{
			
	   Session sessionFactory = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public void addTask(Task task) {
	sessionFactory.getCurrentSession().save(task);
		
	}


	public void updateTask(Task task) {
		sessionFactory.getCurrentSession().update(task);
		
	}


	public void deleteTask(int id) {
		Task task = (Task)sessionFactory.getCurrentSession().load(Task.class ,id);
		sessionFactory.getCurrentSession().delete(task);
		
	}

	public Set<Task> getAllTask(int olimpId) {
		return (Set<Task>)sessionFactory.getCurrentSession().createQuery("from Task").list();
	}


	public Task getTaskById(int id) {
		Task task =(Task) sessionFactory.getCurrentSession().load(Task.class, id);
		return task;
	}


	public void addOlimpiad(Olimpiad olimpiad) {
		sessionFactory.getCurrentSession().save(olimpiad);
		
	}


	public Set<Olimpiad> getAllOlimpiad() {
		return (Set<Olimpiad>)sessionFactory.getCurrentSession().createQuery("from Olimpiad").list();
	}

}
