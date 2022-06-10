/*********************************************************************/
/*                                                                   */
/* Copyright 2017-2020 Rémi Synave, Ryan Verlande                    */
/*                     Antonin Bocket, Teddy Lamarre,                */
/*                     Benjamin Lannoy, Gaetan Duplouy               */
/*                                                                   */
/* This file is part of MG3D.                                        */
/* This library uses javazoom library piece of code                  */
/* http://www.javazoom.net                                           */
/* and can be found with this library (file jlayer1.0.1.tar.gz)      */
/*                                                                   */
/* MG3D is free software: you can redistribute it and/or modify      */
/* it under the terms of the GNU General Public License as published */
/* by the Free Software Foundation, either version 3 of the License, */
/* or (at your option) any later version.                            */
/*                                                                   */
/* MG3D is distributed in the hope that it will be useful,           */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of    */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the      */
/* GNU General Public License for more details.                      */
/*                                                                   */
/* You should have received a copy of the GNU General Public License */
/* along with MG3D. If not, see <http://www.gnu.org/licenses/>.      */
/*                                                                   */
/*********************************************************************/

package MG3D.geometrie;

import java.util.ArrayList;

/**
 * Cette classe permet de stocker un sommet. Le sommet est définie par ses trois composantes x, y et z mais également une liste de voisins. Dans un maillage triangulaire, les sommets sont reliés entre eux afin de créer des faces. C'est ce lien qui est stocké dans la liste de voisins. 
 * @author Ryan Verlande, Antonin Bocket, Gaetan Duplouy, Teddy Lamarre, Benjamin Lannoy, Rémi Synave
 * @version 0.2
 */
public class Sommet extends Point3D {

    // TODO voir s'il ne faut pas plutôt utiliser un Set, un HashSet ? Autre chose ?
    // Permet de stocker les indices des sommets voisins dans le maillage.
    private ArrayList < Integer > voisins;

    /**
    * Constructeur par défaut de la classe sommet. Le sommet créé se trouve en (0,0,0) et n'a pas de voisin.
    */
    public Sommet() {
        super();
        voisins = new ArrayList < Integer > ();
    }

    /**
    * Constructeur de la classe Sommet, on peut définir le x, y et z. La liste des voisin est initialisée à vide.
    * @param x abcisse du sommet
    * @param y ordonnée du sommet
    * @param z profondeur du sommet 
    */
    public Sommet(double x, double y, double z) {
        super(x, y, z);
        voisins = new ArrayList < Integer > ();
    }

    /**
    * Constructeur par copie de la classe Sommet permettant de créer un sommet à partir d'un autre passé en paramètre.
    * @param s Sommet que l'on va utiliser pour créer notre nouveau sommet
    */
    public Sommet(Sommet s) {
        super(s.getX(), s.getY(), s.getZ());
        voisins = new ArrayList < Integer > ();
	for(int i=0;i<s.getNbVoisins();i++)
	    voisins.add(new Integer(s.getVoisin(i)));
    }

    /**
    * Méthode permettant d'ajouter un voisin dans liste des voisins d'un sommet.
    * @param indice indice du voisin que l'on veut ajouter à la liste 
    */
    public boolean ajouterVoisin(int indice) {
        boolean contient = estVoisin(indice);
        if (!contient)
            voisins.add(Integer.valueOf(indice));
        return !contient;
    }

    /**
    * Méthode permettant de tester si un sommet est bien le voisin du sommet passé en paramètre
    * @param indice indice du sommet avec lequel on veut tester le lien.
    * @param vrai si le sommet et celui passé en paramèter sont voisins, faux sinon.
    */
    public boolean estVoisin(int indice) {
        return voisins.contains(new Integer(indice));
    }

    /**
     * Retourne le nombre de voisins du sommet.
     * @return nombre de voisins du sommet.
     */
    public int getNbVoisins() {
	return voisins.size();
    }

    /**
     * Retourne le numéro du sommet voisin en fonction de sa position dans la liste de voisins.
     * @param indice indice de la case de la liste de voisins.
     * @return numéro du sommet voisin.
     */
    public int getVoisin(int indice) {
	return voisins.get(indice);
    }

    /**
    * Méthode permettant de translater un point dans la direction souhaitée. La direction est passée en paramètre sous forme de trois réels donnant les composantes x, y et z du mouvement.
    * @param dx pas de translation suivant X
    * @param dy pas de translation suivant Y
    * @param dz pas de translation suivant Z
    */
    public void translater(double dx, double dy, double dz) {
        this.setX(getX()+dx);
        this.setY(getY()+dy);
        this.setZ(getZ()+dz);
    }

    /**
    * Méthode permettant de translater un point dans la direction souhaitée. La direction est passée en paramètre sous forme d'un vecteur.
    * @param v vecteur de translation
    */
    public void translater(Vecteur3D v) {
        translater(v.getDx(),v.getDy(),v.getDz());
    }

    /**
    * Méthode retournant un ArrayList contenant l'ensemble des voisins du sommet
    * @return retourne la liste contenant l'ensemble des indices des voisins
    */
    public ArrayList < Integer > getVoisins(){
        return voisins;
    }
}
