package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TaskModel;

public class TaskTableModel extends AbstractTableModel {
    
    // os campos que vou ter na minha table e a lista das tarefas (inicializando vazia)
    String[] columns = {"Nome", "Descrição", "Prazo", "Concluído", "Editar", "Excluir"};
    List<TaskModel> tasks = new ArrayList();

    @Override
    public int getRowCount() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return columns.length;
    }
    
    // mostra os nomes corretos das colunas
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        switch(columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).isFinished();
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrados";
        }
    }
    
    // definir apenas uma parte da tabela como editavel
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }
    
    // implementar o metodo para colocar o checkbox
    // retorna o tipo correspondente da coluna
    // nesse caso vai substituir o true/false pelo checkbox
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // se a tarefa for vazia retorna qualquer objeto
        if (tasks.isEmpty()) {
            return Object.class;
        }
        // pega a primeira linha e retorna o tipo da coluna (classe do dado)
        return this.getValueAt(0, columnIndex).getClass();
    }
    
    // transforma o objeto grafico (checkbox) em tipo boolean de volta
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setFinished((boolean) value);
    }

    public String[] getColumns() {
        return columns;
    }

    public List<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
    }
}
