import sys
import random

MAX_LONGUEUR = 10
MAX_LARGEUR = 10
NOM_BATEAU = ['Porte-avions','Croiseur', 'Destroyer', 'Torpilleur']
TAILLE_BATEAU = [5, 4, 3, 2]

def creation_plateau ():
    """On va créer un plateau de jeux vide

    Returns:
        tableau: c'est un tableau qui contient que des case vide
    """
    grille = []
    #On va répèter pour chaque ligne
    for i in range(MAX_LONGUEUR):
        case = []
        #on va remplir notre ligne en répètant pour chaque colonne
        for j in range(MAX_LARGEUR):
            case.append({'contenu' : 'Eau', 'numero' : 0, 'etat' : 'Neuf'})
        #On ajoute la ligne a la grille
        grille.append(case)
    return grille


def coordonnees_bateau(longueur_grille, nbr_case_utile):
    """Cette fonction renvoie les coordonnées choisit au hasard pour un bateau d'une certaine taille 

    Args:
        longueur_grille (entier): c'est la longueur du tableau
        nbr_case_utile (entier): c'est le nombre de case que le bateau va prendre

    Returns:
        str: c'est l'orientation du bateau donc horizontal ou vertical
    """
    #On choisit au hasard si le bateau est vertical ou horizontal
    if(random.randint(0,1) == 0):
        orientation = 'Horizontal'
        
    else:
        orientation = 'Vertical'
    #On choisit au hasard ses coordonnées
    if(orientation == 'Horizontal'):
        hauteur = random.randint(0, longueur_grille - 1)
        largeur = random.randint(0, longueur_grille - nbr_case_utile)
        
    else:
        hauteur = random.randint(0, longueur_grille - nbr_case_utile)
        largeur = random.randint(0, longueur_grille - 1)
        
    return orientation, (hauteur, largeur)



def verification_position(p1, coordonnees, nbr_case_utile, orientation):
    """[summary]

    Args:
        p1 ([type]): [description]
        coordonnees (liste d'entier): c'est les coordonnées du bateau 
        nbr_case_utile (entier): c'est le nombre de case dans la grille que le bateau prendra
        orientation (str): c'est l'orientation du bateau

    Returns:
        booleen: c'est si les coordonnées sont possible
    """
    ligne, colonne = coordonnees[0], coordonnees[1]
    #selon l'orientation on vérifie si c'est possible
    if orientation == 'Horizontal':
        
        for j in range(nbr_case_utile):
            
            if(p1[ligne][colonne + j]['contenu'] != 'Eau'):
                return False
            
    else:
        
        for i in range(nbr_case_utile):
            
            if(p1[ligne + i][colonne]['contenu'] != 'Eau'):
                return False
            
    return True

def affichage (grille : list):
    """On affiche la grille de jeux a l'utilisateur

    Args:
        grille (list): c'est notre grille de jeu
    """
    print('-' * (len(plateau) + 2))
    
    for ligne in grille:
        #on va faire chaque ligne un str pour l'afficher
        a_afficher = '|'
        #on va mettre dans notre ligne chaque case
        for case in ligne:
            
            if(case['etat'] == 'Neuf'):
                a_afficher = a_afficher + ' '
            
            else:
                
                if(case['contenu'] == 'Eau'):
                    a_afficher = a_afficher + 'X'
                
                else:
                    a_afficher = a_afficher + '{}'.format(case['contenu'][0].lower())
        
        a_afficher = a_afficher + '|'
        print(a_afficher)
    print('-' * (len(plateau) + 2))
    
    


def placement_bateau (grille, indice, nbr_bateau = 0):
    """Cette fonction nous renvoie notre grille avec le bateau place

    Args:
        grille (tableau): c'est notre grille de jeu
        indice (entier): c'est pour savoir c'est qu'elle bateau
        nbr_bateau (int, optional): c'est pour savoir s'il y a plusieurs bateau du même nom. Defaults to 0.

    Returns:
        tableau: c'est notre grille de jeux avec le bateau placé en plus
    """
    orientation, position = coordonnees_bateau(len(grille), TAILLE_BATEAU[indice])
    #On répète jusqu'a avoir un deplacement possible pour le bateau
    while(verification_position(grille, position, TAILLE_BATEAU[indice], orientation) == False):
        print('Impossible. Nouvelle position')
        orientation, position = coordonnees_bateau(len(grille), TAILLE_BATEAU[indice])
    #on va mettre le bateau a la place en modifiant la grille
    if(orientation == 'H'):
        
        for j in range(TAILLE_BATEAU[indice]):
            grille[position[0]][position[1] + j] = {'contenu':NOM_BATEAU[indice], 'numero':nbr_bateau, 'etat':'Neuf'}
    
    else:
        
        for i in range(TAILLE_BATEAU[indice]):
            grille[position[0] + i][position[1]] = {'contenu':NOM_BATEAU[indice], 'numero':nbr_bateau, 'etat':'Neuf'}
    return grille
    
if __name__ == "__main__":
    #création du damier vide
    plateau = creation_plateau()
    #placement bateau
    for indice in range(4):
        #On repete deux fois pour le destroyer
        if indice == 2:
            plateau = placement_bateau(plateau, indice)
            plateau = placement_bateau(plateau, indice, 1)
        else:
            plateau = placement_bateau(plateau, indice)
    
######################################################################################
    
    affichage(plateau)
    
    jeu_fini = False
    
    while(not jeu_fini):
        #on demande ou on tire
        print('où voulez vous tirer ? - 0 pour quitter')
        i = (int)(input('Numéro de ligne entre 1 et {} : '.format(10)))
        
        if(i == 0):
            print('Tu ne vas même pas jusqu\'au bout du jeu ? Tant pis. Bye !')
            sys.exit(0)
        
        j = (int)(input('Numéro de colonne entre 1 et {} : '.format(10)))
        #on active le mode triche
        if((i < 0) or (j < 0)):
            print('MODE TRICHE :')
            print('-' * (len(plateau) + 2))
            
            for ligne_plat in plateau:
                a_afficher = '|'
                
                for case_plat in ligne_plat:
                    
                    if(case_plat['contenu'] == 'Eau'):
                        a_afficher = a_afficher + ' '
                    
                    else:
                        a_afficher = a_afficher + '{}'.format(case_plat['contenu'][0])
                
                a_afficher = a_afficher + '|'
                print(a_afficher)
                
            print('-' * (len(plateau) + 2))
            
        else:
            
            if(plateau[(i - 1)][(j - 1)]['etat'] == 'Touche'):
                print('Position déjà touchée')
            
            else:
                plateau[(i - 1)][( j-1 )]['etat'] = 'Touche'

                if(plateau[(i - 1)][(j - 1)]['contenu'] == 'Eau'):
                    print('A l\'eau')
                    
                else:
                    vc = True
                    
                    for l8 in plateau:
                        
                        for c8 in l8:
                            
                            if c8['contenu'] == plateau[(i - 1)][(j - 1)]['contenu'] and c8['numero'] == plateau[(i - 1)][(j - 1)]['numero'] and c8['etat'] == 'Neuf':
                                vc = False
                    
                    if(vc):
                        print(plateau[(i - 1)][(j - 1)]['contenu'], plateau[(i - 1)][(j - 1)]['numero'], 'coulé')
                    
                    else:
                        print(plateau[(i - 1)][(j - 1)]['contenu'], plateau[(i - 1)][(j - 1)]['numero'], 'touché')
            #affichage
            affichage(plateau)
        #test savoir si c'est finit ou pas
        jeu_fini = True
        
        for l10 in plateau:
            
            for c10 in l10:
                
                if((c10['contenu'] != 'Eau') and (c10['etat'] == 'Neuf')):
                    jeu_fini = False
                    
    print('Tu as coulé tous les bateaux.')
    print('GG')
