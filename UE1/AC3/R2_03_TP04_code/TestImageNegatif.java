import java.lang.invoke.MethodHandles;

public class TestImageNegatif{

    // Test de la méthode negatif
    
    public static void main(String[] args){

	System.out.println("***************************************");	
	System.out.print("Classe "+MethodHandles.lookup().lookupClass()+" : ");
	
	try{    
	    Image img = new Image("images/reference.ppm");
	    img.negatif();
	    Image referenceNegatif = new Image("images/reference_negatif.ppm");
	    if(img.equals(referenceNegatif))
		System.out.println("OK");
	    else{
		System.out.println("ECHEC");
		System.out.println("-----------------------");
		System.out.println("Résultat :");
		System.out.println(img);
		System.out.println("Attendu :");
		System.out.println(referenceNegatif);
	    }	    
	}catch(Exception e){
	    System.out.println(e);
	    e.printStackTrace();
	}
    }
}
