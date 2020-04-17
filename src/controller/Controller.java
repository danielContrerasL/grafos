package controller;

import entity.User;
import gui.mainWindow.MainWindow;
import gui.managerMessage.ManagerMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import constant.Constant;
import logic.Logic;

public class Controller implements ActionListener {

	private MainWindow mainWindow;
	private Logic logic;

	public Controller() {
		logic = new Logic();
		mainWindow = new MainWindow(this);
		updateInfo();
		mainWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (MyActions.valueOf(e.getActionCommand())) {
		case ADD_USER:
			addNewUser();
			break;
		case GENERATE_MATCHES:
			generateNewMatches();
			break;
		case SEARCH_DATE:
			searchDates();
			break;

		}
	}

	private void searchDates() {
		try {
			int id1 = mainWindow.getSelectedId();
			ArrayList<User> aux = logic.getPosibleDates(id1);
			for (User user : aux) {
				if (ManagerMessage.askQuestion(mainWindow, user.getName()) == Constant.NO_DATE_VALUE)
					logic.addDate(id1, user.getId(), Constant.DATE_VALUE);
				else
					logic.addDate(id1, user.getId(), Constant.NO_DATE_VALUE);
			}
			mainWindow
					.updateTable(logic.getMatchMatrix(), logic.getUsersName());
			ManagerMessage.showDate(mainWindow, logic.getMatches());
		} catch (Exception e) {
			ManagerMessage.showErrorMessage(mainWindow, "Seleciona un Usuario");
		}
	}

	private void generateNewMatches() {
		logic.generateRandomMatches();
		mainWindow.updateTable(logic.getMatchMatrix(), logic.getUsersName());
		String dates = logic.getMatches();
		if (dates.length() <= 1)
			dates = "No hay citas disponibles";
		ManagerMessage.showDate(mainWindow, dates);
	}

	private void addNewUser() {
		logic.addUser(new User(ManagerMessage.getName(mainWindow)));
		updateInfo();
	}

	private void updateInfo() {
		mainWindow.updateList(logic.getUsersList());
		mainWindow.updateTable(logic.getMatchMatrix(), logic.getUsersName());
	}

}
