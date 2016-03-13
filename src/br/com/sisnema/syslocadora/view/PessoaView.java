package br.com.sisnema.syslocadora.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.sisnema.syslocadora.model.Pessoa;

public class PessoaView {

	public static void run(ArrayList<Pessoa> clientes) {
		int opc = -1;
		do {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog(getMenu()));
				switch (opc) {
				case 0:
					break;
				case 1:
					clientes.add(cadastrar());
					break;
				case 2:
					alterar(clientes);
					break;
				case 3:
					excluir(clientes);
					break;
				case 4:
					listar(clientes);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválido");
					break;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor invalido");
			}
		} while (opc != 0);
	}

	private static void excluir(ArrayList<Pessoa> clientes) {
		try {
			Pessoa clienteAhExcluir = new Pessoa(
					Integer.valueOf(JOptionPane.showInputDialog("Informe o id do cliente a ser excluido")));

			if (clientes.remove(clienteAhExcluir)) {
				JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");

			} else {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado");
			}
		} catch (NumberFormatException e) {
			excluir(clientes);
			JOptionPane.showInputDialog(null, "Valor invalido");
		}
	}

	private static void alterar(ArrayList<Pessoa> clientes) {
		try {
			int index = clientes.indexOf(
					new Pessoa(Integer.valueOf(JOptionPane.showInputDialog("Informe o id do cliente a ser alterado"))));
			if (index >= 0) {
				Pessoa p = clientes.get(index);
				p.setNome(JOptionPane.showInputDialog("Nome", p.getNome()));
				p.setEndereco(JOptionPane.showInputDialog("Endereco", p.getEndereco()));
			} else {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado");
			}
		} catch (NumberFormatException e) {
			alterar(clientes);
			JOptionPane.showInputDialog(null, "Valor invalido");
		}
	}

	private static void listar(ArrayList<Pessoa> clientes) {
		// Ajuste o método listar para que imprima sempre de 3 em 3.
		StringBuilder linhas = new StringBuilder();
		int cont = 0;

		for (Pessoa pessoa : clientes) {
			linhas.append(pessoa).append("\n");
			if (++cont % 3 == 0) {
				JOptionPane.showMessageDialog(null, linhas);
				linhas.setLength(0);
			}
		}
		if (linhas.length() > 0) {
			JOptionPane.showMessageDialog(null, linhas);
		}
	}

	private static Pessoa cadastrar() {
		Pessoa p = new Pessoa();
		p.setNome(JOptionPane.showInputDialog("Informe o nome"));
		p.setEndereco(JOptionPane.showInputDialog("Informe o endereco"));
		return p;
	}

	private static String getMenu() {
		return "MENU CLIENTES\n" + "-----------------------\n" + "1 - Cadastrar\n" + "2 - Alterar\n" + "3 - Excluir\n"
				+ "4 - Listar\n" + "0 - Voltar\n";
	}
}
