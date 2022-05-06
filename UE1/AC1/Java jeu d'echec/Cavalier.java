import java.util.ArrayList;

public class Cavalier extends Piece{

    //les constructeurs
    public Cavalier(){
        super();
    }
    public Cavalier(char la_couleur, Position la_position){
        super(la_couleur, la_position);
    }

    //Le getType
    public String getType(){
        return "cavalier";
    }

    //Le getDeplacementPossible
    public ArrayList<Position> getDeplacementPossible(Plateau plat){
        ArrayList<Position> les_pos = new ArrayList<Position>();

        //On fait les 8 emplacements ou peut aller le cavalier possible 
        Position pos = new Position(this.position.get_X() + 1, this.position.get_Y() + 2);
        if (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur)){
            les_pos.add(new Position(pos));
        }
        pos = new Position(this.position.get_X() - 1, this.position.get_Y() + 2);
        if (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur)){
            les_pos.add(new Position(pos));
        }
        pos = new Position(this.position.get_X() + 2, this.position.get_Y() + 1);
        if (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur)){
            les_pos.add(new Position(pos));
        }
        pos = new Position(this.position.get_X() + 2, this.position.get_Y() - 1);
        if (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur)){
            les_pos.add(new Position(pos));
        }
        pos = new Position(this.position.get_X() - 2, this.position.get_Y() + 1);
        if (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur)){
            les_pos.add(new Position(pos));
        }
        pos = new Position(this.position.get_X() - 2, this.position.get_Y() - 1);
        if (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur)){
            les_pos.add(new Position(pos));
        }
        pos = new Position(this.position.get_X() + 1, this.position.get_Y() - 2);
        if (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur)){
            les_pos.add(new Position(pos));
        }
        pos = new Position(this.position.get_X() - 1, this.position.get_Y() - 2);
        if (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur)){
            les_pos.add(new Position(pos));
        }
        
        return (les_pos);
    }
}
