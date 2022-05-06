import sys
import random



def pa(tp2, nbc2):
    if(random.randint(0,1)==0):
        o2='H'
    else:
        o2='V'
    if(o2=='H'):
        ir2 = random.randint(0,tp2-1)
        jr2 = random.randint(0,tp2-nbc2)
    else:
        ir2 = random.randint(0,tp2-nbc2)
        jr2 = random.randint(0,tp2-1)
    return o2, (ir2, jr2)



def vp(p1, ob1, nbc1, o1):
    ligne, colonne = ob1[0], ob1[1]
    if o1=='H':
        for j in range(nbc1):
            if(p1[ligne][colonne+j]['contenu']!='Eau'):
                return False
    else:
        for i in range(nbc1):
            if(p1[ligne+i][colonne]['contenu']!='Eau'):
                return False
    return True



if __name__ == "__main__":
    pmain=[]
    for i in range(10):
        l4=[]
        for j in range(10):
            l4.append({'contenu':'Eau', 'numero':0, 'etat':'Neuf'})
        pmain.append(l4)
    nbc3=5
    t3='Porte-avions'
    nb3=0
    o3, pos3 = pa(len(pmain), nbc3)
    while(vp(pmain, pos3, nbc3, o3)==False):
        print('Impossible. Nouvelle position')
        o3, pos3 = pa(len(pmain), nbc3)
    if(o3=='H'):
        for j in range(nbc3):
            pmain[pos3[0]][pos3[1]+j]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    else:
        for i in range(nbc3):
            pmain[pos3[0]+i][pos3[1]]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    nbc3=4
    t3='Croiseur'
    nb3=0
    o3, pos3 = pa(len(pmain), nbc3)
    while(vp(pmain, pos3, nbc3, o3)==False):
        print('Impossible. Nouvelle position')
        o3, pos3 = pa(len(pmain), nbc3)
    if(o3=='H'):
        for j in range(nbc3):
            pmain[pos3[0]][pos3[1]+j]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    else:
        for i in range(nbc3):
            pmain[pos3[0]+i][pos3[1]]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    nbc3=3
    t3='Destroyer'
    nb3=0
    o3, pos3 = pa(len(pmain), nbc3)
    while(vp(pmain, pos3, nbc3, o3)==False):
        print('Impossible. Nouvelle position')
        o3, pos3 = pa(len(pmain), nbc3)
    if(o3=='H'):
        for j in range(nbc3):
            pmain[pos3[0]][pos3[1]+j]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    else:
        for i in range(nbc3):
            pmain[pos3[0]+i][pos3[1]]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    nbc3=3
    t3='Destroyer'
    nb3=1
    o3, pos3 = pa(len(pmain), nbc3)
    while(vp(pmain, pos3, nbc3, o3)==False):
        print('Impossible. Nouvelle position')
        o3, pos3 = pa(len(pmain), nbc3)
    if(o3=='H'):
        for j in range(nbc3):
            pmain[pos3[0]][pos3[1]+j]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    else:
        for i in range(nbc3):
            pmain[pos3[0]+i][pos3[1]]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    nbc3=2
    t3='Torpilleur'
    nb3=0
    o3, pos3 = pa(len(pmain), nbc3)
    while(vp(pmain, pos3, nbc3, o3)==False):
        print('Impossible. Nouvelle position')
        o3, pos3 = pa(len(pmain), nbc3)
    if(o3=='H'):
        for j in range(nbc3):
            pmain[pos3[0]][pos3[1]+j]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
    else:
        for i in range(nbc3):
            pmain[pos3[0]+i][pos3[1]]={'contenu':t3, 'numero':nb3, 'etat':'Neuf'}
########################################################################
    print('-'*(len(pmain)+2))
    for l7 in pmain:
        a_afficher='|'
        for c7 in l7:
            if(c7['etat']=='Neuf'):
                a_afficher=a_afficher+' '
            else:
                if(c7['contenu']=='Eau'):
                    a_afficher=a_afficher+'X'
                else:
                    a_afficher=a_afficher+'{}'.format(c7['contenu'][0].lower())
        a_afficher=a_afficher+'|'
        print(a_afficher)
    print('-'*(len(pmain)+2))
    tc=False
    while(not tc):
        print('où voulez vous tirer ? - 0 pour quitter')
        i = (int)(input('Numéro de ligne entre 1 et {} : '.format(10)))
        if(i==0):
            print('Tu ne vas même pas jusqu\'au bout du jeu ? Tant pis. Bye !')
            sys.exit(0)
        j = (int)(input('Numéro de colonne entre 1 et {} : '.format(10)))
        if((i<0) or (j<0)):
            print('MODE TRICHE :')
            print('-'*(len(pmain)+2))
            for l6 in pmain:
                a_afficher='|'
                for c6 in l6:
                    if(c6['contenu']=='Eau'):
                        a_afficher=a_afficher+' '
                    else:
                        a_afficher=a_afficher+'{}'.format(c6['contenu'][0])
                a_afficher=a_afficher+'|'
                print(a_afficher)
            print('-'*(len(pmain)+2))
        else:
            if(pmain[(i-1)][(j-1)]['etat']=='Touche'):
                print('Position déjà touchée')
            else:
                pmain[(i-1)][(j-1)]['etat']='Touche'
                if(pmain[(i-1)][(j-1)]['contenu']=='Eau'):
                    print('A l\'eau')
                else:
                    vc=True
                    for l8 in pmain:
                        for c8 in l8:
                            if c8['contenu'] == pmain[(i-1)][(j-1)]['contenu'] and c8['numero'] == pmain[(i-1)][(j-1)]['numero'] and c8['etat'] == 'Neuf':
                                vc=False
                    if(vc):
                        print(pmain[(i-1)][(j-1)]['contenu'],pmain[(i-1)][(j-1)]['numero'],'coulé')
                    else:
                        print(pmain[(i-1)][(j-1)]['contenu'],pmain[(i-1)][(j-1)]['numero'],'touché')
            print('-'*(len(pmain)+2))
            for l7 in pmain:
                a_afficher='|'
                for c7 in l7:
                    if(c7['etat']=='Neuf'):
                        a_afficher=a_afficher+' '
                    else:
                        if(c7['contenu']=='Eau'):
                            a_afficher=a_afficher+'X'
                        else:
                            a_afficher=a_afficher+'{}'.format(c7['contenu'][0].lower())
                a_afficher=a_afficher+'|'
                print(a_afficher)
            print('-'*(len(pmain)+2))
        tc=True
        for l10 in pmain:
            for c10 in l10:
                if((c10['contenu'] != 'Eau') and (c10['etat']=='Neuf')):
                    tc=False
    print('Tu as coulé tous les bateaux.')
    print('GG')
