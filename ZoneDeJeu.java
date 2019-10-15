import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
public class ZoneDeJeu extends JPanel {

	public ZoneDeJeu(int qte, int largeur, int hauteur) {
		Terrain terrain1 = new Terrain(this.getGraphics(), qte, largeur, hauteur); 
		Serpent.corps.add(new PartieCorps(largeur, hauteur, Color.RED));
		terrain1.creerNourriture(this.getGraphics());
	}
}
