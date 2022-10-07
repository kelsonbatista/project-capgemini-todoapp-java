package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonHandler extends DefaultTableCellRenderer {
    
    private String buttonType;
    
    public ButtonHandler(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {
        
        // pegar a label onde sera escrito o valor
        JLabel label = (JLabel) super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, col);
        
        // centraliza a label
        label.setHorizontalAlignment(JLabel.CENTER);
        
        // configura um icone na label
        label.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/" + buttonType + ".png")));
        
        return label;
    }
}
