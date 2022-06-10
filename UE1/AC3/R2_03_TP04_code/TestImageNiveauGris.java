import java.lang.invoke.MethodHandles;

public class TestImageNiveauGris{

    // Test de la méthode Niveau de gris
    
    public static void main(String[] args){

	System.out.println("***************************************");
	System.out.print("Classe "+MethodHandles.lookup().lookupClass()+" : ");
	
	try{   
	    Image img = new Image("images/reference.ppm");
	    img.niveauGris();
	    Image referenceGris = new Image("images/reference_niveauGris.ppm");
	    if(img.equals(referenceGris))
		System.out.println("OK");
	    else{
		System.out.println("ECHEC");
		System.out.println("-----------------------");
		System.out.println("Résultat :");
		System.out.println(img);
		System.out.println("Attendu :");
		System.out.println(referenceGris);
	    }
	    
	}catch(Exception e){
	    System.out.println(e);
	    e.printStackTrace();
	}
    }
}
