package gloo.test;

import javax.swing.SwingUtilities;

import gloo.control.Controleur;
import gloo.ihm.Fenetre;

/**
 * Programme de test du controleur
 *
 */

public class TestProjet implements Runnable {

	public static void main( String[] args ) {
        SwingUtilities.invokeLater( new TestProjet() );
	}

    @Override
    public void run() {
    	//On construit ci-dessous la fenetre et le controleur
    	//La création du controleur entraîne la création du plateau
    	//La création du plateau entraîne la création de toutes les cases du plateau
    	//La création d'une case construit son plot associé (qui sera null s'il n'y a pas physiquement de plot)
        new Fenetre( new Controleur() );
    }
}
