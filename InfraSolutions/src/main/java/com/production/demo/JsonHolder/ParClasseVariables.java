package com.production.demo.JsonHolder;

public class ParClasseVariables extends RepeatingVariables {
	public String classe;
	public String sens;

	public ParClasseVariables(String classe, String sens) {
		super();
		this.classe = classe;
		this.sens = sens;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

}
