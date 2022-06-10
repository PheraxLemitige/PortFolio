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


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import MG3D.Couleur;
import MG3D.geometrie.BoiteEnglobante;

/**
 * Cette classe fixe les caractéristiques minimales que tout objet doit posséder pour être correctement affiché dans une fenêtre MG3D.<br />
 * La structure de données permettant de stocker un maillage triangulaire est définie ici. Tous les objets MG3D seront des maillages triangulaires.
 * @author Ryan Verlande, Antonin Bocket, Gaetan Duplouy, Teddy Lamarre, Benjamin Lannoy, Rémi Synave
 * @version 0.2
 */
public abstract class Objet3D {
    //Attributs
    protected ArrayList < Sommet > sListe;
    protected ArrayList < Face > fListe;
    protected BoiteEnglobante be;
    private Couleur couleur;

    /**
     * Création d'un objet par défaut donc vide et de couleur noire.
     */
    public Objet3D() {
	sListe = new ArrayList < > ();
	fListe = new ArrayList < > ();
	be = null;
	couleur = new Couleur();
    }

    /**
     * Création d'un objet vide en initialisant sa couleur.
     * @param couleur Couleur de l'objet.
     * @see Couleur
     */
    public Objet3D(Couleur couleur) {
	sListe = new ArrayList < > ();
	fListe = new ArrayList < > ();
	be = null;
	this.couleur = new Couleur(couleur);
    }

    /**
     * Cette méthode doit être redéfinie par les classes filles. Elle permettra de générer le maillage de l'objet.
     */
    abstract protected void genereMaillage();

    /**
     * Ajoute un sommet à la liste de sommets.
     * @param s le sommet à ajouter
     */
    public void ajouter(Sommet s) {
	sListe.add(s);
    }

    /**
     * Ajoute une face à la liste de faces.<br />
     * L'ajout de la face met à jour également la liste de voisins de tous les sommets.
     * @param f la face à ajouter
     */
    public void ajouter(Face f) {
	if ((f.getS1() <= sListe.size()) && (f.getS2() <= sListe.size()) && (f.getS3() <= sListe.size())) {
	    fListe.add(f);

	    //gestion des voisins
	    getSommet(f.getS1()).ajouterVoisin(f.getS2());
	    getSommet(f.getS1()).ajouterVoisin(f.getS3());

	    getSommet(f.getS2()).ajouterVoisin(f.getS1());
	    getSommet(f.getS2()).ajouterVoisin(f.getS3());

	    getSommet(f.getS3()).ajouterVoisin(f.getS1());
	    getSommet(f.getS3()).ajouterVoisin(f.getS2());
	} else {
	    System.out.println("Ajout impossible, l'indice de sommet n'existe pas !");
	}
    }

    /**
     * Retourne le nombre de sommets du maillage.
     * @return nbSommets le nombre de sommets du maillage
     */
    public int getNbSommets() {
	return sListe.size();
    }

    /**
     * Retourne le sommet en fonction de l'indice.
     * @return Le sommet de l'indice
     */
    public Sommet getSommet(int i) {
	return sListe.get(i);
    }

    /**
     * Retourne le nombre de faces du maillage.
     * @return nbFaces le nombre de faces du maillage
     */
    public int getNbFaces() {
	return fListe.size();
    }

    /**
     * Retourne la couleur de l'objet.
     * @return Couleur de l'objet.
     * @see Couleur
     */
    public Couleur getCouleur() {

	return new Couleur(couleur);
    }

    /**
     * Retourne la face dont l’indice est donné en paramètre.
     * @param indiceFace l'indice de la face recherchée.
     * @return la face dont l'indice est donné en paramètre.
     */
    public Face getFace(int indiceFace) {
	return fListe.get(indiceFace);
    }

    /**
     * Méthode permettant de translater l'objet.<br />
     * le pas de translation est donné sous forme de trois réels pour les trois composantes du mouvement.
     * @param dx pas de translation suivant X.
     * @param dy pas de translation suivant Y.
     * @param dz pas de translation suivant Z.
     */
    public void translater(double dx, double dy, double dz) {
	for (int i = 0; i < sListe.size(); i++) {
	    sListe.get(i).setX(sListe.get(i).getX() + dx);
	    sListe.get(i).setY(sListe.get(i).getY() + dy);
	    sListe.get(i).setZ(sListe.get(i).getZ() + dz);
	}
	if (getBoiteEnglobante() != null) {
	    getBoiteEnglobante().getMin().setX(getBoiteEnglobante().getMin().getX() + dx);
	    getBoiteEnglobante().getMin().setY(getBoiteEnglobante().getMin().getY() + dy);
	    getBoiteEnglobante().getMin().setZ(getBoiteEnglobante().getMin().getZ() + dz);

	    getBoiteEnglobante().getMax().setX(getBoiteEnglobante().getMax().getX() + dx);
	    getBoiteEnglobante().getMax().setY(getBoiteEnglobante().getMax().getY() + dy);
	    getBoiteEnglobante().getMax().setZ(getBoiteEnglobante().getMax().getZ() + dz);

	}
    }

    /**
     * Méthode permettant de translater l'objet.<br />
     * le pas de translation est donné sous forme d'un vecteur3D.
     * @param v le vecteur de translation.
     * @see Vecteur3D
     */
    public void translater(Vecteur3D v) {
	translater(v.getDx(),v.getDy(),v.getDz());
    }

    

    /**
     * Calcul de la boite englobante.<br />
     * La boite englobante est stockée dans l'attribut qui peut être récupéré avec la méthode getBoiteEnglobante().
     * @seeObjet3D#getBoiteEnglobante
     */
    public void calculeBoiteEnglobante() {
	double maxX = sListe.get(0).getX(), maxY = sListe.get(0).getY(), maxZ = sListe.get(0).getZ();
	double minX = sListe.get(0).getX(), minY = sListe.get(0).getY(), minZ = sListe.get(0).getZ();
	for (int i = 0; i < sListe.size(); i++) {
	    if (sListe.get(i).getX() > maxX) {
		maxX = sListe.get(i).getX();
	    }
	    if (sListe.get(i).getX() < minX) {
		minX = sListe.get(i).getX();
	    }
	    if (sListe.get(i).getY() > maxY) {
		maxY = sListe.get(i).getY();
	    }
	    if (sListe.get(i).getY() < minY) {
		minY = sListe.get(i).getY();
	    }
	    if (sListe.get(i).getZ() > maxZ) {
		maxZ = sListe.get(i).getZ();
	    }
	    if (sListe.get(i).getZ() < minZ) {
		minZ = sListe.get(i).getZ();
	    }
	}
	be = new BoiteEnglobante(minX, minY, minZ, maxX, maxY, maxZ);
    }

    /**
     * Méthode pour centrer l'objet en (0, 0, 0).
     * La méthode récupère la boite englobante de l'objet pour trouver la bonne translation à appliquer.
     */
    public void centrer(){
	BoiteEnglobante be = this.getBoiteEnglobante();
	double minX = be.getMin().getX();
	double minY = be.getMin().getY();
	double minZ = be.getMin().getZ();
	double maxX = be.getMax().getX();
	double maxY = be.getMax().getY();
	double maxZ = be.getMax().getZ();
	double moyX = (minX+maxX)/2;
	double moyY = (minY+maxY)/2;
	double moyZ = (minZ+maxZ)/2;
	
	this.translater(-moyX, -moyY, -moyZ);
    }

    /**
     * Méthode pour mettre un objet à l'échelle.
     * @param h le facteur d'échelle.
     */
    public void homotethie(double h){
	for (int i = 0; i < sListe.size(); i++) {
	    sListe.get(i).setX(sListe.get(i).getX() * h);
	    sListe.get(i).setY(sListe.get(i).getY() * h);
	    sListe.get(i).setZ(sListe.get(i).getZ() * h);
		
	}
    }

    /**
     * Méthode permettant de mettre à l'échelle l'objet afin que sa boite englobante ait une taille de 1.
     */
    public void normaliser(){
	BoiteEnglobante be = this.getBoiteEnglobante();
	double tailleDiag = be.getMin().longueur(be.getMax());
	double echelle = 1.0/tailleDiag;
	this.homotethie(echelle);
    }
    
    /**
     * Méthode permettant d'effectuer un test d'intersection rapide, basé sur les boites englobantes.<br />
     * En appelant cette méthode, l'utilisateur n'appelle pas les méthodes d'intersection précises des sous-classes mais celle faisant appel aux boites englobantes.<br />
     * Cette méthode est <em>finale</em> et ne peut donc pas être redéfinie.
     * @param d Objet3D avec lequel vérifier s'il y a intersection.
     * @return Vrai si la méthode détecte une intersection, faux sinon.
     */
    public final boolean intersectionRapide(Objet3D d) {
	return this.getBoiteEnglobante().intersection(d.getBoiteEnglobante());
    }

    /**
     * Cette methode permet de récupérer la boite englobante de l'objet.
     * @return la boite englobante de l'objet.
     * @see BoiteEnglobante
     */
    public BoiteEnglobante getBoiteEnglobante() {
	if (be == null)
	    calculeBoiteEnglobante();
	return be;
    }

    /**
     * Attribue une couleur à l'objet.
     * @param couleur Couleur de l'objet.
     * @see Couleur
     */
    public void setCouleur(Couleur couleur) {

	this.couleur = new Couleur(couleur);
    }

    /**
     * Cette méthode affiche la liste de sommets et de faces constituant le maillage.
     */
    public void affichageParListe() {
	System.out.println("Sommets : ");
	for (int i = 0; i < sListe.size(); i++) {
	    System.out.println(i + " - " + sListe.get(i));
	}
	System.out.println("Faces : ");
	for (int i = 0; i < fListe.size(); i++) {
	    System.out.println(i + " - " + fListe.get(i));
	}
    }

    /**
     * Cette methode affiche l’ensemble des faces sous la forme de 3×3 coordonnées (x,y,z).
     */
    public void affichageSoupePolygone() {
	System.out.println("Soupe : ");
	for (int i = 0; i < fListe.size(); i++) {
	    System.out.println(i + " : " + sListe.get(fListe.get(i).getS1()) + "-" + sListe.get(fListe.get(i).getS2()) +
			       "-" + sListe.get(fListe.get(i).getS3()));
	}
    }


    /**
     * Cette méthode permet de sauver le maillage dans un fichier de type pgn.
     * @param saveFile chemin vers le fichier à sauvegarder.
     */
    public void sauverPGN(String saveFile) {
	try {
	    PrintWriter fichier = new PrintWriter(new BufferedWriter(new FileWriter(saveFile)));
	    //fichier.println(toString());
	    fichier.println(getNbSommets() + " " + getNbFaces());
	    for (int i = 0; i < sListe.size(); i++)
		fichier.println(getSommet(i).getX() + " " + getSommet(i).getY() + " " + getSommet(i).getZ());

	    fichier.println("");

	    for (int i = 0; i < fListe.size(); i++)
		fichier.println(getFace(i).getS1() + " " + getFace(i).getS2() + " " + getFace(i).getS3() + " -1");

	    fichier.close();
	} catch (Exception e) {
	    System.out.println("Impossible de sauvegarder le fichier " + saveFile);
	}
    }

    /**
     * Cette méthode permet de sauver le maillage dans un fichier de type off.
     * @param saveFile chemin vers le fichier à sauvegarder.
     */
    public void sauverOFF(String saveFile) {
	try {
	    PrintWriter fichier = new PrintWriter(new BufferedWriter(new FileWriter(saveFile)));
	    //fichier.println(toString());
	    fichier.println("OFF");
	    fichier.println(getNbSommets() + " " + getNbFaces()+ " 0");
	    for (int i = 0; i < sListe.size(); i++)
		fichier.println(getSommet(i).getX() + " " + getSommet(i).getY() + " " + getSommet(i).getZ());

	    fichier.println("");

	    for (int i = 0; i < fListe.size(); i++)
		fichier.println("3 " + getFace(i).getS1() + " " + getFace(i).getS2() + " " + getFace(i).getS3());

	    fichier.close();
	} catch (Exception e) {
	    System.out.println("Impossible de sauvegarder le fichier " + saveFile);
	}
    }

    /**
     * Cette méthode permet de sauver le maillage dans un fichier de type stl.
     * @param saveFile chemin vers le fichier à sauvegarder.
     */
    public void sauverSTL(String saveFile) {
	try {
	    PrintWriter fichier = new PrintWriter(new BufferedWriter(new FileWriter(saveFile)));
	    //fichier.println(toString());
	    fichier.println("solid " + getClass().toString().split(" ")[1]);

	    for (int i = 0; i < fListe.size(); i++) {
		fichier.println("");
		fichier.println("facet normal 0 0 0");
		fichier.println("    outer loop");
		fichier.println("        vertex " + getSommet(getFace(i).getS1()).getX() + " " + getSommet(getFace(i).getS1()).getY() + " " + getSommet(getFace(i).getS1()).getZ());
		fichier.println("        vertex " + getSommet(getFace(i).getS2()).getX() + " " + getSommet(getFace(i).getS2()).getY() + " " + getSommet(getFace(i).getS2()).getZ());
		fichier.println("        vertex " + getSommet(getFace(i).getS3()).getX() + " " + getSommet(getFace(i).getS3()).getY() + " " + getSommet(getFace(i).getS3()).getZ());
		fichier.println("    endloop");
		fichier.println("endfacet");
	    }
	    fichier.println("");
	    fichier.println("endsolid " + getClass().toString().split(" ")[1]);
	    fichier.close();
	} catch (Exception e) {
	    System.out.println("Impossible de sauvegarder le fichier " + saveFile);
	}
    }


    /**
     * Permet de faire pivoter l'objet autour de l'axe X.
     * @param theta Angle de rotation en radian
     */
    public void pivoterAxeX(double theta) {
	double sinTheta = Math.cos(theta);
	double cosTheta = Math.sin(theta);

	for (int i = 0; i < sListe.size(); i++) {
	    Sommet sommet = sListe.get(i);
	    //System.out.println("X = " + sommet.getX() + " Y = " + sommet.getY() + " Z = " + sommet.getZ());
	    double y = (-1) * sommet.getY();
	    double z = (-1) * sommet.getZ();


	    sommet.setY(y * cosTheta - z * sinTheta);
	    sommet.setZ(z * cosTheta + y * sinTheta);
	    //System.out.println("X = " + sommet.getX() + " Y = " + sommet.getY() + " Z = " + sommet.getZ());
	    sListe.set(i, sommet);
	}
    }

    /**
     * Permet de faire pivoter l'objet autour de l'axe Y.
     * @param theta Angle de rotation en radian
     */
    public void pivoterAxeY(double theta) {
	double sinTheta = Math.cos(theta);
	double cosTheta = Math.sin(theta);

	for (int i = 0; i < sListe.size(); i++) {
	    Sommet sommet = sListe.get(i);

	    double x = (-1) * sommet.getX();
	    double z = (-1) * sommet.getZ();

	    sommet.setX((x * cosTheta - z * sinTheta));
	    sommet.setZ((z * cosTheta + x * sinTheta));

	    sListe.set(i, sommet);

	}
    }

    /**
     * Permet de faire pivoter l'objet autour de l'axe Z.
     * @param theta Angle de rotation en radian
     */
    public void pivoterAxeZ(double theta) {
	double sinTheta = Math.cos(theta);
	double cosTheta = Math.sin(theta);

	for (int i = 0; i < sListe.size(); i++) {
	    Sommet sommet = sListe.get(i);
	    double x = (-1) * sommet.getX();
	    double y = (-1) * sommet.getY();

	    sommet.setX(x * cosTheta - y * sinTheta);
	    sommet.setY(y * cosTheta + x * sinTheta);

	    sListe.set(i, sommet);

	}
    }

    /**
     * Méthode calculant la distance euclidienne entre deux points du maillage.
     * @param a premier point du maillage.
     * @param b second point du maillage.
     * @return la distance euclidienne entre les deux points.
     */
    public double distanceEuclidienneEntreSommets(int a, int b){
	double dx=getSommet(a).getX()-getSommet(b).getX();
	double dy=getSommet(a).getY()-getSommet(b).getY();
	double dz=getSommet(a).getZ()-getSommet(b).getZ();
	return Math.sqrt(dx*dx+dy*dy+dz*dz);
    }
}
