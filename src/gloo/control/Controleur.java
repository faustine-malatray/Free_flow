package gloo.control;

import java.util.ArrayList;
import java.util.HashMap;

import gloo.model.Couleur;
import gloo.model.Direction;
import gloo.model.Plateau;
import gloo.model.Plot;
import gloo.model.Tuyau;
import gloo.model.Case;

/**
 * Classe du controleur utilisé au cours du jeu
 * 
 *@author Salomé Fournel et Faustine Malatray
 *
 */
public class Controleur implements IControleur {
    
	
	
	public Plateau plateau;
	//Plot qui correspond au dernier clic souris
	public Plot plotcourant;
	//Dictionnaire qui recensera par couleur, les directions qui créent les tuyaux de couleur
	public HashMap<Couleur, ArrayList<Direction> > ensembledirectionspartuyau;
	
	
	
	public Controleur() {
		this.plateau = new Plateau();
		this.plateau.controleur = this;
		this.ensembledirectionspartuyau = new HashMap<> ();
		this.ensembledirectionspartuyau.put(Couleur.ROUGE, new ArrayList<Direction>() );
		this.ensembledirectionspartuyau.put(Couleur.ORANGE, new ArrayList<Direction>() );
		this.ensembledirectionspartuyau.put(Couleur.BLEU, new ArrayList<Direction>() );
		this.ensembledirectionspartuyau.put(Couleur.VERT, new ArrayList<Direction>() );
		this.ensembledirectionspartuyau.put(Couleur.JAUNE, new ArrayList<Direction>() );
	}

	
	
    public boolean selectionCase( int ligne, int colonne ) {
    	
//        System.out.println("clic en l" + ligne + "c" + colonne);
    	
    	
    	//On abandonne le tuyau courant si on cherche à en recommencer un autre
    	
    	if ((plotcourant != null) && (plotcourant.couleur.tuyau != null)) {
    		Couleur couleurcourante = plotcourant.getCouleur();
    		this.abandonTuyau(couleurcourante);
    	}
    	
    	
    	//"Vrai" corps de cette méthode
    	
    	Plot plotdelacaseselectionnee = this.plateau.getPlot(ligne,  colonne);
        if ( plotdelacaseselectionnee != null) {
        	
        	//On récupère ensuite effectivement ce plot, oncrée le tuyau,
        	//en notifiant la case et sa couleur qu'un tuyau est créé
        	
        	this.plotcourant = plotdelacaseselectionnee;
        	this.plotcourant.nouveauTuyau();
            return true;
        }
        
        //Sinon, c'est qu'on n'a pas selectionné de plot
        
        else {
        	return false;
        }
    }

    
    

    public boolean action( Direction direction ) {
    	
//        System.out.println("flèche " + direction.name());
    	
    	//Méthode qui s'applique lorsqu'on a déjà cliqué sur une case,
    	//et qu'on joue ensuite avec les flèches directionnelles
    	
    	if (this.plotcourant == null) {
    		return false;
    	}
    	else {
    		Tuyau tuyauduplotcourant = this.plotcourant.getTuyau();
    	
    	//On peut effectivement modifier le tuyau lorsque la case suivante est vide,
    	//ou si c'est le plot de la bonne couleur qui permet de terminer le tuyau en cours
    	
    	if (tuyauduplotcourant!=null) {
    		if (tuyauduplotcourant.modifier(direction)) {
    		this.mAJDirectionsParTuyau(tuyauduplotcourant.couleur, direction);
    	}
    	else {
    		this.abandonTuyau(tuyauduplotcourant.couleur);
    	}
    		
//    	System.out.println(this.ensembledirectionspartuyau);
    	
    	return plateau.plateauComplet();
    	}
    	else return false;
    	}
    }
    
    
    
    public void mAJDirectionsParTuyau(Couleur couleur, Direction direction) {
    	ArrayList<Direction> listedirectionsamaj = ensembledirectionspartuyau.get(couleur);
		listedirectionsamaj.add(direction);
		this.ensembledirectionspartuyau.put(couleur, listedirectionsamaj);
    }
    

    public void abandonTuyau(Couleur couleur) {
    	Tuyau tuyauasupprimer = couleur.tuyau;
    	ArrayList<Direction> remiseazero = new ArrayList<Direction> ();
    	this.ensembledirectionspartuyau.put(couleur, remiseazero);
    	for (Case cas : tuyauasupprimer.casesdutuyau) {
    		cas.tuyau = null;
    	}
    	couleur.tuyau = null;
    }

    public int getNbLignes() {
        return 5;
    }


    public int getNbColonnes() {
        return 5;
    }


    public int[] getPositionBorne1( Couleur couleur ) {
        return switch (couleur) {
            case ROUGE -> new int[] { 0, 0 };
            case ORANGE -> new int[] { 1, 4 };
            case BLEU -> new int[] { 1, 2 };
            case VERT -> new int[] { 0, 2 };
            case JAUNE -> new int[] { 0, 4 };
        };
    }


    public int[] getPositionBorne2( Couleur couleur ) {
        return switch( couleur ) {
            case ROUGE  -> new int[] { 4, 1 };
            case ORANGE -> new int[] { 4, 3 };
            case BLEU   -> new int[] { 4, 2 };
            case VERT   -> new int[] { 3, 1 };
            case JAUNE  -> new int[] { 3, 3 };
        };
    }
    
    public Case getCase(int ligne, int colonne) {
    	return this.plateau.getCase(ligne,  colonne);
    }
    
}
