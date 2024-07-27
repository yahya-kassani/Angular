package etudiant.app.portlet;

public class EtudiantDTO {
    private String nom;
    private String prenom;
    private String classe;
    private long Id;
    private long classeId;


    public EtudiantDTO(String nom, String prenom, String classe, long id, long classeId) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        Id = id;
        this.classeId = classeId;
    }

    public EtudiantDTO() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getClasseId() {
        return classeId;
    }

    public void setClasseId(long classeId) {
        this.classeId = classeId;
    }
}