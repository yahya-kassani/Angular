create table LL_Matiere (
	uuid_ VARCHAR(75) null,
	matiereId LONG not null primary key,
	classeId LONG,
	professeurId LONG,
	Intitule VARCHAR(75) null
);