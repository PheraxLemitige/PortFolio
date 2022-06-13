-- Creation des tables de la database police
-- Monsieur CAPITAINE
-- BUT 1 informatique
-- avril 2022

-- table proprietaire
 insert into proprietaire values (1, 'capitaine', 'dany', 'saint-omer');situation
 insert into proprietaire values (2, 'synave', 'remi', 'calais');

-- table voiture
insert into voiture values ( '75PM8962', 'ferrari', 'Ferrari Daytona SP3', 'rouge', 1);
insert into voiture values ( 'ZZAC8462', 'lada', 'lada2107', 'beige', 2);

--table situation
insert into situation values (1, 'cimetiere');
insert into situation values (2, 'place d||'||'armes');

--table infraction
insert into infraction values (2548, 'classe1', 'clignotant absent', '35');

--table commettre 
insert into commettre values ('75PM8962', 1,2548,'28-03-2022');
----------------------------------------
--Sailly Kévin
----------------------------------------
-- table proprietaire
 insert into proprietaire values (3, 'Xina', 'John', 'Beijing');
 insert into proprietaire values (4, 'Wok', 'The', 'Pékin');
 insert into proprietaire values (5, 'Musk', 'Xilon', 'Wuhan');

-- table voiture
insert into voiture values ( 'CD854LP', 'ferrari', 'Daytona SP3', 'rouge', 3);
insert into voiture values ( 'AA123BB', 'lada', 'lada2107', 'beige', 4);
insert into voiture values ( 'VF458ZD', 'Tesxa', 'ModelS', 'Verte', 5);

--table situation
insert into situation values (3, 'Ecole');
insert into situation values (4, 'Mairie');

--table infraction
insert into infraction values (1249, 'classe3', 'Aucun contrôle technique', '35');

--table commettre 
insert into commettre values ('VF458ZD', 4,1249,NOW());
----------------------------------------

--Corion Gauthier
----------------------------------------
-- table proprietaire
insert into proprietaire values (6, 'Henri', 'Matisse', 'Nice');
insert into proprietaire values (7, 'Claude', 'Monet', 'Paris');
insert into proprietaire values (8, 'Eugène', 'Delacroix', 'Paris');

-- table voiture
insert into voiture values ( 'OR333DI', 'porsche', 'Boxster 987', 'rouge', 6);
insert into voiture values ( 'WI111FI', 'citroen', 'Cactus', 'blanche', 7);

--table situation
insert into situation values (5, 'Gare de Calais');
insert into situation values (6, 'Théatre');
insert into situation values (7, 'Piscine');

--table infraction
insert into infraction values (2233, 'classe2', 'Non-paiement d||'||'un péage ;', '75');

--table commettre 
insert into commettre values ('OR333DI', 6,2233,'02-03-2022');

-- Caron Samuel
----------------------------------------
-- table proprietaire
insert into proprietaire values(9, 'Jean', 'Pierre', 'Montcuq');
insert into proprietaire values(10, 'Drexler', 'Henrietta', 'Strasbourg');
insert into proprietaire values(11, 'Ivanov', 'Dmitri', 'Minsk');

-- table voiture
insert into voiture values('XVB4R4R', 'audi', 'rs3', 'noire', 9);
insert into voiture values('E8TYU45', 'suzuki', 'x90', 'rouge', 10);
insert into voiture values('RYD98MP', 'gaz', 'volga', 'rose', 11);

--table situation
insert into situation values(8, 'Parc');
insert into situation values(9, 'Patinoire');
insert into situation values(10, 'Bar');

-- table infraction
insert into infraction values(1782 ,'classe4', 'Alcool au volant', '375');

-- table commettre
insert into commettre values('RYD98MP', 11, 1782, '14-07-2022');

----------------------------------------
--Lovergne Alex
----------------------------------------
-- table proprietaire
insert into proprietaire values (12, 'Simp', 'Noe', 'Marseille');
insert into proprietaire values (13, 'Bauzo', 'Oratio', 'Boulogne');
insert into proprietaire values (14, 'Higa', 'Oren', 'Calais');

-- table voiture
insert into voiture values ( 'CV555OG', 'renault', 'Clio', 'blanche', 12);
insert into voiture values ( 'PD123MD', 'fiat', 'Multipla', 'rouge', 14);

--table situation
insert into situation values (12, 'IUTLCO');
insert into situation values (13, 'Le Channel');
insert into situation values (14, 'McDonalds');

--table infraction
insert into infraction values (4569, 'classe3', 'Pas d||'||'essuie glasse;', '70');

--table commettre 
insert into commettre values ('PD123MD',14,4569,'22-03-2022');

----------------------------------------
--ELUECQUE Anthony
----------------------------------------
-- table proprietaire
insert into proprietaire values (15, 'Terre', 'Jean', 'Calais');
insert into proprietaire values (16, 'Fautré', 'Thibault', 'Lille');
insert into proprietaire values (17, 'Seidman', 'Thomas', 'Marseille');

-- table voiture
insert into voiture values ( 'E750PZZ', 'citroen', 'c4 picasso', 'noir', 15);
insert into voiture values ( 'R4T1OLL', 'citroen', 'c3 picasso', 'orange', 17);

--table situation
insert into situation values (15, 'Mairie de Calais');
insert into situation values (16, 'Théatre');
insert into situation values (17, 'Patinoire');

--table infraction
insert into infraction values (3590, 'classe4', 'Pas de||'||'frein ;', '125');

--table commettre 
insert into commettre values ('ZD987DM', 15,3590,'08-03-2022');

----------------------------------------
--LECLERCQ Tom
----------------------------------------
-- table proprietaire
insert into proprietaire values (3, 'levi', 'sylvain', 'paris');
insert into proprietaire values (4, 'ojeh', 'akramjunior', 'paris');

-- table voiture
insert into voiture values ( 'ZSP5CLQ4', 'Toyota', 'Supra MK4', 'orange', 4);
insert into voiture values ( 'D65ZFDPF', 'Ford', 'Mustang Shelby GT500', 'gris', 3);
insert into voiture values ( 'CLC1SD53', 'Citroen', 'Xantia EXCLUSIVE', 'bleu', 3);
insert into voiture values ( '5D4S5CDS', 'BMW', 'M3 F80', 'jaune', 1);
insert into voiture values ( 'JHEZJ65X', 'Porsche', '911 GT2RS', 'gris', 4);
insert into voiture values ( 'LSQF845S', 'BMW', 'serie 3 e36', 'marron', 1);

--table infraction
insert into infraction values (416,  'classe3', 'fumée noire', '450');
insert into infraction values (3251, 'classe4', 'echappement trop bruyant', '135');
insert into infraction values (5612, 'classe4', 'pare brise teinté', '135');

--table commettre 
insert into commettre values ('LSQF845S', 1,416,'21-08-2020');
insert into commettre values ('D65ZFDPF', 3,3251,'16-01-2018');
insert into commettre values ('D65ZFDPF', 3,5612,'16-01-2018');
insert into commettre values ('ZSP5CLQ4', 4,3251,'14-11-2021');
insert into commettre values ('CLC1SD53', 3,416,'13-11-2021');


----------------------------------------
--BRENEL Pierre
----------------------------------------

--table infraction
insert into infraction values (46431,  'classe4', 'Dépassement dangereux', '135');
insert into infraction values (3851, 'classe4', 'Conduite en état alcoolique', '135');
insert into infraction values (7895, 'classe5', 'Excès de vitesse supérieur à 50 km/h.', '750');
insert into infraction values (5681, 'classe4', 'Circulation en sens interdit', '175');
insert into infraction values (9524, 'classe4', 'Refus de priorité', '105');

--table commettre 
insert into commettre values ('LSQF845S', 2,9524,'24-04-2020');
insert into commettre values ('D65ZFDPF', 2,5681,'16-06-2013');
insert into commettre values ('D65ZFDPF', 3,7895,'10-11-2015');
insert into commettre values ('ZSP5CLQ4', 6,3851,'09-04-2016');
insert into commettre values ('CLC1SD53', 6,46431,'22-02-2022');



----------------------------------------
--DOURNEL FREDERIC
----------------------------------------

--table infraction
insert into infraction values (453,  'classe4', 'Excès de lenteur', '135');
insert into infraction values (757, 'classe4', 'Conduite en état alcoolique', '135');
insert into infraction values (942, 'classe5', 'Délit de fuite', '75000');
insert into infraction values (662, 'classe4', 'Garé sur passage pieton', '135');
insert into infraction values (988, 'classe4', 'passager majeur pas attaché', '135');

--table commettre 
insert into commettre values ('HZDADF8G', 3,453,'24-01-2011');
insert into commettre values ('FEZIAF8D', 4,757,'16-01-2022');
insert into commettre values ('FEZAFUAF', 1,942,'12-11-2015');
insert into commettre values ('GRTQF26F', 6,662,'09-04-2006');
insert into commettre values ('AFIOQF6F', 1,988,'28-02-2012');

----------------------------------------
--          Vandaele Joshua           --
----------------------------------------

-- Table infraction
INSERT INTO infraction VALUES (500, 'classe1', 'Stationnement interdit', '38');
INSERT INTO infraction VALUES (501, 'classe2', 'Téléphone au volant', '135');
INSERT INTO infraction VALUES (502, 'classe3', 'Circulation en l’absence de dispositifs de freinage conformes', '400');
INSERT INTO infraction VALUES (503, 'classe4', 'Conduite en état d’ivresse', '750');
INSERT INTO infraction VALUES (504, 'classe5', 'Excès de vitesse supérieur à 50 km/h', '1500');

-- Table commettre 
INSERT INTO commettre VALUES ('AA123BB', 1, 500, '28-01-2003');
INSERT INTO commettre VALUES ('D65ZFDPF', 2, 501, '05-03-2004');
INSERT INTO commettre VALUES ('WI111FI', 3, 502, '05-01-2007');
INSERT INTO commettre VALUES ('JHEZJ65X', 4, 503, '02-05-2006');
INSERT INTO commettre VALUES ('LSQF845S', 5, 504, '26-11-2015');

----------------------------------------
-- OGES FLORIAN
----------------------------------------
--table infraction
insert into infraction values (3034, 'classe4', 'Usage du téléphone tenu en main', '135');
insert into infraction values (6666, 'classe4', 'Circulation sur la bande d||'||'arrêt d||'||'urgence', '135');
insert into infraction values (2507, 'classe4', 'Conduite sans ceinture de sécurité', '135');
insert into infraction values (9647, 'classe4', 'Refus de priorité', '135');
insert into infraction values (58, 'classe4', 'Non respect d||'||'un feu rouge', '135');
insert into infraction values (4956, 'classe4', 'Non respect d||'||'un stop', '135');
insert into infraction values (2047, 'classe4', 'Franchissement d||'||'une ligne continue', '135');
insert into infraction values (9999, 'classe4', 'Circulation sans éclairage', '135');
insert into infraction values (9785, 'classe4', 'Dépassement dangereux', '135');
insert into infraction values (6549, 'classe4', 'Absence de certificat d||'||'immatriculation', '135');
insert into infraction values (9829, 'classe4', 'Non respect de la distance de sécurité', '135');

--table commettre 
insert into commettre values ('75PM8962', 1,3034,'14-02-2022');
insert into commettre values ('ZZAC8462', 2,6666,'21-10-2021');
insert into commettre values ('CD854LP', 3,2057,'26-02-2012');
insert into commettre values ('AA123BB', 4,9647,'05-01-2015');
insert into commettre values ('VF458ZD', 5,58,'04-01-2013');
insert into commettre values ('OR333DI', 6,4956,'12-03-2020');
insert into commettre values ('WI111FI', 7,2047,'24-07-2021');
insert into commettre values ('CV555OG', 12,9999,'17-01-2022');
insert into commettre values ('XVB4R4R', 9,9785,'18-51-2018');
insert into commettre values ('E8TYU45', 10,6549,'21-01-2019');
insert into commettre values ('RYD98MP', 11,9829,'12-06-2021');


----------------------------------------
-------------- PAUL DEBRIL -------------
----------------------------------------

--table commettre
insert into commettre values ('DJKLFDPP', 3,3771,'12-02-2019');
insert into commettre values ('I8J5HJLP', 3,5222,'16-03-2017');
insert into commettre values ('ZHIKTG57', 4,3851,'20-01-2022');
insert into commettre values ('CLG8HJIG', 3,4770,'12-12-2021');

--table voiture
insert into voiture values ( 'DJKLFDPP', 'Renault', 'Clio 2 Serie MTV', 'bleu', 3);
insert into voiture values ( 'I8J5HJLP', 'Telsa', 'S', 'jaune', 1);
insert into voiture values ( 'ZHIKTG57', 'Tesla', '3', 'gris', 4);
insert into voiture values ( 'CLG8HJIG', 'Tesla', 'X', 'noir', 1);
insert into voiture values ( 'C854HYUI', 'Tesla', 'Roadster', 'noir', 3);

--table proprietaire
insert into proprietaire values (99, 'debril', 'paul', 'loonplage');


-----------------------------------------
-------------- YOURI STECKO -------------
-----------------------------------------

--table proprietaire
insert into proprietaire values (31, 'stecko', 'youri', 'lille');
insert into proprietaire values (42, 'morgana', 'yuri', 'Pékin');
insert into proprietaire values (51, 'garen', 'steven', 'paris');
insert into proprietaire values (32, 'yii', 'matheo', 'Beijing');
insert into proprietaire values (41, 'vargas', 'pablo', 'mexico');
insert into proprietaire values (52, 'musk', 'elon', 'californie');

--table voiture
insert into voiture values ( 'CLGHKOPP', 'Ford', 'Mustang', 'noir', 3);
insert into voiture values ( '5D4S587S', 'BMW', 'X6', 'jaune', 1);
insert into voiture values ( 'JOIZ765X', 'Dacia', 'Duster', 'gris', 4);
insert into voiture values ( 'LSQF8H7S', 'BMW', 'X4', 'marron', 1);

----------------------------------------
-- WATEL NOA
----------------------------------------
--table infraction
insert into infraction values (3035, 'classe4', 'Oublie de clignotant', '135');
insert into infraction values (6667, 'classe4', 'Non respect du temp d||'||'arret au panneau STOP', '135');
insert into infraction values (2508, 'classe4', 'Non payement du stationnement', '135');
insert into infraction values (9648, 'classe4', 'Conduite dangereuse', '135');
insert into infraction values (59, 'classe4', 'Non port de la ceinture de sécurité', '135');
insert into infraction values (4957, 'classe4', 'Port de sandale en conduisant', '135');
insert into infraction values (2048, 'classe4', 'Stationnement gênant', '135');
insert into infraction values (9995, 'classe4', 'Stationnement très gênant', '135');
insert into infraction values (9784, 'classe4', 'Stationnement sur une place handicapé', '135');
insert into infraction values (6542, 'classe4', 'Controle technique non valide', '135');
insert into infraction values (9823, 'classe4', 'Pneu lisse', '135');

--table commettre 
insert into commettre values ('BQ900ZD', 1,3034,'04-09-2021');
insert into commettre values ('GB452CQ', 2,6666,'21-10-2020');
insert into commettre values ('CQ478GB', 3,2057,'26-04-2012');
insert into commettre values ('NA564BG', 4,9647,'05-08-2015');
insert into commettre values ('DV882WA', 5,58,'04-01-2003');
insert into commettre values ('AN822JT', 6,4956,'12-03-2010');
insert into commettre values ('BI73545', 7,2047,'14-08-2018');
insert into commettre values ('ZA4EA8E', 12,9999,'17-01-2014');
insert into commettre values ('BD655SE', 9,9785,'18-51-2020');
insert into commettre values ('NO456ES', 10,6549,'05-01-2022');
insert into commettre values ('QA7DQZ6', 11,9829,'14-11-2001');

----
--JULES BENARD
-----

--table voiture
insert into voiture values ( 'JDZIAQHF', 'Mercedes-Benz', 'Class A45S AMG', 'jaune', 7);
insert into voiture values ( 'FQZEFH54', 'Mercedes-Benz', 'GLE 2021', 'vert mat', 5);
insert into voiture values ( '3TQEZDJJ', 'Mercedes-Benz', 'GT63S', 'noir mat', 8);
insert into voiture values ( '5FQSDJQ2', 'Mercedes-Benz', 'GLA', 'rouge', 9);

--table infraction
insert into infraction values (2943, 'classe4', 'Assurance périmé', '22');
insert into infraction values (3813, 'classe4', 'Ligne blanche continue depassé', '135');
insert into infraction values (4328, 'classe4', 'Excés de vitesse +20km/h', '135');
insert into infraction values (8403, 'classe4', 'Non port de la ceinture de sécurité', '90');
insert into infraction values (2984, 'classe4', 'Non-paiement d´un péage', '135');
insert into infraction values (4568, 'classe4', 'Dispositifs de freinage non conformes', '135');

/*
labit evan
*/

insert into commettre values ( 'OR333DI', 17, 2943, '12-02-2016' );
insert into commettre values ( 'WI111FI', 17, 3813, '21-04-2003' );
insert into commettre values ( 'ZSP5CLQ4', 14, 6667, '29-10-2001' );
insert into commettre values ( 'D65ZFDPF', 5, 9829, '15-06-2005' );
insert into commettre values ( 'CLC1SD53', 3, 6549, '05-08-2022' );
insert into commettre values ( '5D4S5CDS', 9, 5681, '03-11-2019' );
insert into commettre values ( 'JHEZJ65X', 12, 9524, '07-03-2018' );
insert into commettre values ( 'I8J5HJLP', 4, 7895, '16-01-2010' );
insert into commettre values ( 'DJKLFDPP', 15, 46431, '13-07-2014' );
insert into commettre values ( 'LSQF845S', 3, 3851, '12-06-2019' );

----------------------------------------
--CZARKOWSKI Matthieu
----------------------------------------

insert into commettre values ('AA123BB', 12,503, NOW());
insert into commettre values ('WI111FI', 14,942, NOW());
insert into commettre values ('PD123MD', 7,3251,'12-12-2012');
insert into commettre values ('R4T1OLL', 3,9648, '13-08-2022');
insert into commettre values ('LSQF845S', 2,59, '22-03-2022');
insert into commettre values ('CD854LP', 2,2233, '06-09-2016');
insert into commettre values ('D65ZFDPF', 1,9647, '01-01-2015');
insert into commettre values ('JHEZJ65X', 9,2233, '14-12-2020');
insert into commettre values ('CD854LP', 16,942, '19-05-1969');
insert into commettre values ('JHEZJ65X', 10,503, '04-06-2021');
insert into commettre values ('CV555OG', 4,6542, '26-06-2021');


----------------------------------------
--MOURONVAL Laurane
----------------------------------------

-- table propriétaire
insert into proprietaire values (248, 'Anne', 'Héantie', 'Samer');
insert into proprietaire values (124, 'Jacques', 'Célères', 'Socx');

-- table situation
insert into situation values (18, 'Parking de l||'||'IUT');
insert into situation values (19, 'Hotel de ville');
insert into situation values (20, 'Carrefour');
insert into situation values (21, 'Lycee Coubertin');

-- table voiture
insert into voiture values ( 'CH248AT', 'Fiat', 'multipla', 'kaki', 2);
insert into voiture values ( 'PA636IN', 'Porsche', '944 S', 'rouge', 17);
insert into voiture values ( 'QQ123PT', 'Renault', 'scenic', 'bleu', 248);
insert into voiture values ( 'FJ753DE', 'Peugeot', '206', 'blanche', 124);

----------------------------------------
--BUATHIER TOM
----------------------------------------

--table proprietaire
insert into proprietaire values (231, 'marc', 'marc', 'montreux');
insert into proprietaire values (432, 'melenchon', 'jean-luc', 'paris');
insert into proprietaire values (251, 'hugo', 'gilleron', 'wimereux');
insert into proprietaire values (322, 'quentin', 'halo', 'samer');
insert into proprietaire values (421, 'marina', 'pablo', 'new york');
insert into proprietaire values (323, 'hermes', 'elon', 'athenes');

--table voiture
insert into voiture values ( 'CLGHKOFD', 'citroen', 'C3', 'blanche', 2);
insert into voiture values ( '5D8F587S', 'BMW', 'M4', 'noir', 1);
insert into voiture values ( 'JOIZ734X', 'Dacia', 'sandero', 'marron', 4);
insert into voiture values ( 'LSCN8H7S', 'mercedes', 'amg', 'grise', 5);


----------------------------------------
--Hallot Hugo
----------------------------------------
-- table proprietaire
insert into proprietaire values (6969, 'marc', 'dutroux', 'Nice');
insert into proprietaire values (6970, 'jean', 'lassalle', 'Paris');
insert into proprietaire values (6971, 'pedro', 'claro', 'Paris');

-- table voiture
insert into voiture values ( 'OR323DI', 'FIAT', 'multipla', 'rouge', 6969);
insert into voiture values ( 'GERG3GH', 'fiat', 'multipla', 'beige', 6970);

--table situation
insert into situation values (6969, 'Gare de Lilles');
insert into situation values (6970, 'Theatre');
insert into situation values (6971, 'Piscine');

--table infraction
insert into infraction values (22233, 'classe2', 'Non-paiement d||'||'un péage ;', '75');

--table commettre 
insert into commettre values ('OR323DI', 6969,22233,'02-03-2420');

----------------------------------------
--VALLART Tom
----------------------------------------

-- table propriétaire
insert into proprietaire values (69, 'Zemmour', 'Éric', 'Neuilly-Sur-Seine');
insert into proprietaire values (696, 'Pecresse', 'Valérie', 'Paris');
insert into proprietaire values (70, 'Poutou', 'Phillipe', 'Paris')

-- table situation
insert into situation values (25, 'Autoroute A16');
insert into situation values (26, 'Champs Elysées');
insert into situation values (27, 'Parking Cité Europe');

-- table voiture
insert into voiture values ( 'R4C1ST3', 'Peugeot', '3008', 'blanche', 69);
insert into voiture values ( 'R1CH0U3', 'Lamborghini', 'Centenario', 'noire', 696);
insert into voiture values ( 'AP1F58F', 'Wolkswagen', 'T-Roc', 'grise', 70);
insert into voiture values ( 'TPDB3ST', 'Ferrari', '812 Competizione', 'grise', 71);

-----------------------------------------
-- BUGNON Lucas
-----------------------------------------

-- table situation 

insert into situation values (28, 'Plage de Calais');
insert into situation values (29, 'A26');
insert into situation values (30, 'Parking Cité Europe');
insert into situation values (31, 'Lycée Sophie Berthelot');

-- table commettre 

insert into commettre values('CH248AT', 28, 3813, '12-01-2022');
insert into commettre values('QQ123PT', 20, 4568, '04-12-2021');
insert into commettre values('FJ753DE', 30, 8403, '25-12-2020');
insert into commettre values('PA636IN', 18, 9995, '01-03-2022');
insert into commettre values('JDZIAQHF', 19, 6542, '24-03-2022');
insert into commettre values('5FQSDJQ2', 31, 4328, '19-05-2021');

-----------------------------------------
-- PAP Alexandre
-----------------------------------------

--table proprietaire
insert into proprietaire values (312, 'Roussy', 'Charles', 'calais');
insert into proprietaire values (220, 'Vanda', 'Georges', 'washington');
insert into proprietaire values (406, 'Herlock', 'Laurent', 'grande synthe');
insert into proprietaire values (240, 'Dauchot', 'Prat', 'saint omer');
insert into proprietaire values (321, 'Montrueu', 'Stephane', 'longuenesse');
insert into proprietaire values (254, 'Gorzo', 'Andre', 'dunkerque');

--table voiture
insert into voiture values ( 'LAKZLAZN', 'ALFA ROMEO', '75', 'blanche', 3);
insert into voiture values ( 'JAHZHE67', 'AIXAM', '500', 'grise', 5);
insert into voiture values ( 'IZAOZUE8', 'AIXAM', 'Crossline', 'bleue', 1);
insert into voiture values ( 'AMZLZO2E', 'ABARTH', '124', 'verte', 4);


-----------------------------------------
-- CREPIN Pierre
-----------------------------------------

-- table propriétaire
insert into proprietaire values (705, 'Lafarge', 'David', 'Bourg-palette');
insert into proprietaire values (706, 'Handshape', 'Tibo', 'Paris');
insert into proprietaire values (707, 'Feetcat', 'Juju', 'Paris')

-- table situation
insert into situation values (32, 'Route 112');
insert into situation values (33, 'Parking du temple');
insert into situation values (34, 'Félicity');
insert into situation values (35, 'Parking de la Ligue');

-- table voiture
insert into voiture values ( 'P1K4CHU', 'Audi', 'R8', 'jaune', 705);
insert into voiture values ( 'T3MPL35', 'Citröen', 'C4', 'marron', 706);
insert into voiture values ( 'V01TUR3', 'Renault', 'Z.E', 'vert', 707);

----
--CLEMENT DEKEISTER
-----

-- table situation 

insert into situation values (25, 'Place Jean Bart');
insert into situation values (26, 'Route de la Branche');
insert into situation values (27, 'A16');
insert into situation values (28, 'Rue Nelson Mandela');

-- table commettre 

insert into commettre values ('LPQF815V', 2,9524,'30-05-2010');
insert into commettre values ('ZS5ZFDPF', 2,5681,'16-10-2012');
insert into commettre values ('F85ZFDMF', 3,7895,'25-11-2015');
insert into commettre values ('ZEL5MLQ4', 6,3851,'19-12-2006');
insert into commettre values ('CHJ5MD53', 6,46431,'25-08-2021');



-- Pierre BISCARAS
--------------------------------
-- table proprietaire
insert into proprietaire values (101, 'Johnson', 'Dwayne', 'Los Angels');
insert into proprietaire values (102, 'Stark', 'Tony', 'Los Angels');

-- table voiture
insert into voiture values ( 'THE ROCK', 'ferrari', 'Ferrari Daytona SP3', 'rouge', 101);
insert into voiture values ( 'TONY', 'Audi', 'R8 V10+', 'blanche', 102);

-- table situation 

insert into situation values (32, 'Espace');
insert into situation values (33, 'Tour Avengers');
insert into situation values (34, 'Le temple');

-- table commettre 

insert into commettre values('TONY', 32, 5484, '24-07-2018');
insert into commettre values('TONY', 33, 4486, '28-12-2021');
insert into commettre values('THE ROCK', 34, 4542, '24-10-2022');


-- Corentin Bak
--------------------------------
-- table proprietaire
insert into proprietaire values (4789, 'Smith', 'Will', 'Los Angeles');
insert into proprietaire values (4790, 'Parker', 'Peter', 'New-York');

-- table voiture
insert into voiture values ( 'Will', 'ford', 'Ford Mustang gt500 shelby', 'rouge',4789);
insert into voiture values ( 'Peter', 'bmw', 'BMW m4', 'noire', 4790);

-- table situation 

insert into situation values (37, 'Souterrains de la MIB 10');
insert into situation values (38, 'Le queens');
insert into situation values (39, 'Oscorp');

-- table commettre 

insert into commettre values('Will', 37, 6789, '22-03-2000');
insert into commettre values('Peter', 38, 6549, '28-05-2002');
insert into commettre values('Peter', 39, 6908, '16-06-2006');

-- Bacquet Antoine
--------------------------------
-- table proprietaire
insert into proprietaire values (6520, 'Cellere', 'Jack', 'Montcucq');
insert into proprietaire values (6521, 'Térieur', 'Alex', 'Nantes');

-- table voiture
insert into voiture values ( 'Jack', 'Alpine', 'Alpine A110 GT', 'Bleu',6520);
insert into voiture values ( 'Alex', 'Porsche', 'Porsche Macan', 'Jaune', 6521);

-- table situation 

insert into situation values (30, 'Rue Louise Michel');
insert into situation values (32, 'Bercy');
insert into situation values (31, 'Lycée Édouard Branly');

-- table commettre 

insert into commettre values('Jack',41, 7560, '09-12-2002');
insert into commettre values('Jack', 42, 7864, '13-11-2002');
insert into commettre values('Jack', 43, 7945, '21-06-20013');

----------------------------------------
--Gilleron Quentin
----------------------------------------
-- table proprietaire
insert into proprietaire values (548, 'Jule', 'Romeo', 'Lille');
insert into proprietaire values (568, 'jean', 'Fala', 'Paris');
insert into proprietaire values (485, 'pedro', 'Ivala', 'Paris');

-- table voiture
insert into voiture values ( 'OP324DI', 'audi', 'RS3', 'noir', 548);
insert into voiture values ( 'GCRG8GK', 'fiate', 'multipla', 'beige', 568);

--table situation
insert into situation values (548, 'Piscine');
insert into situation values (568, 'Theatre');
insert into situation values (485, 'Gare du Nord');

--table infraction
insert into infraction values (22243, 'classe3', 'Ecces de vitesse de plus de 25 km/h;', '135');

--table commettre 
insert into commettre values ('OP324DI', 548,22243,'14-06-2021');

--------------------
-- Langrez Marine
--------------------------------

insert into situation values (45, 'Rue Voltaire');
insert into situation values (46, 'Boulevard Carnot');
insert into situation values (47, 'Grand ¨Place');

insert into commettre values ('CD857LP', 3,2943,'21-01-2014');
insert into commettre values ('WI111FI',  7,3813,'08-12-2007');
insert into commettre values ('VF458ZD', 5,5612,'01-04-2021');

insert into voiture values ( 'CD857LP', 'Twingo', 'III', 'rouge', 801);
insert into voiture values ( 'CZ85MCC', 'Audi', 'A3', 'noire', 802);

insert into proprietaire values (801, 'Martin', 'Jean', 'Lille');
insert into proprietaire values (802, 'Dubois', 'Jean', 'Marck');



-- Raphael Guarim
--------------------------------

-- table commettre 
insert into commettre values ('25900AD', 32,5671,'04-06-2020');
insert into commettre values ('G74B23Q', 21,4251,'01-11-2021');
insert into commettre values ('6QDR8G5', 39,4521,'06-02-2020');
insert into commettre values ('NA564BG', 44,8625,'02-09-2018');
insert into commettre values ('578A2W2', 58,3146,'02-11-2017');
insert into commettre values ('6N8THJ4', 62,5261,'19-09-2015');

-- table infraction 
insert into infraction values (4398, 'classe5', 'Defaut de permis', '1200');
insert into infraction values (1367, 'classe4', 'feu rouge non respoecté', '135');
insert into infraction values (2843, 'classe4', 'Excés de vitesse +20km/h', '135');
insert into infraction values (0345, 'classe4', 'Telephone au volant', '90');


-- Lilian Pouly
--------------------------------
-- table propriétaire
insert into proprietaire values (4791, 'Lebron', 'James', 'Los Angeles')
insert into proprietaire values (4792, 'Mercury', 'Freddy', 'Limoges')

--table voiture

insert into voiture values ( 'Lebron', 'Chevrolet', 'Chevrolet Camaro SS', 'blanc',4791);
insert into voiture values ( 'Lebron', 'Ferrari', 'Ferrari 458 Spider', 'Rouge',4791);
insert into voiture values ( 'Mercury', 'Rolls-Royce', 'Rolls-Royce Silver Shadow ', 'gris',4792);

-- table situation

insert into situation values (40, 'Crypto.com Arena');
insert into situation values (40, 'Cleveland');
insert into situation values(41, 'Stade de Wembley');


-- table commettre

insert into commettre values('Lebron', 40, 3333, '25-11-2005');
insert into commettre values('Mercury',41, 9876, '17-09-1978')


--------------------
-- Lutic Enzo
--------------------------------

-- table proprietaire
insert into proprietaire values (4793, 'Fauché', 'Jean', 'Arras');
insert into proprietaire values (4794, 'Larue', 'Mark', 'Lens');
insert into proprietaire values (4795, 'Mattiaq', 'Théo', 'Dunkerque');

-- table voiture
insert into voiture values ( 'EN78ZO9', 'peugeot', 'peugeot 206', 'noir', 4795);
insert into voiture values ( 'AZD54C6', 'citroen', 'c3 picasso', 'Kaki', 4793);

--table situation
insert into situation values (48, 'Cité Europe');
insert into situation values (49, 'Grand Théatre de Calais');
insert into situation values (50, 'Iceo');


--table commettre 
insert into commettre values ('EN78ZO9', 15,22243,'08-08-2022');
insert into commettre values ('AZD54C6', 20,22233,'10-08-2022');


-----------------------------------------
--           Houssam CUMZAIN           --
-----------------------------------------

-- table proprietaire
insert into proprietaire values (8000, 'Julien', 'Lang', 'Dunkerque');
insert into proprietaire values (8001, 'Abby', 'Campbell', 'Dunkerque');
insert into proprietaire values (8002, 'Houssam', 'Cumzain', 'Dunkerque');

-- table voiture
insert into voiture values ('PK48AF6', 'Audi', 'A3', 'noir', 8000);
insert into voiture values ('TC13RE8', 'Fiat', 'Multipla', 'rouge', 8001);
insert into voiture values ('LX69PD6', 'Citroen', 'C4', 'gris', 8002);

--table situation
insert into situation values (8000, 'Stade');
insert into situation values (8001, 'Mairie');
insert into situation values (8002, 'Gare de Dunkerque');

--table commettre 
insert into commettre values ('PK48AF6',8000,2548,'02-03-2420');
insert into commettre values ('TC13RE8',8001,0345,'02-03-2420');

--------------------
-- Lucie Le Fur
--------------------------------

-- table situation
insert into situation values (80, 'Engare a banane');
insert into situation values (81, 'Machine de l île');
insert into situation values (82, 'Livet');

-- table voiture
insert into voiture values ( 'CD857LP', 'AUDI', 'S8', 'blanc', 900);
insert into voiture values ( 'KAYOUKA', 'Citroen', 'C1', 'noire', 900);
insert into voiture values ( 'LULLFJC', 'Citroen', 'C5', 'grise', 888);

-- table proprietaire
insert into proprietaire values (900, 'Julie', 'Furet', 'Nantes');
insert into proprietaire values (888, 'Hugo', 'LeBlanc', 'Nantes');

-- table commettre
insert into commettre values('KAYOUKA',88, 4568, '01-01-2022');
insert into commettre values('LULLFJC', 99, 4568, '13-11-2002');


--Bernard Laetitia
--------------------------

--table propirietaire
insert into proprietaire values (7512, 'Braille', 'Jacqueline', 'Wittes');
insert into proprietaire values (7513, 'Lecigne', 'Bob', 'Berlin');

-- table voiture
insert into voiture values ( 'CV842', 'Infinity', 'QX60', 'Grise',7512);
insert into voiture values ( 'CV865CU''Alex', 'Lexus', 'UX 250h', 'marron', 7513);

insert into situation values (7513, 'Rue de la Fosse');
insert into situation values (7512, ' Bd de Courcelles');
insert into situation values (7511, 'Bd Gallieni');


-- table commettre 

insert into commettre values('Bob',71,7649 , '01-08-2010');
insert into commettre values('Jacqueline', 62, 5987, '19-01-1954');
insert into commettre values('Bob', 43, 4562, '12-11-2006');

----------------------------------------
-- FONTAINE Lucas
----------------------------------------

--table situation 
insert into situation values (22, 'Rue de Varenne');
insert into situation values (34, 'Lycée Leonard de Vinci');
insert into situation values (35, 'Rue de l||'||'eglise');
insert into siutation values (48, 'Route de Guines')
insert into situation values (50, 'Boulevard Carnot')

--table proprietaire
insert into proprietaire values(690,'Lizotte','Cecile','Sanghen');
insert into proprietaire values(476,'Deblois','Joseph','Paris');
insert into proprietaire values(55,'Leroux','Olivier','Calais');

--table voiture
insert into voiture values('WW813DQ', 'BMW', 'i3', 'noire', 690);
insert into voiture values('CQ251PB', 'Citroen', 'C1', 'bleu', 476);

-----------------------------------------
-- FOURNIER Benjamin
-----------------------------------------

-- table propriétaire
insert into proprietaire values (1201, 'GG', 'Chap', 'LaFaille');
insert into proprietaire values (1202, 'Vel', 'Koz', 'Neant');
insert into proprietaire values (1203, 'Arbre', 'Mojo', 'ForetKorogu')

-- table situation
insert into situation values (154, 'Topside');
insert into situation values (156, 'Jungle');
insert into situation values (158, 'Cocorico');
insert into situation values (160, 'Hyrule');

-- table voiture
insert into voiture values ( 'FF15PLS', 'Audi', 'R8', 'noire', 1201);
insert into voiture values ( 'X9TOPGG', 'Citroen', 'C4', 'bleue', 1202);
insert into voiture values ( 'AM0NGU5', 'Renault', 'Z.E', 'rouge', 1203);

-----------------------------------------
-- MALEBE Mayel
-----------------------------------------

-- table situation
insert into situation values (16000, 'Achat de crampons');
insert into situation values (16001, 'Vol de ballon');
insert into situation values (16002, 'Bagarre lors du match');

-- table voiture
insert into voiture values ( 'ZF743GP', 'AUDI', 'A4', 'noir', 800);
insert into voiture values ( 'COCACOLA', 'Citroen', 'C3', 'grise', 600);
insert into voiture values ( 'RCLENS', 'Porsche', 'Cayenne', 'Jaune', 788);

-- table proprietaire
insert into proprietaire values (16005, 'Dany', 'BIGBOSS', 'Nanterre');
insert into proprietaire values (16007, 'Rémi', 'Baptiste', 'Nanterre');

-- table commettre
insert into commettre values('Dany',26, 45680, '01-01-2001');
insert into commettre values('Rémi', 44, 45680, '21-05-2006');

-- Flament Marina

--table infraction
insert into infraction values (2309, 'classe2', 'Excès de vitesse', '135');
insert into infraction values (2503, 'classe3', 'Stupéfiant au volant', '4500');
insert into infraction values (6794, 'classe3', 'Alcoolémie dans le sang', '135');
insert into infraction values (1853, 'classe1', 'Stationnement gênant', '35');
insert into infraction values (8456, 'classe1', 'Contrôle radar', '33');

-- table commettre
insert into commettre values('EGT675YU',27, 4834, '12-08-2021');
insert into commettre values('BGH593RT',87, 5083, '23-04-2022');
insert into commettre values('OUI432ER',90, 1835, '09-12-2021');
insert into commettre values('ASU678OJ',24, 9824, '01-01-2022');
insert into commettre values('NDT098AS',12, 7356, '28-02-2022');

-------------------------------------------
-- DESSAILLY Léandre
-------------------------------------------

-- table proprietaire
insert into proprietaire values (9521, 'Bourdon', 'Didier', 'Frankfort')
insert into proprietaire values (9522, 'Evans', 'Mark', 'Chezpuquoi')
insert into proprietaire values (9523, 'Babie', 'Belle', 'Nielles-les-Blequin')

-- table situation
insert into situation values (562, 'Aquaponey')
insert into situation values (563, 'Uzbekistan')
insert into situation values (564, 'Garagiste')

-- table voiture
insert into voiture values ('R4AOZ56', 'Fiat', 'Punto', 'Verte', 9522)
insert into voiture values ('00XTK78', 'Tesla', 'S', 'Rose', 9521)
insert into voiture values ('XPA0UFX', 'Renault', 'Modus', 1)
insert into voiture values ('ACDCEXP', 'BMW', 'X1', 2)

-----------------------------------------
-- CREPIN Corentin
-----------------------------------------

-- table situation
insert into situation values (4380, 'Stade Pierre Mauroy');
insert into situation values (4381, 'Rue Solférino');
insert into situation values (4382, 'Rue Royale');
insert into situation values (4383, 'Place Crèvecoeur');

-- table voiture
insert into voiture values ( 'GY223HF', 'Ford', 'Fiesta', 'Grise', 1111);
insert into voiture values ( 'QP392TV', 'Audi', 'RS3', 'Noir', 1112);
insert into voiture values ( 'AS853HG', 'Porsche', '911', 'Grise', 1113);

-- table proprietaire
insert into proprietaire values(1111,'Chevalier','Lucas','Valenciennes');
insert into proprietaire values(1112,'David','Jonathan','Lille');
insert into proprietaire values(1113,'Galtier','Christophe','Nice');

--------------------
-- Martinet Romain
--------------------------------

-- table situation
insert into situation values (83, 'Route 66');
insert into situation values (84, 'Sous l ocean');
insert into situation values (20830, 'Nurburgring');

-- table proprietaire
insert into proprietaire values (4176, 'Albert', 'Muda', 'Mantes-la-Jolie');
insert into proprietaire values (1729, 'Jean', 'Titouplin', 'Quimper');

-- table voiture
insert into voiture values ( 'CZ65ZMZ', 'Ford', 'Fiesta', 'Violette', 4176);
insert into voiture values ( 'HAYAYA', 'Fiat', 'Tipo', 'Blanche', 4176);
insert into voiture values ( 'LOLCOF', 'Ferrari', 'Enzo', 'Bleu', 1729);


-- table commettre
insert into commettre values('CZ65ZMZ',3851, 15655, '17-09-2010');
insert into commettre values('HAYAYA', 2233, 14156, '21-05-2011');

--------------------------------
-- Lejeune Hugo
--------------------------------

-- table situation
insert into situation values (100, 'À la frontière');
insert into situation values (103, 'À séoul');
insert into situation values (104, 'Proche de la mer Rouge');

-- table proprietaire
insert into proprietaire values (700, 'Rider', 'Astolfo', 'Nouzily');
insert into proprietaire values (701, 'Dupont', 'Clothilde', 'calais');
insert into propirietaire values (702, 'Charlelie', 'Claude', 'Dunkerque');

-- table voiture
insert into voiture values ( 'PL123AK', 'Ferrarie', 'F40', 'Verte', 702);
insert into voiture values ( 'NR755BZ', 'Fiat', 'punto', 'Noir', 701);
insert into voiture values ( 'XX641CB', 'Citroen', 'Charleston', 'Rose', 700);


-- table commettre
insert into commettre values('XX641CB',100, 1249, '17-09-2010');

--------------------------------
-- Haffner Aurelian
--------------------------------

-- table commettre
insert into commettre values('PL123AK',1,2548, '16-09-2020');
insert into commettre values('NR755BZ', 4,1249, '21-05-2016');
insert into commettre values('CV555OG',14,4569, '16-09-2020');
insert into commettre values('LSQF845S',1,416, '21-05-2016');
insert into commettre values('FEZIAF8D',6,3851, '16-09-2020');
insert into commettre values('CLGHKOPP',3,5612, '21-05-2016');
insert into commettre values('LSQF8H7S',100,501, '16-09-2020');
insert into commettre values('JOIZ734X', 28,453, '21-05-2016');
insert into commettre values('LSCN8H7S',6969,32, '16-09-2020');
insert into commettre values('P1K4CHU', 26,22243, '21-05-2016');

----------------------------------------
-- Loridan Thomas
----------------------------------------
-- table proprietaire
 insert into proprietaire values (3, 'Boite', 'Jean', 'Villejuif');
 insert into proprietaire values (4, 'kivala', 'Eva', 'Killem');
 insert into proprietaire values (5, 'Musk', 'Xilon', 'Fucking');

-- table voiture
insert into voiture values ( 'CT244JO', 'toyota', 'Corolla', 'rouge', 18);
insert into voiture values ( 'DT253OL', 'fiat', 'Panda I', 'blanche', 4561);
insert into voiture values ( 'AH186SD', 'Jaguar', 'I-PACE', 'noire', 57412);

--table situation
insert into situation values (17851, 'Chez momo');
insert into situation values (4478, 'au PMU');

--table infraction
insert into infraction values (4215, 'classe1', 'Non respect des règles de stationnement.', '47');

--table commettre 
insert into commettre values ('J4B40UD', 354,19415,'22-05-2017');

----------------------------------------
-- Giniaux Anatole
----------------------------------------
-- table proprietaire
insert into proprietaire values (667, 'Afon', 'Ekip', 'Dakar');
insert into proprietaire values (668, 'Lancer', 'Karna', 'Kaurava');

--table situation
insert into situation values (758, 'au city');
insert into situation values (446, 'Accor Arena');
insert into situation values (8876, 'Stade de France');
insert into situation values (59741, 'Giverny');

--table infraction
insert into infraction values (48812, 'classe4', 'Pneus lisses', '135');

--table commettre 
insert into commettre values ('J4B40UD', 48812, 667,'22-05-2017');

-- table voiture
insert into voiture values ('NE284GR', 'Maserati', 'MC20', 'noire', 667);
insert into voiture values ('ZX857VP', 'Mercedes', 'Classe S', 'rouge', 668);
