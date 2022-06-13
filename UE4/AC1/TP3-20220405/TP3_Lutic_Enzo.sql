/*###############################################
#################Lutic Enzo######################
#####################TP3#########################
#####################TPA#########################
##################26/04/2022#####################
###############################################*/

/*Question 1 et 2*/
/*Créez une vue NOTE_ANGLAIS qui donne le numéro d’épreuve, le nom d l’épreuve, le nom de l’étudiant et 
la note pour la matière ANGLAIS et consulté cette vue.*/

create view note_anglais AS select A.numepr, EP.libepr, ET.nometu, A.note 
from avoir_note AS A INNER JOIN epreuves AS EP 
ON A.numepr = EP.numepr INNER JOIN 
etudiants AS ET ON A.numetu = ET.numetu 
INNER JOIN matieres AS M 
ON M.nummat = EP.matepr
WHERE M.nommat = 'anglais';

select * from note_anglais;


/*Le résultat*/


/*Question 3*/
/*Pouvez-vous insérer un tuple dans cette vue ?.*/

/*Non ce n'est pas possible*/

/*Question 4*/
/*Créez une vue ETUDIANT_1 des étudiants de première année*/

create view ETUDIANTS_1 AS select * from etudiants where annetu = 1;

/*Le résultat*/

CREATE VIEW

/*Question 5*/
/*Créez une vue TUTEUR_POS des enseignants qui habitent la même ville qu’un étudiant. Son contenu sera 
nom étudiant, nom enseignant.*/

create view TUTEUR_POS (nom_etudiant, nom_professeur) as select ET.nometu, EN.nomens 
from enseignants as EN INNER JOIN etudiants as ET on EN.vilens = ET.viletu;


/*Le résultat*/

CREATE VIEW

/*Question 6*/
/*Créez une vue MOY_MATIERE de la moyenne par étudiants par matière. Son contenu sera nom étudiant, 
nom matière, moyenne. Vous veillerez à bien exploiter le coefficient de l’épreuve.*/

create VIEW MOY_MATIERE as select ET.nometu, M.nommat, 
avg(A.note*EP.coefepr)/sum(EP.coefepr) from etudiants ET inner join avoir_note A on
ET.numetu = A.numetu inner join epreuves EP on A.numepr = EP.numepr inner join matieres M
on EP.matepr = M.nummat group by ET.nometu, M.nummat, M.nommat;

/*Le résultat*/

CREATE VIEW

/*Question 7*/
/*Créez une vue BONS_ETUDIANTS des étudiants qui ont une moyenne supérieure à 12. On y mettra le nom 
de l’étudiant et sa moyenne.*/

create view bons_etudiants as 
select ET.nometu, M.nommat,avg(A.note*EP.coefepr)/sum(EP.coefepr) 
from etudiants as ET inner join avoir_note as A on ET.numetu = A.numetu
inner join epreuves as EP on A.numepr = EP.numepr 
inner join matieres as M on EP.matepr = M.nummat 
group by ET.nometu,M.nummat,M.nommat having avg(A.note*EP.coefepr)/sum(EP.coefepr) > 12;


/*Le résultat*/

CREATE VIEW

/*Question 8*/
/*A partir de cette vue, créez TRES_BONS_ETUDIANTS des moyennes supérieures à 16.*/

create view tres_bons_etudiants as 
select * from bons_etudiants where moyenne > 16;

/*Le résultat*/

CREATE VIEW

/*Question 9*/
/*Si vous supprimez BONS_ETUDIANTS, qu’advient-il de TRES_BONS_ETUDIANTS ?*/

/*On ne peut pas supprimé bons_etudiants car une autre requête depends de celle-ci*/

/*Question 10*/
/*Supprimez tout de même BONS_ETUDIANTS avec la commande conseillé par postgresql. Qu'advient-il de 
TRES_BONS_ETUDIANTS ?*/

drop view bons_etudiants cascade;

/*Question 11*/
/*A vous de créer une question nécessitant le recours à une vue. Cette question sera à rédiger correctement en 
commentaire dans votre fichier sql ainsi que la correction et la réponse renvoyée .*/

/*Crée une vue avec la liste des enseignants et de leurs epreuves.*/

create view enseignant_epreuve as select EN.nomens, EN.preens, EP.libepr from enseignants AS EN INNER JOIN epreuves AS EP ON EN.numens = EP.ensepr;

/*Le résultat*/

CREATE VIEW