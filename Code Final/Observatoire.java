import java.util.Scanner;

public class Observatoire extends Batiment {
	private Carte carte;
	
	public Observatoire(String nom, Case caze,Carte carte) {
		super(nom, caze);
		this.carte = carte;
	}

	
	
	public void faireActionBatiment(Hero personnage) {
		System.out.println("Vous arrivez dans observatoire. Les savants qui y travaillent vous montre gentiment une carte de la region.");
		carte.afficherCarte();
		System.out.print("\n\n");
	}

}
