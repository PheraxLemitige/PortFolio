import java.lang.invoke.MethodHandles;

public class TestImageDifference02{

    // Test de la méthode différence
    
    public static void main(String[] args){

	System.out.println("***************************************");	
	System.out.print("Classe "+MethodHandles.lookup().lookupClass()+" : ");

	
	try{
	    
	    Image img1 = new Image("images/reference.ppm");
	    Image img2 = new Image("images/reference.ppm");
	    img2.negatif();
	    img1.difference(img2);
	    Image blanc = new Image(img1.getTailleX(), img1.getTailleY());
	    blanc.setBlanc();
	    
	    if(img1.equals(blanc))
		System.out.println("OK");
	    else{
		System.out.println("ECHEC");
		System.out.println("-----------------------");
		System.out.println("Résultat :");
		System.out.println(img1);
		System.out.println("Attendu :");
		System.out.println(blanc);
	    }
	    
	}catch(Exception e){
	    System.out.println(e);
	    e.printStackTrace();
	}
    }
}
