package Outils;
import java.io.IOException;
import java.util.ArrayList;
import Model.*;


public class OutilsStringToObject {
    public static ArrayList<Etudiant> getEtudiants(String path) throws IOException
    {
        String file = OutilsCsvToString.loadFile(path);
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

        for(int i=0; i < OutilsCsvToString.nbLines(file); i++) {
            String line = OutilsCsvToString.extractLine(file,i);

            Etudiant e = new Etudiant(
                    OutilsCsvToString.extractValue(line,0),
                    OutilsCsvToString.extractValue(line,1),
                    OutilsCsvToString.extractValue(line,2)
            );
            etudiants.add(e);
        }
        return etudiants;
    }

    public static ArrayList<Matiere> getMatieres(String path) throws IOException
    {
        String file = OutilsCsvToString.loadFile(path);
        ArrayList<Matiere> matieres = new ArrayList<Matiere>();

        for(int i=0; i < OutilsCsvToString.nbLines(file); i++) {
            String line = OutilsCsvToString.extractLine(file,i);

            Matiere m = new Matiere(
                    OutilsCsvToString.extractValue(line,0),
                    OutilsCsvToString.extractValue(line,1),
                    Float.parseFloat(OutilsCsvToString.extractValue(line,2))
            );
            matieres.add(m);
        }
        return matieres;
    }


    public static ArrayList<Devoir> getDevoirs(String path, ArrayList<Matiere> matieres) throws IOException{
        String file = OutilsCsvToString.loadFile(path);
        ArrayList<Devoir> devoirs = new ArrayList<Devoir>();

        for(int i=0; i < OutilsCsvToString.nbLines(file); i++) {
            String line = OutilsCsvToString.extractLine(file,i);

            Devoir d = new Devoir(
                    OutilsCsvToString.extractValue(line,0),
                    OutilsCsvToString.extractValue(line,1),
                    Float.parseFloat(OutilsCsvToString.extractValue(line,2)),
                    OutilsStringToObject.getMatiereById(matieres,OutilsCsvToString.extractValue(line,3))
            );
            devoirs.add(d);
        }
        return devoirs;
    }

    public static ArrayList<Note> getNotes(String path, ArrayList<Devoir> devoirs, ArrayList<Etudiant> etudiants) throws IOException{
        String file = OutilsCsvToString.loadFile(path);
        //String[] notes = file.split("\n");
        ArrayList<Note> notes = new ArrayList<Note>();

        for(int i=0; i < OutilsCsvToString.nbLines(file); i++) {
            String line = OutilsCsvToString.extractLine(file,i);

            Note n = new Note(
                    OutilsCsvToString.extractValue(line,0),
                    Float.parseFloat(OutilsCsvToString.extractValue(line,1)),
                    OutilsStringToObject.getEtudiantById(etudiants,OutilsCsvToString.extractValue(line,2)),
                    OutilsStringToObject.getDevoirById(devoirs,OutilsCsvToString.extractValue(line,3))
            );
            notes.add(n);
        }
        return notes;
    }

    public static Etudiant getEtudiantById(ArrayList<Etudiant> etudiants, String id) {
        for(int i = 0; i< etudiants.size(); i++) {
            if(etudiants.get(i).getIdEtudiant().equals(id))
                return etudiants.get(i);
        }
        return null;
    }

    public static Matiere getMatiereById(ArrayList<Matiere> matieres,String id) {
        for(int i = 0; i< matieres.size(); i++) {
            if(matieres.get(i).getIdMatiere().equals(id))
                return matieres.get(i);
        }
        return null;
    }

    public static Devoir getDevoirById(ArrayList<Devoir> devoirs,String id) {
        for(int i = 0; i< devoirs.size(); i++) {
            if(devoirs.get(i).getIdDevoir().equals(id))
                return devoirs.get(i);
        }
        return null;
    }
}
