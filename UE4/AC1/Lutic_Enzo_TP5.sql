/*/////////////////////////////////////
//////////////////////////////////////
//////////////Lutic Enzo//////////////
/////////////////TP5//////////////////
/////////////////TPA/////////////////
/////////////////////////////////////
////////////////////////////////////
*/

--Réalisez les actions suivantes(les 7 premieres QUESTIONs).

--QUESTION 1
--Expliquez l’effet de chaque action et l'utilité des tables sur lesquelles la requête travaille : 

--REQUETE 1
SELECT schemaname, tablename from pg_tables;

--RESULTAT


     schemaname     |        tablename
--------------------+-------------------------
 public             | modules
 public             | matieres
 public             | enseignants
 public             | epreuves
 public             | etudiants
 public             | avoir_note
 public             | faire_cours
 pg_catalog         | pg_statistic
 pg_catalog         | pg_type
 pg_catalog         | pg_foreign_table
 pg_catalog         | pg_authid
 pg_catalog         | pg_statistic_ext_data
 [...]

--EXPLICATION

/*
    Cette commande affiche le nom du shema ou est presente les tables, 
    les 7 premieres tables sont les tables qu'on a crée donc elles sont en public 
    et le reste sont des tables systemes
*/

--REQUETE 2
SELECT schemaname, tablename from pg_tables where tableowner=USER;

--RESULTAT

 schemaname |  tablename
------------+-------------
 public     | modules
 public     | matieres
 public     | enseignants
 public     | epreuves
 public     | etudiants
 public     | avoir_note
 public     | faire_cours
(7 rows)

--EXPLICATION

/*
    Cette commande va trouvé les tables crée par l'utilisateur auquelle on est connecté. 
    Il va affiché dans quelle shema ils sont present et leurs noms
*/

--REQUETE 3
SELECT * from pg_views;

--RESULTAT

     schemaname     |               viewname                | viewowner |               definition                                                                                                                    
--------------------+---------------------------------------+-----------+---------------------------------------------------------
 public             | note_anglais                          | enzolutic |  SELECT a.numepr,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         +
                    |                                       |           |     ep.libepr,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            +
                    |                                       |           |     et.nometu,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            +
                    |                                       |           |     a.note                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                +
                    |                                       |           |    FROM (((avoir_note a                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   +
                    |                                       |           |      JOIN epreuves ep ON ((a.numepr = ep.numepr)))                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        +
                    |                                       |           |      JOIN etudiants et ON ((a.numetu = et.numetu)))                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       +
                    |                                       |           |      JOIN matieres m ON ((m.nummat = ep.matepr)))                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         +
                    |                                       |           |   WHERE ((m.nommat)::text = 'anglais'::text);
 pg_catalog         | pg_shadow                             | postgres  |  SELECT pg_authid.rolname AS usename,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     +
                    |                                       |           |     pg_authid.oid AS usesysid,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            +
                    |                                       |           |     pg_authid.rolcreatedb AS usecreatedb,                                                                                                                                                                                                                                                                                                                   :
[...]
--EXPLICATION

/*
    Cette commande donne toute les informations sur les vue de la base de donnée et les vue du systeme.
    On peut voir le shema ou il se trouve, le nom de la vue, celui qui la crée et ce qui definie la vue
*/

--REQUETE 4
SELECT * FROM pg_indexes WHERE tablename IN (SELECT tablename FROM pg_tables WHERE tableowner=USER);

--RESULTAT

 schemaname |  tablename  |    indexname     | tablespace |                                            indexdef
------------+-------------+------------------+------------+------------------------------------------------------------------------------------------------
 public     | etudiants   | etudiants_pkey   |            | CREATE UNIQUE INDEX etudiants_pkey ON public.etudiants USING btree (numetu)
 public     | modules     | modules_pkey     |            | CREATE UNIQUE INDEX modules_pkey ON public.modules USING btree (nummod)
 public     | faire_cours | faire_cours_pkey |            | CREATE UNIQUE INDEX faire_cours_pkey ON public.faire_cours USING btree (numens, nummat, annee)
 public     | avoir_note  | avoir_note_pkey  |            | CREATE UNIQUE INDEX avoir_note_pkey ON public.avoir_note USING btree (numetu, numepr)
 public     | matieres    | matieres_pkey    |            | CREATE UNIQUE INDEX matieres_pkey ON public.matieres USING btree (nummat)
 public     | epreuves    | epreuves_pkey    |            | CREATE UNIQUE INDEX epreuves_pkey ON public.epreuves USING btree (numepr)
 public     | enseignants | enseignants_pkey |            | CREATE UNIQUE INDEX enseignants_pkey ON public.enseignants USING btree (numens)
(7 rows)

--EXPLICATION

/*
    Cette commande met toute les clé primaires de chaque tables crée par le user auquelle on est connecté
*/

--REQUETE 5
SELECT * FROM pg_user ;

--RESULTAT

  usename  | usesysid | usecreatedb | usesuper | userepl | usebypassrls |  passwd  | valuntil | useconfig
-----------+----------+-------------+----------+---------+--------------+----------+----------+-----------
 postgres  |       10 | t           | t        | t       | t            | ******** |          |
 enzo      |    16394 | t           | f        | f       | f            | ******** |          |
 enzolutic |    16396 | f           | t        | f       | f            | ******** |          |
(3 rows)

--EXPLICATION

/*
    Cette commande nous presente toute les information sur chaque utilisateur, le nom, son id, son mot de passe et plusieurs autre valeurs
*/

--REQUETE 6
SELECT relname, conname, consrc FROM pg_class INNER JOIN pg_constraint ON relfilenode=conrelid;

--la collonne consrc n'existe plus sur cette version donc on va faire sans.

SELECT relname, conname FROM pg_class INNER JOIN pg_constraint ON relfilenode=conrelid;

--RESULTAT

                 relname                 |           conname
-----------------------------------------+------------------------------
 modules                                 | modules_pkey
 matieres                                | fk_matieres_nummod
 matieres                                | matieres_pkey
 enseignants                             | enseignants_pkey
 epreuves                                | fk_epreuves_nummat
 epreuves                                | fk_epreuves_numens
 epreuves                                | epreuves_pkey
 etudiants                               | etudiants_pkey
 avoir_note                              | fk_avoir_note_numepr
 avoir_note                              | fk_avoir_note_numetu
 avoir_note                              | avoir_note_pkey
 faire_cours                             | fk_faire_cours_nummat
 faire_cours                             | fk_faire_cours_numens
 faire_cours                             | faire_cours_pkey
 pg_type                                 | yes_or_no_check
 pg_type                                 | cardinal_number_domain_check
 pg_toast_1255                           | yes_or_no_check
 pg_toast_1255                           | cardinal_number_domain_check
 pg_toast_1255_index                     | yes_or_no_check
 pg_toast_1255_index                     | cardinal_number_domain_check
 pg_toast_1247                           | yes_or_no_check
 pg_toast_1247                           | cardinal_number_domain_check
 pg_toast_1247_index                     | yes_or_no_check
 pg_toast_1247_index                     | cardinal_number_domain_check
 pg_toast_1260                           | yes_or_no_check
 pg_toast_1260                           | cardinal_number_domain_check
 pg_toast_1260_index                     | yes_or_no_check
 pg_toast_1260_index                     | cardinal_number_domain_check
 pg_toast_1262                           | yes_or_no_check
 pg_toast_1262                           | cardinal_number_domain_check
 pg_toast_1262_index                     | yes_or_no_check
 [...]

--EXPLICATION
--REQUETE 7
SELECT datname, usename from pg_database inner join pg_user on datdba=usesysid where usename=user;

--RESULTAT

      datname       |  usename
--------------------+-----------
 tp1                | enzolutic
 bdd2               | enzolutic
 mabase_lutic       | enzolutic
 ma_base_lutic      | enzolutic
 iut_lutic          | enzolutic
 course_lutic       | enzolutic
 test               | enzolutic
 employe_lutic      | enzolutic
 groupenumero_23    | enzolutic
 lutic_db_iut       | enzolutic
 police             | enzolutic
 lutic_privilegebdd | enzolutic
(12 rows)

--EXPLICATION

--affiche le nom des bases créés par le user.


--QUESTION 9

-- Retrouver le nom des bases de données ainsi que le nom de leur propriétaire et son type d'encodage.

select datdba, oid,datname FROM pg_database;

 datdba |  oid   |     datname
--------+--------+-----------------
     10 |  13427 | postgres
  16384 |  16385 | tp1
     10 |      1 | template1
     10 |  13426 | template0
  16384 |  16386 | bdd2
  16384 |  24576 | mabase_lutic
  16384 |  49152 | iut_lutic
  16384 |  65541 | course_lutic
  16384 |  73728 | entrainement
  16384 |  81920 | bdd_employe_lutic
  16384 |  90112 | groupenumero_23
  16384 |  98304 | lutic_db_iut
  16384 | 131118 | lutic_police
(13 rows)
--QUESTION 10
-- Retrouver les informations des contraintes dans les tables contenues dans le schéma « information_schema ». 

select conname FROM pg_constraint as c inner join pg_namespaces as n on c.connamespace=N.oid 
inner join pg_tables as t on n.nspname=t.schemaname WHERE schemaname like 'information_schema';

           conname
------------------------------
 yes_or_no_check
 cardinal_number_domain_check
 yes_or_no_check
 cardinal_number_domain_check
 yes_or_no_check
 cardinal_number_domain_check
 yes_or_no_check
 cardinal_number_domain_check
 yes_or_no_check
 cardinal_number_domain_check
 yes_or_no_check
 cardinal_number_domain_check
 yes_or_no_check
 cardinal_number_domain_check
(14 rows)

--QUESTION 13
-- Lister les nom, prénom et âge des étudiants.

SELECT nometu, prenometu,  age(datenaietu) FROM etudiants;

--RESULTAT

   nometu    | prenometu |           age
-------------+-----------+--------------------------
 roblin      | lea       | 47 years 3 mons 27 days
 athur       | leon      | 48 years 28 days
 minol       | luc       | 45 years 1 mon 29 days
 bagnole     | sophie    | 46 years 1 mon 20 days
 bury        | marc      | 49 years 3 mons 5 days
 vendraux    | marc      | 46 years 3 mons 20 days
 vendermaele | helene    | 46 years 1 mon 11 days
 besson      | loic      | 43 years 11 mons 20 days
 jean-paul   | godard    | 48 years 10 mons 28 days
 beaux       | marie     | 47 years 28 days
 turini      | elsa      | 45 years 9 mons 24 days
 torelle     | elise     | 47 years 24 days
 pharis      | pierre    | 44 years 1 mon 23 days
 ephyre      | luc       | 46 years 3 mons 20 days
 leclercq    | jules     | 44 years 11 mons 22 days
 dupont      | luc       | 45 years 6 mons 8 days
 marke       | loic      | 46 years 5 mons 28 days
 dewa        | leon      | 47 years 1 mon 7 days
(18 rows)

--QUESTION 14
-- Lister les nom, prénom des étudiants (dans une seule colonne avec des chaînes concaténées) ainsi 
-- que le mois de leur naissance. 

select nometu||prenometu||extract(month FROM datenaietu) FROM etudiants;

--RESULTAT

--------------------
 roblinlea1
 athurleon4
 minolluc3
 bagnolesophie3
 burymarc2
 vendrauxmarc1
 vendermaelehelene3
 bessonloic5
 jean-paulgodard6
 beauxmarie4
 turinielsa7
 torelleelise4
 pharispierre3
 ephyreluc1
 leclercqjules5
 dupontluc11
 markeloic11
 dewaleon4
(18 rows)

--QUESTION 15
-- Idem que la question précédente en remplaçant toutes les occurrences de 'MA' par 'TU'.

select replace(nometu,'ma','tu')||replace(prenometu,'ma','tu')||extract(month FROM datenaietu) FROM etudiants;

--RESULTAT

      ?column?
--------------------
 roblinlea1
 athurleon4
 minolluc3
 bagnolesophie3
 buryturc2
 vendrauxturc1
 vendertuelehelene3
 bessonloic5
 jean-paulgodard6
 beauxturie4
 turinielsa7
 torelleelise4
 pharispierre3
 ephyreluc1
 leclercqjules5
 dupontluc11
 turkeloic11
 dewaleon4
(18 rows)

--QUESTION 16
-- Lister les nom, prénom et note des étudiants seulement si celle-ci est supérieure à 3 fois pi. 

select P.nometu,P.prenometu,A.note FROM etudiants as P inner join avoir_note as A on P.numetu=A.numetu WHERE A.note > pi()*3;

--RESULTAT

   nometu    | prenometu | note
-------------+-----------+------
 roblin      | lea       |   15
 bagnole     | sophie    |   11
 bury        | marc      |   15
 vendraux    | marc      |   16
 dewa        | leon      |   11
 roblin      | lea       |   12
 athur       | leon      |   12
 bagnole     | sophie    |   15
 vendraux    | marc      |   11
 vendermaele | helene    |   13
 marke       | loic      |   19
 jean-paul   | godard    |   14
 beaux       | marie     |   14
 turini      | elsa      |   11
 ephyre      | luc       |   20
 leclercq    | jules     |   12
 dupont      | luc       |   11
 jean-paul   | godard    |   11
 beaux       | marie     |   12
 torelle     | elise     |   20
 pharis      | pierre    |   12
 ephyre      | luc       |   10
 dupont      | luc       |   10
(23 rows)