import java.lang.invoke.MethodHandles;

public class TestImageDifference01{

    // Test de la méthode différence
    
    public static void main(String[] args){

	System.out.println("***************************************");	
	System.out.print("Classe "+MethodHandles.lookup().lookupClass()+" : ");

	
	try{
	    Image img1 = new Image("images/reference.ppm");
	    Image img2 = new Image("images/reference.ppm");
	    img1.difference(img2);
	    Image noir = new Image(img1.getTailleX(), img1.getTailleY());
	    noir.setNoir();
	    
	    if(img1.equals(noir))
		System.out.println("OK");
	    else{
		System.out.println("ECHEC");
		System.out.println("-----------------------");
		System.out.println("Résultat :");
		System.out.println(img1);
		System.out.println("Attendu :");
		System.out.println(noir);
	    }
	    
	}catch(Exception e){
	    System.out.println(e);
	    e.printStackTrace();
	}
    }
}
