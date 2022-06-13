-- Creation des tables de la database police
-- Monsieur CAPITAINE
-- BUT 1 informatique
-- avril 2022


CREATE TABLE situation(
   sit_id INT,
   sit_lieu VARCHAR(50),
   PRIMARY KEY(sit_id)
);

CREATE TABLE infraction(
   inf_numero INT,
   inf_categorie VARCHAR(50),
   inf_libelle VARCHAR(50),
   inf_prix INT,
   PRIMARY KEY(inf_numero)
);

CREATE TABLE proprietaire(
   pro_id INT,
   pro_nom VARCHAR(50),
   pro_prenom VARCHAR(50),
   pro_ville VARCHAR(50),
   PRIMARY KEY(pro_id)
);

CREATE TABLE voiture(
   voi_immatriculation VARCHAR(50),
   voi_marque VARCHAR(50),
   voi_modele VARCHAR(50),
   voi_couleur VARCHAR(50),
   pro_id INT NOT NULL,
   PRIMARY KEY(voi_immatriculation),
   FOREIGN KEY(pro_id) REFERENCES proprietaire(pro_id)
);

CREATE TABLE commettre(
   voi_immatriculation VARCHAR(50),
   sit_id INT,
   inf_numero INT,
   date_heure DATE,
   PRIMARY KEY(voi_immatriculation, sit_id, inf_numero),
   FOREIGN KEY(voi_immatriculation) REFERENCES voiture(voi_immatriculation),
   FOREIGN KEY(sit_id) REFERENCES situation(sit_id),
   FOREIGN KEY(inf_numero) REFERENCES infraction(inf_numero)
);


select pro_nom from proprietaire where pro_id IN (select pro_id from voiture where voi_immatriculation IN (select voi_immatriculation from commettre where inf_numero in (select inf_numero from infraction where inf_prix IN (select MAX(inf_prix) from infraction))));
select P.pro_nom from proprietaire AS P INNER JOIN voiture AS V ON P.pro_id = V.pro_id INNER JOIN commettre AS C ON V.voi_immatriculation = C.voi_immatriculation INNER JOIN infraction AS I ON C.inf_numero = I.inf_numero where inf_prix IN (select MAX(inf_prix) from infraction);


select sit_lieu from situation where sit_id IN (select sit_id from commettre where voi_immatriculation IN (select voi_immatriculation from voiture where pro_id IN(select pro_id from proprietaire where pro_nom = 'Synave')));
select S.sit_lieu from situation AS S INNER JOIN commettre AS C ON S.sit_id = C.sit_id INNER JOIN voiture AS V ON C.voi_immatriculation = V.voi_immatriculation INNER JOIN proprietaire AS P ON V.pro_id = P.pro_id where pro_nom = 'Synave';


select AVG(inf_prix) from infraction where inf_numero IN (select inf_numero from commettre where voi_immatriculation = '%P%');
select AVG(I.inf_prix) from infraction AS I INNER JOIN commettre AS C ON I.inf_numero =C.inf_numero where C.voi_immatriculation = '%P%';


select SUM(inf_prix) from infraction GROUP BY (select inf_numero from commettre GROUP BY voi_immatriculation);



select SUM(I.inf_prix) AS somme_ammende, C.voi_immatriculation from infraction AS I INNER JOIN commettre AS C ON I.inf_numero = C.inf_numero GROUP BY C.voi_immatriculation;



select pro_nom from proprietaire where pro_id in (select pro_id from voiture where voi_immatriculation in (select voi_immatriculation from commettre where inf_numero in (select inf_numero from infraction where inf_categorie = 'classe1')));
select P.pro_nom from proprietaire AS P INNER JOIN voiture AS V ON P.pro_id = V.pro_id INNER JOIN commettre AS C ON V.voi_immatriculation = C.voi_immatriculation INNER JOIN infraction AS I ON C.inf_numero = I.inf_numero where I.inf_categorie = 'classe1';

select pro_nom from proprietaire where 