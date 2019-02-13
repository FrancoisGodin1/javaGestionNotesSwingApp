package Model;

public class Matiere {
    String idMatiere;
    String libelleMatiere;
    float coefMatiere;

    public Matiere(String idMatiere, String libelleMatiere, float coefMatiere) {
        super();
        this.idMatiere = idMatiere;
        this.libelleMatiere = libelleMatiere;
        this.coefMatiere = coefMatiere;
    }

    @Override
    public String toString() {
        return libelleMatiere + " (" + coefMatiere + ")";
    }

    public String getIdMatiere() {
        return idMatiere;
    }
    public float getCoefMatiere() {
        return coefMatiere;
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
        Matiere other = (Matiere) obj;
        if (Float.floatToIntBits(coefMatiere) != Float.floatToIntBits(other.coefMatiere)) {
            return false;
        }
        if (idMatiere == null) {
            if (other.idMatiere != null) {
                return false;
            }
        } else if (!idMatiere.equals(other.idMatiere)) {
            return false;
        }
        if (libelleMatiere == null) {
            if (other.libelleMatiere != null) {
                return false;
            }
        } else if (!libelleMatiere.equals(other.libelleMatiere)) {
            return false;
        }
        return true;
    }
}
