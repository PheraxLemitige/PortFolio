/* fichier sql pour le tp1 BUT 1 informatique */

create table etudiant (etuid integer primary key, etunom varchar(24), etuprenom varchar(24), etudatenai date, dptid integer);
create table departement (dptid integer primary key, dptnom varchar(20), dptchef integer);
create table enseignant (ensid integer primary key, ensnom varchar(24), ensprenom varchar(24), dptid integer references departement (dptid));



insert into etudiant values (1,'dupont', 'marcel','22/10/1994',1);
insert into etudiant values (2, 'durand','sophie','02/08/1995',1);

insert into departement values (1, 'GEA', 1);
insert into departement values (2, 'GEII', 10);
insert into departement values (3, 'INFORMATIQUE', 20);
insert into departement values (4, 'GB', 40);

insert into enseignant values (1, 'segond','franck' ,1);
insert into enseignant values (10, 'merlot','jimmy', 2);
insert into enseignant values (20, 'capitaine','dany', 3);
insert into enseignant values (40, 'leblond','jean-marc', 4);

alter table departement ADD CONSTRAINT dist_fk FOREIGN KEY (dptchef) REFERENCES enseignant (ensid);
alter table etudiant add constraint ck_etu FOREIGN KEY (dptid) references departement (dptid);