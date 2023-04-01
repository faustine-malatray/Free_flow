package gloo.control;

import gloo.model.Couleur;
import gloo.model.Direction;

/**
 * Interface du controleur
 * @author Salomé Fournel et Faustine Malatray
 */


public interface IControleur {

    /**
     * selectionCase
     * 
     * Méthode appellée par l'IHM quand le joueur clique sur une case, permet de selectionner un plot coloré
     * 
     * <ul>
     * <li> Si cette case contient un plot :
     *   <ul>
     *   <li> si un tuyau de la même couleur que le plot existe, il
     *        est détruit ;
     *   </li>
     *   <li> un nouveau tuyau, de la couleur du plot, est créé, il prend
     *        comme point de départ ce plot et ce plot devient le tuyau courant ;
     *   </li>
     *   <li> la case du plot courant mémorise le tuyau; la méthode retourne true ;
     *   </li>
     *   </ul>
     * </li>
     * <li> Sinon, il ne se passe rien et la méthode retourne false.
     * </li>
     * </ul>
     * @param ligne numéro de la ligne de la case sélectionnée (de 0 à  
     *              getNbLignes() - 1)
     * @param colonne numéro de la colonne de la case sélectionnée (de 0 à  
     *                getNbColonnes() - 1)
     * @return true si un plot est présent sur la case, false sinon.
     */
    boolean selectionCase( int ligne, int colonne );

    /**
     * action
     * 
     * Méthode appellée par l'IHM quand le joueur appuie sur l'une des
     * flèches du clavier.
     * 
     * <ul>
     * <li> S'il n'y a pas de plot courant, rien ne se passe.
     * <li/>
     * <li> S'il y a un plot courant, son tuyau associé doit s'agrandir, si
     * il le peut, dans la direction indiquée en argument. On mémorisera par couleur les
     * directions qui servent à modifier le tuyau de la dite couleur.
     * 
     * 
     * @param direction direction de la progression demandée par le joueur
     * @return true si le plateau est terminé, false sinon
     */
    boolean action( Direction direction );

    /**
     * getNbLignes
     * Méthode appellée par l'IHM pour connaître le nombre de
     * lignes du plateau courant.
     * 
     * @return le nombre de lignes du plateau à  afficher
     */
    int getNbLignes();

    /**
     * getNbColonnes
     * Méthode appellée par l'IHM pour connaître le nombre de
     * colonnes du plateau courant.
     * 
     * @return le nombre de colonnes du plateau à  afficher
     */
    int getNbColonnes();

    /**
     * getPositionBorne1
     * Méthode appellée par l'IHM pour obtenir la position du plot
     * le plus en haut (plus petit indice de ligne) du tuyau d'une couleur donnée.
     * 
     * @param couleur identifie le tuyau demandé via sa couleur 
     * @return un tableau de 2 entiers [ligne, colonne] donnant la
     *         position du plot de plus petit indice de ligne associé à  la couleur
     *         indiquée. S'il n'y a pas encore de tuyau pour cette 
     *         couleur, la position de l'un des plots de cette 
     *         couleur.
     */
    int[] getPositionBorne1( Couleur couleur );

    /**
     * getPositionBorne2
     * Méthode appellée par l'IHM pour obtenir la position du plot au plus grand indice de ligne
     * d'une couleur donnée.
     * 
     * @param couleur identifie la couleur du plot cherché 
     * @return un tableau de 2 entiers [ligne, colonne] donnant la
     *         position du plot au plus grand indice de ligne de cette couleur (la position du premier plot
     *         est retournée par {@link #getPositionBorne1(Couleur)
     *         getPositionBorne1(Couleur)}.
     */
    int[] getPositionBorne2( Couleur couleur );


}

