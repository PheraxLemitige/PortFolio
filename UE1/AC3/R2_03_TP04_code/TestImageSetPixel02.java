import java.lang.invoke.MethodHandles;

public class TestImageSetPixel02{

    // Test du constructeur et de la méthode setPixel avec
    // un seul objet de type Couleur
    
    public static void main(String[] args){

	System.out.println("***************************************");	
	System.out.print("Classe "+MethodHandles.lookup().lookupClass()+" : ");
	
	Image img = new Image(3, 3);
	Couleur c = new Couleur();

	c.setR(0);c.setV(0);c.setB(0);
	img.setPixel(0, 0, c);
	c.setR(0);c.setV(0);c.setB(255);
	img.setPixel(1, 0, c);
	c.setR(0);c.setV(255);c.setB(0);
	img.setPixel(2, 0, c);
	c.setR(0);c.setV(255);c.setB(255);
	img.setPixel(0, 1, c);
	c.setR(255);c.setV(0);c.setB(0);
	img.setPixel(1, 1, c);
	c.setR(255);c.setV(0);c.setB(255);
	img.setPixel(2, 1, c);
	c.setR(255);c.setV(255);c.setB(0);
	img.setPixel(0, 2, c);
	c.setR(255);c.setV(255);c.setB(255);
	img.setPixel(1, 2, c);
	c.setR(0);c.setV(0);c.setB(0);
	img.setPixel(2, 2, c);
	
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
