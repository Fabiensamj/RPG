import java.util.ArrayList;
import java.util.Scanner;

public class Serveur {
	private Scanner scanner_lecture = new Scanner(System.in);
	private ArrayList<Hero> liste_hero = new <Hero>ArrayList();
	private Carte carte;
	
	public Serveur() {
		System.out.println("Combien de joueurs etes vous ? (minimum 2) ");
		int nb_joueur = 0;
		boolean ok = true;
		while(ok) {
			try {
				nb_joueur = Integer.parseInt(scanner_lecture.nextLine());
				ok = false;
				if(nb_joueur < 2 )
					ok = true;
			}
			
			catch(NumberFormatException e) {
				System.out.println("Rentrez un nombre, soyez gentil.");
				
			}
		}
		
		carte = new Carte(10 +(10 * (nb_joueur-2)),20+(10 * (nb_joueur-2)));
		
		Case caze;
		
		caze = carte.caseLibre("centre");
		new Observatoire("observatoire de Juivisy",caze,carte);
		
		for (int a = 0; a < 10 ;a++) {
			caze = carte.caseLibre();
			new Ruine("ruine dwemer",caze);
		}
		
		for (int a = 0; a < 15 ;a++) {
			caze = carte.caseLibre();
			Monstre.monstreAleatoire(caze);
		}
		
		for (int a = 0; a < 5 ;a++) {
			caze = carte.caseLibre();
			new FontaineSoin("soin",caze);
		}
		
		for (int a = 0; a < 10 ;a++) {
			caze = carte.caseLibre();
			new Marche("marche du bourg",caze);
		}
		
		for (int a = 0; a < 5 ;a++) {
			caze = carte.caseLibre();
			creerAuberge(caze);
		}
		
		for (int a = 0; a < 5 ;a++) {
			caze = carte.caseLibre();
			new Forge("forge",caze);
		}
		
		creerPortails();
		
		this.lancerPartie(nb_joueur);
		
	}
	
	public void creerAuberge(Case caze) {
		Auberge auberge = new Auberge("auberge", caze , carte.getCarteZoomee(caze));
		caze.setBatiment(auberge);
	}
	
	public void creerPortails() {
		Case caze;
		for (int a = 0; a < 4 ;a++) {
			if(a == 0 ) {
				caze = carte.caseLibre("nord");
				new Portail("portail du nord",caze,carte.caseLibre("sud"));
			}
			
			else if(a == 1 ) {
				caze = carte.caseLibre("est");
				new Portail("portail de l'est",caze,carte.caseLibre("ouest"));
			}
			
			else if(a == 2 ) {
				caze = carte.caseLibre("sud");
				new Portail("portail du sud",caze,carte.caseLibre("nord"));
			}
			
			else if(a == 3 ) {
				caze = carte.caseLibre("ouest");
				new Portail("portail de l'ouest",caze,carte.caseLibre("est"));
			}
		
		}
		
	}
	
	public boolean deplacer(Hero hero,Case caze) {
		if (caze.caseLibrePersonnage()) {
			hero.changerCase(caze);
			return true;
		}
		System.out.println("Le chemin est bloque par quelque chose.");
		return false;
		
	}
	
	public ArrayList<Personnage> proximite(Hero hero) {
		
		ArrayList<Personnage> var = new ArrayList<Personnage>();
		
		int i = hero.getCase().getPos().getX();
		int j = hero.getCase().getPos().getY();
		try {
			 if(hero.toString().equals("Mage") || hero.toString().equals("Archer")) {

					if(carte.getCase(i-2, j).getPersonnage() != null)

						var.add(carte.getCase(i-2, j).getPersonnage());
					
					if( carte.getCase(i+2, j).getPersonnage() != null)

						var.add(carte.getCase(i+2, j).getPersonnage());

					if( carte.getCase(i, j-2).getPersonnage() != null)

						var.add(carte.getCase(i, j-2).getPersonnage());

					if( carte.getCase(i, j+2).getPersonnage() != null)

						var.add(carte.getCase(i, j+2).getPersonnage());
			}
				
			if(carte.getCase(i-1, j).getPersonnage() != null)
				var.add(carte.getCase(i-1, j).getPersonnage());
				
			if(carte.getCase(i+1, j).getPersonnage() != null)
				var.add(carte.getCase(i+1, j).getPersonnage());

			if(carte.getCase(i, j-1).getPersonnage() != null)
				var.add(carte.getCase(i, j-1).getPersonnage());

			if(carte.getCase(i, j+1).getPersonnage() != null)
				var.add(carte.getCase(i, j+1).getPersonnage());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
		}
			
		return var;
	}
	
	public Personnage choixCible(Hero hero) {
		
		String choix;
		ArrayList<Personnage> liste2 = proximite(hero);
		Personnage retour = null;
		
		if(liste2.isEmpty()) {
			System.out.println("Il n'y a personne autour que vous puissiez combattre.\n");
			return retour;
		}
		
		else {
			System.out.println("Vous pouvez attaquer :");
			
			for(int b = 0 ; b < liste2.size();b++) {
				System.out.println("- "+(liste2.get(b).getNom()+ " (" + liste2.get(b).getEsquive()+ 
						" de chances d'esquiver)."));
			}
			System.out.print("\n");
			System.out.println("Saisissez le nom du perso a combattre :");
			choix = scanner_lecture.nextLine();
			for(int a = 0; a < liste2.size();a++) {
				if(liste2.get(a) != hero ) {
					if(liste2.get(a).getNom().equals(choix)) {
						retour = liste2.get(a);
					}
				}
			}
		}
		
		return retour;
		
	}
	
	public boolean choixSeDeplacer (Hero hero) {
		int x = hero.getCase().getPos().getX();
		int y = hero.getCase().getPos().getY();
		String direction;
		do {
			System.out.println("Ou voulez vous aller ? (haut/bas/gauche/droite/annuler)");
			direction = scanner_lecture.nextLine();
		}while(direction.length() <= 1);
		
		if(direction.charAt(0) == 'a' || direction.charAt(0) == 'A') {
			return false;
		}
		
		else if(direction.charAt(0) == 'd' || direction.charAt(0) == 'D' || direction.charAt(1) == 'd' || direction.charAt(1) == 'D') {
			x ++;
		}

		else if(direction.charAt(0) == 'g' || direction.charAt(0) == 'G' || direction.charAt(1) == 'g' || direction.charAt(1) == 'G') {
			x--;
	
		}

		else if(direction.charAt(0) == 'b' || direction.charAt(0) == 'B' || direction.charAt(1) == 'b' || direction.charAt(1) == 'B') {
			y++;
		}
		
		else if(direction.charAt(0) == 'h' || direction.charAt(0) == 'H' || direction.charAt(1) == 'h' || direction.charAt(1) == 'H') {
			y--;
		}
		
		
		return(deplacer(hero,carte.getCase(x, y)));
		
	}

	
	
	public void faireAction(Hero hero) {
		for(int a = 0 ; a  < hero.getListeEffet().size() ; a++) {
			hero.getListeEffet().get(a).perteTemps(hero);
		}
		
		hero.reinitialiserPa();
		System.out.println("La carte autour de vous " + hero.getNom()+ ".");
		
		carte.afficherCarte(hero.getCase(), 3);
		
		String choix = ""; 
		
		while (choix.equals("fin") != true && hero.getPa() > 0) { 
			
			System.out.println("Quelle action voulez vous effectuez "+hero.getNom() + " ? (deplacement/resume/gestion inventaire)");
			System.out.println("Vous avez " + hero.getPa() + " pa restant(s) pour ce tour." );
			choix = scanner_lecture.nextLine();
			int cout = hero.coutPa(choix);
			if( hero.getPa() + cout < 0 ) {
				choix = "";
				System.out.println("Vous n'avez pas assez de Pa pour cette action.");
			}
			if (choix.equals("deplacement")) {
				while(( (hero.getPa() + hero.coutPa("deplacement")) >= 0) && choixSeDeplacer(hero)) {
						hero.modifPa(cout);
				}
				if(hero.getPa() + hero.coutPa("deplacement") < 0)
					System.out.println("Vous n'avez plus assez de Pa pour vous deplacer.");
				
			}
			else if(choix.equals("combat")) {
				Personnage cible = choixCible(hero);
				if(cible != null) {
					hero.modifPa(cout);
					hero.combattre(cible);
				}
					
			}
			
			else if (choix.equals("resume")) {
				carte.afficherCarte(hero.getCase(),3);
				hero.resume();
				
			}
			
			else if (choix.equals("gestion") || choix.equals("gestion inventaire")) {
				hero.gestionInventaire();
			}
			
			else if (choix.equals("suicide")) {
				hero.mort();
			}
			
			for (int b = 0 ; b < liste_hero.size() ; b++) {
				if(liste_hero.get(b).getPv() == 0)
					liste_hero.remove(b);
			}
			if(liste_hero.size() == 1 ){
				System.out.println("Vous avez gagne " + liste_hero.get(0).getNom() + ". Bien joue !");
				liste_hero.remove(0);
			 }
		}
		
		System.out.println("Fin de tour. (appuyer sur entre)");
		scanner_lecture.nextLine();
	}
	
	public void faireTour() {
		for (int a = 0 ; a < liste_hero.size() ; a++) {
			if(liste_hero.size() == 0 )
				break;
			faireAction(liste_hero.get(a));
			for(int b = 0 ; b < 60 ; b++) {
				System.out.print("\n");
			}
			
		}
	}
	
	public Hero creerHero() {
		Hero hero;
		
		String nom = "";
		String nom_ecrit;
		
		System.out.println("Saisissez le nom par lequel on vous appelera jusqu'a la fin de votre partie.");
		boolean ok = true;
		
		while(ok) {
			
			System.out.print("Soyez role play :");
			nom_ecrit = scanner_lecture.nextLine();
			nom = "";
			
			for(int a = 0 ; a < nom_ecrit.length() ; a++ ) {
				
				if (nom_ecrit.charAt(a) != ' ') {
					
					nom += nom_ecrit.charAt(a);
				}
			}
			
			System.out.print(nom + " vous convient il ? ");
			
			nom_ecrit = scanner_lecture.nextLine();
			
			if(nom_ecrit.length() == 0 || nom_ecrit.charAt(0) == 'o' || nom_ecrit.charAt(0) == 'O' )
				ok = false;
		}
		
		System.out.println("Tres bien " + nom + "." );
		System.out.println("Maintenant vous allez choisir la zone ou commencer la partie (par defaut au nord): " );
		
		nom_ecrit = scanner_lecture.nextLine();
		
		System.out.println("Pour finir choisissez votre classe (Mage, Guerrier, Assassin, Archer): ");
		String persoClasse;
		
		boolean yes = true;
		while (yes) {
			persoClasse = scanner_lecture.nextLine();
			try {
				if(persoClasse.charAt(0) == 'M' || persoClasse.charAt(0) == 'm') {
					hero = new Mage(nom,carte.caseLibre(nom_ecrit));
					hero.setOr(20);
					return hero;
				}
				else if(persoClasse.charAt(0) == 'G' || persoClasse.charAt(0) == 'g') {
					hero = new Guerrier(nom,carte.caseLibre(nom_ecrit));
					hero.setOr(20);
					return hero;
				}
				else if(persoClasse.charAt(1) == 's'){
					hero = new Assassin(nom,carte.caseLibre(nom_ecrit));
					hero.setOr(20);
					return hero;
				}
				else if(persoClasse.charAt(1) == 'r') {
					hero = new Archer(nom,carte.caseLibre(nom_ecrit));
					hero.setOr(20);
					return hero;
				}
				else {
					System.out.println("Choisissez une des quatres classes ");
					persoClasse = scanner_lecture.nextLine();
				}
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Ecrivez le nom de la classe que vous voulez choisir.");
				
			}
		
		}
		return null;
		
	}
	
	public void lancerPartie(int nb_joueur) {
		for (int a = 0 ; a < nb_joueur ; a++) {
			System.out.println("Au joueur "+ (a+1) +" de creer son hero : ");
			liste_hero.add(creerHero());
		}
		while(true) {
			faireTour();
		}
	}
	
	public ArrayList<Hero> getListe_hero() {
		return liste_hero;
	}

	public void setListe_hero(ArrayList<Hero> liste_hero) {
		this.liste_hero = liste_hero;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

}
