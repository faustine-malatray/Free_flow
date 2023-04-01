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
    	//La cr�ation du controleur entra�ne la cr�ation du plateau
    	//La cr�ation du plateau entra�ne la cr�ation de toutes les cases du plateau
    	//La cr�ation d'une case construit son plot associ� (qui sera null s'il n'y a pas physiquement de plot)
        new Fenetre( new Controleur() );
    }
}
