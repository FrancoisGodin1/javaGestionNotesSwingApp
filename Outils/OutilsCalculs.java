package Outils;
import java.util.ArrayList;
import Model.*;

public class OutilsCalculs {

    public static float getMoyenneByDevoir(ArrayList<Note> notes, Devoir devoir) {
        float sommeNotes = 0;
        float nbNotes = 0;
        for(int i = 0; i < notes.size(); i++) {
            if(notes.get(i).getDevoir().equals(devoir)) {
                sommeNotes = sommeNotes + notes.get(i).getNote();
                nbNotes++;
            }
        }
        return sommeNotes/nbNotes;
    }

    public static float getMoyenneByMatiere(ArrayList<Note> notes, Matiere m) {
        float sommeNotes = 0;
        float nbNotes = 0;
        for(int i = 0; i < notes.size(); i++) {
            if(notes.get(i).getDevoir().getMatiere().equals(m)) {
                sommeNotes = sommeNotes + (notes.get(i).getNote() * notes.get(i).getDevoir().getCoefDevoir());
                nbNotes = nbNotes + notes.get(i).getDevoir().getCoefDevoir();
            }
        }
        return sommeNotes/nbNotes;
    }

    public static float getMoyenneEtudiantByMatiere(ArrayList<Note> notes, Matiere matiere, Etudiant etudiant) {
        float sommeNotes=0;
        float nbNotes=0;
        for(int i=0;i<notes.size();i++) {
            if(notes.get(i).getDevoir().getMatiere().equals(matiere) && notes.get(i).getEtudiant().equals(etudiant)) {
                sommeNotes = sommeNotes + notes.get(i).getNote() * notes.get(i).getDevoir().getCoefDevoir();
                nbNotes = nbNotes + notes.get(i).getDevoir().getCoefDevoir();
            }
        }
        return sommeNotes/nbNotes;
    }

    public static float getMoyenneEtudiant(ArrayList<Note> notes, ArrayList<Matiere> matieres, Etudiant etudiant) {
        float sommeMoyenneMatiere = 0;
        float nbMoyenneMatiere = 0;
        for(int i=0; i < matieres.size(); i++) {
            sommeMoyenneMatiere = sommeMoyenneMatiere + OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matieres.get(i), etudiant) * matieres.get(i).getCoefMatiere();
            nbMoyenneMatiere = nbMoyenneMatiere + matieres.get(i).getCoefMatiere();
        }
        return sommeMoyenneMatiere/nbMoyenneMatiere;
    }

    public static float getMoyenne(ArrayList<Note> notes, ArrayList<Matiere> matieres, ArrayList<Etudiant> etudiants) {
        float sommeMoyenneEtudiants = 0;
        float nbMoyenneEtudiants = 0;
        for(int i = 0 ; i < etudiants.size(); i++) {
            sommeMoyenneEtudiants = sommeMoyenneEtudiants + OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(i));
            nbMoyenneEtudiants++;
        }
        return sommeMoyenneEtudiants/nbMoyenneEtudiants;
    }

    public static Etudiant getEtudiantWithLowestMoyenne(ArrayList<Note> notes, ArrayList<Etudiant> etudiants, ArrayList<Matiere> matieres) {
        Etudiant etudiant = etudiants.get(0);
        for(int i = 1; i < etudiants.size(); i++) {
            if(OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiant) > OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(i))) {
                etudiant = etudiants.get(i);
            }
        }
        return etudiant;
    }

    public static Etudiant getEtudiantWithHighestMoyenne(ArrayList<Note> notes, ArrayList<Etudiant> etudiants, ArrayList<Matiere> matieres) {
        Etudiant etudiant = etudiants.get(0);
        for(int i=1;i<etudiants.size();i++) {
            if(OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiant)< OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(i))) {
                etudiant = etudiants.get(i);
            }
        }
        return etudiant;
    }

    public static Etudiant getEtudiantWithLowestMoyenneByMatiere(ArrayList<Note> notes, ArrayList<Etudiant> etudiants, Matiere matiere) {
        Etudiant etudiant = etudiants.get(0);
        for(int i = 1; i < etudiants.size(); i++) {
            if(OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matiere, etudiant) > OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matiere, etudiants.get(i))) {
                etudiant = etudiants.get(i);
            }
        }
        return etudiant;
    }

    public static Etudiant getEtudiantWithHighestMoyenneByMatiere(ArrayList<Note> notes, ArrayList<Etudiant> etudiants, Matiere matiere) {
        Etudiant etudiant = etudiants.get(0);
        for(int i = 1; i < etudiants.size(); i++) {
            if(OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matiere, etudiant) < OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matiere, etudiants.get(i))) {
                etudiant = etudiants.get(i);
            }
        }
        return etudiant;
    }

    public static Etudiant getEtudiantWithLowestNoteByDevoir(ArrayList<Note> notes, Devoir devoir) {
        Etudiant etudiant = notes.get(0).getEtudiant();
        for(int i = 1; i < notes.size(); i++) {
            if(OutilsCalculs.getNoteEtudiantByDevoir(notes, devoir, notes.get(i).getEtudiant()) < OutilsCalculs.getNoteEtudiantByDevoir(notes, devoir, etudiant)){
                etudiant = notes.get(i).getEtudiant();
            }
        }
        return etudiant;
    }

    public static Etudiant getEtudiantWithHighestNoteByDevoir(ArrayList<Note> notes, Devoir devoir) {
        Etudiant etudiant = notes.get(0).getEtudiant();
        for(int i = 1; i < notes.size(); i++) {
            if(OutilsCalculs.getNoteEtudiantByDevoir(notes, devoir, notes.get(i).getEtudiant()) > OutilsCalculs.getNoteEtudiantByDevoir(notes, devoir, etudiant)){
                etudiant = notes.get(i).getEtudiant();
            }
        }
        return etudiant;
    }

    public static float getNoteEtudiantByDevoir(ArrayList<Note> notes,Devoir devoir, Etudiant etudiant) {
        for(int i = 0; i < notes.size(); i++) {
            if(notes.get(i).getDevoir().equals(devoir) && notes.get(i).getEtudiant().equals(etudiant)) {
                return notes.get(i).getNote();
            }
        }
        return -1.0f;
    }

    public static float getLowestMoyenne(ArrayList<Note> notes,ArrayList<Matiere> matieres, ArrayList<Etudiant> etudiants) {
        float lowestMoyenne = OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(0));
        for(int i = 0; i < etudiants.size();i++) {
            if(lowestMoyenne > OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(i))){
                lowestMoyenne = OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(i));
            }
        }
        return lowestMoyenne;
    }

    public static float getHighestMoyenne(ArrayList<Note> notes, ArrayList<Matiere> matieres, ArrayList<Etudiant> etudiants) {
        float highestMoyenne = OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(0));
        for(int i = 0; i < etudiants.size();i++) {
            if(highestMoyenne < OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(i))){
                highestMoyenne = OutilsCalculs.getMoyenneEtudiant(notes, matieres, etudiants.get(i));
            }
        }
        return highestMoyenne;
    }

    public static float getLowestMoyenneByMatiere(ArrayList<Note> notes, Matiere matiere, ArrayList<Etudiant> etudiants) {
        float lowestMoyenneMatiere = OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matiere,etudiants.get(0));
        for(int i = 1; i < etudiants.size(); i++) {
            float current = OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matiere,etudiants.get(i));
            if(lowestMoyenneMatiere > current) {
                lowestMoyenneMatiere = current;
            }
        }
        return lowestMoyenneMatiere;
    }

    public static float getHighestMoyenneByMatiere(ArrayList<Note> notes, Matiere matiere, ArrayList<Etudiant> etudiants) {
        float highestMoyenneMatiere = OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matiere,etudiants.get(0));
        for(int i = 1; i < etudiants.size(); i++) {
            float current = OutilsCalculs.getMoyenneEtudiantByMatiere(notes, matiere,etudiants.get(i));
            if(highestMoyenneMatiere < current) {
                highestMoyenneMatiere = current;
            }
        }
        return highestMoyenneMatiere;
    }
}
