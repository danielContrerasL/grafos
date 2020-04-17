package gui.mainWindow;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import controller.MyActions;
import entity.User;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JList<User> jList;
	private DefaultListModel<User> model;
	private JPanelTable jPanelTable;
	private JButton addClient;
	private JButton generateMatches;
	private JButton searchDates;
	private int singlevalue;

	public MainWindow(Controller controller) {
		setTitle("Administrador");
		singlevalue = 1;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(750, 430);
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
		initWindowFeatures();
		initButton(controller);
	}

	private void initButton(Controller controller) {
		JPanel p = new JPanel();
		addClient = new JButton("Agregar Usuario");
		addClient.setActionCommand(MyActions.ADD_USER.toString());
		addClient.addActionListener(controller);
		p.add(addClient);
		generateMatches = new JButton("inicia");
		generateMatches.setActionCommand(MyActions.GENERATE_MATCHES.toString());
		generateMatches.addActionListener(controller);
		p.add(generateMatches);
		searchDates = new JButton("Buscar");
		searchDates.setActionCommand(MyActions.SEARCH_DATE.toString());
		searchDates.addActionListener(controller);
		p.add(searchDates);
		add(p, BorderLayout.SOUTH);
	}

	private void initWindowFeatures() {
		jPanelTable = new JPanelTable();

		model = new DefaultListModel<User>();
		jList = new JList<User>(model);
		add(new JScrollPane(jList), BorderLayout.WEST);

		add(jPanelTable, BorderLayout.CENTER);
	}

	public void updateTable(int[][] info, String[] usersList) {
		jPanelTable.clearTable();
		int dfPosition = 0;
		for (int i = 0; i < info.length; i++) {
			Object[] o = new Object[info[i].length + singlevalue];
			o[dfPosition] = usersList[i];
			for (int j = 0; j < info[i].length; j++) {
				if (o[j + singlevalue] == null) {
					o[j + singlevalue] = info[i][j];
					continue;
				}
			}
			jPanelTable.addValue(o);
		}
	}

	public int getSelectedId() throws Exception {
		return jList.getSelectedValue().getId();
	}

	public void updateList(ArrayList<User> usersList) {
		model.clear();
		for (User user : usersList) {
			model.addElement(user);
		}
		jPanelTable.addColums(usersList);
		revalidate();
	}

}
