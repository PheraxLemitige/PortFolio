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
 * Cette classe permet de stocker les informations concernant une arête d'un maillage triangulaire.<br />
 * Dans MG3D, la structure de données utilisée pour stocker les informations d'un maillage triangulaire est un tableau de sommets et un tableau de faces. Les arêtes ne font donc pas partie de cette structure. Toutefois, il peut être nécessaire pour certains algorithmes d'y avoir accès.<br />
 * Les arêtes sont définies par deux sommets. Les indices du tableau de sommets sont utilisés pour identifier les sommets.
* @author Ryan Verlande, Antonin Bocket, Gaetan Duplouy, Teddy Lamarre, Benjamin Lannoy, Rémi Synave
 * @version 0.3
 * @see Sommet
 */
public class Arete {

	// Attributs
	private int s1; 
	private int s2; 

	/**
	 * Constructeur par défaut d'une arête.<br />
	 * L'arête créée a pour sommet  0 et 1.
	 */
	public Arete() {
		this.s1 = 0;
		this.s2 = 1;
	}

	/**
	 * Constructeur prenant en paramètre 2 entiers (indice de sommets) pour en faire une arête.
	 * @param s1 l'indice du premier sommet
	 * @param s2 l'indice du second sommet
	 */
	public Arete(int s1, int s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	/**
	 * Constructeur par copie.
	 * Construit une arête à partir d'un modèle d'arête.
	 * @param a L'arête à copier.
	 */
    public Arete(Arete a) {
		this.s1 = a.s1;
		this.s2 = a.s2;
	}

	/**
	 * Retourne l'indice du premier sommet.
	 * @return l'indice du sommet s1
	 */
	public int getS1() {
		return s1;
	}

	/**
	 * Retourne l'indice du second sommet.
	 * @return l'indice de sommet s2
	 */
	public int getS2() {
		return s2;
	}

	/**
	 * Permet de modifier la valeur de l'indice du sommet s1
	 * @param s1 le nouvel indice du sommet s1
	 */
	public void setS1(int s1) {
		this.s1 = s1;
	}

	/**
	 * Permet de modifier la valeur de l'indice du sommet s2
	 * @param s2 le nouvel indice du sommet s2
	 */
	public void setS2(int s2) {
		this.s2 = s2;
	}


	/**
	 * Retourne une description de l'arête.
	 * La chaine de caractère est donnée sous la forme : (s1,s2).
	 * @return une chaine de caractère décrivant l'arête.
	 */
	public String toString() {
		return "(" + getS1() + ", " + getS2() + ")";
	}

	/**
	 * Permet de comparer deux arêtes.
	 * La méthode retournera vrai si les indices des deux sommets sont les mêmes
	 * dans les deux arêtes à une permutation près.
	 * @return vrai si les deux arêtes sont les mêmes, faux sinon.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
		    return true;
		if (obj == null)
		    return false;
		if (getClass() != obj.getClass())
		    return false;
		Arete other = (Arete) obj;
		return ((s1==other.s1 && s2==other.s2) || (s1==other.s2 && s2==other.s1));
  }
}
