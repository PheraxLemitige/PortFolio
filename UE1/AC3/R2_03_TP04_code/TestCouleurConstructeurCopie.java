import java.lang.invoke.MethodHandles;

public class TestCouleurConstructeurCopie{

    // Test du constructeur par copie
    
    public static void main(String[] args){

	System.out.println("***************************************");	
	System.out.print("Classe "+MethodHandles.lookup().lookupClass()+" : ");

	try{
	    Couleur p1 = new Couleur(128, 36, 49);
	    Couleur p2 = new Couleur(p1);
	    if(p1.equals(p2))
		System.out.println("OK");
	    else{
		System.out.println("ECHEC");
		System.out.println("-----------------------");
		System.out.println("Résultat :");
		System.out.println(p2);
		System.out.println("Attendu :");
		System.out.println(p1);
	    }
	}catch(Exception e){
	    System.out.println(e);
	    e.printStackTrace();
	}
    }
}
