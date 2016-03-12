package br.com.sisnema.syslocadora.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.sisnema.syslocadora.model.Filme;
import br.com.sisnema.syslocadora.model.Midia;
import br.com.sisnema.syslocadora.model.Pessoa;

public class SysLocadoraView {

	private static final String LOCADORA = "locadora.ser";
	private static ArrayList<Pessoa> clientes = new ArrayList<>();
	private static ArrayList<Filme> filmes = new ArrayList<>();
	private static ArrayList<Midia> midias = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		int opc = -1;
		lerArquivo();
		do {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog(getMenu()));
				switch (opc) {
				case 0:
					int sair = JOptionPane.showConfirmDialog(null, "Desejas realmente sair", "",
							JOptionPane.YES_NO_OPTION);
					if (sair != JOptionPane.YES_OPTION) {
						opc = -1;
					}
					break;
				case 1:
					PessoaView.run(clientes);
					break;
				case 2:
				case 3:
					JOptionPane.showMessageDialog(null, "Opção em desenvolvimento");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválido");
					break;
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
			}
		} while (opc != 0);
		try {
			salvarArquivo();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ops");
		}
	}

	private static void salvarArquivo() throws IOException {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(LOCADORA));
			oos.writeObject(clientes);
			oos.writeObject(filmes);
			oos.writeObject(midias);
		} finally {
			if (oos != null) {
				oos.close();
			}
		}
	}

	private static void lerArquivo() throws Exception {
		ObjectInputStream ois = null;
		try {
			File f = new File(LOCADORA);
			if (f.exists()) {
				ois = new ObjectInputStream(new FileInputStream(f));
				ArrayList<Pessoa> clientesAux = (ArrayList<Pessoa>) ois.readObject();
				if (clientesAux != null) {
					clientes = clientesAux;
				}
				ArrayList<Filme> FilmesAux = (ArrayList<Filme>) ois.readObject();
				if (FilmesAux != null) {
					filmes = FilmesAux;
				}
				ArrayList<Midia> MidiaAux = (ArrayList<Midia>) ois.readObject();
				if (MidiaAux != null) {
					midias = MidiaAux;
				}
			}
		} finally {
			if (ois != null) {
				ois.close();
			}
		}
	}

	private static String getMenu() {
		return "MENU PRINCIPAL\n" + "-----------------------\n" + "1 - Clientes\n" + "2 - Filmes\n" + "3 - Midias\n"
				+ "0 - Sair\n";
	}
}
