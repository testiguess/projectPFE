package com.production.demo.JsonHolder;

public class ParClasseVariables extends RepeatingVariables  {
	public String[] classes;
	public int voie;
	public String sens;
	public String[] getClasses() {
		return classes;
	}
	public void setClasses(String[] classes) {
		this.classes = classes;
	}
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
	public ParClasseVariables(String[] classes, int voie, String sens) {
		super();
		this.classes = classes;
		this.voie = voie;
		this.sens = sens;
	}
 }
