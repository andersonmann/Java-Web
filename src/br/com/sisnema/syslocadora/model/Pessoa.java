package br.com.sisnema.syslocadora.model;

import java.io.Serializable;

public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4051951978462432857L;

	private static int cont;

	public Integer id;
	private String nome;
	private String endereco;

	static {
		cont = 0;
	}
	{
		id = ++cont;
	}

	public Pessoa() {
		id = ++cont;
	}

	public Pessoa(Integer id) {
		super();
		this.id = id;
	}

	public Pessoa(String nome, String endereco) {
		super();
		this.setNome(nome);
		this.setEndereco(endereco);
	}

	public Pessoa(Integer id, String nome, String endereco) {
		super();
		this.id = id;
		this.setNome(nome);
		this.setEndereco(endereco);
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + getNome() + ", endereco=" + getEndereco() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pessoa)) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
