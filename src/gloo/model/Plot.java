package gloo.model;

import gloo.control.Controleur;

public class Plot {
	
	protected Controleur controleur;
	public Couleur couleur;
	public Case cas;
	
	public Plot(Couleur couleur, Case cas) {
		this.couleur = couleur;
		this.cas = cas ;
	}
	
	
	
	public Tuyau nouveauTuyau() {
		Tuyau tuyaucree =  this.couleur.newTuyau(this.cas);
		this.cas.tuyau = tuyaucree;
		this.couleur.tuyau = tuyaucree;
		return tuyaucree;
	}
	
	
	
	public boolean accepteTuyau(Tuyau tuyauafinir) {
		Couleur couleurtuyau = tuyauafinir.getCouleur();
		if (couleurtuyau == this.couleur) {
			boolean plotdejadansletuyau = tuyauafinir.estDansTuyau(this.cas);
			return !plotdejadansletuyau; //on n'accepte pas le tuyau si le plot ne le cloture pas
		}
		else {
			return false;
		}
	}
	
	
	
	public Tuyau getTuyau() {
		return this.couleur.getTuyau();
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
}
