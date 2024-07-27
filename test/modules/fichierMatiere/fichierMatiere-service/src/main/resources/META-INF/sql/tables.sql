create table LL_FichierMatiere (
	uuid_ VARCHAR(75) null,
	fichierMatiereId LONG not null primary key,
	matiereId LONG,
	fichierId LONG
);