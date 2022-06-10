import java.lang.invoke.MethodHandles;

public class TestImageConstructeurCopie{

    // Test du constructeur par copie
    
    public static void main(String[] args){

	System.out.println("***************************************");	
	System.out.print("Classe "+MethodHandles.lookup().lookupClass()+" : ");

	try{
	    Image img = new Image("images/reference.ppm");
	    Image copie = new Image(img);
	    Image reference = new Image("images/reference.ppm");
	    if(copie.equals(reference))
		System.out.println("OK");
	    else{
		System.out.println("ECHEC");
		System.out.println("-----------------------");
		System.out.println("Résultat :");
		System.out.println(copie);
		System.out.println("Attendu :");
		System.out.println(reference);
	    }
	}catch(Exception e){
	    System.out.println(e);
	    e.printStackTrace();
	}
    }
}
