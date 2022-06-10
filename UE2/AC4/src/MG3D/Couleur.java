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

package MG3D;

/**
 * Classe permettant de gérer les couleurs.<br />
 * Cette classe contient des constantes représentant les couleurs les plus utiliées.<br />
 * Vous pourrez toujours utiliser le constructeur prenant 3 entiers r, v et b en paramètre pour créer vos propres couleurs.
 * @author Ryan Verlande, Antonin Bocket, Gaetan Duplouy, Teddy Lamarre, Benjamin Lannoy, Rémi Synave
 * @version 0.2
 */
public class Couleur {
    private int rouge, vert, bleu;

    /**
     * Constantes à utiliser pour le noir.
     */
    public static final Couleur NOIR = new Couleur(0, 0, 0);
    /**
     * Constantes à utiliser pour le blanc.
     */
    public static final Couleur BLANC = new Couleur(255, 255, 255);
    /**
     * Constantes à utiliser pour le rouge.
     */
    public static final Couleur ROUGE = new Couleur(255, 0, 0);
    /**
     * Constantes à utiliser pour le vert.
     */
    public static final Couleur VERT = new Couleur(0, 255, 0);
    /**
     * Constantes à utiliser pour le bleu.
     */
    public static final Couleur BLEU = new Couleur(0, 0, 255);
    /**
     * Constantes à utiliser pour le cyan.
     */
    public static final Couleur CYAN = new Couleur(0, 255, 255);
    /**
     * Constantes à utiliser pour le gris.
     */
    public static final Couleur GRIS = new Couleur(127, 127, 127);
    /**
     * Constantes à utiliser pour le gris foncé.
     */
    public static final Couleur GRIS_FONCE = new Couleur(96, 96, 96);
    /**
     * Constantes à utiliser pour le gris clair.
     */
    public static final Couleur GRIS_CLAIR = new Couleur(158, 158, 158);
    /**
     * Constantes à utiliser pour le magenta.
     */
    public static final Couleur MAGENTA = new Couleur(255, 0, 255);
    /**
     * Constantes à utiliser pour le orange.
     */
    public static final Couleur ORANGE = new Couleur(255, 127, 0);
    /**
     * Constantes à utiliser pour le rose.
     */
    public static final Couleur ROSE = new Couleur(249, 66, 158);
    /**
     * Constantes à utiliser pour le jaune.
     */
    public static final Couleur JAUNE = new Couleur(255, 255, 0);

    /**
     * Constructeur par défaut. 
     * La couleur créée par défaut est du noir.
     */
    public Couleur() {
        rouge = 0;
        vert = 0;
        bleu = 0;
    }

    /**
     * Création d'une couleur personnalisée.<br />
     * Vous pouvez donner les valeurs de rouge, vert et bleu que vous souhaitez. Attention, les valeurs sont comprises entre 0 et 255.
     * @param r Valeur de rouge.
     * @param v Valeur de vert.
     * @param b Valeur de bleu.
     */
    public Couleur(int r, int v, int b) {
        rouge = r;
        vert = v;
        bleu = b;
    }

    /**
     * Constructeur par copie.
     * @param c la couleur à copier.
     */
    public Couleur(Couleur c) {
        rouge = c.rouge;
        vert = c.vert;
        bleu = c.bleu;
    }

    /**
     * Test de la couleur afin de savoir si elle est blanche.
     * @return Vrai si la couleur est blanche, faux sinon.
     */
    public boolean estBlanc() {
        return (equals(Couleur.BLANC));
    }

    /**
     * Test de la couleur afin de savoir si elle est noire.
     * @return Vrai si la couleur est noire, faux sinon.
     */
    public boolean estNoir() {
        return (equals(Couleur.NOIR));
    }

    /**
     * Méthode toString retournant un description de la couleur.<br />
     * La chaine de caractères retournée est de la forme "(r,v,b) = (x,x,x)".
     * @return Une chaîne de caractères décrivant la couleur.
     */
    public String toString() {
        return new String("(r,v,b)=(" + getRed() + "," + getGreen() + "," + getBlue() + ")");
    }

   
    /**
     * Méthode permettant d'accéder à la composante rouge de la couleur.<br />
     * Attention ! La composante est retournée sous forme d'un réel entre 0 et 1.
     * @return la composante rouge de la couleur sous forme d'un réel entre 0 et 1.
     */
    public float getRed() {
        return (float)(rouge / 255.0);
    }

    /**
     * Méthode permettant d'accéder à la composante verte de la couleur.<br />
     * Attention ! La composante est retournée sous forme d'un réel entre 0 et 1.
     * @return la composante verte de la couleur sous forme d'un réel entre 0 et 1.
     */
    public float getGreen() {
        return (float)(vert / 255.0);
    }

    /**
     * Méthode permettant d'accéder à la composante bleue de la couleur.<br />
     * Attention ! La composante est retournée sous forme d'un réel entre 0 et 1.
     * @return la composante bleue de la couleur sous forme d'un réel entre 0 et 1.
     */
    public float getBlue() {
        return (float)(bleu / 255.0);
    }

    /**
     * Méthode equals permettant de tester l'égalité entre la couleur et un objet passé en paramètre.
     * @return Vrai si l'objet passé en paramètre est une couleur dont les caractéristiques sont les mêmes que la couleur sur laquelle la méthode est appelée.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        // Vérification du type du paramètre 
        if (obj instanceof Couleur) {
            // Vérification des valeurs des attributs 
            Couleur other = (Couleur) obj;
            return getRed() == other.getRed() && getGreen() == other.getGreen() && getBlue() == other.getBlue();
        }
        return false;
    }

}
