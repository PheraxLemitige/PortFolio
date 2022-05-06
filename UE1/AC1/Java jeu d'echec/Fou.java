import java.util.ArrayList;

public class Fou extends Piece{

    //Le constructeur
    public Fou(){
        super();
    }
    public Fou(char la_couleur, Position la_position){
        super(la_couleur, la_position);
    }

    //Le getType
    public String getType(){
        return "fou";
    }

    //Le getDeplacementPossible
    public ArrayList<Position> getDeplacementPossible(Plateau plat){
        ArrayList<Position> les_pos = new ArrayList<Position>();
        Position pos = new Position(this.position);

        //Diagonales haut
        //Haut et gauche
        for (int i=1; i < 9; i++){
            if (position.get_X() - i < 8 && pos.get_X() - i >= 0 && pos.get_Y() + i >= 0 && pos.get_Y() + i < 8){
                Position posHautGauche = new Position(( pos.get_X() - i ),( pos.get_Y() + i ));
                if(plat.getCase(posHautGauche) != null && plat.getCase(posHautGauche).getCouleur() == this.getCouleur()){
                    break;
                }
                if(plat.getCase(posHautGauche) == null){
                    les_pos.add(posHautGauche);
                }
                if (plat.getCase(posHautGauche) != null && plat.getCase(posHautGauche).getCouleur() != this.getCouleur()){
                    les_pos.add(posHautGauche);
                    break;
                }
                
            }
        }

        //Haut et droite 
        for (int i=1; i < 9; i++){
            if (pos.get_X() + i < 8 && pos.get_X() + i >= 0 && pos.get_Y() + i >= 0 && pos.get_Y() + i < 8){
                Position posHautDroite = new Position((pos.get_X() + i ), (pos.get_Y() + i ));
                if (plat.getCase(posHautDroite) != null && plat.getCase(posHautDroite).getCouleur() == this.getCouleur()){
                    break;
                }
                if(plat.getCase(posHautDroite) == null){
                    les_pos.add(posHautDroite);
                }
                if(plat.getCase(posHautDroite) != null && plat.getCase(posHautDroite).getCouleur() != this.getCouleur()){
                    les_pos.add(posHautDroite);
                    break;
                }
                
            }   
        }

        //Diagonales bas
        //Bas et gauche
        for (int i=1; i < 9; i++){
            if (pos.get_X() - i < 8 && pos.get_X() - i >= 0 && pos.get_Y() - i >= 0 && pos.get_Y() - i < 8){
                Position posBasGauche = new Position(( pos.get_X() - i ),( pos.get_Y() - i ));
                if(plat.getCase(posBasGauche) != null && plat.getCase(posBasGauche).getCouleur() == this.getCouleur()){
                    break;
                } 
                if(plat.getCase(posBasGauche) == null ){
                    les_pos.add(posBasGauche);
                }   
                if(plat.getCase(posBasGauche) != null && plat.getCase(posBasGauche).getCouleur() != this.getCouleur()){
                    les_pos.add(posBasGauche);
                    break;
                }
            }
        }

        //Bas et droite
        for (int i=1; i < 9; i++){
            if (pos.get_X() + i < 8 && pos.get_X() + i >= 0 && pos.get_Y() - i >= 0 && pos.get_Y() - i < 8){
                Position posBasDroite = new Position(( pos.get_X() + i ),( pos.get_Y() - i ));
                if(plat.getCase(posBasDroite) != null && plat.getCase(posBasDroite).getCouleur() == this.getCouleur()){
                    break;
                }
                if(plat.getCase(posBasDroite) == null){
                les_pos.add(posBasDroite);
                }
                if (plat.getCase(posBasDroite) != null && plat.getCase(posBasDroite).getCouleur() != this.getCouleur()){
                    les_pos.add(posBasDroite);
                    break;
                }
            }
        }
        return les_pos;
    }
}
