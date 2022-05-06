import java.util.ArrayList;

public class Dame extends Piece{

    //les constructeurs
    public Dame(){
        super();
    }
    public Dame(char la_couleur, Position la_position){
        super(la_couleur, la_position);
    }

    //Le getType
    public String getType(){
        return "dame";
    }

    //Le getDeplacementPossible
    public ArrayList<Position> getDeplacementPossible(Plateau plat){
        ArrayList<Position> les_pos = new ArrayList<Position>();

        //Verification comme la Tour
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
        Position pos = new Position(this.position);
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

        //Verification comme le Fou
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
