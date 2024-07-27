package professeur.app.portlet;

public class ClasseProffeurDTO {
    private String intitule;
    private long classeId;
    private long professeurId;

    public ClasseProffeurDTO(String intitule, long professeurId, long classeId) {
        this.intitule = intitule;
        this.professeurId = professeurId;
        this.classeId = classeId;
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

