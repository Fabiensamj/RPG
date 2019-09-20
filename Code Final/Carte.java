public class Carte {
	
	private Case[][] carte;
	
	public Carte(int hauteur, int largeur ) {
		carte = new Case[hauteur][largeur];
		for (int a = 0 ; a < hauteur ; a++) {
			for (int b = 0; b < largeur ;b++) {
				if ( a == 0 || a == hauteur-1 || b == 0 || b == largeur-1)
					this.carte[a][b] = new Case(b,a,"mur");
				else 
					this.carte[a][b] = new Case(b,a);
			}
		}
	}
	
	public Carte(Case[][] carte) {
		this.carte = carte;
	}
	
	public void afficherCarte() {
		for ( int a=0; a < carte.length ;a++) {
			for (int b=0;b< carte[a].length; b++) {
				
				if (carte[a][b].getBatiment() != null)
					System.out.print(carte[a][b].getBatiment().getNom().charAt(0));
				
				else if (carte[a][b].getPersonnage() != null)
					System.out.print(carte[a][b].getPersonnage().getNom().charAt(0));
				
				else if (carte[a][b].getType().equals("mur"))
						System.out.print("#");
				
				else if (carte[a][b].getType().equals("terre"))
						System.out.print(" ");
				else 
					System.out.print(carte[a][b].getType().charAt(0));
			}
			System.out.print("\n");
		}
	}
	
	public void afficherCarte(Position pos,int vision) {
		int vision_gauche = pos.getX() - vision;
		int vision_droite = pos.getX() + vision ;
		int vision_bas = vision + pos.getY();
		int vision_haut = pos.getY()- vision;
		
		if ( vision_gauche < 0  )
			vision_gauche = 0;
		
		if ( vision_droite >= carte[0].length  )
			vision_droite =  carte[0].length-1;
		
		if ( vision_haut < 0  )
			vision_haut = 0 ;
		
		if ( vision_bas >= carte.length   )
			vision_bas =  carte.length-1;
		
		for ( int a = vision_haut; a < vision_bas+1 ;a++) {
			
			for (int b= vision_gauche ; b <  vision_droite+1; b++) {
				
				if (carte[a][b].getBatiment() != null)
					System.out.print(carte[a][b].getBatiment().getNom().charAt(0));
				
				else if (carte[a][b].getPersonnage() != null)
					System.out.print(carte[a][b].getPersonnage().getNom().charAt(0));
				
				else if (carte[a][b].getType().equals("mur"))
						System.out.print("#");
				
				else if (carte[a][b].getType().equals("terre"))
						System.out.print(" ");
				else 
					System.out.print(carte[a][b].getType().charAt(0));
			}
			System.out.print("\n");
		}
	}
	
	public Case[][] getCarteZoomee(Case caze) {
		int vision = 4;
		Position pos = caze.getPos();
		int vision_gauche = pos.getX() - vision;
		int vision_droite = pos.getX() + vision ;
		int vision_bas = vision + pos.getY();
		int vision_haut = pos.getY()- vision;
				
		if ( vision_gauche < 0)
			vision_gauche = 0;
		
		if ( vision_droite >= carte[0].length)
			vision_droite =  carte[0].length-1;
		
		if ( vision_haut < 0)
			vision_haut = 0 ;
		
		if ( vision_bas >= carte.length)
			vision_bas =  carte.length-1;
			
		Case[][] cartezoomee = new Case[vision_bas-vision_haut][vision_droite-vision_gauche];
		
		int x = 0;
		int y = 0;
		for ( int a = vision_haut; a < vision_bas;a++) {
			
			for (int b= vision_gauche ; b <  vision_droite; b++) {
				cartezoomee[y][x] = this.carte[a][b];
				x++;
			}
			y++;
			x = 0;
			
		}
			
		return cartezoomee ;
		
	}
	
	public void afficherCarte(Case caze,int vision) {
		afficherCarte(caze.getPos(),vision);
	}

	public Case[][] getCarte() {
		return carte;
	}

	
	public Case getCase(int x,int y) {
		return carte[y][x];
	}
	
	public void setCarte(Case[][] carte) {
		this.carte = carte;
	}
	
	public Case caseLibre(){
		int x ;
		int y ;
		do {
			x = De.Lancer(1, carte.length-1 );
			y = De.Lancer(1, carte[0].length-1 );
		}while(carte[x][y].isFranchissable() != true && carte[x][y].getPersonnage() == null && carte[x][y].getBatiment() == null );
		return carte[x][y];
		
	}
	
	
	public Case caseLibre(String localisation){
		int x;
		int y;
		if (localisation.length() == 0) {
			localisation = "nord";
		}
		
		char test = localisation.charAt(0);
		
		
		if ( test == 's' || test == 'S') {
			do {
				x = De.Lancer( (int) ((carte.length-1)*0.7) , (carte.length-1) );
				y = De.Lancer( (int) ((carte[0].length-1)*0.3) , (int) ((carte[0].length-1)*0.7) );
			}while(carte[x][y].isFranchissable() != true || carte[x][y].getPersonnage() != null || carte[x][y].getBatiment() != null );
		}
		
		else if ( test == 'e' || test == 'E') {
			do {
				x = De.Lancer( (int) ((carte.length-1)*0.3) , (int) ((carte.length-1)*0.7) );
				y = De.Lancer( (int) ((carte[0].length-1)*0.7) , (carte[0].length-1) );
			}while(carte[x][y].isFranchissable() != true || carte[x][y].getPersonnage() != null || carte[x][y].getBatiment() != null );
		}
		
		else if ( test == 'o' || test == 'O') {
			do {
				x = De.Lancer( (int) ((carte.length-1)*0.3) , (int) ((carte.length-1)*0.7) );
				y = De.Lancer( 1 , (int) ((carte[0].length-1)*0.3) );
				
			}while(carte[x][y].isFranchissable() != true || carte[x][y].getPersonnage() != null || carte[x][y].getBatiment() != null );
		}
		
		else if ( test == 'c' || test == 'C') {
			do {
				x = De.Lancer( (int) ((carte.length-1)*0.4) , (int) ((carte.length-1)*0.6) );
				y = De.Lancer( (int) ((carte.length-1)*0.4) , (int) ((carte.length-1)*0.6) );
				
			}while(carte[x][y].isFranchissable() != true || carte[x][y].getPersonnage() != null || carte[x][y].getBatiment() != null );
		}
		
		
		else {
			do {
				x = De.Lancer(1, (int) ((carte.length-1)*0.3) );
				y = De.Lancer( (int) ((carte[0].length-1)*0.2) , (int) ((carte[0].length-1)*0.8) );
				
			}while(carte[x][y].isFranchissable() != true || carte[x][y].getPersonnage() != null || carte[x][y].getBatiment() != null );
		}
		
		return carte[x][y];
	}
}
