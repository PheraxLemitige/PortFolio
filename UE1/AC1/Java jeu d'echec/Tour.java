import java.util.ArrayList;

public class Tour extends Piece {

    //les constructeurs
    public Tour(){
        super();
    }
    public Tour(char la_couleur, Position la_position){
        super(la_couleur, la_position);
    }

    //Le getType
    public String getType(){
        return "tour";
    }

    //Le getDeplacementPossible
    public ArrayList<Position> getDeplacementPossible(Plateau plat){
        ArrayList<Position> les_pos = new ArrayList<Position>();
        Position pos = new Position(this.position);

        //Gauche 
        for (int i=1; i < 9; i++){
            if (pos.get_X() - i < 8 && pos.get_X() - i >= 0 ){
                Position posGauche = new Position(( position.get_X() - i), (position.get_Y()));
                if (plat.getCase(posGauche) != null && plat.getCase(posGauche).getCouleur() == this.getCouleur()){
                    break;
                }
                if(plat.getCase(posGauche) == null){
                    les_pos.add(posGauche);
                }
                if(plat.getCase(posGauche) != null && plat.getCase(posGauche).getCouleur() != this.getCouleur()){
                    les_pos.add(posGauche);
                    break;
                } 
            }   
        }

        //Droite
        for (int i=1; i < 9; i++){
            if (pos.get_X() + i < 8 && pos.get_X() + i >= 0 ){
                Position posDroite = new Position((pos.get_X() + i), (pos.get_Y()));
                if (plat.getCase(posDroite) != null && plat.getCase(posDroite).getCouleur() == this.getCouleur()){
                    break;
                }
                if(plat.getCase(posDroite) == null){
                    les_pos.add(posDroite);
                }
                if(plat.getCase(posDroite) != null && plat.getCase(posDroite).getCouleur() != this.getCouleur()){
                    les_pos.add(posDroite);
                    break;
                } 
            }   
        }

        //Haut
        for (int i=1; i < 9; i++){
            if (pos.get_Y() + i < 8 && pos.get_Y() + i >= 0 ){
                Position posHaut = new Position(( pos.get_X()), (pos.get_Y() + i));
                if (plat.getCase(posHaut) != null && plat.getCase(posHaut).getCouleur() == this.getCouleur()){
                    break;
                }
                if(plat.getCase(posHaut) == null){
                    les_pos.add(posHaut);
                }
                if(plat.getCase(posHaut) != null && plat.getCase(posHaut).getCouleur() != this.getCouleur()){
                    les_pos.add(posHaut);
                    break;
                } 
            }   
        }

        //Bas
        for (int i=1; i < 9; i++){
            if (pos.get_Y() - i < 8 && pos.get_Y() - i >= 0 ){
                Position posBas = new Position(( pos.get_X()), (pos.get_Y() - i));
                if (plat.getCase(posBas) != null && plat.getCase(posBas).getCouleur() == this.getCouleur()){
                    break;
                }
                if(plat.getCase(posBas) == null){
                    les_pos.add(posBas);
                }
                if(plat.getCase(posBas) != null && plat.getCase(posBas).getCouleur() != this.getCouleur()){
                    les_pos.add(posBas);
                    break;
                } 
            }   
        }

        return les_pos;
    }
}
