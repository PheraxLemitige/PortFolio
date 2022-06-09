import java.util.ArrayList;

public class PionBlanc extends Pion{

    //les constructeurs
    public PionBlanc(){
        super();
    }
    public PionBlanc(Position la_position){
        super('B', la_position);
    }

    //le getDeplacementPossible
    public ArrayList<Position> getDeplacementPossible(Plateau plat){
        ArrayList<Position> les_pos = new ArrayList<Position>();

        Position pos = new Position(this.position.get_X(), this.position.get_Y() + 2);
        if (this.position.get_Y() == 1 && plat.getCase(pos) == null){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X(), this.position.get_Y() + 1);
        if (this.position.get_Y() < 8 && plat.getCase(pos) == null){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X() - 1, this.position.get_Y() + 1);
        if (this.position.get_Y() < 8 && ((plat.getCase(pos) != null && ! (plat.getCase(pos).getCouleur() == this.couleur)))){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X() + 1, this.position.get_Y() + 1);
        if (this.position.get_Y() < 8 && ((plat.getCase(pos) != null && ! (plat.getCase(pos).getCouleur() == this.couleur)))){
            les_pos.add(new Position(pos));
        }

        return les_pos;
    }
}
