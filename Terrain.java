import java.awt.Color;
import java.awt.Graphics;
public class Terrain {
	private int Terrain[][]; 
	private int qte, posX, posY;
	private int largeur; 
	private int hauteur; 
	private Color couleur;
	private Graphics g; 
	public Terrain (Graphics g, int qte, int largeur, int hauteur) {
		this.qte = qte; 
		this.g = g; 
		this.largeur = largeur;
		this.hauteur = hauteur; 
	}
	public void creerNourriture(Graphics g) {
		int popX, popY; 
		boolean dessiner = true; 
		for (int i=0; i < qte;i++) {
			popX = (int) Math.random()*(largeur/10);
			popY = (int) Math.random()*(hauteur/10);
			popX = popX*10; 
			popY = popY*10; 
			for (int j=0; j < Serpent.corps.size(); j++) {
				PartieCorps chek = (PartieCorps) Serpent.corps.get(j); 
				if(popX == chek.getPosX() && popY == chek.getPosY()) {
					dessiner = false; 
				}
				if(dessiner == true) {
					dessinerNourriture(g, popX, popY);
					Serpent.dessine(g); 
				}
			}
		}
	}
	public void dessinerNourriture (Graphics g, int popX, int popY) {
		g.setColor(Color.BLUE); 
		g.fillOval(popX, popY, 10, 10);
	}
	public boolean contientNourriture() {
		boolean aNourriture = false;
		int case1, case2; 
		return aNourriture; 
	}
	public void supprimeNourriture() {
		for(int i = 0; i < qte; i++) {
			PartieCorps partie = Serpent.corps.get(i); 
			PartieCorps position = Serpent.corps.get(Serpent.corps.size()-1); 
			if(posX == partie.getPosX() && posY == partie.getPosY()) {
				qte -= 1; 
				Serpent.sAgrendit(position);
			}
		}
	}
	public void dessinTerrain() {
		
	}
}
