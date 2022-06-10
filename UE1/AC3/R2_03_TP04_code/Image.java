import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Cette classe permet la création d'images.<br />
 * Une image est une grille rectangulaire ou carrée contenant une couleur (objet de type Couleur) par case. Chaque case est appelé <strong>pixel</strong>. Chaque pixel est donc un objet de type Couleur.<br />
 * Cette classe propose un ensemble d'opérations sur les images telles que le passage en niveau de gris, en négatif, etc.<br />
 * Les images peuvent être lues depuis des fichiers au format PPM. La sauvegarde s'effectue également au format PPM.<br />
 * Les images ont une taille en X (largeur) et en Y (hauteur). L'origine de l'image se trouve en haut à gauche. Chaque pixel peut être identifié par ses coordonnées. L'origine de l'image se trouve sur le pixel (0,0) qui se trouve donc en haut à gauche. Le pixel (1,0) sera le second, celui qui se trouve juste à sa droite, etc.<br />
 * Les pixels (objet de type Couleur) sont stockés dans un tableau dynamique dans l'ordre de leur apparition sur l'image. De gauche à droite et de haut en bas. Le premier élément du tableau sera le pixel se trouvant en (0,0). Le second élément sera le pixel se trouvant en (1,0), etc. jusqu'à la fin de la première ligne de pixel. L'élément suivant sera le premier pixel de la seconde ligne, celui se trouvant en (0,1), etc.
 * @author Rémi Synave
 * @version 1.0
 * @see Couleur
 * Date : 10/03/2013
 */
public class Image {
    
    /**
     * Taille en X de l'image - Largeur.
     */
    private int tailleX;
    
    /**
     * Taille en Y de l'image - Hauteur.
     */
    private int tailleY;
    
    /**
     * Liste des pixels (objets de type Couleur) de l'image.
     * @see Couleur
     */
    private ArrayList<Couleur> pixels;

    /**
     * Création d'une image noire de 1x1 pixel.
     */
    public Image() {
	// Constructeur par défaut, sans paramètre.
	// Création d'une image vide
	this.tailleX = 1;
	this.tailleY = 1;
	this.pixels = new ArrayList<Couleur>();
	this.pixels.add(new Couleur());
    }
    
    /**
     * Création d'une image noire dont la taille est fournie en paramètre.
     * @param tailleX largeur de l'image.
     * @param tailleY hauteur de l'image.
     */
    public Image(int tailleX, int tailleY) throws RuntimeException{
	// Constructeur par défaut, sans paramètre.
	// Création d'une image vide
	if(tailleX < 1 || tailleY < 1)
	    throw new RuntimeException("La taille d'une image doit être supérieur à 0 : "+tailleX+", "+tailleY);
	this.tailleX = tailleX;
	this.tailleY = tailleY;
	this.pixels = new ArrayList<Couleur>();
	for(int i = 0 ; i<this.tailleX*this.tailleY;i++)
	    this.pixels.add(new Couleur());
    }
    
    /**
     * Création d'une image à partir du chemin fourni en paramètre.<br />
     * Attention, l'image doit être au format PPM.
     * @param chemin chemin vers l'image.
     */
    public Image(String chemin) throws java.io.IOException, RuntimeException {
	// Constructeur prenant un chemin en paramètre.
	// Ouverture d'une image contenue dans un fichier

	// Ouverture du fichier ppm
	File fichier = new File(chemin);
	// Ouverture d'un Scanner permettant le parcours du fichier
	Scanner lecteur = new Scanner(fichier);
	int r, v, b;

	// Instanciation du vecteur de Couleur
	this.pixels = new ArrayList<Couleur>();

	String p3 = lecteur.next();

	if (!p3.equals("P3")) {
	    // Si la première chose lue n'est pas "P3" alors l'image n'est pas correcte.
	    // Nous créons donc une image vide.
	    throw new RuntimeException("Erreur dans le format de fichier. Magic number P3 non trouvé.");
	} else {
	    // lecture de la taille de l'image
	    this.tailleX = lecteur.nextInt();
	    this.tailleY = lecteur.nextInt();
	    // lecture de la profondeur des couleurs. Information non conservée
	    r = lecteur.nextInt();
	    for (int i = 0; i < tailleX * tailleY; i++) {
		// lecture de toutes les couleurs de pixel
		r = lecteur.nextInt();
		v = lecteur.nextInt();
		b = lecteur.nextInt();
		// Ajout de cette couleur dans le vecteur
		this.pixels.add(new Couleur(r, v, b));
	    }
	}
    }

    /**
     * Création d'une copie d'une image.
     * @param img l'image à copier.
     */
    public Image(Image img) {
	// Constructeur par copie
	// recopie membre à membre des attributs de l'image passé en paramètre
	this.tailleX = img.tailleX;
	this.tailleY = img.tailleY;
    this.pixels = new ArrayList<Couleur>();
	// Recopie du vecteur de couleur
	for (int i = 0; i < tailleX; i++)
	    for (int j = 0; j < tailleY; j++)
		this.pixels.add(new Couleur(img.getPixel(j,i)));	    
    }


    
    /**
     * Récupération de la largeur de l'image.
     * @return la largeur de l'image.
     */
    public int getTailleX() {
	return tailleX;
    }

    /**
     * Récupération de la hauteur de l'image.
     * @return la hauteur de l'image.
     */
    public int getTailleY() {
	return tailleY;
    }

    /**
     * Récupération d'un pixel, d'un objet de type Couleur.<br />
     * Si les coordonnées passées en paramètre ne sont pas corrects, une exception de type IndexOutOfBoundsException sera levée.
     * @param x coordonnées en X du pixel à récupérer.
     * @param y coordonnées en Y du pixel à récupérer.
     * @return L'objet Couleur contenu dans le pixel (x, y).
     * @see Couleur
     */
    public Couleur getPixel(int x, int y) throws IndexOutOfBoundsException {
	    return pixels.get(y * tailleX + x);
    }
    
    /**
     * Modification de la couleur d'un pixel.<br />
     * Les coordonnées du pixel sont passées en paramètre ainsi que la nouvelle couleur.<br />
     * Si les coordonnées passées en paramètre ne sont pas corrects, une exception de type IndexOutOfBoundsException sera levée.
     * @param x coordonnées en X du pixel à modifier.
     * @param y coordonnées en Y du pixel à modifier.
     * @param c nouvelle couleur pour le pixel.
     * @see Couleur
     */
    public void setPixel(int x, int y, Couleur c)  throws RuntimeException, IndexOutOfBoundsException{
	pixels.set(y * tailleX + x, c);
	
    }

    /**
     * Modification de la couleur d'un pixel.<br />
     * Les coordonnées du pixel sont passées en paramètre ainsi que la nouvelle couleur.<br />
     * Si les coordonnées passées en paramètre ne sont pas corrects, une exception de type IndexOutOfBoundsException sera levée.
     * @param x coordonnées en X du pixel à modifier.
     * @param y coordonnées en Y du pixel à modifier.
     * @param r composante rouge de la nouvelle couleur du pixel.
     * @param v composante verte de la nouvelle couleur du pixel.
     * @param b composante bleue de la nouvelle couleur du pixel.
     * @see Couleur
     */
    public void setPixel(int x, int y, int r, int v, int b)  throws RuntimeException, IndexOutOfBoundsException{
	this.setPixel(x, y, new Couleur(r, v, b));
    }

    /**
     * Modification de l'image pour la rendre totalement blanche.
     */
    public void setBlanc(){
	for (int i = 0; i < tailleX * tailleY; i++)
	    this.pixels.set(i, new Couleur(255,255,255));
    }
    
    /**
     * Modification de l'image pour la rendre totalement noire.
     */
    public void setNoir(){
	for (int i = 0; i < tailleX * tailleY; i++)
	    this.pixels.set(i, new Couleur(0,0,0));
    }

    /**
     * Sauvegarde de l'image dans un fichier au format PPM.<br />
     * Si le fichier passé en paramètre n'a pas une extension en ppm, une exception est levée.
     * @param chemin chemin vers le fichier à sauvegarder.
     */
    public void sauver(String chemin) throws java.io.IOException, RuntimeException {
	// Test du nom de fichier qui doit terminer par .ppm
	String parts[] = chemin.split("\\.");
	String ext = parts[parts.length-1];
	if(!ext.equals("ppm"))
	    throw new RuntimeException("L'extension du fichier image doit être .ppm");
	
	// Création d'un nouvel objet capable d'écrire dans un fichier
	FileWriter fichier = new FileWriter(chemin);
	// l'écriture se fait par des write, équivalent de print dans les sorties
	// console.
	// Ne pas oublier le \n
	// écriture de "P3"
	fichier.write("P3\n");
	// écriture de la taille de l'image
	fichier.write(tailleX + " " + tailleY + "\n");
	// écriture de la profondeur des couleurs
	fichier.write("255\n");
	// écriture de tous les pixels
	// attention, nous écrivons directement les couleurs
	// la méthode toString de la classe Couleur est implicitement appelée !
	for (int i = 0; i < tailleX * tailleY; i++)
	    fichier.write(pixels.get(i) + "\n");
	// fermeture du fichier
	fichier.close();
    }

    /**
     * Calcule le négatif de l'image.<br />
     * Le résultat est stocké dans l'image. Elle est donc modifiée.
     * @see Couleur#negatif
     */
    public void negatif() {
	// pour tous les pixels de l'image, on demande à la couleur de calculer son
	// négatif
	for (int i = 0; i < tailleX * tailleY; i++)
	    pixels.get(i).negatif();
    }

    /**
     * Calcule le niveau de gris de l'image.<br />
     * Le résultat est stocké dans l'image. Elle est donc modifiée.
     * @see Couleur#niveauGris
     */
    public void niveauGris() {
	// Pour tous les pixels, on demande à la couleur de calculer son niveau de gris
	for (int i = 0; i < tailleX * tailleY; i++)
	    pixels.get(i).niveauGris();
    }

    /**
     * Calcule la différence entre l'image courante et celle passée en paramètre.<br />
     * Si les images n'ont pas la même taille alors une exception est levée.<br />
     * La différence est calculée au niveau de chaque pixel. Les couleurs sont soutraites deux à deux.
     * Le résultat est stocké dans l'image courante. Elle est donc modifiée.
     * @param comp l'image à soustraire.
     * @see Couleur#difference
     */
    public void difference(Image comp) throws RuntimeException{
	// On vérifie d'abord que les deux images ont même taille sinon on ne fait rien
	if (comp.tailleX == tailleX && comp.tailleY == tailleY) {
	    // Pour tous les pixels, on demande à la couleur de faire la différence
	    // avec le pixel correspondant dans l'image passée en paramètre
	    for (int i = 0; i < tailleX * tailleY; i++)
		pixels.get(i).difference(comp.pixels.get(i));
	}else
	    throw new RuntimeException("Les tailles des images à soustraire sont incompatibles.");	    
    }

    /**
     * Comparaison de l'image courante avec un objet passé en paramètre.
     * @param obj l'objet qui doit être comparé avec l'image.
     * @return vrai si l'image courante et l'objet passé en paramètre représentent la même image, faux sinon.
     */
    public boolean equals(Object obj){
	if(this == obj)
	    return true;
	if( (obj instanceof Image) == false)
	    return false;
	Image img = (Image)(obj);
	if(this.tailleX!=img.tailleX)
	    return false;
	if(this.tailleY!=img.tailleY)
	    return false;
	for(int i=0;i<this.tailleX*this.tailleY;i++)
	    if(!this.pixels.get(i).equals(img.pixels.get(i)))
		return false;
	
	return true;
    }

    /**
     * Permet de récupérer une chaine de caractères listant l'ensemble des couleurs des pixels de l'image.
     * @return une chaine de caractère représentant l'ensemble des pixels de l'image.
     */
    public String toString() {
	StringBuffer str = new StringBuffer();
	for (int j = 0; j < tailleY; j++)
	    for (int i = 0; i < tailleX; i++) {
		str.append(pixels.get(j * tailleX + i).toString());
		str.append("\n");
	    }
	return str.toString();
    }
}
