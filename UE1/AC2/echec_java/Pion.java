import java.util.ArrayList;

abstract public class Pion extends Piece {

    //les constructeur
    public Pion(){
        super();
    }
    public Pion(char la_couleur, Position la_position){
        super(la_couleur, la_position);
    }

    //le getType
    public String getType(){
        return "pion";
    }

    abstract public ArrayList<Position> getDeplacementPossible(Plateau plat);
}
