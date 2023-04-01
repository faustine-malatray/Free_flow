package gloo.model;


/**
 * Couleurs possibles pour le projet
 *
 */
public enum Couleur {
	ROUGE,
	ORANGE,
	BLEU,
	VERT,
	JAUNE;
	
	public Tuyau tuyau;
	
	
	public Tuyau newTuyau(Case cas) {
		Tuyau tuyau = new Tuyau(this, cas);
		return tuyau;
	}
	
	public Tuyau getTuyau() {
		return this.tuyau;
	}
}
