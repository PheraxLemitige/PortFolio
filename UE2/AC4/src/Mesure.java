
import MG3D.geometrie.Maillage;
import MG3D.geometrie.Sommet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Mesure {

    public static String chercherFichier(){
    // Objet qui contiendra le chemin du fichier à lire.
    String chemin = new String();
    // Pour la lecture au clavier.
    Scanner clavier = new Scanner(System.in);
    boolean reussi = false;
    while(!(reussi)){
        reussi = true;
        try{
            // On demande à l'utilisateur le nom du fichier à lire.
            // On récupère le résultat grâce au scanner.
            System.out.println("Entrez le nom du fichier à lire  correct:");
            chemin = clavier.next();
            
            // On crée un objet de type fichier qui sera passé en
            // paramètre à un scanner pour lecture.
            File f = new File(chemin);
            // Création du scanner pour lire le contenu du fichier.
            // C'est ce constructeur qui peut lever une exception.
            // https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Scanner.html#%3Cinit%3E(java.io.File)
            Scanner sc = new Scanner(f);
            
            // On ferme le scanner pour libérer la ressource.
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("Une erreur sur le fichier");
            reussi = false;
            }
        }
        return chemin;
    }

    public static int chercherDebut (){
        // Objet qui contiendra le chemin du fichier à lire.
    int debut = 0;
    // Pour la lecture au clavier.
    Scanner clavier = new Scanner(System.in);
    boolean reussi = false;
    while(!(reussi)){
        reussi = true;
        try{
            // On demande à l'utilisateur le nombre.
            // On récupère le résultat grâce au scanner.
            System.out.println("Entrez le nombre du premier:");
            String le_int_debut = clavier.next();

            
            debut = Integer.parseInt(le_int_debut);
            
        } catch(NumberFormatException e){
            System.out.println("Une erreurce n'est pas un entier");
            reussi = false;
            }
        }
        return debut;
    }
    public static int chercherFin(){

    int fin = 0;
    // Pour la lecture au clavier.
    Scanner clavier = new Scanner(System.in);
    boolean reussi = false;
    while(!(reussi)){
        reussi = true;
        try{
            
            System.out.println("Entrez le nombre du premier:");
            String le_int_fin = clavier.next();

            //On transforme notre entier de fin qui est en string par un entier 
            fin = Integer.parseInt(le_int_fin);
        } catch(NumberFormatException e){
            System.out.println("Une erreurce n'est pas un entier");
            reussi = false;
            }
        }
        return fin;
    }

    public static int plusPetit(double[] la_list, Sommet[] pas_vus, int nb_s){
        int plus_petit = 0;

        //on fait la boucle pour avoir le plus petit
        for (int i = 1; i < nb_s; i++){
            if(pas_vus[plus_petit] == null){
                plus_petit = plus_petit + 1;
            }
            else if(pas_vus[i] != null && la_list[plus_petit] >= la_list[i]){
                plus_petit = i;
            }
        }
        return plus_petit;
    }

    public static ArrayList<Integer> Dijkstra(int s_source, int s_destination, Maillage m){
        int nb_s = m.getNbSommets();
        int arret = m.getNbSommets() - 1;
        double[] sommet_dist = new double[nb_s];
        int[] sommet_prec = new int[nb_s];
        Sommet[] sommet = new Sommet[nb_s];

        //On remplit les liste 
        for (int i = 0; i < nb_s; i++){
            sommet_dist[i] = Integer.MAX_VALUE;
            sommet_prec[i] = 0;
            sommet[i] = m.getSommet(i);
        }



        sommet_dist[s_source] = 0;

        ArrayList<Integer> voisins = new ArrayList<Integer>();
        int le_plus_petit = s_source;

        //On va faire une boucle while pour le termier quand on a plus de sommet a visiter
        while(arret > 0){
                voisins = sommet[le_plus_petit].getVoisins();

                //On va visiter chaque voisins et changer la distance minimun a la quel il peut etre atteins
                for (int j = 0; j < voisins.size(); j ++){
                    if (sommet[voisins.get(j)] != null && sommet_dist[voisins.get(j)] > sommet_dist[le_plus_petit] + sommet[le_plus_petit].longueur(sommet[voisins.get(j)])){
                        sommet_dist[voisins.get(j)] = sommet_dist[le_plus_petit] + sommet[le_plus_petit].longueur(sommet[voisins.get(j)]);
                        sommet_prec[voisins.get(j)] = le_plus_petit;
                    }
                }
                
                //On va chercher le plus petit
                sommet[le_plus_petit] = null;
                le_plus_petit = plusPetit(sommet_dist, sommet, nb_s);
                arret = arret -1;
        }

        System.out.println(sommet_dist[s_destination]);
        int s = le_plus_petit;
        ArrayList<Integer> chemin = new ArrayList<Integer>();

        //on va remplir le chemin
        while (s != s_source){
            chemin.add(s);
            s = sommet_prec[s];
        }
        chemin.add(s);

        
        return chemin;
    }
    public static void main(String[] args) throws IOException{
        String chemin = chercherFichier();
        int debut = chercherDebut();
        int fin = chercherFin();
        Maillage m = new Maillage(chemin);
        ArrayList<Integer> les_sommets = Dijkstra(debut, fin, m);

        //On va remplir notre fichier texte
        FileWriter fw = new FileWriter("chemin.txt");
        fw.write(chemin + "\n");
        String le_chemin_som = new String();
        
        for (int i = 0; i < les_sommets.size(); i++){
            le_chemin_som = le_chemin_som + les_sommets.get(i).toString() + " ";
        }
        fw.append(le_chemin_som);
        fw.close();
    }
}
