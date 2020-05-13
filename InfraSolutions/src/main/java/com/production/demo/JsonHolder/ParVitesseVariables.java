package com.production.demo.JsonHolder;

public class ParVitesseVariables extends RepeatingVariables {
	public int voie;
	public String sens;
	public int getVoie() {
		return voie;
	}
	public void setVoie(int voie) {
		this.voie = voie;
	}
	public String getSens() {
		return sens;
	}
	public void setSens(String sens) {
		this.sens = sens;
	}
	public ParVitesseVariables(int voie, String sens) {
		super();
		this.voie = voie;
		this.sens = sens;
	}
	
	
}
