package logic;

import java.util.ArrayList;

import constant.Constant;
import entity.User;

public class Logic {

	private ArrayList<User> usersList;
	private int[][] matchMatrix;
	private int sigleValue;

	public Logic() {
		sigleValue = 1;
		usersList = new ArrayList<User>();
		matchMatrix = new int[1][1];
		usersList.add(new User("Hugo"));
		resizeMatrix();
		usersList.add(new User("Paco"));
		resizeMatrix();
		usersList.add(new User("Luiz"));
		resizeMatrix();
		usersList.add(new User("Ana"));
		resizeMatrix();
		usersList.add(new User("Lulu"));
		resizeMatrix();
		usersList.add(new User("Juana"));
		resizeMatrix();
	}

	public void addUser(User user) {
		usersList.add(user);
		resizeMatrix();
	}

	private void resizeMatrix() {
		int size = usersList.size();
		int[][] aux = matchMatrix;
		matchMatrix = new int[size][size];
		for (int i = 0; i < matchMatrix.length - sigleValue; i++) {
			for (int j = 0; j < matchMatrix.length - sigleValue; j++) {
				if (!(i == j)) {
					matchMatrix[i][j] = aux[i][j];
				} else {
					matchMatrix[i][j] = Constant.NO_POSIBLE_DATE_VALUE;
				}
			}
		}
		matchMatrix[size - sigleValue][size - sigleValue] = Constant.NO_POSIBLE_DATE_VALUE;
	}

	public void generateRandomMatches() {
		for (int i = 0; i < matchMatrix.length; i++) {
			for (int j = 0; j < matchMatrix.length; j++) {
				if (!(i == j))
					matchMatrix[i][j] = Math.random() < 0.5 ? Constant.DATE_VALUE : Constant.NO_DATE_VALUE;
			}
		}
	}

	public String[] getUsersName() {
		String[] aux = new String[usersList.size()];
		for (User user : usersList) {
			aux[user.getId()] = user.getName();
		}
		return aux;
	}

	public String getMatches() {
		String exit = "";
		for (int i = 0; i < matchMatrix.length; i++) {
			for (int j = 0; j < matchMatrix.length; j++) {
				if (i != j) {
					if (matchMatrix[i][j] == Constant.DATE_VALUE
							&& matchMatrix[j][i] == Constant.DATE_VALUE) {
						exit += usersList.get(i).getName() + ", saldra con "
								+ usersList.get(j).getName() + "\n";
					}
				} else
					break;
			}
		}
		return exit;
	}

	public ArrayList<User> getUsersList() {
		return usersList;
	}

	public int[][] getMatchMatrix() {
		return matchMatrix;
	}

	public void addDate(int id1, int id2, int option) {
		matchMatrix[id1][id2] = option;
	}

	public ArrayList<User> getPosibleDates(int id) {
		ArrayList<User> aux = new ArrayList<User>();
		for (User user : usersList) {
			if (id != user.getId())
				aux.add(user);
		}
		return aux;
	}

}
