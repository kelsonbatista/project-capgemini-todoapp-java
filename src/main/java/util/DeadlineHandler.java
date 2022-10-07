package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.TaskModel;

public class DeadlineHandler extends DefaultTableCellRenderer {
    // renderizador de celulas padrao do Java
    // sera usado para fazer customizacao, por ex, alterar cor  
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {
        
        // pegar a label onde sera escrito o valor
        JLabel label = (JLabel) super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, col);
        
        // pega o texto da celula e centraliza
        label.setHorizontalAlignment(CENTER);
        
        // mudar a cor conforme a data
        // pegar a tarefa primeiro
        // obs o model esta dentro da Jtable, e com o model consigo pegar a tarefa dentro dele
        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        // pega a tarefa da linha x
        TaskModel task = taskTableModel.getTasks().get(row);
        
        // muda a cor conforme condição da data
        if(task.getDeadline().after(new Date())) {
            label.setBackground(Color.GREEN);
            label.setForeground(Color.BLACK);
        } else {
            label.setBackground(Color.RED);
            label.setForeground(Color.WHITE);
        }
        // retorna a label customizada
        return label;
    }
    
}
