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

import java.text.DecimalFormat;

/**
 * Cette classe permet de stocker un point dans l'espace. Il est défini par ses trois composantes x, y et z. 
 * @author Ryan Verlande, Antonin Bocket, Gaetan Duplouy, Teddy Lamarre, Benjamin Lannoy, Rémi Synave
 * @version 0.2
 */
public class Point3D {
    // ATTRIBUTS
    private double x; // abscisse
    private double y; // ordonnee
    private double z; // cote

    /**
     * Constructeur par defaut d'un point.
     * Les valeurs par défaut des coordonnées sont égales à 0.
     */
    public Point3D() {
	this.x = 0;
	this.y = 0;
	this.z = 0;
    }

    /**
     * Constructeur prenant en paramètre des coordonnées.
     * @param x l'abscisse
     * @param y l'ordonnee
     * @param z la profondeur
     */
    public Point3D(double x, double y, double z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    /**
     * Construit un point à partir d'un modèle de point.
     * @param p Le point à copier.
     */
    public Point3D(Point3D p) {
	this.x = p.x;
	this.y = p.y;
	this.z = p.z;
    }

    /**
     * Retourne la valeur de l'abscisse
     * @return la valeur de l'abscisse
     */
    public double getX() {
	return x;
    }

    /**
     * Retourne la valeur de l'ordonnée
     * @return la valeur de l'ordonnée
     */
    public double getY() {
	return y;
    }

    /**
     * Retourne la valeur de la profondeur.
     * @return la valeur de la profondeur
     */
    public double getZ() {
	return z;
    }

    /**
     * Permet de modifier la valeur de l'abcisse.
     * @param x la nouvelle abscisse
     */
    public void setX(double x) {
	this.x = x;
    }

    /**
     * Permet de modifier la valeur de l'ordonnée.
     * @param y la nouvelle ordonnée
     */
    public void setY(double y) {
	this.y = y;
    }

    /**
     * Permet de modifier la valeur de la profondeur
     * @param z la nouvelle profondeur
     */
    public void setZ(double z) {
	this.z = z;
    }

    /**
     * Calcule la longueur entre deux points.
     * @param p le second point pour la mesure de la longueur.
     * @return la longueur.
     */
    public double longueur(Point3D p){
	double dX = this.x - p.x;
	double dY = this.y - p.y;
	double dZ = this.z - p.z;
	return Math.sqrt(dX*dX+dY*dY+dZ*dZ);
    }
       

    /**
     * Methode retournant une description du point.<br />
     * La chaine de caractère retournée est de la forme : (x;y;z)
     * @return une chaine de caractère décrivant le point
     */
    public String toString() {
	DecimalFormat fmt = new DecimalFormat("#,##0.000#");
	return "(" + fmt.format(getX()) + ", " + fmt.format(getY()) + ", " + fmt.format(getZ()) + ")";
    }
}
