BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "categorie" (
	"pk_cat"	INTEGER PRIMARY KEY,
	"libelle"	TEXT
);
CREATE TABLE IF NOT EXISTS "client" (
	"pk_client"	INTEGER PRIMARY KEY,
	"nom"	TEXT,
	"email"	TEXT,
	"dept"	INTEGER,
	"latitude"	INTEGER,
	"longitude"	INTEGER
);
CREATE TABLE IF NOT EXISTS "devis" (
	"pk_devis"	INTEGER PRIMARY KEY,
	"ref"	TEXT,
	"fk_client"	INTEGER REFERENCES client(pk_client),
	"date"	TEXT
);
CREATE TABLE IF NOT EXISTS "produit" (
	"pk_produit"	INTEGER PRIMARY KEY,
	"ref"	TEXT,
	"libelle"	TEXT,
	"fk_cat"	INTEGER REFERENCES categorie(pk_cat),
	"pu_ht"	INTEGER
);
CREATE TABLE IF NOT EXISTS "ligne_des_devis" (
	"pk_ligne"	INTEGER PRIMARY KEY,
	"fk_devis"	INTEGER REFERENCES devis(pk_devis),
	"fk_produit"	INTEGER REFERENCES produit(pk_produit),
	"qty"	INTEGER
);


INSERT INTO "categorie" VALUES (1,'CAT_1');
INSERT INTO "categorie" VALUES (2,'CAT_2');
INSERT INTO "categorie" VALUES (3,'CAT_3');
INSERT INTO "categorie" VALUES (4,'CAT_4');
INSERT INTO "client" VALUES (1,'Client 1','email@client1.com',69,45.76695695,4.83288933);
INSERT INTO "client" VALUES (2,'Client 2','NULL',33,45.76526928,4.83411115);
INSERT INTO "devis" VALUES (1,'DEV-001',1,'2021-03-20');
INSERT INTO "devis" VALUES (2,'DEV-002',2,'2021-04-20');
INSERT INTO "devis" VALUES (3,'DEV-003',1,'2021-05-10');
INSERT INTO "produit" VALUES (1,'PDT_A','PRODUIT_A',1,150);
INSERT INTO "produit" VALUES (2,'PDT_B','PRODUIT_B',2,90);
INSERT INTO "produit" VALUES (3,'PDT_C','PRODUIT_C',2,45);
INSERT INTO "produit" VALUES (4,'PDT_D','PRODUIT_D',3,250);
INSERT INTO "produit" VALUES (5,'PDT_E','PRODUIT_E',1,30);
INSERT INTO "ligne_des_devis" VALUES (1,1,3,1);
INSERT INTO "ligne_des_devis" VALUES (2,2,2,3);
INSERT INTO "ligne_des_devis" VALUES (3,2,3,2);
INSERT INTO "ligne_des_devis" VALUES (5,3,2,5);
COMMIT;


SELECT C.nom, COUNT(D.pk_devis) from client AS C INNER JOIN devis AS D ON C.pk_client = D.fk_client GROUP BY C.nom;