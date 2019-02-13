import java.util.ArrayList;
import Outils.*;
import Model.*;
import javax.swing.*;

public class JPanelGeneral extends JPanel {

    private JLabel jlMoyenneGenerale = new JLabel();
    private JLabel jlMoyenneMini = new JLabel();
    private JLabel jlMoyenneMaxi = new JLabel();
    private JLabel jlMoyenneLibelle = new JLabel("Moyenne:");
    private JLabel jlMoyenneMiniLibelle = new JLabel("Mini:");
    private JLabel jlMoyenneMaxiLibelle = new JLabel("Maxi:");

    public JPanelGeneral(ArrayList<Etudiant> etudiants, ArrayList<Note> notes, ArrayList<Matiere> matieres) {
        this.setJlMoyenneG(
                Float.toString(OutilsCalculs.getMoyenne(notes, matieres, etudiants))
        );

        this.setJlMoyenneMaxi(
                OutilsCalculs.getEtudiantWithHighestMoyenne(notes, etudiants, matieres).toString(),
                Float.toString(OutilsCalculs.getHighestMoyenne(notes, matieres, etudiants))
        );

        this.setJlMoyenneMini(
                OutilsCalculs.getEtudiantWithLowestMoyenne(notes, etudiants, matieres).toString(),
                Float.toString(OutilsCalculs.getLowestMoyenne(notes, matieres, etudiants))
        );
    }

    //getter setter

    public JLabel getJlMoyenneGenerale() { return jlMoyenneGenerale; }
    public void setJlMoyenneG(String value) { this.jlMoyenneGenerale.setText(value + "/20"); }
    public JLabel getJlMoyenneMini() { return jlMoyenneMini; }
    public void setJlMoyenneMini(String etudiant, String value) { this.jlMoyenneMini.setText(etudiant + " : "+value + "/20"); }
    public JLabel getJlMoyenneMaxi() { return jlMoyenneMaxi; }
    public void setJlMoyenneMaxi(String etudiant, String value) { this.jlMoyenneMaxi.setText(etudiant + " : "+value + "/20"); }
    public JLabel getJlMoyenneLibelle() { return jlMoyenneLibelle; }
    public JLabel getJlMoyenneMiniLibelle() { return jlMoyenneMiniLibelle; }
    public JLabel getJlMoyenneMaxiLibelle() { return jlMoyenneMaxiLibelle; }
}
