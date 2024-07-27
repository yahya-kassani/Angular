create table LL_Etudiant (
	uuid_ VARCHAR(75) null,
	etudiantId LONG not null primary key,
	nom VARCHAR(75) null,
	prenom VARCHAR(75) null,
	imageId LONG,
	classeId LONG
);