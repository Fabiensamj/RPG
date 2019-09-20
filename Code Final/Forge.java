import java.util.ArrayList;
import java.util.Scanner;

public class Forge extends Batiment {

	public Forge(String nom, Case caze) {
		super(nom, caze);
	}

	public void faireActionBatiment(Hero hero) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Vous arrivez chez un forgeron." );
		ArrayList <Equipable> liste_equipable = new ArrayList <Equipable>();
		if(hero.getArme_equipee() !=null && hero.getArme_equipee().getAmeliore() == 0 )
			liste_equipable.add(hero.getArme_equipee() );
		if(hero.getArmure_equipee() !=null && hero.getArmure_equipee().getAmeliore() == 0)
			liste_equipable.add(hero.getArmure_equipee());
		if(hero.getBottes_equipees() !=null && hero.getBottes_equipees().getAmeliore() == 0)
			liste_equipable.add(hero.getBottes_equipees());
		
		if(liste_equipable.size() == 0 ) {
			System.out.println("Malheureusement vous n'avez aucun objet a ameliorer. Revenez une autre fois.\n\n" );
			return;
		}
		
		int choix;
		
		System.out.println("Vous avez " + hero.getOr() + " pieces d'or." );
		
		for(int a = 0 ; a < liste_equipable.size() ; a++) {
			System.out.println( (a+1) + "." + liste_equipable.get(a).getNom() + ". Cout amelioration = " + liste_equipable.get(a).getBonus()*4 + " pieces d'or." );
		}
		
		
		
		do {
			System.out.println("Choisissez l'equipement à ameliorer. (mettez le numero, si 0 alors rien.)");
			try {
				choix = Integer.parseInt(sc.nextLine());
				if(liste_equipable.get(choix-1).getBonus() * 4 > hero.getOr())
					System.out.println("Vous n'avez pas assez d'or pour ameliorer cette objet.");
			}
			catch(NumberFormatException e) {
				System.out.println("Il faut uniquement entrer un nombre.");
				choix = -1;
			}
			
			catch(IndexOutOfBoundsException e) {
				System.out.println("Entrez un nombre correspondant a un objet.");
				choix = -1;
			}
			
		}while( (choix < 0 || choix > liste_equipable.size()) || liste_equipable.get(choix-1).getBonus() * 4 > hero.getOr());
		
		System.out.println("\n");
		
		if (choix == 0) {
			return;
		}
		
		liste_equipable.get(choix-1).setAmeliore(1);
		hero.modifOr(-liste_equipable.get(choix-1).getBonus()*4);
		
	}

}
