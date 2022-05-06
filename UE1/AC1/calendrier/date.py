# Implémentation des dates et calendriers
# Implémentation des tests (voir main en fin de fichier)

from typing import Dict, List, Tuple, NoReturn



# =============================================================================
def est_bissextile(annee: int) -> bool :
    """
        retourne vrai si l'année est bissextile

        >>> est_bissextile(2020)
        True
        >>> est_bissextile(2021)
        False
        >>> est_bissextile(2022)
        False
        >>> est_bissextile(1900)
        False
        >>> est_bissextile(2000)
        True
    """ 
    
    # renvoie true ou False si c'est bissextile
    if (annee % 4 == 0 and annee % 100 != 0) or annee % 400 == 0:
        return(True)
    else:
        return(False)

# =============================================================================
def cree_date(j: int, m: int, a: int) -> Dict :
    """
    Crée une date à partir des entiers la décrivant.
    Si l'un des paramètres n'est pas un entier, la fonction retournera None

    >>> cree_date(15,12,2020)
    {'jour': 15, 'mois': 12, 'annee': 2020}
    >>> cree_date(1.5,12,2020)

    """
    
    #renvoie la date en dico
    if type(j) == int and type(m) == int and type(a) == int:
        return ({'jour': j, 
                 'mois': m, 
                 'annee': a})


    
# =============================================================================
def copie_date(date: Dict) -> Dict :
    """
    copie la date passée en paramètre
    """
    
    #renvoie une copie de la date
    dico = cree_date(date['jour'], date['mois'], date['annee'])
    return dico

    
# =============================================================================
def compare(d1: Dict, d2: Dict) -> int :
    """
    Permet de classer deux dates.
    Retourne
    -1 si la date d1 < d2
    +1 si la date d1 > d2
    0 si les dates sont identiques
    on considère que les dates sont croissantes 
    dans l'ordre chronologique

    >>> date1 = cree_date(25,12,2021)
    >>> date2 = cree_date(31,12,2021)
    >>> compare(date1,date2)
    -1
    >>> compare(date2,date1)
    1
    >>> compare(date1,date1)
    0
    >>> date1 = cree_date(15,11,2021)
    >>> date2 = cree_date(10,12,2021)
    >>> compare(date1,date2)
    -1
    >>> compare(date2,date1)
    1
    >>> compare(date1,date1)
    0
    """
    
    #On test l'année 
    if d1['annee'] < d2['annee']:
        return (-1)
    elif d1['annee'] > d2['annee']:
        return (1)
    
    else:
        #On test le mois
        if d1['mois'] < d2['mois']:
            return (-1)
        elif d1['mois'] > d2['mois']:
            return(1)
        
        else:
            #On test le jours
            if d1['jour'] < d2['jour']:
                return(-1)
            elif d1['jour'] > d2['jour']:
                return(1)
            
            #On arrive ici si tout est égal
            else:
                return(0)

# =============================================================================
def valide_simple(d: Dict) -> bool :
    """   
    retourne vrai si la date est valide.
    on supposera que la date est valide si :
    - si le premier (le jour) est un entier compris entre 1 et 31
    - si le second (le mois) est un entier compris entre 1 et 12

    >>> date = cree_date(1, 2, 0)
    >>> valide_simple(date)
    True
    >>> date = cree_date(1.5, 5, 6)
    >>> valide_simple(date)
    False
    >>> date = cree_date(0, 5, 6)
    >>> valide_simple(date)
    False
    >>> date = cree_date(20, 8, 2021)
    >>> valide_simple(date)
    True
    """
    
    #Si le dico est vide on renvoie False sinon on test si chaque jour/mois depasse pas 31/12
    if d == None:
        return(False)
    else:
        return(not(d['jour'] > 31 or d['mois'] > 12 or d['jour'] <= 0 or d['mois'] <= 0))
    

# =============================================================================
def valide_complet(d: Dict) -> bool :
    """ 
    retourne vrai si la date est valide.
    on supposera que la date est valide si :
    - la validation simple est vraie
    - si la date représente une date réelle 

    >>> date = cree_date(15, 1, 2022)
    >>> valide_complet(date)
    True
    >>> date = cree_date(32, 1, 2022)
    >>> valide_complet(date)
    False
    >>> date = cree_date(-1, 1, 2022)
    >>> valide_complet(date)
    False
    >>> date = cree_date(31, 6, 2022)
    >>> valide_complet(date)
    False
    >>> date = cree_date(29, 2, 2020)
    >>> valide_complet(date)
    True
    >>> date = cree_date(29, 2, 2022)
    >>> valide_complet(date)
    False
    """
    
    #si le test de valide simple passe
    if valide_simple(d) :
        
        #on test pour fevrier
        if d['mois'] == 2:
            if d['jour'] < 29:
                return(True)
            elif d['jour'] == 29 and est_bissextile(d['annee']):
                return(True)
            else:
                return (False)
            
        #on test pour les jour de 30 jour
        elif d['jour'] < 30:
            return(True)
        
        #pour les jours de 31 jour
        elif d['mois'] < 8:
            return(d['mois'] % 2 == 1)
        else:
            return(d['mois'] % 2 == 0)
    else:
        return(False)

# =============================================================================
def ajoute_calendrier(calendrier: List, date: Dict, description: str ) -> NoReturn :
    """
    ajoute un élément à la liste du calendrier.
    """
    
    #on ajoute un dico dans le calendrier
    if valide_complet(date):
        la_date = {'date' : date, 'description' : description}
        calendrier.append(la_date)
            

    
# =============================================================================
def affiche_calendrier(calendrier: List) -> NoReturn :
    """
    affiche le calendrier sous forme de liste.
    """
    
    le_calendrier = ''
    
    #on va ajouter chaque ligne pour les print au final
    for date in calendrier:
        chaine = 'Le ' + str(date['date']['jour']) + '/' + str(date['date']['mois']) + '/' + str(date['date']['annee']) + ':' + date['description'] + '\n'
        le_calendrier += chaine
    print(le_calendrier)
    
    
# =============================================================================

# =============================================================================

def calcule_jour( date : Dict ) -> str:
    """
    Cette fonction renvoie le jour de la date donné en parametre
    
    >>> calcule_jour(cree_date (8 ,12 ,2021 ))
    'mercredi'
    
    >>> calcule_jour(cree_date (11 ,12 ,2022))
    'dimanche'
    """
    
    #Cela donne le jours de la semaine selon une date 
    les_jours = {1 : 'lundi', 2: 'mardi', 3: 'mercredi', 4: 'jeudi', 5 : 'vendredi', 6 :'samedi', 0 : 'dimanche'}
    c = (14 - date['mois']) // 12
    annee = date['annee'] - c
    mois = date['mois'] + 12 * c - 2
    jour = (date['jour'] + annee + annee//4 - annee//100 + annee // 400 + (31 * mois) // 12) % 7
    return les_jours[jour]

# =============================================================================

def calcule_veille_lendemain (date : Dict) -> Tuple [ Dict , Dict ]:
    """
    Cette fonction renvoie un tuple de dictionnaire de date
    
    >>> calcule_veille_lendemain(cree_date(19, 11, 2021))
    ({'jour': 18, 'mois': 11, 'annee': 2021}, {'jour': 20, 'mois': 11, 'annee': 2021})
    
    >>> calcule_veille_lendemain(cree_date(31, 12, 2021))
    ({'jour': 30, 'mois': 12, 'annee': 2021}, {'jour': 1, 'mois': 1, 'annee': 2022})
    
    """
    
    #On definie date_veille et date_lend
    date_veille = cree_date(date['jour'] - 1, date['mois'], date['annee']) 
    date_lend = cree_date(date['jour'] + 1, date['mois'], date['annee'])
    
    #On verifie pour chacune des dates si le jours n'est pas trop loin
    date_lend = verif_jour_ajout(date_lend)
    date_veille = verif_jour_moins(date_veille)
    
    #on verifie le mois
    veille_lend = (verif_mois_moins(date_veille), verif_mois_ajout(date_lend))
    return veille_lend
    
def verif_jour_ajout ( date : Dict ):
    """
    Dans cette fonction on verifie la date ou on a ajouté un jour
    
    >>> date_lend = cree_date(1 + 1, 11, 2022)
    >>> verif_jour_ajout(date_lend)
    {'jour': 2, 'mois': 11, 'annee': 2022}
    
    >>> date_lend = cree_date(30 + 1, 11, 2022)
    >>> verif_jour_ajout(date_lend)
    {'jour': 1, 'mois': 12, 'annee': 2022}
    """
    
    #on vérifie pour les mois de 31 jours
    if ((date['mois'] < 8 and date['mois'] % 2 == 1) or (date['mois'] > 8 and date['mois'] % 2 == 0)):
        if date['jour'] == 32:
            date['jour'] = 1
            date['mois'] += 1
            
    #on vérifie pour février
    elif (date['mois'] == 2):
        if est_bissextile(date) and date['jour'] == 30:
            date['jour'] = 1
            date['mois'] += 1
        elif date['jour'] == 29:
            date['jour'] = 1
            date['mois'] += 1
            
    #on vérifie pour le reste donc les mois de 30 jours
    else:
        if date['jour'] == 31:
            date['jour'] = 1
            date['mois'] += 1
    return date 

def verif_jour_moins ( date : Dict ):
    """
    Dans cette fonction on verifie la date ou on a envelé un jour
    >>> date_veille = cree_date(11 - 1, 11, 2022)
    >>> verif_jour_moins(date_veille)
    {'jour': 10, 'mois': 11, 'annee': 2022}
    
    >>> date_veille = cree_date(1 - 1, 11, 2022)
    >>> verif_jour_moins(date_veille)
    {'jour': 31, 'mois': 10, 'annee': 2022}
    """
    
    #on verifie si jours est egale a 0 donc si on dois changer de mois
    if date['jour'] == 0:
        date['mois'] -= 1
        
        #on fait pour les mois de 31 jours
        if ((date['mois'] < 8 and date['mois'] % 2 == 1) or (date['mois'] > 8 and date['mois'] % 2 == 0) or date['mois'] == 0):
            date['jour'] = 31
            
        #on fait pour février
        elif (date['mois'] == 2):
            if est_bissextile(date):
                date['jour'] = 29
            else:
                date['jour'] = 28
                
        #on fait pour les mois de 30 jours
        else:
            date['jour'] = 30
    return date

def verif_mois_moins (date_veille):
    """
    Dans cette fonction on verifie si on doit passé une anné ou non
    >>> date_veille = verif_jour_moins(cree_date(1 - 1, 1, 2023))
    >>> verif_mois_moins(date_veille)
    {'jour': 31, 'mois': 12, 'annee': 2022}
    
    >>> date_veille = verif_jour_moins(cree_date(31 - 1, 1, 2022))
    >>> verif_mois_moins(date_veille)
    {'jour': 30, 'mois': 1, 'annee': 2022}
    """
    
    #on teste pour la veille
    if date_veille['mois'] == 0:
        date_veille['mois'] = 12
        date_veille['annee'] -= 1
    return date_veille
        
def verif_mois_ajout (date_lend):
    """
    Dans cette fonction on verifie si on doit passé une anné ou non
    >>> date_lend = verif_jour_ajout(cree_date(1 + 1, 1, 2023))
    >>> verif_mois_ajout(date_lend)
    {'jour': 2, 'mois': 1, 'annee': 2023}
    
    >>> date_lend = verif_jour_ajout(cree_date(31 + 1, 12, 2022))
    >>> verif_mois_ajout(date_lend)
    {'jour': 1, 'mois': 1, 'annee': 2023}
    """
    
    #on teste pour le lendemain
    if date_lend['mois'] == 13:
        date_lend['mois'] = 1
        date_lend['annee'] += 1
    return (date_lend)

# =============================================================================
def ajoute_n_jour ( date : Dict , n: int ) -> Dict :
    """
    Cette fonction renvoie la date en ajoutant n jour
    >>> date_n = cree_date(10, 1, 2022)
    >>> ajoute_n_jour (date_n, 10)
    {'jour': 20, 'mois': 1, 'annee': 2022}
    
    >>> date_n = cree_date(31, 12, 2022)
    >>> ajoute_n_jour (date_n, 10)
    {'jour': 10, 'mois': 1, 'annee': 2023}
    """
    
    date_lend = copie_date(date)
    #on va ajouter n jour 1 par 1
    for i in range (n):
        date_lend = cree_date(date_lend['jour'] + 1, date_lend['mois'], date_lend['annee'])
        date_lend = verif_jour_ajout(date_lend)
        date_lend = verif_mois_ajout(date_lend)
    return date_lend

def retranche_n_jour ( date : Dict , n: int ) -> Dict :
    """
    Cette fonction renvoie la date en enlevant n jour
    >>> date_n = cree_date(31, 12, 2022)
    >>> retranche_n_jour(date_n, 10)
    {'jour': 21, 'mois': 12, 'annee': 2022}
    
    >>> date_n = cree_date(1, 1, 2022)
    >>> retranche_n_jour(date_n, 10)
    {'jour': 22, 'mois': 12, 'annee': 2021}
    """
    
    date_veille = copie_date(date)
    #on va enlever n jour 1 par 1
    for i in range (n):
        date_veille = cree_date(date_veille['jour'] - 1, date_veille['mois'], date_veille['annee'])
        date_veille = verif_jour_moins(date_veille)
        date_veille = verif_mois_moins(date_veille)
    return date_veille

# =============================================================================


def ajoute_fetes( calendrier : List , annee : int ) -> NoReturn :
    """
    Dans cette fonction on ajoute chaque évènement qui ne change pas de date
    """
    
    #on ajoute toutes les dates
    ajoute_calendrier(calendrier, cree_date (25 ,12 ,annee ), 'Noel')
    ajoute_calendrier(calendrier, cree_date (1 ,1 ,annee ), 'Jour de l’an' )
    ajoute_calendrier(calendrier, cree_date (1 ,5 ,annee ), 'Fête du travail')
    ajoute_calendrier(calendrier, cree_date (8 ,5 ,annee ), 'Armistice 1945')
    ajoute_calendrier(calendrier, cree_date (21 ,6 ,annee ), 'Fête de la musique')
    ajoute_calendrier(calendrier, cree_date (14 ,7 ,annee ), 'Fête nationale')
    ajoute_calendrier(calendrier, cree_date (15 ,8 ,annee ), 'Assomption')
    ajoute_calendrier(calendrier, cree_date (1 ,11 ,annee ), 'Toussaint')
    ajoute_calendrier(calendrier, cree_date (31 ,10 ,annee ), 'Halloween')
    
# =============================================================================
    
def trouve_evenement (calendrier : List , date : Dict) -> str:
    """
    Dans cette fonction on cherche si un evenement existe
    
    >>> calendrier = [ ]
    >>> ajoute_fetes(calendrier, 2022)
    >>> trouve_evenement (calendrier, cree_date(25 ,12 , 2022))
    'Noel'
    
    >>> calendrier = [ ]
    >>> ajoute_fetes(calendrier, 2022)
    >>> trouve_evenement (calendrier, cree_date(1 ,1 , 2022))
    'Jour de l’an'
    """
    
    #on va vérifier pour chaques événements
    for date_event in calendrier:
        if compare(date, date_event['date']) == 0:
            return (date_event['description'])
    return(None)


# =============================================================================


def afficheur_mensuel (calendrier : List, mois : int, annee : int) -> NoReturn:
    """
    Dans cette fonction on fait un affichage dans la console pour un mois à une année donné
    """
    
    les_mois = {1 : 'janvier', 2 : 'février', 3: 'mars', 4 : 'avril', 5 : 'mai', 6 :'juin', 7 : 'juillet', 8 : 'aout', 9 : 'septembre',10 : 'octobre', 11 : 'novembre', 12 : 'décembre'}
    le_calendrier = '** ' + les_mois[mois] + ' ' + str(annee) + ' **' + '\n'
    la_date = 0
    #on va de 1 à 32 jours non compris
    for i in range (1, 32):
        la_date = cree_date(i, mois, annee)
        #si on depasse selon le mois on sort de la boucle for
        if (est_bissextile(annee) and i == 30 and mois == 2) or (i == 28 and mois == 2) or (mois in [4, 6, 9, 11] and i == 31):
            break
        #s'il n'y a pas de d'événement
        elif trouve_evenement(calendrier, la_date) == None:
            le_calendrier += calcule_jour(la_date) + ' ' + str(i) + ' : \n'
        #s'il y a un événement
        else:
            le_calendrier += calcule_jour(la_date) + ' ' + str(i) + ' : ' + trouve_evenement(calendrier, la_date) +  '\n'
    print(le_calendrier)
    
    
    
# =============================================================================    
if __name__ == '__main__':
    import doctest
    doctest.testmod(verbose=True)

# %%
