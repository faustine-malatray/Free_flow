package gloo.model;

import gloo.control.Controleur;

public class Plateau {
	
	public Controleur controleur;
	public Case[][] cases;
	final public int nombrelignes = 5;
	final public int nombrecolonnes = 5;

	
	public Plateau() {
		this.cases = new Case[nombrelignes][nombrecolonnes];
		for (int ligne = 0; ligne < nombrelignes; ligne++) {
			for (int colonne = 0; colonne < nombrecolonnes ; colonne ++) {
					this.cases[ligne][colonne] = new Case(this, ligne, colonne);			
			}
		}
	}
	
	public Plot getPlot(int ligne, int colonne) {
		return this.cases[ligne][colonne].getPlot();
	}
	
	public Couleur getCouleur(int ligne, int colonne) {
		return this.cases[ligne][colonne].getCouleur();
	}
	
	
	
	public Case getMaCaseVoisine(Case dernierecase, Direction direction) {
		if (direction == Direction.HAUT) {
			int nouvelleligne = dernierecase.lignedecettecase - 1;
			int nouvellecolonne = dernierecase.colonnedecettecase;
			return this.cases[nouvelleligne][nouvellecolonne];
		}
		else if (direction == Direction.BAS) {
			int nouvelleligne = dernierecase.lignedecettecase + 1;
			int nouvellecolonne = dernierecase.colonnedecettecase;
			return this.cases[nouvelleligne][nouvellecolonne];
		}
		else if (direction == Direction.DROITE) {
			int nouvelleligne = dernierecase.lignedecettecase;
			int nouvellecolonne = dernierecase.colonnedecettecase + 1;
			return this.cases[nouvelleligne][nouvellecolonne];
		}
		else {
			int nouvelleligne = dernierecase.lignedecettecase;
			int nouvellecolonne = dernierecase.colonnedecettecase - 1;
			return this.cases[nouvelleligne][nouvellecolonne];
		}
	}
	
	
	public Case getCase(int ligne, int colonne) {
		return this.cases[ligne][colonne];
	}
	
	
	public boolean plateauComplet() {
		boolean validefindujeu = true;
		for (int ligne = 0; ligne < nombrelignes; ligne++) {
			for (int colonne = 0; colonne < nombrecolonnes; colonne++) {
				validefindujeu = cases[ligne][colonne].valideFinJeu();
				if (!validefindujeu) break;
			}
			if (!validefindujeu) break;
		}	//Rappelons que validefinjeu est donc true tant que chaque case du plateau est engagée dans un tuyau
			//donc est sensée rester true pour toutes les cases si fin de jeu, en particulier sur la derniere case à tester
		return validefindujeu;
	}
}
