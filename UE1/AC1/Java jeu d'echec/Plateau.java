import java.util.ArrayList;

public class Plateau {
    private ArrayList<Piece> plateau;

    //Le constructeur
    public Plateau(){
        this.plateau = new ArrayList<Piece>();
        // piece blanche
        this.plateau.add(new Tour('B',new Position(0, 0)));
        this.plateau.add(new Cavalier('B',new Position(1, 0)));
        this.plateau.add(new Fou('B',new Position(2, 0)));
        this.plateau.add(new Dame('B', new Position(3, 0)));
        this.plateau.add(new Roi('B', new Position(4, 0)));
        this.plateau.add(new Tour('B', new Position(7, 0)));
        this.plateau.add(new Cavalier('B', new Position(6, 0)));
        this.plateau.add(new Fou('B', new Position(5, 0)));
        this.plateau.add(new PionBlanc(new Position(0, 1)));
        this.plateau.add(new PionBlanc(new Position(1, 1)));
        this.plateau.add(new PionBlanc(new Position(2, 1)));
        this.plateau.add(new PionBlanc(new Position(3, 1)));
        this.plateau.add(new PionBlanc(new Position(4, 1)));
        this.plateau.add(new PionBlanc(new Position(5, 1)));
        this.plateau.add(new PionBlanc(new Position(6, 1)));
        this.plateau.add(new PionBlanc(new Position(7, 1)));
        //piece noir
        this.plateau.add(new Tour('N', new Position(7, 7)));
        this.plateau.add(new Cavalier('N', new Position(6, 7)));
        this.plateau.add(new Fou('N', new Position(5, 7)));
        this.plateau.add(new Dame('N', new Position(3, 7)));
        this.plateau.add(new Roi('N', new Position(4, 7)));
        this.plateau.add(new Tour('N', new Position(0, 7)));
        this.plateau.add(new Cavalier('N', new Position(1, 7)));
        this.plateau.add(new Fou('N', new Position(2, 7)));
        this.plateau.add(new PionNoir(new Position(0, 6)));
        this.plateau.add(new PionNoir(new Position(1, 6)));
        this.plateau.add(new PionNoir(new Position(2, 6)));
        this.plateau.add(new PionNoir(new Position(3, 6)));
        this.plateau.add(new PionNoir(new Position(4, 6)));
        this.plateau.add(new PionNoir(new Position(5, 6)));
        this.plateau.add(new PionNoir(new Position(6, 6)));
        this.plateau.add(new PionNoir(new Position(7, 6)));
    }

    //les 3 fonctions getCase
    public Piece getCase(int le_x, int le_y){
        Position la_position = new Position(le_x, le_y);

        //On parcours tout les pieces du plateau
        for (int i = 0; i < this.plateau.size(); i ++){

            //Si les coordonnées mit en parametre sont egal a la position de la piece
            if (this.plateau.get(i).getPosition().equals((la_position))){
                return (this.plateau.get(i));
            }
        }
        return (null);
    }

    public Piece getCase(Position la_position){

        //On parcours tout les pieces du plateau
        for (int i = 0; i < this.plateau.size(); i ++){

            //Si les coordonnées mit en parametre sont egal a la position de la piece
            if (this.plateau.get(i).getPosition().equals((la_position))){
                return (this.plateau.get(i));
            }
        }
        return (null);
    }

    public Piece getCase(String l_emplacement){
        Position la_position = new Position(l_emplacement);

        //On parcours tout les pieces du plateau
        for (int i = 0; i < this.plateau.size(); i ++){

            //Si les coordonnées mit en parametre sont egal a la position de la piece
            if (this.plateau.get(i).getPosition().equals((la_position))){
                return (this.plateau.get(i));
            }
        }
        return (null);
    }


    public ArrayList<Piece> getPiecesBlanches() {
        
        ArrayList<Piece> les_blancs = new ArrayList<Piece>();
        Piece la_piece;

        //On parcourt toutes les cases du plateau
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j ++){

                //Si les coordonnées pointent une piece
                if (getCase(j, i) != null){

                    la_piece = getCase(j, i);

                    //si la piece est blanche
                    if (la_piece.getCouleur() == 'B'){
                        les_blancs.add(la_piece);
                    }
                }
            }
        }
        return les_blancs;
    }

    public ArrayList<Piece> getPiecesNoires() {

        ArrayList<Piece> les_noirs = new ArrayList<Piece>();
        Piece la_piece;

        //On parcourt toutes les cases du plateau
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j ++){

                //Si les coordonnées pointent une piece
                if (getCase(j, i) != null){

                    la_piece = getCase(j, i);

                    //si la piece est noire
                    if (la_piece.getCouleur() == 'N'){
                        les_noirs.add(la_piece);
                    }
                }
            }
        }
        return les_noirs;
    }

    public boolean deplacer(Position from, Position to) {

        if(getCase(from) == null){
            return false;
        }

        ArrayList<Position> les_positions = getCase(from).getDeplacementPossible(this);
        for (int i = 0; i < les_positions.size(); i ++){

            if (to.equals(les_positions.get(i))){
                return (true);
            }
        }

        return (false);
    }

    //J'ai du rajouté cette fonction pour le main graphique
    public void piecePrise (Position la_pose){

        for (int i = 0; i < this.plateau.size(); i ++){

            if (la_pose.equals(this.plateau.get(i))){
                this.plateau.remove(i);
            }
        }
    }

    //Le getRoi
    public Piece getRoi (char couleur){
        int index_roi = 0;

        if (couleur == 'N'){

            for (int i = 0; i < plateau.size(); i ++){

                if (plateau.get(i).getType() == "roi" && plateau.get(i).getCouleur() == couleur){

                    index_roi = i;
                }
            }
        }

        else{

            for (int i = 0; i < plateau.size(); i ++){

                if (plateau.get(i).getType() == "roi" && plateau.get(i).getCouleur() == couleur){

                    index_roi = i;
                }
            }
        }

        return (plateau.get(index_roi));
    }

    public boolean estEchec (char couleur){

        ArrayList<Piece> ennemies = new ArrayList<Piece>();
        ArrayList<Position> depla_ennemies = new ArrayList<Position>();
        Piece le_roi;
        boolean echec = false;

        if (couleur == 'N'){

            ennemies = getPiecesBlanches();
        }

        else{

            ennemies = getPiecesNoires();
        }

        le_roi = getRoi(couleur);

        for (int j = 0; j < ennemies.size(); j ++){

            depla_ennemies = ennemies.get(j).getDeplacementPossible(this);
            for (int depla = 0; depla < depla_ennemies.size(); depla ++){

                if(depla_ennemies.get(depla).equals(le_roi.getPosition())){

                    echec = true;
                }
            }
        }

        return echec;
    }

    public String toString() {
        String affichage = new String(" |-A-|-B-|-C-|-D-|-E-|-F-|-G-|-H-|\n");

        for (int i = 0; i < 8; i ++){

            affichage += String.valueOf(i + 1) + "|";
            for (int j = 0; j < 8; j ++){

                if (getCase(j, i) == null){

                    affichage += "   |";
                }
                else{
                    
                    affichage += getCase(j, i).getType().substring(0, 2) + Character.toString(getCase(j, i).getCouleur()) + "|";
                }
                
            }
            affichage = affichage + String.valueOf(i + 1) + "\n |---|---|---|---|---|---|---|---|\n";
        }
        return affichage;
    }

}
