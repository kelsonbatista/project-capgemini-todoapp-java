package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TaskModel;
import util.ConnectionFactory;

public class TaskController {
    
    public void create(TaskModel task) {
        String sql = "INSERT INTO tasks ("
                + "idProject,"
                + "name,"
                + "description,"
                + "finished,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isFinished());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir a tarefa "
                    + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public List<TaskModel> getAll(int idProject) {
        
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        // lista de tarefas que será devolvida
        // quando a chamada do método acontecer
        List<TaskModel> tasks = new ArrayList<TaskModel>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                TaskModel task = new TaskModel();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setFinished(resultSet.getBoolean("finished"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar as tarefas "
                    + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        // Lista de tarefas que foi criada e carregada no banco
        return tasks;
    }
    
    public void update(TaskModel task) {
        
        String sql = "UPDATE tasks SET "
                + "idProject = ?,"
                + "name = ?,"
                + "description = ?,"
                + "finished = ?,"
                + "notes = ?,"
                + "deadline = ?,"
                + "createdAt = ?,"
                + "updatedAt = ? WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isFinished());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a tarefa "
                    + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void delete(int taskId) {
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao apagar a tarefa "
                    + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
