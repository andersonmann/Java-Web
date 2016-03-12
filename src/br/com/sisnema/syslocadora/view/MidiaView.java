package br.com.sisnema.syslocadora.view;

import javax.swing.JOptionPane;

public class MidiaView {

	public static void run() {
		
		String menu = JOptionPane.showInputDialog(getmenu());
		
	}

	private static String getmenu() {
		
		return "MENU MIDIAS\n"
				+ "-----------------------\n"
				+ "1 - Cadastrar\n"
				+ "2 - Alterar\n"
				+ "3 - Excluir\n"
				+ "4 - Listar\n"
				+ "0 - Voltar\n";
	}
	
}
