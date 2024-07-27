create table LL_ProfClasse (
	uuid_ VARCHAR(75) null,
	profClasseId LONG not null primary key,
	professeurId LONG,
	classeId LONG
);

create table LL_Professeur (
	uuid_ VARCHAR(75) null,
	professeurId LONG not null primary key,
	nom VARCHAR(75) null,
	prenom VARCHAR(75) null
);