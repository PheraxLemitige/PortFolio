import java.lang.invoke.MethodHandles;

public class TestImageSetPixel01{

    // Test du constructeur et de la méthode setPixel
    
    public static void main(String[] args){

	System.out.println("***************************************");	
	System.out.print("Classe "+MethodHandles.lookup().lookupClass()+" : ");
	
	Image img = new Image(3, 3);

	img.setPixel(0, 0, new Couleur(0, 0, 0));
	img.setPixel(1, 0, new Couleur(0, 0, 255));
	img.setPixel(2, 0, new Couleur(0, 255, 0));
	img.setPixel(0, 1, new Couleur(0, 255, 255));
	img.setPixel(1, 1, new Couleur(255, 0, 0));
	img.setPixel(2, 1, new Couleur(255, 0, 255));
	img.setPixel(0, 2, new Couleur(255, 255, 0));
	img.setPixel(1, 2, new Couleur(255, 255, 255));
	img.setPixel(2, 2, new Couleur(0, 0, 0));
	
	try{
	    Image reference = new Image("images/reference.ppm");
	    if(img.equals(reference))
		System.out.println("OK");
	    else{
		System.out.println("ECHEC");
		System.out.println("-----------------------");
		System.out.println("Résultat :");
		System.out.println(img);
		System.out.println("Attendu :");
		System.out.println(reference);
	    }
	}catch(Exception e){
	    System.out.println(e);
	    e.printStackTrace();
	}
    }
    
}
