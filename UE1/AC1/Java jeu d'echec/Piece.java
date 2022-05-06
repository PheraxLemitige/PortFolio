import java.util.ArrayList;

abstract class Piece {
    protected char couleur;
    protected Position position;

    //les constructeurs
    public Piece(){
        this.couleur = 'B';
        this.position = new Position("A2");
    }

    public Piece(Piece other){
        this.couleur = other.couleur;
        this.position = new Position(other.position);
    }

    public Piece(char la_couleur, int le_x, int le_y){
        //On vient arreter le programme si la couleur n'est pas blanc ou noir
        if (la_couleur != 'B' && la_couleur != 'N'){
            System.exit(-1);
        }

        this.couleur = la_couleur;
        this.position = new Position(le_x, le_y);
    }

    public Piece(char la_couleur, Position la_position){
        //On vient arreter le programme si la couleur n'est pas blanc ou noir
        if (la_couleur != 'B' && la_couleur != 'N'){
            System.exit(-1);
        }
        
        this.couleur = la_couleur;
        this.position = new Position(la_position);
    }

    public Piece(char la_couleur, String la_position){
        //On vient arreter le programme si la couleur n'est pas blanc ou noir
        if (la_couleur != 'B' && la_couleur != 'N'){
            System.exit(-1);
        }

        this.couleur = la_couleur;
        this.position = new Position(la_position);
    }

    //les getters
    public abstract String getType();

    public char getCouleur() {
        return this.couleur;
    }

    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }

    public Position getPosition() {
        return this.position;
    }

    //les setters
    public void setPosition(Position position) {
        this.position = position;
    }

    //les getNom
    public String getNomCourt(){
        //On n'utilise plus le this.type mais le getType
        String firstchar = Character.toString(getType().charAt(0));
        char secondchar = getType().charAt(1);
        String nom = new String ( firstchar.toUpperCase() + Character.toString(secondchar) + Character.toString(this.couleur));
        return (nom);
    }

    public String getNomLong(){
        //On n'utilise plus le this.type mais le getType
        String nom = new String(getType() + "_" + Character.toString(this.couleur));
        return(nom);
    }

    @Override
    public boolean equals(Object l_objet){
        if (l_objet instanceof Piece == false){
            return false;
        }
        Piece la_piece = (Piece)l_objet;
        return this.couleur == la_piece.couleur && this.position.equals(la_piece.position);
    }

    abstract ArrayList<Position> getDeplacementPossible(Plateau plat);

    public String toString (){
        if (this.couleur == 'N'){
            return (getType() + " noir en " + this.position.toString());
        }
        return (getType() + " blanc en " + this.position.toString());
    }
}
