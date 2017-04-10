package br.univel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DownloadTableModel extends AbstractTableModel {

	private List<Download> itens = new ArrayList<>();
	
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return itens.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Download d = itens.get(row);
		switch (column) {
		case 0:
			return d.getId();
		case 1:
			return d.getProgresso();
		case 2:
			return d.getEndereco();
		}

		
		return "ma oeee!!";
	}

	public void addNovoDownload(Download d1) {
		itens.add(d1);
		super.fireTableDataChanged();
	}

}
