package gui.managerMessage;

import java.awt.Component;

import javax.swing.JOptionPane;

public class ManagerMessage {

	public static String getName(Component component) {
		return JOptionPane.showInputDialog(component, "Ingrese Su Nombre",
				"Registro", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showDate(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "Citas",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static int askQuestion(Component component, String message) {
		return JOptionPane.showConfirmDialog(component, message,
				"¿quieres salir con?", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showErrorMessage(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "Error Inesperado",
				JOptionPane.ERROR_MESSAGE);
	}
	

}
