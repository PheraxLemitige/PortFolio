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

/**
 * Cette classe permet de créer des boites englobantes. Les boites englobantes sont utilisées par le moteur graphique pour gérer les collisions via le principe des AABB (Axis Aligned Bounding Box).<br />
 * La boite englobante est définie par deux points, un minimum et un maximum. Les composantes x,y et z du point minimum doivent être inférieur à leur correspondant du point maximum.
 * <br /><br />
 * Le principe est simple : on entoure notre forme par un parallèlépipède dont les côtés sont alignés avec les axes x, y et z.<br />
 * L'objectif est de permettre de fournir une méthode de collision pour toutes les formes gérées par le moteur car les collisions parallèlépipède - parallèlépipède sont très faciles à détecter.<br /><br />
 * Chaque forme géométrique héritant de Objet3D possède une méthode getBoiteEnglobante.
 * @author Ryan Verlande, Antonin Bocket, Gaetan Duplouy, Teddy Lamarre, Benjamin Lannoy, Rémi Synave
 * @version 0.2
 * @see Objet3D
 * @see Objet3D#getBoiteEnglobante
 */
public class BoiteEnglobante {

    private Point3D min, max;

    /**
     * Constructeur par défaut de la boite englobante.
     * La boite englobante créée commence en (0,0,0) et s'arrête en (0,0,0).
     * Ne sert donc pas à grand chose !
     */

    public BoiteEnglobante() {
	this.min = new Point3D(0, 0, 0);
	this.max = new Point3D(0, 0, 0);
    }
    
    /**
     * Construction d'une boite englobante pour laquelle on donne le point minimum et le point maximum.
     * @param min minimum de la boite englobante.
     * @param max maximum de la boite englobante.
     * @see Point3D
     */

    public BoiteEnglobante(Point3D min, Point3D max) {
	this.min = new Point3D(min);
	this.max = new Point3D(max);
    }

    /**
     * Construction d'une boite englobante pour laquelle on donne toutes les coordonnées du point minimal et du point maximal.
     * @param minX qui va déterminer la position x du point minimal
     * @param minY qui va déterminer la position y du point minimal
     * @param minZ qui va déterminer la position z du point minimal
     * @param maxX qui va déterminer la position x du point maximal
     * @param maxY qui va déterminer la position y du point maximal
     * @param maxZ qui va déterminer la position z du point maximal
     */

    public BoiteEnglobante(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
	this.min = new Point3D(minX, minY, minZ);
	this.max = new Point3D(maxX, maxY, maxZ);
    }

    /**
     * Méthode qui va tester si la boite englobante s'intersecte avec une boite englobante passée en paramètre.
     * @param be BoiteEnglobante avec laquelle on va tester la collision
     * @return retourne vrai s'il y a intersection, faux sinon
     */

    public boolean intersection(BoiteEnglobante be) {
	boolean collision = true;
		
	if (
	    be.getMin().getX() > this.getMax().getX() ||
	    be.getMin().getY() > this.getMax().getY() ||
	    be.getMin().getZ() > this.getMax().getZ() ||
	    be.getMax().getX() < this.getMin().getX() ||
	    be.getMax().getY() < this.getMin().getY() ||
	    be.getMax().getZ() < this.getMin().getZ()
	    )
	    collision = false;
		
	return collision;
    }

    /**
     * Méthode permettant de savoir si un point passé en paramètre se trouve dans la boite englobante.
     * @param p point à tester
     * @return vrai si le point se trouve dans le boite englobante, faux sinon.
     * @see Point3D
     */

    public boolean intersection(Point3D p){
	boolean collision = false;
	if(
	   p.getX() <= this.max.getX() &&
	   p.getY() <= this.max.getY() &&
	   p.getZ() <= this.max.getZ() &&
	   p.getX() >= this.min.getX() &&
	   p.getY() >= this.min.getY() &&
	   p.getZ() >= this.min.getZ()
	   )
	    collision = true;
	return collision;
    }

    /**
     * Méthode permettant l'accès au point minimum de la boite englobante.
     * @return un Point3D correspondant au point minimum de la boite englobante
     */
    public Point3D getMin() {
	return this.min;
    }

    /**
     * Méthode permettant l'accès au point maximum de la boite englobante.
     * @return un Point3D correspondant au point maximum de la boite englobante
     */
    public Point3D getMax() {
	return this.max;
    }

    /**
     * Méthode tostring.
     */
    public String toString(){
	return "Boite englobante : " + min + " - " + max;
    }

}
