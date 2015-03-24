package dbo;
 
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

import object.*;
import util.connectDB;

public class DbService {
		
	private Connection connection;

    public DbService() {
        connection = connectDB.getConnection();
    }
	
	public void addTask(Task task){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into TASK (Id, olimpId , Description) values (?, ?, ? )");
            preparedStatement.setInt(1, task.getId());
            preparedStatement.setInt(2, task.getOlimpId());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	} 
	
	
		public void updateTask(Task task){
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update TASK set olimpId=?, description=?"+" where Id =?");
	            preparedStatement.setInt(1, task.getOlimpId());
	            preparedStatement.setString(2, task.getDescription());
	            preparedStatement.setInt(3, task.getId());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	
	
	public void deleteTask(int id) throws SQLException{
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from TASK where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
	
	
     public Set<Task> getAllTask() {
		    	Set<Task> tasks = new LinkedHashSet <Task>();
		        try {
		            Statement statement = connection.createStatement();
		            ResultSet rs = statement.executeQuery("select * from TASK");
		            while (rs.next()) {
		                Task task = new Task();
		                task.setId(rs.getInt("id"));
		                task.setOlimpId(rs.getInt("olimpId"));
		                task.setDescription(rs.getString("description"));
		                tasks.add(task);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return tasks;
		    }
	
     public Task getTaskById(int id) {
         Task task = new Task();
         try {
             PreparedStatement preparedStatement = connection.prepareStatement("select * from TASK where id=?");
             preparedStatement.setInt(1, id);
             ResultSet rs = preparedStatement.executeQuery();

             if (rs.next()) {
	                task.setId(rs.getInt("id"));
	                task.setOlimpId(rs.getInt("olimpId"));
	                task.setDescription(rs.getString("description"));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

         return task;
     }
     
 	public void addOlimpiad(Olimpiad olimpiad){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Olimpiad (id, name , start, end) values (?, ?, ?, ? )");
            preparedStatement.setInt(1, olimpiad.getId());
            preparedStatement.setString(2, olimpiad.getName());
            preparedStatement.setDate(3, new java.sql.Date(olimpiad.getStart().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(olimpiad.getEnd().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	} 
		
}
