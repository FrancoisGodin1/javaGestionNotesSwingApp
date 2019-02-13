import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Outils.*;
import Model.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JPanelDevoir extends JPanel implements ActionListener{

    private JButton btnDevoir = new JButton("Rechercher");
    private JComboBox jcbDevoir;
    JOptionPane jopEtudiant = new JOptionPane();
    ArrayList<Note> notes;
    ArrayList<Matiere> matieres;
    ArrayList<Etudiant> etudiants;
    ArrayList<Devoir> devoirs;

    public JPanelDevoir(ArrayList<Etudiant> etudiants, ArrayList<Note> notes,	ArrayList<Matiere> matieres, ArrayList<Devoir> devoirs) {
        this.notes = notes;
        this.matieres = matieres;
        this.etudiants = etudiants;
        this.devoirs = devoirs;
        this.initCombo(devoirs);
        btnDevoir.addActionListener(this);
    }

    public void initCombo(ArrayList<Devoir> devoirs) {
        Devoir[] devoirsToArray = new Devoir[matieres.size()];
        for(int i = 0; i < matieres.size(); i++) {
            devoirsToArray[i] = devoirs.get(i);
        }
        setJcbDevoir(new JComboBox(devoirsToArray));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        String data = "";
        Devoir devoir = (Devoir) jcbDevoir.getSelectedItem();
        data = devoir.toString()
                + "\n Moyenne : "
                + OutilsCalculs.getMoyenneByDevoir(notes, devoir)
                + "\n Note Min : "
                + OutilsCalculs.getEtudiantWithLowestNoteByDevoir(notes, devoir)
                + "->"
                + OutilsCalculs.getNoteEtudiantByDevoir(notes, devoir, OutilsCalculs.getEtudiantWithLowestNoteByDevoir(notes, devoir))
                + "\n Note Max : "
                + OutilsCalculs.getEtudiantWithHighestNoteByDevoir(notes,devoir)
                + "->"
                + OutilsCalculs.getNoteEtudiantByDevoir(notes, devoir, OutilsCalculs.getEtudiantWithHighestNoteByDevoir(notes, devoir));

        jopEtudiant.showMessageDialog(this, data, "Infos", JOptionPane.INFORMATION_MESSAGE);
    }

    // getter setter
    public JComboBox getJcbDevoir() { return jcbDevoir; }
    public void setJcbDevoir(JComboBox jcbDevoir) { this.jcbDevoir = jcbDevoir; }
    public JButton getBtnDevoir() { return btnDevoir; }
}
