package matiere.app.portlet;

public class MatiereDTO {
    private long matiereId;
    private long classeId;
    private long professeurId;
    private String intitule;
    private String nomIntitue;
    private String nomProf;

    public MatiereDTO(String nomProf, String nomIntitue, String intitule, long classeId, long professeurId, long matiereId) {
        this.nomProf = nomProf;
        this.nomIntitue = nomIntitue;
        this.intitule = intitule;
        this.classeId = classeId;
        this.professeurId = professeurId;
        this.matiereId = matiereId;
    }

    public long getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(long matiereId) {
        this.matiereId = matiereId;
    }

    public String getNomIntitue() {
        return nomIntitue;
    }

    public void setNomIntitue(String nomIntitue) {
        this.nomIntitue = nomIntitue;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public long getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(long professeurId) {
        this.professeurId = professeurId;
    }

    public long getClasseId() {
        return classeId;
    }

    public void setClasseId(long classeId) {
        this.classeId = classeId;
    }
}

