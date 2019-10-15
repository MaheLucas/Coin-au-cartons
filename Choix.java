import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Choix extends JPanel implements ActionListener {
	private JComboBox nbNourriture, tailleGrille;
	private JFrame appli;
	public Choix(JFrame application) {
		appli = application;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		JPanel petitPanneau = new JPanel();
		add(petitPanneau, BorderLayout.CENTER);
		petitPanneau.setLayout(new GridLayout(2,2));
		
		JLabel choixParametres = new JLabel("Choix des parametres");
		choixParametres.setHorizontalAlignment(JLabel.CENTER);
		choixParametres.setPreferredSize(new Dimension(50,20));
		add(choixParametres, BorderLayout.NORTH);
		
		JLabel qteNourriture = new JLabel("Quantit� de nourriture");
		petitPanneau.add(qteNourriture);
		String[] nourriture = {"5","10","15","20","25","30"};
		nbNourriture = new JComboBox(nourriture);
		petitPanneau.add(nbNourriture);
		
		JLabel dimGrille = new JLabel("Dimension de la grille");
		petitPanneau.add(dimGrille);
		String[] dim = {"10x10","20x20","30x30","40x40","50x50"};
		tailleGrille = new JComboBox(dim);
		petitPanneau.add(tailleGrille);
		
		JButton valider = new JButton("Valider");
		add(valider, BorderLayout.SOUTH);
		
		valider.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String quantite = (String)nbNourriture.getSelectedItem();
		String taille = (String)tailleGrille.getSelectedItem();
		
		int qte = Integer.parseInt(quantite);
		String[] dimension = taille.split("x");
		int largeur = Integer.parseInt(dimension[0]);
		int hauteur = Integer.parseInt(dimension[1]);
		
		appli.getContentPane().removeAll();
		appli.setSize(new Dimension(largeur*10, hauteur*10));
		appli.getContentPane().add(new ZoneDeJeu(qte, largeur, hauteur));
		validate();
	}
}


