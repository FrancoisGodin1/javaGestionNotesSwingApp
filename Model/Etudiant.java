package Model;

public class Etudiant {
    String idEtudiant;
    String nomEtudiant;
    String prenomEtudiant;

    public Etudiant(String idEtudiant, String prenomEtudiant, String nomEtudiant) {
        this.idEtudiant = idEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.nomEtudiant = nomEtudiant;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    @Override
    public String toString() {
        return nomEtudiant + " " + prenomEtudiant;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Etudiant other = (Etudiant) obj;
        if (idEtudiant == null) {
            if (other.idEtudiant != null) {
                return false;
            }
        } else if (!idEtudiant.equals(other.idEtudiant)) {
            return false;
        }
        if (nomEtudiant == null) {
            if (other.nomEtudiant != null) {
                return false;
            }
        } else if (!nomEtudiant.equals(other.nomEtudiant)) {
            return false;
        }
        if (prenomEtudiant == null) {
            if (other.prenomEtudiant != null) {
                return false;
            }
        } else if (!prenomEtudiant.equals(other.prenomEtudiant)) {
            return false;
        }
        return true;
    }
}
