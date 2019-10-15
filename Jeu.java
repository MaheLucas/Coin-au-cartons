import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jeu extends JFrame implements KeyListener{
private Graphics g; 
private Serpent serpent = new Serpent(this.getGraphics(), 4); 
private JLabel gagne = new JLabel();
private JLabel gameOver = new JLabel();
	public Jeu() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Application TD7");
		setSize (new Dimension (400, 300));
		Choix panChoix = new Choix(this);
		getContentPane().add(panChoix);
		sleep(200); 
		serpent.seDeplace();
		serpent.seCogne();
		gagne.setBounds((Terrain.largeur/2)-40,0,100,20);
		gameOver.setBounds((Terrain.largeur/2)-40,0,100,20);
		if (Terrain.qte == 0) {
			gagner(); 
		}
		if(serpent.se_mord_la_queue() == false) {
			gameOver(); 
		}
		setVisible(true);
	}
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		}catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}
	public void gagner () {
		gagne.setText("Bravo !");
	}
	public void gameOver () {
		gameOver.setText("Game Over !");
	}
	public static void main (String[] args) {
		new Jeu();
	}
	
	public Serpent getSerpent () {
		return serpent; 
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_UP && serpent.getDirrection() != 3) {
			serpent.setDirrection(1);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && serpent.getDirrection() != 4) {
			serpent.setDirrection(2);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN && serpent.getDirrection() != 1) {
			serpent.setDirrection(3);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT && serpent.getDirrection() != 2) {
			serpent.setDirrection(4);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}