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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe permettant la manipulation de maillage triangulaire. Il est possible de créer ses maillages en ajoutant les sommets et les faces ou de charger ses maillages stockés dans des fichiers au format off.
 * @author Ryan Verlande, Antonin Bocket, Gaetan Duplouy, Teddy Lamarre, Benjamin Lannoy, Rémi Synave
 * @version 0.2
 * @see Sommet
 * @see Face
 */
public class Maillage extends Objet3D {

    //Attributs
    String fichier;

    /**
     * Constructeur par défaut d'un maillage triangulaire vide.
     */
    public Maillage() {
	super();
	fichier = new String();
    }

    /**
     * Constructeur prenant en paramètre un chemin vers un fichier off.
     * Le fichier est lu, puis ajoute le contenu de ce fichier dans la liste des sommets.
     * Les faces sont ensuite ajoutées dans la liste de faces.
     * @param str chaine de caractère étant le chemin vers le fichier.
     * @throws IOException
     */
    public Maillage(String str) {
	super();
	fichier = new String(str);
	genereMaillage();
    }

    /**
     * Constructeur par copie.
     * Construit un maillage à partir d'un modèle de maillage.
     * @param m le maillage à copier.
     */
    public Maillage(Maillage m) {
	//TODO - sûrement pas !!
	// A REVOIR !!
	// Ne pas utiliser !!!
	m.fListe = fListe;
	m.sListe = sListe;
    }

    /**
     * Méthode permettant de générer le maillage triangulaire. Cette méthode est appelée automatiquement par le constructeur lorsqu'un fichier off doit être lu.<br />
     * Pour utiliser cette méthode, il faut que le chemin vers un fichier off soit fixé en étant passé par le contructeur prenant une chaine de caractère en paramètre.
     */
    protected void genereMaillage() {

	Scanner sc = null;

	// Lecture du fichier
	try {
	    sc = new Scanner(new File(fichier));
	} catch (IOException e) {
	    System.out.println("Fichier non trouve dans le repertoire suivant le chemin : " + fichier + "!");
	}

	sc.next(); // on passe le OFF du fichier

	// Recuperation du nombre de sommets, de faces et d'aretes
	int nbSommets = Integer.valueOf(sc.next());
	int nbFaces = Integer.valueOf(sc.next());
	int nbAretes = Integer.valueOf(sc.next()); // ne sert a rien

	for (int i = 0; i < nbSommets; i++) { // boucle de sommets
	    double reel1 = Double.valueOf(sc.next());
	    double reel2 = Double.valueOf(sc.next());
	    double reel3 = Double.valueOf(sc.next());

	    sListe.add(new Sommet(reel1, reel2, reel3)); // ajout du sommet lu dans le fichier
	}

	for (int i = 0; i < nbFaces; i++) { // boucle de faces
	    sc.next(); // on evite le 3 a chaque debut de ligne
	    int entier1 = Integer.valueOf(sc.next());
	    int entier2 = Integer.valueOf(sc.next());
	    int entier3 = Integer.valueOf(sc.next());

	    ajouter(new Face(entier1, entier2, entier3)); // ajout de la face lu dans le fichier
	}

	sc.close(); // fermeture du fichier apres lecture

    }

}
