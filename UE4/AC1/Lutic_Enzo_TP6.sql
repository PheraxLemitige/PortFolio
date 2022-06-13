/*/////////////////////////////////////
//////////////////////////////////////
//////////////Lutic Enzo//////////////
/////////////////TP6//////////////////
/////////////////TPA/////////////////
/////////////////////////////////////
////////////////////////////////////
*/


--Question 1
--Créer une requête qui affichera les noms de stade dans les lesquels se sont déroulés des matchs 
--ayant eu plus de 5000 spectateurs

SELECT nom_stade FROM stade WHERE id_stade IN (SELECT id_stade FROM match WHERE nbre_spectateurs >= 5000 );

       nom_stade
------------------------
 Stade Bolleart Delelis
 Parc des Princes
 Stade Louis II
 Vélodrome
 Parc OL
 La Beaujoire
 La Mosson
 Matmut Atlantique
 Roazhon Park
 Allianz Riviera
 Roudourou
 Michel-d Ornano
 Gaston-Gérard
 La Meinau
 Geoffroy-Guichard
 Stadium Municipal
 Pierre-Mauroy
 La Licorne
(18 rows)

--Question 2
-- Donner les noms des joueurs et le nombre de buts inscrits par chacun d'entre eux.

SELECT N.nom,COUNT(B.id_but) FROM personne AS N INNER JOIN but AS B ON N.id_personne=B.id_personne GROUP BY nom;

   nom   | count
---------+-------
 VACHOUX |     4
 PAYET   |    12
(2 rows)

--Question 3
-- Donner les noms des joueurs qui n'ont pas marqué de but.

SELECT nom FROM personne WHERE id_personne NOT IN (SELECT id_personne FROM but);

      nom
----------------
 THAUVIN
 MANDANDA
 RAMI
 GUSTAVO
 NEYMAR
 DI MARIA
 CAVANI
 MBAPPE
 FEKIR
 DEPAY
 TRAORE
 AOUAR
 FALCAO
 LEMAR
 JOVETIC
 BALDE
 SALA
 NAKOULMA
 BAMMOU
 THOMASSON
 SIO
 CAMARA
 IKONE
 ROUSSILLON
 DE PREVILLE
 MENDY
 BRAITHWAITE
:

--Question 4
--Affichez les id_personnes qui ont une moyenne de note par match supérieure à 5/10. (Vous 
--pourrez utiliser au choix un AVG ou faire le calcul)

SELECT id_personne, ROUND(avg(note),2) AS moyenne FROM evaluer GROUP BY id_personne HAVING avg(note)>5;

 id_personne | moyenne
-------------+---------
           4 |    7.25
           2 |    7.25
           1 |   10.00
(3 rows)

--Question 5
-- Créer une vue qui aura comme nom 'joueurs_match_lens_paris' qui affichera tous les joueurs 
--ayant participé au match opposant paris qui se déplace sur la pelouse de la merveilleuse et talentueuse équipe de
--Lens.

CREATE OR REPLACE view joueurs_match_lens_paris AS 
 SELECT distinct p.nom,p.prenom FROM personne AS p 
 INNER JOIN evaluer AS e ON p.id_personne = e.id_personne
 INNER JOIN match AS m ON m.id_match = e.id_match
 WHERE m.id_equipe_recoit = 1 OR m.id_equipe_deplace = 2;

CREATE VIEW


--Question 6
--A partir de la vue précédente , recréez une vue 'joueurs_match_lens_paris_V' qui affichera les 
--noms des joueurs ayant assisté à la rencontre Lens-Paris qui contiennent la lettre V (dans le nom)

CREATE OR REPLACE view nomV AS SELECT * FROM joueurs_match_lens_paris WHERE nom LIKE '%V%';

   nom   | prenom
---------+---------
 THAUVIN | Florian
 VACHOUX | Jérémy
(2 rows)

--Question 7
--Donnez la requête qui permet de supprimer les 2 vues créées précédemment en une seule fois.

DROP view joueurs_match_lens_paris,nomV;
DROP VIEW