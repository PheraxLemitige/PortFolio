/*
Fait par: Lutic Enzo
Projet Puissance 4
*/




#include <stdio.h> 
#include <stdlib.h> 
#include <stdbool.h>


#define max_ligne 6
#define max_colonne 7

typedef char grille[max_ligne][max_colonne];



void initGrille(grille G) {
    int i,j;
    /* On definie le tableau */
    for (i = 0; i < max_ligne; i ++) {
        for (j = 0; j < max_colonne; j ++)
            G[i][j] = ' ';
        
    }
    
}

void afficheGrille(grille G) {
    int i,j,k;
    /* On print dans la console la premier ligne */
    printf("%s", "    1   2   3   4   5   6   7  ");
    printf("\n");

    k = 0;
    /* On print dans la console chaque ligne */
    for (i = 0; i < max_ligne; i ++) { 
        printf("%i |", i + 1);
        for (j = 0; j < max_colonne; j ++) 
            printf(" %c |", G[i][j]);
        printf("\n");
    }

}


int grillepleine(grille G) {
    int i, j = -1;
    int ok = 1;
    /* On va vérifier si une case contient un zéro */
    for (i = 0; i < max_ligne; i ++) {
        for (j = 0; j < max_colonne; j ++)
            if (G[i][j] == ' '){
                ok = 0;
            }
    }
    return (ok);
}

int demandeaction (){
    int colonne;
    /* On va demander ce que fait le joueur*/
    printf("Sur quelle colonne voulez vous placez votre piece entre 1-7\nSi vous voulez afficher le menu entrer 0");
    scanf("%d", &colonne);
    return(colonne);
}

void ajoutejeton(grille G, int joueur, int colonne) {
    int ok;
    int i = 5;
    ok = 0;
    colonne -= 1;

    /* On va mofidier selon le choix */
    while  (ok == 0) {

        if (G[0][colonne] == ' ') {

            do {
                
                if ( G[i][colonne] == ' '){
                    

                    if (joueur == 1) {
                        G[i][colonne] = 'X';
                        ok = 1;
                    }
                    if (joueur == 0) {
                        G[i][colonne] = 'O';
                        ok = 1;
                    }
                    
                }
                else {
                    i = i - 1;
                }
                
            } while (i < 0 || ok == 0);

        
        }
        else {
            printf("\nLa colonne est pleine\n");
            printf("Sur quelle colonne voulez vous placez votre piece entre 1-7");
            scanf("%d", &colonne);
            colonne -= 1;
        }
    }
}


int verifLigne(grille G){
    int i, j;
    /* On vérifie pour chaque ligne*/
    for (i = 0; i < max_ligne; i ++){
        
        for (j = 0; j < max_colonne - 3; j ++){

            if (G[i][j] == G[i][j + 1] && G[i][j + 1] == G[i][j + 2] && G[i][j + 2] == G[i][j + 3] && G[i][j] == 'X'){
                return 1;
            }

            if (G[i][j] == G[i][j + 1] && G[i][j + 1] == G[i][j + 2] && G[i][j + 2] == G[i][j + 3] && G[i][j] == 'O'){
                return 2;
            }
        }
    }
    return 0;
}

int verifCol(grille G){
    int i, j;
    /* On vérifie pour chaque colonne*/
    for (j = 0; j < max_colonne; j ++){
        
        for (i = 0; i < max_ligne - 3; i ++){

            if (G[i][j] == G[i + 1][j] && G[i + 1][j] == G[i + 2][j] && G[i + 2][j] == G[i + 3][j] && G[i][j] == 'X'){
                return 1;
            }

            if (G[i][j] == G[i + 1][j] && G[i + 1][j] == G[i + 2][j] && G[i + 2][j] == G[i + 3][j] && G[i][j] == 'O'){
                return 2;
            }
        }
    }
    return 0;
}


int verifdiag(grille G) {
    int i, j;
    /* On vérifie pour chaque diagonale*/
    for (i = 0; i <= max_colonne; i ++){

            for (j = 0; j <= max_ligne; j ++){

    if (((G[i][j] == G[i-1][j-1] && G[i][j] == G[i-2][j-2] && G[i][j] == G[i-3][j-3] ) || 
        (G[i][j] == G[i-1][j+1] && G[i][j] == G[i-2][j+2] && G[i][j] == G[i-3][j+3])) 
        && G[i][j] == 'X'){
                return 1;
            }

    if (((G[i][j] == G[i-1][j-1] && G[i][j] == G[i-2][j-2] && G[i][j] == G[i-3][j-3] ) || 
        (G[i][j] == G[i-1][j+1] && G[i][j] == G[i-2][j+2] && G[i][j] == G[i-3][j+3])) 
        && G[i][j] == 'O'){
                return 2;
            }
        }
    }
    return 0;
}

int jeuFini(grille G) {
    int verif;
    verif = verifCol(G);
    /* Pour verifie chaque verification et si l'une renvoie autre chose que 0 on continue*/
    if (verif != 0){
        return (verif);
    }

    verif = verifLigne(G);
    if (verif != 0){
        return(verif);
    }
    
    verif = verifdiag(G);
    if (verif != 0){
        return(verif);
    }
    /* Si la grille est pleine on renvoie 3*/
    if (grillepleine(G) == 1) {
        return (3);
    }
    return (0);
}

void sauvegardePartie(char joueur, grille G){
    int i, j;
    FILE *file;
    file = fopen("sauvegarde.txt", "w");
    fputc(joueur, file);
    for (i = 0; i < max_ligne; i ++) { 
        for (j = 0; j < max_colonne; j ++){
        fputc(G[i][j], file);
        }
    }
    fclose(file);
}

void lecturePartie(int joueur, grille G){
    int i, j;
    FILE *file;
    char caractere;
    file = fopen("sauvegarde.txt", "r");
    joueur = fgetc(file);
    for (i = 0; i < max_ligne; i ++) { 
        for (j = 0; j < max_colonne; j ++){
         caractere = fgetc(file);
         G[i][j] = caractere;
        }
    }
}

void afficheMenu(){
    printf("Que voulez vous faire\n");
    printf("1. Reprendre\n");
    printf("2. Démarer une nouvelle partie\n");
    printf("3. Sauvegarder la partie\n");
    printf("4. Reprendre une ancienne partie\n");
}

int menu(){
    int i;
    afficheMenu();
    scanf("%d", &i);
    return (i);
}

void main(){
    grille g;
    int ok, colonne, condition;
    int i = 1;
    initGrille(g);   
    afficheGrille(g);
    do {
    i = i % 2;
    colonne = demandeaction();
    if (colonne == 0){
        condition = menu();
        if (condition == 2){
            initGrille(g);   
            afficheGrille(g);
        }
        else if (condition == 3){
            sauvegardePartie(i + '0', g);
            exit(-1);
        }
        else if (condition == 4){
            lecturePartie(i, g);
            initGrille(g);   
            afficheGrille(g);
        }
        colonne = demandeaction();
    }
    ajoutejeton(g, i, colonne);
    afficheGrille(g);
    ok = jeuFini(g);
    i++;
    } while (ok == 0);
    if (ok == 1){
        printf("Le joueur 1 a gagné");
    }
    else if (ok == 2){
        printf("Le joueur 2 a gagné");
    }
    else{
        printf("Egalité entre les deux joueurs");
    }
    

}