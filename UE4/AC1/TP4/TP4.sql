/*###############################################
#################Lutic Enzo######################
#####################TP4#########################
#####################TPA#########################
##################26/04/2022#####################
###############################################*/

/*Question 1*/
/*Retrouvez la commande permettant de faire apparaître l’ensemble des tables catalogue du logiciel postgresql*/

select * from pg_tables where schemaname LIKE 'pg_catalog';

/*Le résultat*/

schemaname |        tablename        | tableowner | tablespace | hasindexes | hasrules | hastriggers | rowsecurity
------------+-------------------------+------------+------------+------------+----------+-------------+-------------
 pg_catalog | pg_statistic            | postgres   |            | t          | f        | f           | f
 pg_catalog | pg_type                 | postgres   |            | t          | f        | f           | f
 pg_catalog | pg_foreign_table        | postgres   |            | t          | f        | f           | f
 pg_catalog | pg_authid               | postgres   | pg_global  | t          | f        | f           | f
 pg_catalog | pg_statistic_ext_data   | postgres   |            | t          | f        | f           | f
[...]

/*Question2*/
/*Retrouvez la valeur du « search_path » dans les options (table pg_settings)*/

SELECT * FROM pg_settings WHERE name LIKE 'search_path';

/*Le résultat*/

    name     |     setting     | unit |                                   category                                    |                                 short_desc                                 | extra_desc | context | vartype | source  | min_val | max_val | enumvals |    boot_val     |    reset_val    | sourcefile | sourceline | pending_restart
-------------+-----------------+------+-------------------------------------------------------------------------------+----------------------------------------------------------------------------+------------+---------+---------+---------+---------+---------+----------+-----------------+-----------------+------------+------------+-----------------
 search_path | "$user", public |      | Valeurs par défaut pour les connexions client / Comportement des instructions | Initialise l ordre de recherche des schémas pour les noms qui ne précisent+|            | user    | string  | default |         |         |          | "$user", public | "$user", public |            |            | f
             |                 |      |                                                                               | pas le schéma.                                                             |            |         |         |         |         |         |          |                 |                 |            |            |
(1 row)

/*Question 3*/
/*Cherchez la commande qui permet de lister (avec le détail!) les schémas de la base de données*/

/*Premiere façon*/

SELECT nspname FROM pg_catalog.pg_namespace;

/*Deuxieme façon*/

SELECT schema_name FROM information_schema.schemata;

/*Le résultat*/

      nspname
--------------------
 pg_toast
 pg_catalog
 public
 information_schema
(4 rows)


--question 4--

SELECT COUNT(nspname) FROM pg_catalog.pg_namespace;

--question 5--

create table ordinateur (numordi int PRIMARY KEY, marqueordi varchar(20), prixordi int);

Create view COMPLET_ENSGNT as select EN.nomens, M.nommat from enseignants as EN INNER JOIN faire_cours AS F ON EN.numens = F.numens INNER JOIN matieres AS M ON F.nummat = M.nummat GROUP BY EN.nomens, M.nommat;

show search_path;

select schemaname from pg_tables where tablename like 'ordinateur';

drop table ordinateur;

grant all on schema "lutic.enzo" to "lejeune.hugo";
grant select on ETU2 to "lejeune.hugo";


grant all on COMPLET_ENSGNT to "lejeune.hugo";

grant update(note) on avoir_note to "lejeune.hugo";

grant all on table etudiants to "lejeune.hugo" ;

revoke all on etudiants from "lejeune.hugo" ;

revoke all on etudiants from "lejeune.hugo" ;

revoke all on avoir_note from "lejeune.hugo" ;

revoke all on ETU2 from "lejeune.hugo" ;

revoke all on COMPLET_ENSGNT from "lejeune.hugo" ;
