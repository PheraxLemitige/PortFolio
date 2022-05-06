# %%
from numpy import *
import random as rb
import time

def initialisation (taille:int):
    tab = zeros (taille, dtype = int)
    return tab

def remplir_tableau (tableau, n):
    print(len(tableau))
    for i in range (len(tableau)):
        nb = rb.randint(0, n)
        tableau[i] = nb
    return tableau

def tri_bulle (tableau):
    for j in range (len(tableau)):
        for i in range (len(tableau) - j - 1):
            if tableau[i] > tableau[i + 1]:
                element = tableau[i]
                tableau[i] = tableau [i + 1]
                tableau[i + 1] = element
    return tableau

def tri_selection (tableau):
    for j in range (len(tableau)):
        indice_grand = 0
        for i in range (len(tableau) - j):
            if tableau[indice_grand] < tableau[i]:
                indice_grand = i
            element = tableau[indice_grand]
            tableau[indice_grand] = tableau [len(tableau) - j - 1]
            tableau[len(tableau) - j - 1] = element
    return tableau

def tri_insertion (tableau):
    tab = zeros (len(tableau), dtype = int)
    for i in range (len(tableau)):
        plus_petit = tableau[i]
        for j in range (len(tableau)):
            if tableau[j] < plus_petit:
                plus_petit = tableau[j]
        tab[i] = plus_petit
    return tab

def eclatement(tab):
    """éclatement :  éclate le tableau en 2 parties, grâce aux monotonies
    Args:
        tab  : le tableau

    Returns:
        tabd, tabg : les deux monotonies
    """
    assert len(tab)!=0,"le tableau est vide"
    V1=[tab[0]]
    V2=[]
    Rang=False
    i1=1
    i2=0
    for i in range(1,len(tab)):
        if not Rang: 
            if V1[len(V1)-1]<=tab[i]:
               V1.append(tab[i])
            else:
                Rang=True
                V2.append(tab[i])
        else :
            if V2[len(V2)-1] <=tab[i]:
                V2.append(tab[i])
            else:
                Rang=False
                V1.append(tab[i])
    return V1, V2


def fusion(gauche,droite):
    resultat = []
    index_gauche, index_droite = 0, 0
    while index_gauche < len(gauche) and index_droite < len(droite):        
        if gauche[index_gauche] <= droite[index_droite]:
            resultat.append(gauche[index_gauche])
            index_gauche += 1
        else:
            resultat.append(droite[index_droite])
            index_droite += 1
    if gauche:
        resultat.extend(gauche[index_gauche:])
    if droite:
        resultat.extend(droite[index_droite:])
    return resultat

def tri_fusion_eclatement(tab):
    fini = False
    tab_trie = tab
    while not fini:
        V1,V2=eclatement(tab_trie)
        if V2==[]:
            fini = True
        else :
            tab_trie=fusion(V1,V2)
    return tab_trie

taille = int(input("Quelle taille pour le tableau"))
tableau = initialisation(taille)
print("1. Remplir aléatoirement un tableau")
print("2. Afficher un tableau")
print("3. Rechercher la valeur minimum d'un tableau")
print("4. Compter le nombre d'occurences d'une valeur demandée à l'utilisateur dans un tableau")
print("5. Rechercher une valeur dans un tableau")
print("6. Calculer la moyenne des valeurs d'un tableau")
print("7. Quiter")
valeur = int(input("Que voulez vous faire?"))
while valeur != 7:
    if valeur == 1:
        tableau = remplir_tableau(tableau, 50)
    elif valeur == 2:
        print(tableau)
    elif valeur == 3:
        print(tri_bulle(tableau))
    elif valeur == 4:
        print(tri_selection(tableau))
    elif valeur == 5:
        print(tri_insertion([tableau]))
    else:
        print(tri_fusion_eclatement(tableau))
    valeur = int(input("Que voulez vous faire?"))
    time.sleep(2)
print("Fin du programme.")
# %%