package gloo.model;

import java.util.ArrayList;


public class Tuyau {
	
	public ArrayList<Case> casesdutuyau;
	public Couleur couleur;
	
	
	
	public Tuyau(Couleur couleur, Case casedepart) {
		if ( casedepart.getPlot() != null ) {
			this.couleur = couleur;
			this.casesdutuyau= new ArrayList<Case>();
			casesdutuyau.add(casedepart);
		}
	}
	
	
	
	public boolean modifier(Direction direction) {
		Case dernierecase = this.getCaseIndiceI(casesdutuyau.size()-1);
		if (dernierecase.lignedecettecase==0 && direction==Direction.HAUT) {
			return false;
		}
		else if (dernierecase.lignedecettecase==4 && direction==Direction.BAS) {
			return false;
		}
		else if (dernierecase.colonnedecettecase==0 && direction==Direction.GAUCHE) {
			return false;
		}
		else if (dernierecase.colonnedecettecase==4 && direction==Direction.DROITE) {
			return false;
		}
		else {
			Case nouvellecase = dernierecase.getCaseVoisine(direction);
			boolean tuyaumodifie = nouvellecase.accepteTuyau(this);
			
			if (tuyaumodifie) {
				dernierecase.tuyau = this;
				nouvellecase.tuyau = this;
			}

			return tuyaumodifie;
		}

	}
	
	
	
	public void ajouteCase(Case caseaajouter) {
		this.casesdutuyau.add(caseaajouter);
	}
	
	
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public Case getPremiereCase() {
		return this.casesdutuyau.get(0);
	}
	
	
	public Case getCaseIndiceI(int i) {
		return this.casesdutuyau.get(i);
	}
	
	public ArrayList<Case> getCasesTuyau(){
		return this.casesdutuyau;
	}
	
	
	public boolean estDansTuyau(Case caseatester) {
		boolean estbiendansletuyau = false;
		for (int indice = 0; indice < casesdutuyau.size() ; indice++) {
			if ( casesdutuyau.get(indice) == caseatester) {
				estbiendansletuyau = true;
				break;
			}
		}
		return estbiendansletuyau;
	}

}
