/**
 * Classe permettant de gérer la couleur des pixels d'un objet de type Image.<br />
 * Une couleur est un triplet de valeurs (r, v, b) correspondant respectivement
 * à la composante rouge, verte et bleue. Ces valeurs sont comprises entre 0 et 255,
 * 0 signifiant l'absence de cette composante dans la couleur et 255 une puissance maximale de cette composante.<br />
 * Ainsi, le triplet :
 * <ul>
 * <li>(255,0,0) correspond à la couleur rouge (puissance maximale de rouge et absence des composantes verte et bleue).</li>
 * <li>(0,255,0) correspond à la couleur verte (puissance maximale de vert et absence des composantes rouge et bleue).</li>
 * <li>(0,0,255) correspond à la couleur bleue (puissance maximale de bleu et absence des composantes rouge et verte).</li>
 * <li>(255,255,0) correspond à la couleur jaune (puissance maximale de vert et de rouge et absence de la composante bleue).</li>
 * <li>Pour une liste exhaustive des couleurs, vous pouvez consulter la page wikipédia :<br />
 * <a href="http://fr.wikipedia.org/wiki/Liste_de_couleurs">http ://fr.wikipedia.org/wiki/Liste_de_couleurs</a></li>
 * </ul>
 * @author Rémi Synave
 * @version 1.0
 * @see Image
 * Date : 10/03/2013
 */

public class Couleur {
    
    /**
     * Composante rouge de la couleur.
     */
    private int r;
    
    /**
     * Composante verte de la couleur.
     */
    private int v;
    
    /**
     * Composante bleue de la couleur.
     */
    private int b;

    /**
     * Création d'une couleur noire.
     */
    public Couleur() {
	this.r = 0;
	this.v = 0;
	this.b = 0;
    }

    /**
     * Création d'un couleur personnalisée. Les trois paramètres doivent être compris entre 0 et 255. Si ce n'est pas le cas, le constructeur lève une RuntimException.
     * @param r composante rouge de la couleur.
     * @param v composante verte de la couleur.
     * @param b composante bleue de la couleur.
     */
    public Couleur(int r, int v, int b) throws RuntimeException {
	if (r < 0 || r > 255)
	    throw new RuntimeException("Erreur dans la composante R de la couleur : " + r + ", " + v + ", " + b);
	else
	    this.r = r;
	if (v < 0 || v > 255)
	    throw new RuntimeException("Erreur dans la composante V de la couleur : " + r + ", " + v + ", " + b);
	else
	    this.v = v;
	if (b < 0 || b > 255)
	    throw new RuntimeException("Erreur dans la composante B de la couleur : " + r + ", " + v + ", " + b);
	else
	    this.b = b;
    }

    /**
     * Copie d'une couleur.
     * @param c la couleur à copier.
     */
    public Couleur(Couleur c) {
	this.r = c.r;
	this.v = c.v;
	this.b = c.b;
    }

    /**
     * Récupération de la composante rouge de la couleur.
     * @return composante rouge.
     */
    public int getR() {
	return this.r;
    }

    /**
     * Récupération de la composante verte de la couleur.
     * @return composante verte.
     */

    public int getV() {
	return this.v;
    }

    /**
     * Récupération de la composante bleue de la couleur.
     * @return composante bleue.
     */

    public int getB() {
	return this.b;
    }

    /**
     * Modification de la composante rouge de la couleur. La valeur doit être compris entre 0 et 255. Si ce n'est pas le cas, la méthode lève une RuntimException.
     * @param r nouvelle valeur de la composante rouge.
     */
    public void setR(int r) throws RuntimeException {
	if (r < 0 || r > 255)
	    throw new RuntimeException("Erreur dans la composante R : " + r);
	else
	    this.r = r;
    }

    /**
     * Modification de la composante verte de la couleur. La valeur doit être compris entre 0 et 255. Si ce n'est pas le cas, la méthode lève une RuntimException.
     * @param v nouvelle valeur de la composante verte.
     */
    public void setV(int v) {
	if (v < 0 || v > 255)
	    throw new RuntimeException("Erreur dans la composante V : " + r);
	else
	    this.v = v;
    }

    /**
     * Modification de la composante bleue de la couleur. La valeur doit être compris entre 0 et 255. Si ce n'est pas le cas, la méthode lève une RuntimException.
     * @param b nouvelle valeur de la composante bleue.
     */
    public void setB(int b) {
	if (b < 0 || b > 255)
	    throw new RuntimeException("Erreur dans la composante B : " + r);
	else
	    this.b = b;
    }

    /**
     * Test de la couleur pour vérifier si elle correspond à la couleur noire.
     * @return vrai si la couleur correspond au noir, faux sinon.
     */
    public boolean estNoir(){
	return (this.r==0) && (this.v==0) && (this.b==0);
    }

    /**
     * Test de la couleur pour vérifier si elle correspond à la couleur blanche.
     * @return vrai si la couleur correspond au blanc, faux sinon.
     */
    public boolean estBlanc(){
	return (this.r==255) && (this.v==255) && (this.b==255);
    }

    /**
     * Calcule la différence entre la couleur courante et celle passée en paramètre. La différence se fait composante par composante. On soustrait la composante rouge de la couleur passée en paramètre à la composante rouge de l'objet courant, etc.<br />
     * Le résultat est stocké dans l'objet courant. La couleur est donc modifiée.
     * @param c la couleur à soustraire.
     */
    public void difference(Couleur c) {
	this.r = this.r - c.r;
	this.v = this.v - c.v;
	this.b = this.b - c.b;
    }

    /**
     * Calcule la différence entre la couleur courante et celle passée en paramètre sous forme de 3 entiers représentant les 3 composantes rouge, vert et bleu. La différence se fait composante par composante. On soustrait la composante rouge passée en paramètre à la composante rouge de l'objet courant, etc.<br />
     * Le résultat est stocké dans l'objet courant. La couleur est donc modifiée.
     * @param r la composante rouge de la couleur à soustraire.
     * @param v la composante verte de la couleur à soustraire.
     * @param b la composante bleue de la couleur à soustraire.
     */
    public void difference(int r, int v, int b) {
	this.difference(new Couleur(r, v, b));
    }

    /**
     * Calcule le négatif de la couleur courante.<br />
     * Le négatif se calcul en inversant la couleur, c'est à dire que, pour toutes les composantes, on remplace la composante par 255-valeurDeLaComposante.<br />
     * Le résultat est stocké dans l'objet courant. La couleur est donc modifiée.
     */
    public void negatif() {
	this.r = 255 - this.r;
	this.v = 255 - this.v;
	this.b = 255 - this.b;
    }
    
    /**
     * Calcule du niveau de gris de la couleur courante.<br />
     * Le niveau de gris est calculer en affectant à chaque composante de la couleur la moyenne des valeurs des composantes.<br />
     * Le résultat est stocké dans l'objet courant. La couleur est donc modifiée.
     */
    public void niveauGris() {
	int moy = (this.r + this.v + this.b) / 3;
	this.r = moy;
	this.v = moy;
	this.b = moy;
    }

    /**
     * Permet de tester si notre objet couleur est égal a un autre objet
     * @param lobjet un type objet ce que l'on veut comparé
     * @return si les deux objet sont égaux
     */
    public boolean equals(Object lobjet){
        if (lobjet instanceof Couleur == false){
            return false;
        }
        Couleur nouv_cou = (Couleur)lobjet;
        return (this.r == nouv_cou.getR() && this.b == nouv_cou.getB() && this.v == nouv_cou.getV());
        }

    /**
     * Permet de récupérer une chaine de caractères contenant les valeurs des composantes de la couleur.
     * @return Chaine de caractères représentant la couleur. Les 3 composantes sont données dans l'ordre séparées par un espace.
     */
    public String toString() {
	return new String(this.r + " " + this.v + " " + this.b);
    }

}
