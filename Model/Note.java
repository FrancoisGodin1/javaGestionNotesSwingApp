package Model;

public class Note {
    String idNote;
    float note;
    Etudiant etudiant;
    Devoir devoir;

    public Note(String idNote, float note, Etudiant etudiant, Devoir devoir) {
        super();
        this.idNote = idNote;
        this.note = note;
        this.etudiant = etudiant;
        this.devoir = devoir;
    }

    public float getNote() { return note; }
    public Etudiant getEtudiant() { return etudiant; }
    public Devoir getDevoir() { return devoir; }

    @Override
    public String toString() {
        return "Note [idNote=" + idNote + ", note=" + note + ", etudiant=" + etudiant + ", devoir=" + devoir + "]";
    }

}
