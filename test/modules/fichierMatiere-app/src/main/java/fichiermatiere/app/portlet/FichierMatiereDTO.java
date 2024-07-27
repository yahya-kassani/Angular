package fichiermatiere.app.portlet;

public class FichierMatiereDTO {
    private long fichierMatiereId;
    private long fichierId;
    private long matiereid;
    private String nomMatiere;

    public FichierMatiereDTO(long fichierMatiereId, long fichierId, long matiereid, String nomMatiere) {
        this.fichierMatiereId = fichierMatiereId;
        this.fichierId = fichierId;
        this.matiereid = matiereid;
        this.nomMatiere = nomMatiere;
    }

    public long getFichierMatiereId() {
        return fichierMatiereId;
    }

    public void setFichierMatiereId(long fichierMatiereId) {
        this.fichierMatiereId = fichierMatiereId;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public long getMatiereid() {
        return matiereid;
    }

    public void setMatiereid(long matiereid) {
        this.matiereid = matiereid;
    }

    public long getFichierId() {
        return fichierId;
    }

    public void setFichierId(long fichierId) {
        this.fichierId = fichierId;
    }
}

