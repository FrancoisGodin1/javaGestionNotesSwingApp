package Model;

public class Devoir {
    String idDevoir;
    String libelleDevoir;
    float coeffDevoir;
    Matiere matiere;

    public Devoir(String idDevoir, String libelleDevoir, float coeffDevoir, Matiere matiere) {
        super();
        this.idDevoir = idDevoir;
        this.libelleDevoir = libelleDevoir;
        this.coeffDevoir = coeffDevoir;
        this.matiere = matiere;
    }

    public String getIdDevoir() {
        return idDevoir;
    }
    public float getCoefDevoir() { return coeffDevoir; }
    public Matiere getMatiere() { return matiere; }

    @Override
    public String toString() {
        return libelleDevoir + "(" + coeffDevoir + ")";
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
        Devoir other = (Devoir) obj;
        if (Float.floatToIntBits(coeffDevoir) != Float.floatToIntBits(other.coeffDevoir)) {
            return false;
        }
        if (idDevoir == null) {
            if (other.idDevoir != null) {
                return false;
            }
        } else if (!idDevoir.equals(other.idDevoir)) {
            return false;
        }
        if (libelleDevoir == null) {
            if (other.libelleDevoir != null) {
                return false;
            }
        } else if (!libelleDevoir.equals(other.libelleDevoir)) {
            return false;
        }
        if (matiere == null) {
            if (other.matiere != null) {
                return false;
            }
        } else if (!matiere.equals(other.matiere)) {
            return false;
        }
        return true;
    }
}
