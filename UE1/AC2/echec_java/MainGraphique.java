import MG2D. * ;
import MG2D. geometrie . * ;
import java.util.ArrayList;

public class MainGraphique {

    public static void remplir_case(Fenetre f){
        for (int i = 0;i <= 7; i++){
            for (int j = 0; j <= 7; j++){
                if (i % 2 == 0 && j % 2 == 1){
                    Carre la_case = new Carre(new Couleur(41, 49, 51), new Point(i * 100, j * 100), 100, true);
                    f.ajouter(la_case);
                }
                else if(i % 2 == 1 && j % 2 == 0){
                    Carre la_case = new Carre(new Couleur(41, 49, 51), new Point(i * 100, j * 100), 100, true);
                    f.ajouter(la_case);
                }
                else{
                    Carre la_case = new Carre(new Couleur(255, 255, 255), new Point(i * 100, j * 100), 100, true);
                    f.ajouter(la_case);
                }
                
            }
        }
    }
    public static void remplir_piece(Fenetre f){
        Plateau mon_plat = new Plateau();
        String chemin = new String();
        Piece ma_piece;
        Texture la_case;
        for (int i = 0;i <= 7; i++){
            for (int j = 0; j <= 7; j++){
                if (mon_plat.getCase(j, i) == null){
                }
                else{
                    ma_piece = mon_plat.getCase(j, i);
                    chemin = "images\\";
                    chemin += ma_piece.getNomLong() + ".png";
                    la_case = new Texture(chemin, new Point(ma_piece.getPosition().get_X() * 100, ma_piece.getPosition().get_Y() * 100), 100, 100);
                    f.ajouter(la_case);
                }
            }
        }
    }

    public static Position position_piece_clic(Souris mouse){
        Point clic = new Point(mouse.getPosition());
        int x = (int)Math.floor(clic.getX() / 100);
        int y = (int)Math.floor(clic.getY() / 100);
        return (new Position(x, y));
    }

    public static void pose_depl_possible (Position la_pos, Plateau p, Fenetre f){
        if (p.getCase(la_pos) != null){
            ArrayList<Position> les_pos = p.getCase(la_pos).getDeplacementPossible(p);
            for (int i = 0; i < les_pos.size(); i ++){
                Cercle le_cercle = new Cercle(new Couleur(255, 0, 0), new Carre(new Point(les_pos.get(i).get_X() * 100, les_pos.get(i).get_Y() * 100), 100, true));
                f.ajouter(le_cercle);
            }
        }
    }

    public static void del_pose_depl_possible (Position la_pos, Plateau p, Fenetre f){
        if (p.getCase(la_pos) != null){
            ArrayList<Position> les_pos = p.getCase(la_pos).getDeplacementPossible(p);
            for (int i = 0; i < les_pos.size(); i ++){
                Cercle le_cercle = new Cercle(new Couleur(255, 0, 0), new Carre(new Point(les_pos.get(i).get_X() * 100, les_pos.get(i).get_Y() * 100), 100, true));
                f.supprimer(le_cercle);
            }
        }
    }

    public static void deplacer_piece(Position from, Position to, Plateau p, Fenetre f){
        String chemin = new String();
        Piece ma_piece = p.getCase(from);
        Texture la_piece;
        chemin += "images\\" + ma_piece.getNomLong() + ".png";
        la_piece = new Texture(chemin, new Point(from.get_X() * 100, from.get_Y() * 100), 100, 100);
        if (from.get_X() % 2 == 0 && from.get_Y() % 2 == 1){
            Carre la_case = new Carre(new Couleur(41, 49, 51), new Point(from.get_X() * 100, from.get_Y() * 100), 100, true);
            f.ajouter(la_case);
        }
        else if(from.get_X() % 2 == 1 && from.get_Y() % 2 == 0){
            Carre la_case = new Carre(new Couleur(41, 49, 51), new Point(from.get_X() * 100, from.get_Y() * 100), 100, true);
            f.ajouter(la_case);
        }
        else{
            Carre la_case = new Carre(new Couleur(255, 255, 255), new Point(from.get_X() * 100, from.get_Y() * 100), 100, true);
            f.ajouter(la_case);
        }
        f.supprimer(la_piece);
        if(p.getCase(to) != null){
            if (to.get_X() % 2 == 0 && to.get_Y() % 2 == 1){
                Carre la_case = new Carre(new Couleur(41, 49, 51), new Point(from.get_X() * 100, from.get_Y() * 100), 100, true);
                f.ajouter(la_case);
            }
            else if(to.get_X() % 2 == 1 && to.get_Y() % 2 == 0){
                Carre la_case = new Carre(new Couleur(41, 49, 51), new Point(from.get_X() * 100, from.get_Y() * 100), 100, true);
                f.ajouter(la_case);
            }
            else{
                Carre la_case = new Carre(new Couleur(255, 255, 255), new Point(from.get_X() * 100, from.get_Y() * 100), 100, true);
                f.ajouter(la_case);
            }
            p.piecePrise(to);
        }
        la_piece.setA(new Point(to.get_X() * 100, to.get_Y() * 100));
        f.ajouter(la_piece);
        del_pose_depl_possible(from, p, f);
        f.rafraichir();
        p.getCase(from).setPosition(to);
    }
    public static void main(String args[]){
        Fenetre f = new Fenetre("Mon_echequier", 800, 800);
        remplir_case(f);
        remplir_piece(f);
        f.rafraichir();
        Souris mouse = f.getSouris();
        Plateau p = new Plateau();
        Position la_pos;
        int i = - 1;
        ArrayList<Position> les_pos = new ArrayList<Position>();
        boolean clic_depla;
        int joueur = 0;
        char[] couleur = {'B', 'N'};

        while(true) {
            if (mouse.getClicGauche()) {
                la_pos = position_piece_clic(mouse);
                clic_depla = false;
                if (p.getCase(la_pos) == null | (p.getCase(la_pos) != null && p.getCase(la_pos).getCouleur() == couleur[joueur])){
                    if(i != -1){
                        if (p.getCase(les_pos.get(i)) != null){
                            if (p.deplacer(les_pos.get(i), la_pos)){
                                deplacer_piece(les_pos.get(i), la_pos, p, f);
                                clic_depla = true;
                                
                            }
                            del_pose_depl_possible(les_pos.get(i), p, f);
                        }
                        if (!(clic_depla)){
                            pose_depl_possible(la_pos, p, f);
                        }
                    }
                    else{
                        pose_depl_possible(la_pos, p, f);
                    }
                    f.rafraichir();
                    
                    les_pos.add(la_pos);
                    i += 1;
                    if (clic_depla){
                        joueur = (joueur + 1) % 2;
                        if(p.estEchec(couleur[joueur])){
                            System.out.println("Le roi " + Character.toString(couleur[joueur]) + " est en echec");
                        }
                    }
                }
            }

            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
}
