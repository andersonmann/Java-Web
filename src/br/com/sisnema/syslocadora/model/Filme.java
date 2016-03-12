package br.com.sisnema.syslocadora.model;

import java.io.Serializable;

public class Filme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2377216918761911575L;
	public String codigo;
	public String nome;
	public String genero;

	@Override
	public String toString() {
		return "Filme [codigo=" + codigo + ", nome=" + nome + ", genero=" + genero + "]";
	}

}
