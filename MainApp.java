import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mdlaf.utils.MaterialColors;
import Model.*;
import  Outils.*;

public class MainApp extends  JPanel{

    public MainApp(String title, Color fadeTo) {
        this.setBorder(BorderFactory.createTitledBorder(title));
        this.setBackground(fadeTo);
    }

    private static void display() throws IOException {
        JFrame f = new JFrame("Classe DAI2");
        f.setMinimumSize (new Dimension (400, 200));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));

        // map datas into obj from tsv files

        ArrayList<Etudiant> etudiants = OutilsStringToObject.getEtudiants("src\\csv\\etudiant.tsv");
        ArrayList<Matiere> matieres = OutilsStringToObject.getMatieres("src\\csv\\matiere.tsv");
        ArrayList<Devoir> devoirs = OutilsStringToObject.getDevoirs("src\\csv\\devoir.tsv",matieres);
        ArrayList<Note> notes = OutilsStringToObject.getNotes("src\\csv\\notes.tsv",devoirs,etudiants);

        // init JPanels

        JPanel jpGeneral = new JPanelGeneral(etudiants, notes, matieres);
        jpGeneral.setBorder(BorderFactory.createTitledBorder("General"));
        jpGeneral.setBackground(MaterialColors.RED_100);
        jpGeneral.setPreferredSize(new Dimension(400,100));

        JPanel jpEtudiant = new JPanelEtudiant(etudiants,notes,matieres);
        jpEtudiant.setBorder(BorderFactory.createTitledBorder("Etudiant"));
        jpEtudiant.setBackground(MaterialColors.GREEN_100);

        JPanel jpMatiere = new JPanelMatiere(etudiants,notes,matieres);
        jpMatiere.setBorder(BorderFactory.createTitledBorder("Matiere"));
        jpMatiere.setBackground(MaterialColors.BLUE_100);

        JPanel jpDevoir = new JPanelDevoir(etudiants,notes,matieres,devoirs);
        jpDevoir.setBorder(BorderFactory.createTitledBorder("Devoir"));
        jpDevoir.setBackground(MaterialColors.YELLOW_100);

        f.add(jpGeneral);
        f.add(jpEtudiant);
        f.add(jpMatiere);
        f.add(jpDevoir);

        // init groupLayout container for JPanel GENERAL

        GroupLayout layoutGeneral = new GroupLayout(jpGeneral);
        jpGeneral.setLayout(layoutGeneral);
        layoutGeneral.setAutoCreateGaps(true);
        layoutGeneral.setAutoCreateContainerGaps(true);

        layoutGeneral.setHorizontalGroup(layoutGeneral.createSequentialGroup()
                .addGroup(layoutGeneral.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneLibelle(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneMiniLibelle(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneMaxiLibelle(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layoutGeneral.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneGenerale(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneMaxi(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneMini(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layoutGeneral.setVerticalGroup(layoutGeneral.createSequentialGroup()
                .addGroup(layoutGeneral.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneLibelle())
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneGenerale()))
                .addGroup(layoutGeneral.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneMiniLibelle())
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneMini()))
                .addGroup(layoutGeneral.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneMaxiLibelle())
                        .addComponent(((JPanelGeneral) jpGeneral).getJlMoyenneMaxi()))
        );

        // init groupLayout container for JPanel ETUDIANT

        GroupLayout layoutEtudiant = new GroupLayout(jpEtudiant);
        jpEtudiant.setLayout(layoutEtudiant);
        layoutEtudiant.setAutoCreateGaps(true);
        layoutEtudiant.setAutoCreateContainerGaps(true);

        layoutEtudiant.setHorizontalGroup(layoutEtudiant.createSequentialGroup()
                .addGroup(layoutEtudiant.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(((JPanelEtudiant) jpEtudiant).getJcbEtudiant()))
                .addGroup(layoutEtudiant.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(((JPanelEtudiant) jpEtudiant).getBtnEtudiant()))
        );
        layoutEtudiant.setVerticalGroup(layoutEtudiant.createSequentialGroup()
                .addGroup(layoutEtudiant.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(((JPanelEtudiant) jpEtudiant).getJcbEtudiant())
                        .addComponent(((JPanelEtudiant) jpEtudiant).getBtnEtudiant()))
        );

        // init groupLayout container for JPanel MATIERES

        GroupLayout layoutMatiere = new GroupLayout(jpMatiere);
        jpMatiere.setLayout(layoutMatiere);
        layoutMatiere.setAutoCreateGaps(true);
        layoutMatiere.setAutoCreateContainerGaps(true);

        layoutMatiere.setHorizontalGroup(layoutMatiere.createSequentialGroup()
                .addGroup(layoutMatiere.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(((JPanelMatiere) jpMatiere).getJcbMatiere()))
                .addGroup(layoutMatiere.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(((JPanelMatiere) jpMatiere).getJbtMatiere()))
        );
        layoutMatiere.setVerticalGroup(layoutMatiere.createSequentialGroup()
                .addGroup(layoutMatiere.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(((JPanelMatiere) jpMatiere).getJcbMatiere())
                        .addComponent(((JPanelMatiere) jpMatiere).getJbtMatiere()))
        );

        // init groupLayout container for JPanel DEVOIR

        GroupLayout layoutDevoir = new GroupLayout(jpDevoir);
        jpDevoir.setLayout(layoutDevoir);
        layoutDevoir.setAutoCreateGaps(true);
        layoutDevoir.setAutoCreateContainerGaps(true);

        layoutDevoir.setHorizontalGroup(layoutDevoir.createSequentialGroup()
                .addGroup(layoutDevoir.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(((JPanelDevoir) jpDevoir).getJcbDevoir()))
                .addGroup(layoutDevoir.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(((JPanelDevoir) jpDevoir).getBtnDevoir()))
        );
        layoutDevoir.setVerticalGroup(layoutDevoir.createSequentialGroup()
                .addGroup(layoutDevoir.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(((JPanelDevoir) jpDevoir).getJcbDevoir())
                        .addComponent(((JPanelDevoir) jpDevoir).getBtnDevoir()))
        );

        f.add(Box.createVerticalGlue());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    display();
                } catch (IOException ex) {
                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


}
