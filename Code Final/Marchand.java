public class Marchand extends Humanoide {

	public Marchand(String nom, Case caze) {
		super(nom,caze);
	}
	
	public Marchand(String nom) {
		super(nom);
	}
	
	public Marchand(String nom,Case caze,Objet[] inventaire) {
		super(nom,caze,inventaire);
	}
	
	public Marchand(String nom,Objet[] inventaire) {
		super(nom,inventaire);
	}
	
	public void afficherListeObjet() {
		int taille = inventaire.size();
		System.out.println("Le marchand " + getNom() + " dispose de " + taille + " objet(s)." );
		for (int a = 0 ; a < taille ; a++ ) {
			System.out.println( (a+1) + "-" +  inventaire.get(a) + " Prix : " + inventaire.get(a).getPrix() + ".");
		}
	}
	
}
