import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
public class Serpent extends JPanel implements KeyListener{
	private int longueur; 
	private Graphics g; 
	private boolean jouer = true; 
	static ArrayList<PartieCorps> corps = new ArrayList<PartieCorps>(); 
	private int dirrection; 
	public Serpent(Graphics g, int longueur) {
		this.g = g; 
		this.longueur = longueur; 
	}
	public void seDeplace(){
		int pX, pY; 
		for(int j = 0; j < corps.size(); j++) {
			PartieCorps partie; 
			partie = corps.get(j-1);
			pX = partie.getPosX(); 
			pY = partie.getPosY(); 
			partie = corps.get(j); 
			partie.getPosX() = pX; 
			partie.getPosY() = pY; 
		}
		PartieCorps partie2 = corps.get(0);
		if (dirrection == 1)
			partie2.getPosY() -= 10; 
		if (dirrection == 2)
			partie2.getPosX() += 10; 
		if (dirrection == 3)
			partie2.getPosY() += 10; 
		if (dirrection == 4)
			partie2.getPosX() -= 10; 
	}
	public int getDirrection (){
		return dirrection;
	}
	public void setDirrection (int uneDirrection){
		dirrection = uneDirrection; 
	}
	public void sAgrandit(PartieCorps position) {
		corps.add(new PartieCorps(200 + (position.getPosX()+10),0, Color.BLACK)); 
	}
	public boolean se_mord_la_queue() {
		for(int k = 0; k < corps.size(); k++) {
			PartieCorps partie = corps.get(k); 
			PartieCorps tete = corps.get(0);
			if (tete.getPosX() == partie.getPosX() && tete.getPosY() == partie.getPosY()) {
				jouer = false; 
			}else {
				jouer = true; 
			}
		}
		return jouer; 
	}
	public void seCogne() {
		PartieCorps tete = corps.get(0);
		while(tete.getPosX() < 10 || tete.getPosY() < 30 || tete.getPosX() > Terrain.largeur || tete.getPosY() > Terrain.hauteur) {
			dirrection = (int) (Math.random()*4); 
			seDeplace(); 
		}
	}
	public void dessine(Graphics g) {
		for(int i = 0; i < corps.size(); i++) {
			PartieCorps partie; 
			partie = corps.get(i);
			g.setColor(partie.couleur);
			g.fillRect(partie.getPosX(), partie.getPosY(), 10, 10);
			Terrain.creerNourriture(g); 
		}
	}
}