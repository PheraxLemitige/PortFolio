
create table etudiants (
   numetu integer primary key,
   nometu varchar(20) not null,
   prenometu varchar(20),
   adretu varchar(40),
   viletu varchar(10),
   cpetu integer,
   teletu varchar(14),
   datentetu date,
   annetu integer constraint ck_etu_annee check (annetu in (1,2)), 
   remetu varchar(40),
   sexetu char(1) constraint ck_etu_sex check (sexetu in ('M','F')),
   datnaietu date);

create table enseignants (
   numens integer primary key,
   nomens varchar(20) not null,
   preens varchar(20),
   foncens varchar(25) constraint ck_ens_fonc check (foncens in ('AGREGE', 'CERTIFIE', 'MAITRE DE CONFERENCES', 'VACATAIRE')),
   adrens varchar(40),
   vilens varchar(10),
   cpens integer,
   telens varchar(14),
   datnaiens date,
   datembens date);
  
create table modules (
   nummod integer primary key,
   nommod varchar(15) not null,
   coefmod integer);

create table matieres (
   nummat integer primary key,
   nommat varchar(15) not null,
   nummod integer references modules (nummod),
   coefmat integer);

create table epreuves (
   numepr integer primary key,
   libepr varchar(20),
   ensepr integer not null references enseignants (numens),
   matepr integer not null references matieres (nummat),
   datepr date,
   coefepr integer not null,
   annepr integer);


create table avoir_note (
   numetu integer references etudiants (numetu),
   numepr integer references epreuves (numepr),
   note integer,
   primary key (numetu, numepr));

create table faire_cours (
   numens integer references enseignants (numens),
   nummat integer references matieres (nummat),
   annee integer,
   primary key (numens, nummat, annee));














ALTER TABLE etudiants ADD hobby varchar(20) constraint check (hobby IN ('sport', 'lecture', 'cinema', 'peinture', 'sculpture')) default ('sport');

ALTER TABLE etudiants drop newcol;

ALTER TABLE etudiants ALTER COLUMN prenometu SET NOT NULL;

INSERT INTO epreuves VALUES (7, 'interro écrite', 9, 1, '21-oct-96', 1);

INSERT INTO avoir_note VALUES (1, 7, 10), (2, 7, 08), (3, 7, 05), (4, 7, 09);

UPDATE avoir_note SET note = 07 WHERE numetu = 3 and numepr = 7;


UPDATE avoir_note SET note = note + 1 WHERE numetu = 1 and numepr = 7;

DELETE FROM avoir_note WHERE numepr = 7;
DELETE FROM epreuves WHERE numepr = 7;

UPDATE avoir_note SET note = note - 3 WHERE numepr IN (SELECT numepr FROM epreuves WHERE matepr = 2) and numetu IN (SELECT numetu FROM etudiants WHERE nometu LIKE 'marke';

INSERT INTO avoir_note VALUES ((SELECT numetu FROM etudiants WHERE nometu LIKE 'dewa'), 4, (SELECT ROUND(AVG(note), 2) * 0.9 from avoir_note WHERE numepr = 4))

INSERT INTO etudiants VALUES (25, 'darte', 'remy', NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 'structure')
select note from avoir_note where numepr in (select matepr from epreuves where matepr in (select nummat from matieres where nommat like 'BD')) and numetu in (select nometu from etudiants where nometu like 'marke');

INSERT INTO etudiants (numetu, nometu, prenometu, hobby, annetu) values (25, 'dartez', 'remi', 'sculpture', 2);

SELECT Et.nometu FROM etudiants as Et
INNER JOIN avoir_note as A ON Et.numetu=A.numetu
WHERE A.note IN



=


(SELECT A.note FROM etudiants AS Et INNER JOIN avoir_note AS A ON
Et.numetu=A.numetu
WHERE Et.nometu='dupont');

























