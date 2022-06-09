import java.util.ArrayList;

public class Roi extends Piece{

    //Les constructeurs
    public Roi(){
        super();
    }
    public Roi(char la_couleur, Position la_position){
        super(la_couleur, la_position);
    }

    //Le getType
    public String getType(){
        return "roi";
    }

    //Le getDeplacementPossible
    public ArrayList<Position> getDeplacementPossible(Plateau plat){
        ArrayList<Position> les_pos = new ArrayList<Position>();

        Position pos = new Position(this.position.get_X() - 1, this.position.get_Y());
        if (this.position.get_X() > 0 && (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur))){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X() - 1, this.position.get_Y() - 1);
        if (this.position.get_X() > 0 && this.position.get_Y() > 0 && (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur))){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X() - 1, this.position.get_Y() + 1);
        if (this.position.get_X() > 0 && this.position.get_Y() < 7 && (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur))){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X(), this.position.get_Y() + 1);
        if (this.position.get_Y() < 7 && (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur))){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X(), this.position.get_Y() - 1);
        if (this.position.get_Y() > 0 && (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur))){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X() + 1, this.position.get_Y());
        if (this.position.get_X() < 7 && (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur))){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X() + 1, this.position.get_Y() + 1);
        if (this.position.get_X() < 7 && this.position.get_Y() > 7 && (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur))){
            les_pos.add(new Position(pos));
        }

        pos = new Position(this.position.get_X() + 1, this.position.get_Y() - 1);
        if (this.position.get_X() < 7 && this.position.get_Y() > 0 && (plat.getCase(pos) == null || ! (plat.getCase(pos).getCouleur() == this.couleur))){
            les_pos.add(new Position(pos));
        }

        return les_pos;
    }
}
