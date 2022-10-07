package TodoApp;

import controller.ProjectController;
import controller.TaskController;
import java.util.List;
import model.ProjectModel;
import model.TaskModel;

public class App {
    public static void main(String[] args) {
        // TODO App
        
        // Criação de novo projeto
        TaskController taskController = new TaskController();
        
        TaskModel task = new TaskModel();
//        task.setIdProject(6);
//        task.setName("Tarefa Teste");
//        task.setDescription("Testando tarefa...");
//        task.setFinished(false);
//        task.setNotes("Observações da tarefa...");
        
//        taskController.create(task);
        
        // Alteração do projeto
//        task.setId(1);
//        task.setIdProject(6);
//        task.setName("Nova Tarefa");
//        task.setDescription("Nova descrição");
//        task.setFinished(true);
//        taskController.update(task);
        
        // Listar todos projetos
//        List<TaskModel> tasks = taskController.getAll(7);;
//        System.out.println("Total de projetos: " + tasks.size());

        // Apagar projeto
//        taskController.delete(1);
    }
}
