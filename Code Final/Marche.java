import java.util.ArrayList;
import java.util.Scanner;

public class Marche extends Batiment {
	
	private Marchand marchand;

	public Marche(String nom, Case caze) {
		super(nom, caze);
		marchand = new Marchand(nom);
		int nb_objet = De.Lancer(3,6);
		for (int a = 0 ; a < nb_objet ; a++) {
			marchand.getInventaire().add( Objet.objetAleatoire());
		}
	}
	
	public void choixAchat(Hero hero) {
		marchand.afficherListeObjet();
		Scanner sc = new Scanner(System.in);
		int choix;
		do {
			System.out.println("Quel objet vous fait envie ? (numero a saisir,si 0 alors aucun achat)");
			try {
				choix = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Il faut uniquement entrer un nombre.");
				choix = -1;
			}
			
		}while(choix < 0 || choix > marchand.getInventaire().size());
		
		if (choix == 0)
			return;
		
		Objet obj = marchand.getInventaire().get(choix-1);
		
		if(hero.getOr() - obj.getPrix() < 0)
			System.out.println("Malheuresement vous n'avez pas assez d'or pour cet objet, et le marchand n'a plus de temps a vous consacrer. Revenez demain.");
		
		else {
			hero.gainObjet(obj);
			marchand.getInventaire().remove(obj);
			marchand.gainObjet(Objet.objetAleatoire());
			hero.modifOr(-obj.getPrix());
			System.out.println("Vous etes l'heureux acquereur de cet objet : " + obj);
		}
	}
	
	public void choixVente(Hero hero) {
		Scanner sc =new Scanner(System.in);
		ArrayList <Objet> liste_vente = hero.getInventaire();
		
		if(liste_vente.size() == 0 ) {
			System.out.println("Malheureusement vous n'avez aucun objet a vendre. Revenez une autre fois.\n\n" );
			return;
		}
		
		int choix;
		
		System.out.println("Vous avez " + hero.getOr() + " pieces d'or." );
		
		for(int a = 0 ; a < liste_vente.size() ; a++) {
			System.out.println( (a+1) + "." + liste_vente.get(a).getNom() + ". Prix  = " + liste_vente.get(a).getPrix()+ " pieces d'or." );
		}
		
		
		
		do {
			System.out.println("Choisissez l'objet à vendre. (mettez le numero, si 0 alors rien.)");
			try {
				choix = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Il faut uniquement entrer un nombre.");
				choix = -1;
			}
			
			catch(IndexOutOfBoundsException e) {
				System.out.println("Entrez un nombre correspondant a un objet.");
				choix = -1;
			}
			
		}while( (choix < 0 || choix > liste_vente.size()) );
		
		System.out.println("\n");
		
		if (choix == 0) {
			return;
		}
		
		hero.modifOr(liste_vente.get(choix-1).getPrix());
		liste_vente.remove(choix-1);
		
		
	}
	
	public String choixAction() {
		Scanner sc = new Scanner(System.in);
		String choix = "";
		System.out.println("Que voulez vous faire ?");
		do {
			System.out.println("Faites un choix : (acheter/vendre/quitter)");
			choix = sc.nextLine();
		}while(choix.length() < 1);
		return choix;
		
	}
	
	public void faireActionBatiment(Hero hero) {
		System.out.println("Vous arrivez sur le " + getNom() +".");
		System.out.print("Vous pouvez y acheter ou y vendre un seul objet, vous avez " + hero.getOr() + " piece(s) d'or.");
		String choix = choixAction();
		if(choix.charAt(0) == 'a' || choix.charAt(0) == 'A')
			choixAchat(hero);
		else if(choix.charAt(0) == 'v' || choix.charAt(0) == 'V')
			choixVente(hero);
		System.out.println("Merci d'etre venu sur le " + getNom() +".");
		System.out.print("\n\n");
	}
	
	public Marchand getMarchand() {
		return marchand;
	}

	public void setMarchand(Marchand marchand) {
		this.marchand = marchand;
	}

}
