package gloo.model;

import java.util.ArrayList;

public class Case {
	
	protected Plateau plateau;
	public Tuyau tuyau;
	public Plot plot;
	protected int lignedecettecase;
	protected int colonnedecettecase;
	
	
	public Case(Plateau plateau, int lignedecettecase, int colonnedecettecase) {
		this.plateau = plateau;
		this.lignedecettecase = lignedecettecase;
		this.colonnedecettecase = colonnedecettecase;
		if ( lignedecettecase == 0 && colonnedecettecase == 0) {
			this.plot = new Plot(Couleur.ROUGE, this);
		}
		else if ( this.lignedecettecase == 0 && this.colonnedecettecase == 2) {
			this.plot = new Plot(Couleur.VERT, this);
		}
		else if ( this.lignedecettecase == 0 && this.colonnedecettecase == 4) {
			this.plot = new Plot(Couleur.JAUNE, this);
		}
		else if ( this.lignedecettecase == 1 && this.colonnedecettecase == 2) {
			this.plot = new Plot(Couleur.BLEU, this);
		}
		else if ( this.lignedecettecase == 1 && this.colonnedecettecase == 4) {
			this.plot = new Plot(Couleur.ORANGE, this);
		}
		else if ( this.lignedecettecase == 3 && this.colonnedecettecase == 1) {
			this.plot = new Plot(Couleur.VERT, this);
		}
		else if ( this.lignedecettecase == 3 && this.colonnedecettecase == 3) {
			this.plot = new Plot(Couleur.JAUNE, this);
		}
		else if ( this.lignedecettecase == 4 && this.colonnedecettecase == 1) {
			this.plot = new Plot(Couleur.ROUGE, this);
		}
		else if ( this.lignedecettecase == 4 && this.colonnedecettecase == 2) {
			this.plot = new Plot(Couleur.BLEU, this);
		}
		else if ( this.lignedecettecase == 4 && this.colonnedecettecase == 3) {
			this.plot = new Plot(Couleur.ORANGE, this);
		}
		else {
			this.plot = null;
		}
		this.tuyau = null;
	}
	
	
	
	public Plot getPlot() {
		return this.plot;
	}
	
	public Couleur getCouleur() {
		return this.plot.getCouleur();
	}
	
	
	
	public Case getCaseVoisine(Direction direction) {
		return this.plateau.getMaCaseVoisine(this, direction);
	}
	
	
	public ArrayList<Case> getCasesTuyau(){
		return this.tuyau.getCasesTuyau();
	}
	
	
	
	public boolean accepteTuyau(Tuyau tuyauacompleter) {
		
		//On accepte le tuyau si la case n'est pas un plot
		//et ne participe déjà pas à un tuyau,
		//ou si le plot permet de terminer le tuyau en cours
		
		if (this.plot == null) {
			if (this.tuyau == null) {
				tuyauacompleter.ajouteCase(this);
			return true;
			}
			else {
				return false;
			}
		}
		else {
			if ( (tuyauacompleter.getCouleur() == this.plot.getCouleur()) && (this != tuyauacompleter.getPremiereCase() )) {
				tuyauacompleter.ajouteCase(this);
				this.plateau.controleur.plotcourant = null;//tuyau fini
				return true;
			}
			else return false;
		}
	}
	
	
	
	public boolean valideFinJeu() {
		return (this.tuyau != null);
	}

}
