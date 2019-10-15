import java.awt.Color;

public class PartieCorps {
	private int posX, posY; 
	Color couleur; 
	public PartieCorps(int posX, int posY, Color couleur) {
		this.posX = posX; 
		this.posY = posY; 
		this.couleur = couleur;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
}
