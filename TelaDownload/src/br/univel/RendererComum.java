package br.univel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RendererComum extends JLabel 
			implements TableCellRenderer {
	
	
	public RendererComum() {
		setOpaque(true);
		setBackground(Color.YELLOW);
		setForeground(Color.RED);
	}
	

	@Override
	public Component getTableCellRendererComponent(JTable table, 
			Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		this.setText(String.valueOf(value));
		
		if (isSelected) {
			setBackground(Color.BLACK);
		} else {
			setBackground(Color.YELLOW);
		}
		
		return this;
	}
	
	
	
	
	
	
	
	
	

}
