/*###############################################
#################Lutic Enzo######################
#####################TP3#########################
#####################TPA#########################
##################26/04/2022#####################
###############################################*/

/*Question 1*/
/*Retrouver le nom de celui qui a reçu l’amende la plus forte.*/

/*Avec une requête imbriqué*/

select pro_nom from proprietaire where pro_id IN (select pro_id from voiture where voi_immatriculation IN 
(select voi_immatriculation from commettre where inf_numero in (select inf_numero from infraction where inf_prix IN 
(select MAX(inf_prix) from infraction))));

/*Avec des INNER JOIN*/

select P.pro_nom from proprietaire AS P INNER JOIN voiture AS V ON P.pro_id = V.pro_id INNER JOIN commettre AS C 
ON V.voi_immatriculation = C.voi_immatriculation INNER JOIN infraction AS I ON C.inf_numero = I.inf_numero 
where inf_prix IN (select MAX(inf_prix) from infraction);

/*Le résultat*/

    pro_nom
    ---------
    Xina
    Claude
    (2 lignes)

/*Question 2*/
/*Retrouver tous les lieux où ont été commis des infractions par Rémi Synave*/

/*Avec une requête imbriqué*/

select sit_lieu from situation where sit_id IN (select sit_id from commettre where voi_immatriculation IN 
(select voi_immatriculation from voiture where pro_id IN(select pro_id from proprietaire where pro_nom = 'synave')));

/*Avec des INNER JOIN*/

select S.sit_lieu from situation AS S INNER JOIN commettre AS C ON S.sit_id = C.sit_id 
INNER JOIN voiture AS V ON C.voi_immatriculation = V.voi_immatriculation INNER JOIN proprietaire AS P 
ON V.pro_id = P.pro_id where pro_nom = 'synave';

/*Le résultat*/

    sit_lieu
    -----------------
    Plage de Calais
    place d||armes
    (2 lignes)

/*Question 3*/
/*Retrouver la moyenne des amendes pour les voitures qui ont un P dans la plaqued’immatriculation.*/

/*Avec une requête imbriqué*/

select round(AVG(inf_prix), 2) from infraction where inf_numero IN (select inf_numero from commettre where voi_immatriculation LIKE '%P%');

/*Avec des INNER JOIN*/

select round(AVG(I.inf_prix)) from infraction AS I INNER JOIN commettre AS C ON I.inf_numero =C.inf_numero where C.voi_immatriculation LIKE '%P%';

/*Le résultat*/

    round
    ---------
    4110.53
    (1 ligne)

/*Question 4*/
/*Donner le total des amendes dressées par voiture.*/

/*Avec une requête imbriqué*/

/*Avec des INNER JOIN*/

select SUM(inf_prix), C.voi_immatriculation from infraction  AS I INNER JOIN commettre AS C ON I.inf_numero = C.inf_numero GROUP BY C.voi_immatriculation;

/*Le résultat*/

sum
-------
   135
    35
   232
   135
   750
    90
   510
 75405
 [...]

/*Question 5*/
/*Donner le total des amendes dressées par propriétaire de voiture. Ce total ne sera affiché que si le conducteur 
a déjà reçu une amende de plus de 1000 euros.*/

/*Avec une requête imbriqué*/

/*Avec des INNER JOIN*/

select SUM(I.inf_prix), C.voi_immatriculation from infraction AS I INNER JOIN commettre AS C ON I.inf_numero = C.inf_numero where I.inf_prix >= 1000 GROUP BY C.voi_immatriculation;

/*Le résultat*/

sum  | voi_immatriculation
-------+---------------------
 75000 | CD854LP
 75000 | WI111FI
(2 lignes)

/*Question 6*/
/*Retrouver les noms des propriétaires des voitures ayant été verbalisées pour une infraction de classe1*/

/*Avec une requête imbriqué*/

select pro_nom from proprietaire where pro_id in (select pro_id from voiture where voi_immatriculation in 
(select voi_immatriculation from commettre where inf_numero in (select inf_numero from infraction where inf_categorie = 'classe1')));

/*Avec des INNER JOIN*/

select P.pro_nom from proprietaire AS P INNER JOIN voiture AS V ON P.pro_id = V.pro_id INNER JOIN commettre AS C 
ON V.voi_immatriculation = C.voi_immatriculation INNER JOIN infraction AS I ON C.inf_numero = I.inf_numero 
where I.inf_categorie = 'classe1';

/*Le résultat*/

pro_nom
-----------
 capitaine
 Wok
 Julien
(3 lignes)

/*Question 7*/
/*Retrouver le nom du propriétaire qui a payé le plus d’amendes (somme des amendes)*/

SELECT p.pro_nom, sum(inf_prix) FROM infraction AS i
INNER JOIN commettre AS c on c.inf_numero = i.inf_numero
INNER JOIN voiture AS v on v.voi_immatriculation = c.voi_immatriculation
INNER JOIN proprietaire AS p on p.pro_id = v.pro_id
GROUP BY p.pro_nom
having sum(inf_prix) >= all (SELECT (sum(inf_prix)) FROM infraction AS i
INNER JOIN commettre AS c on c.inf_numero = i.inf_numero
INNER JOIN voiture AS v on v.voi_immatriculation = c.voi_immatriculation
INNER JOIN proprietaire AS p on p.pro_id = v.pro_id
GROUP BY p.pro_nom);

/*Le résultat*/

pro_nom |  sum
---------+-------
 Xina    | 77665
(1 ligne)