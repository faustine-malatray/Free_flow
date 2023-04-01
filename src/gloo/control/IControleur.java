package gloo.control;

import gloo.model.Couleur;
import gloo.model.Direction;

/**
 * Interface du controleur
 * @author Salom� Fournel et Faustine Malatray
 */


public interface IControleur {

    /**
     * selectionCase
     * 
     * M�thode appell�e par l'IHM quand le joueur clique sur une case, permet de selectionner un plot color�
     * 
     * <ul>
     * <li> Si cette case contient un plot :
     *   <ul>
     *   <li> si un tuyau de la m�me couleur que le plot existe, il
     *        est d�truit ;
     *   </li>
     *   <li> un nouveau tuyau, de la couleur du plot, est cr��, il prend
     *        comme point de d�part ce plot et ce plot devient le tuyau courant ;
     *   </li>
     *   <li> la case du plot courant m�morise le tuyau; la m�thode retourne true ;
     *   </li>
     *   </ul>
     * </li>
     * <li> Sinon, il ne se passe rien et la m�thode retourne false.
     * </li>
     * </ul>
     * @param ligne num�ro de la ligne de la case s�lectionn�e (de 0 � 
     *              getNbLignes() - 1)
     * @param colonne num�ro de la colonne de la case s�lectionn�e (de 0 � 
     *                getNbColonnes() - 1)
     * @return true si un plot est pr�sent sur la case, false sinon.
     */
    boolean selectionCase( int ligne, int colonne );

    /**
     * action
     * 
     * M�thode appell�e par l'IHM quand le joueur appuie sur l'une des
     * fl�ches du clavier.
     * 
     * <ul>
     * <li> S'il n'y a pas de plot courant, rien ne se passe.
     * <li/>
     * <li> S'il y a un plot courant, son tuyau associ� doit s'agrandir, si
     * il le peut, dans la direction indiqu�e en argument. On m�morisera par couleur les
     * directions qui servent � modifier le tuyau de la dite couleur.
     * 
     * 
     * @param direction direction de la progression demand�e par le joueur
     * @return true si le plateau est termin�, false sinon
     */
    boolean action( Direction direction );

    /**
     * getNbLignes
     * M�thode appell�e par l'IHM pour conna�tre le nombre de
     * lignes du plateau courant.
     * 
     * @return le nombre de lignes du plateau � afficher
     */
    int getNbLignes();

    /**
     * getNbColonnes
     * M�thode appell�e par l'IHM pour conna�tre le nombre de
     * colonnes du plateau courant.
     * 
     * @return le nombre de colonnes du plateau � afficher
     */
    int getNbColonnes();

    /**
     * getPositionBorne1
     * M�thode appell�e par l'IHM pour obtenir la position du plot
     * le plus en haut (plus petit indice de ligne) du tuyau d'une couleur donn�e.
     * 
     * @param couleur identifie le tuyau demand� via sa couleur 
     * @return un tableau de 2 entiers [ligne, colonne] donnant la
     *         position du plot de plus petit indice de ligne associ� � la couleur
     *         indiqu�e. S'il n'y a pas encore de tuyau pour cette 
     *         couleur, la position de l'un des plots de cette 
     *         couleur.
     */
    int[] getPositionBorne1( Couleur couleur );

    /**
     * getPositionBorne2
     * M�thode appell�e par l'IHM pour obtenir la position du plot au plus grand indice de ligne
     * d'une couleur donn�e.
     * 
     * @param couleur identifie la couleur du plot cherch� 
     * @return un tableau de 2 entiers [ligne, colonne] donnant la
     *         position du plot au plus grand indice de ligne de cette couleur (la position du premier plot
     *         est retourn�e par {@link #getPositionBorne1(Couleur)
     *         getPositionBorne1(Couleur)}.
     */
    int[] getPositionBorne2( Couleur couleur );


}

