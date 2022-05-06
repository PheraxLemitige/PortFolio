Auteur: Lutic Enzo
SAE 1.01

3.2
calcule_jour 
	param
	 date : dict
	return
	 type : str
    Cette fonction renvoie le jour de la date donné en parametre

3.3
verif_jour_ajout
	param 
	 date : dict
	return
	 type : dict
  Dans cette fonction on verifie la date ou on a ajouté un jour

verif_jour_moins
	param 
	 date : dict
	return
	 type : dict
  Dans cette fonction on verifie la date ou on a envelé un jour
	
verif_mois_moins
	param 
	 date : dict
	return
	 type : dict
  Dans cette fonction on verifie si on doit passé une anné ou non

verif_mois_ajout
	param 
	 date : dict
	return
	 type : dict
  Dans cette fonction on verifie si on doit passé une anné ou non


calcule_veille_lendemain
	param 
	 date : dict
	return
	 type : tuple de dict
   Cette fonction renvoie un tuple de dictionnaire de date

3.4
ajoute_n_jour
	param 
	 date : dict
	return
      	 type : dict
  Cette fonction renvoie la date en ajoutant n jour

retranche_n_jour
	param 
	 date : dict
	return
	 type : dict
  Cette fonction renvoie la date en enlevant n jour

4.1
ajoute_fetes
	param
	 calendrier : list
	 annee : int
	No return
  Dans cette fonction on ajoute chaque évènement qui ne change pas de date

4.3
trouve_evenement
	param
	  calendrier : list
	  date : dict
	return
	  type : str ou none
  Dans cette fonction on cherche si un evenement existe

5.1
afficheur_mensuel
	param
	 calendrier : list
	 mois : int
	 annee : int
	no return
  Dans cette fonction on fait un affichage dans la console pour un mois à une année donné


