import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Outils.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JPanelEtudiant extends JPanel implements ActionListener{

    private JButton btnEtudiant = new JButton("Rechercher");
    private JComboBox jcbEtudiant;
    private JOptionPane jpoEtudiant = new JOptionPane();
    private ArrayList<Note> notes;
    private ArrayList<Matiere> matieres;

    public JPanelEtudiant(ArrayList<Etudiant> etudiants, ArrayList<Note> notes, ArrayList<Matiere> matieres) {
        this.initCombo(etudiants);
        this.notes = notes;
        this.matieres = matieres;
        btnEtudiant.addActionListener(this);
    }

    public void initCombo(ArrayList<Etudiant> etudiants) {
        Etudiant[] etudiantsToArray = new Etudiant[etudiants.size()];
        for(int i = 0; i < etudiants.size(); i++) {
            etudiantsToArray[i] = etudiants.get(i);
        }
        setJcbEtudiant(new JComboBox(etudiantsToArray));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        String data = "";
        Etudiant etudiant = (Etudiant) getJcbEtudiant().getSelectedItem();
        data = etudiant.toString()
                +"\n Moyenne Générale: "
                +(OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiant))
                +"\n";
        for(int i = 0;i<matieres.size();i++) {
            data = data
                    + matieres.get(i).toString()
                    + " : "
                    + OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matieres.get(i), etudiant)
                    + "\n";
        }
        jpoEtudiant.showMessageDialog(this, data, "Infos", JOptionPane.INFORMATION_MESSAGE);
    }

    //getter setter
    public JComboBox getJcbEtudiant() { return jcbEtudiant; }
    public void setJcbEtudiant(JComboBox jcbEtudiant) { this.jcbEtudiant = jcbEtudiant; }
    public JButton getBtnEtudiant() { return btnEtudiant; }

}
