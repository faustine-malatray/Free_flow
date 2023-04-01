package gloo.ihm;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gloo.control.Controleur;
import gloo.model.Direction;

/**
 * Réalise la fenetre du jeu
 *
 */

@SuppressWarnings( "serial" )
public class Fenetre extends JFrame implements KeyListener {

	
	
    public static final int COTE_FENETRE = 500;
    private static final int HAUTEUR_BARRE_FENETRE = 20;
    private Controleur controleur;

    
    
    public Fenetre( Controleur controleur ) {
        this.controleur = controleur;
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setPreferredSize( new Dimension( COTE_FENETRE, COTE_FENETRE + HAUTEUR_BARRE_FENETRE ));
        this.setTitle( "Jeu Projet" );
        this.add( new Panneau( controleur ));
        this.addKeyListener( this );
        this.pack();
        this.setVisible( true );
    }

    
    
    @Override
    public void keyTyped( KeyEvent e ) {
        // nothing
    }

    
    
    @Override
    public void keyPressed( KeyEvent e ) {
        Direction direction = switch( e.getKeyCode() ) {
            case KeyEvent.VK_UP    -> Direction.HAUT;
            case KeyEvent.VK_DOWN  -> Direction.BAS;
            case KeyEvent.VK_LEFT  -> Direction.GAUCHE;
            case KeyEvent.VK_RIGHT -> Direction.DROITE;
            default                -> null;
        };
        if( direction == null ) return;
        else {
        	this.controleur.action(direction);
            repaint();
            if (this.controleur.plateau.plateauComplet()) {
            	JOptionPane.showMessageDialog( this, "Vous avez gagné !" );
            	System.exit( 0 );
            }
            
        }
        repaint();
       }
        

    
    
    @Override
    public void keyReleased( KeyEvent e ) {
        // nothing
    }

}
