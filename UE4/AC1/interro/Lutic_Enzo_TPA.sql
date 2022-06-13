/*/////////////////////////////////////////////////////
///////////////////////INTERO/////////////////////////
/////////////////////Lutic Enzo///////////////////////
////////////////////////TPA///////////////////////////
/////////////////////////////////////////////////////*/


--Question 1
-- Créez une vue nommée client_produit permettant de consulter les caractéristiques des produits commandés par chaque client

CREATE OR REPLACE VIEW client_produit AS SELECT C.numerocli, C.nomcli, P.numeroprod, P.designationprod, P.prixprod 
FROM client AS C INNER JOIN commande AS CO ON C.numerocli = CO.numerocli INNER JOIN produit AS P 
ON CO.numeroprod = P.numeroprod;

--Question 2
-- En utilisant la vue client_produit, donnez pour chaque nom de client le produit le plus cher qui a été commandé

SELECT nomcli, MAX(prixprod) FROM client_produit GROUP BY nomcli; 

--Question 3
-- Le nom des clients qui ont commandé tous les produits

-- Premiere méthode

SELECT CP.nomcli FROM client_produit AS CP GROUP BY CP.nomcli HAVING COUNT (DISTINCT CP.numeroprod) IN 
(SELECT COUNT(numeroprod) FROM produit);

-- Deuxième méthode

SELECT C.nomcli from client AS C WHERE C.numerocli in( SELECT DISTINCT(CO1.numerocli) from commande AS CO1 
WHERE NOT EXISTS (SELECT * FROM produit AS P WHERE NOT EXISTS (SELECT * FROM commande AS CO2 
WHERE CO2.numerocli = CO1.numerocli AND CO2.numeroprod=P.numeroprod)));

--Question 4 
-- PAS A FAIRE

--Question 5
-- Créer une vue produit_populaire qui donne tout les informations sur les 10 produits les plus commandés

CREATE OR REPLACE produit_populaire AS SELECT P.numeroprod, P.designationprod, P.prixprod FROM produit AS P 
INNER JOIN commande AS CO ON P.numeroprod = CO.numeroprod GROUP BY P.numeroprod 
ORDER BY COUNT(CO.numeroprod) DESC LIMIT 10;

