package br.com.sisnema.syslocadora.view;

import javax.swing.JOptionPane;

public class FilmeView {

	public static void run() {
		
		String menu = JOptionPane.showInputDialog(getMenu());
		
		MidiaView.run();
		
	}

	private static String getMenu() {
		
		return "MENU FILMES\n"
				+ "-----------------------\n"
				+ "1 - Cadastrar\n"
				+ "2 - Alterar\n"
				+ "3 - Excluir\n"
				+ "4 - Listar\n"
				+ "0 - Voltar\n";
	}

}
