package gui.mainWindow;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.User;

@SuppressWarnings("serial")
public class JPanelTable extends JPanel{
	
	private JTable jTable;
	private DefaultTableModel model;
	
	public JPanelTable(Object[] object) {
		setLayout(new BorderLayout());
		model = new DefaultTableModel();
		updateIdentifierTable(object);
		jTable = new JTable(model);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
	}
	
	public JPanelTable() {
		setLayout(new BorderLayout());
		model = new DefaultTableModel();
		jTable = new JTable(model);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
	}

	private void updateIdentifierTable(Object[] object) {
		model.setColumnIdentifiers(object);
	}
	
	public void addColums(ArrayList<User> usersList) {
		Object[] object = null;
		model.setColumnIdentifiers(object);
		model.addColumn("Nombre");
		for (User name : usersList) {
			model.addColumn(name);
		}
		revalidate();
	}
	
	
	public void clearTable() {
		model.setRowCount(0);
	}
	
	public void addValue(Object[] object){
		model.addRow(object);
	}

}
