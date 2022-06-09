public class Position {
    int x;
    int y;

    //les constructeurs de la classe Position
    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public Position(Position other){
        //Si sa depasse les bornes de notre plateau on arrete le programme
        if (other.x < 0 && other.x > 7 && other.y < 0 && other.y > 7){
            System.exit(-1);
        }
        
        this.x = other.x;
        this.y = other.y;
    }

    public Position(int le_x, int le_y){
        //Si sa depasse les bornes de notre plateau on arrete le programme
        if (le_x < 0 && le_x > 7 && le_y < 0 && le_y > 7){
            System.exit(-1);
        }

        this.x = le_x;
        this.y = le_y;
    }

    public Position(String la_place){
        //On va divisé le String en plusieurs bout et utiliser le code ASCII
        char lettre = la_place.charAt(0);
        int le_x = (int) lettre - 65;
        int le_y = (int) la_place.charAt(1) - 48;

        //Si sa depasse les bornes de notre plateau on arrete le programme
        if (le_x < 0 && le_x > 7 && le_y < 0 && le_y > 7){
            System.exit(-1);
        }

        this.x = le_x;
        this.y = le_y;
    }

    //les getters
    public int get_X (){
        return this.x;
    }

    public int get_Y (){
        return this.y;
    }

    //les setters
    public void set_X(int nouv_x){
        this.x = nouv_x;
    }

    public void set_Y(int nouv_y){
        this.x = nouv_y;
    }

    @Override
    public boolean equals(Object l_objet){
        if (l_objet instanceof Position == false){
            return false;
        }
        Position la_position = (Position)l_objet;
        return this.x == la_position.x && this.y == la_position.y;
    }

    public String toString (){
        int code = this.x + 65;
        char lettre = (char)code;
        return (Character.toString(lettre) + String.valueOf(this.y));
    }
}
