package dto;

public class EtudiantDto {
    private long etudiantId;
    private String nom;
    private String prenom;
    private long imageId;
    private long classeId;

    private String intitule;

    public EtudiantDto(long etudiantId, long classeId, long imageId, String prenom, String nom,String intitule) {
        this.etudiantId = etudiantId;
        this.classeId = classeId;
        this.imageId = imageId;
        this.prenom = prenom;
        this.nom = nom;
        this.intitule=intitule;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public long getClasseId() {
        return classeId;
    }

    public void setClasseId(long classeId) {
        this.classeId = classeId;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
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
}