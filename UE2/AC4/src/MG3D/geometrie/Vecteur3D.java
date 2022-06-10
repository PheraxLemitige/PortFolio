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

import MG3D.geometrie.Point3D;

/**
 * Classe permettant de stocker un vecteur définie par ses trois composantes dx, dy et dz.
 * @author Ryan Verlande, Antonin Bocket, Gaetan Duplouy, Teddy Lamarre, Benjamin Lannoy, Rémi Synave
 * @version 0.2
 */
public class Vecteur3D {

    private double dx, dy, dz;

    /**
     * Constructeur par défaut du Vecteur3D avec dx dy et dz égaux à 0.
     */
    public Vecteur3D() {
	this.dx = 1.0;
	this.dy = 0.0;
	this.dz = 0.0;
    }

    /**
     * Constructeur du Vecteur3D dans lequel on peut déterminer dx, dy, et dz
     * @param dx déterminant la direction x du vecteur
     * @param dy déterminant la direction y du vecteur
     * @param dz déterminant la direction z du vecteur
     */
    public Vecteur3D(double dx, double dy, double dz) {
	this.dx = dx;
	this.dy = dy;
	this.dz = dz;
    }

    /**
     * Constructeur du Vecteur3D à partir de deux points a et b. a est l'origine du vecteur et b son extrémité.
     * @param a origine du vecteur
     * @param b extrémité du vecteur
     */
    public Vecteur3D(Point3D a, Point3D b) {
	this.dx = b.getX()-a.getX();
	this.dy = b.getY()-a.getY();
	this.dz = b.getZ()-a.getZ();
    }
    
    /**
     * Méthode retournant la taille du vecteur.
     * @return taille du vecteur.
     */
    public double taille() {
	return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Méthode permetant de normaliser un vecteur.<br />
     * Suite à l'exécution de cette méthode, la taille du vecteur sera de 1.
     */
    public void normaliser() {
	double taille = taille();
	if (taille == 0.0)
	    throw new java.lang.RuntimeException("Impossible de normaliser le vecteur nul");

	this.dx /= taille;
	this.dy /= taille;
	this.dz /= taille;
    }
    
    /**
     * Méthode retournant la direction X du vecteur.
     * @return composante x du vecteur.
     */
    public double getDx() {
	return this.dx;
    }
    
    /**
     * Méthode retournant la direction Y du vecteur.
     * @return composante y du vecteur.
     */
    public double getDy() {
	return this.dy;
    }
    
    /**
     * Méthode retournant la direction Z du vecteur.
     * @return composante z du vecteur.
     */
    public double getDz() {
	return this.dz;
    }

    /**
     * Méthode permettant de modifier la composante x du vecteur.
     * @param dx nouvelle composante x du vecteur.
     */
    public void getDx(double dx) {
	this.dx=dx;
    }
    
    /**
     * Méthode permettant de modifier la composante y du vecteur.
     * @param dy nouvelle composante y du vecteur.
     */
    public void getDy(double dy) {
	this.dy=dy;
    }
    
    /**
     * Méthode permettant de modifier la composante z du vecteur.
     * @param dz nouvelle composante z du vecteur.
     */
    public void getDz(double dz) {
	this.dz=dz;
    }

    /**
     * Produit vectoriel de deux vecteurs.
     * @param v second vecteur.
     * @return vecteur résultat.
     */
    public Vecteur3D produitVectoriel(Vecteur3D v){
	return new Vecteur3D(getDy()*v.getDz()-getDz()*v.getDy(), getDz()*v.getDx()-getDx()*v.getDz(), getDx()*v.getDy()-getDy()*v.getDx());
    }

    /**
     * Produit scalaire de deux vecteurs.
     * @param v second vecteur.
     * @return résultat sous forme de réel.
     */
    public double produitScalaire(Vecteur3D v){
	return getDx()*v.getDx()+getDy()*v.getDy()+getDz()*v.getDz();
    }

}
