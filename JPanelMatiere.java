import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Outils.*;
import Model.*;

public class JPanelMatiere extends JPanel implements ActionListener{

    private JButton jbtMatiere = new JButton("Rechercher");
    private JComboBox jcbMatiere;
    JOptionPane jopMatiere = new JOptionPane();
    ArrayList<Note> notes;
    ArrayList<Matiere> matieres;
    ArrayList<Etudiant> etudiants;

    public JPanelMatiere(ArrayList<Etudiant> etudiants, ArrayList<Note> notes, ArrayList<Matiere> matieres) {
        this.initCombo(matieres);
        this.notes = notes;
        this.matieres = matieres;
        this.etudiants = etudiants;
        jbtMatiere.addActionListener(this);
    }

    public void initCombo(ArrayList<Matiere> matieres) {
        Matiere[] matieresToArray = new Matiere[matieres.size()];
        for(int i = 0;i < matieres.size();i++) {
            matieresToArray[i] = matieres.get(i);
        }
        jcbMatiere = new JComboBox(matieresToArray);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        String data = "";
        Matiere matiere = (Matiere) jcbMatiere.getSelectedItem();
        data = matiere.toString()
                + "\n Moyenne : "
                + OutilsCalculs.getMoyenneByMatiere(notes, matiere)
                + "\n Moyenne Min : "
                + OutilsCalculs.getEtudiantWithLowestMoyenneByMatiere(notes,etudiants,matiere)
                + "("
                + OutilsCalculs.getLowestMoyenneByMatiere(notes,matiere,etudiants)
                + ")"
                + "\n Moyenne Max : "
                + OutilsCalculs.getEtudiantWithHighestMoyenneByMatiere(notes,etudiants,matiere)
                + "("
                + OutilsCalculs.getHighestMoyenneByMatiere(notes,matiere,etudiants)
                + ")";
        jopMatiere.showMessageDialog(this, data, "Infos", JOptionPane.INFORMATION_MESSAGE);
    }

    public JComboBox getJcbMatiere() { return jcbMatiere; }
    public JButton getJbtMatiere() { return jbtMatiere; }
}
