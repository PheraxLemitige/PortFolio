import org.junit.Test;

public class ImageTest{
    @Test
    public void TestImageConstructeurCopie(){
        Image img = new Image("images/reference.ppm");
	    Image copie = new Image(img);
	    Image reference = new Image("images/reference.ppm");
        assert copie.equals(reference);
    }

    @Test
    public void TestImageDifference01(){
        Image img1 = new Image("images/reference.ppm");
	    Image img2 = new Image("images/reference.ppm");
	    img1.difference(img2);
	    Image noir = new Image(img1.getTailleX(), img1.getTailleY());
	    noir.setNoir();
        assert img1.equals(noir);
    }

    @Test
    public void TestImageDifference02(){
        Image img1 = new Image("images/reference.ppm");
	    Image img2 = new Image("images/reference.ppm");
	    img2.negatif();
	    img1.difference(img2);
	    Image blanc = new Image(img1.getTailleX(), img1.getTailleY());
	    blanc.setBlanc();
        assert img1.equals(blanc);
    }

    @Test 
    public void TestImageNegatif(){
        Image img = new Image("images/reference.ppm");
	    img.negatif();
	    Image referenceNegatif = new Image("images/reference_negatif.ppm");
	    assert img.equals(referenceNegatif);
    }

    @Test
    public void TestImageNiveauGris(){
        Image img = new Image("images/reference.ppm");
	    img.niveauGris();
	    Image referenceGris = new Image("images/reference_niveauGris.ppm");
	    assert img.equals(referenceGris);
    }

    @Test 
    public void TestImageSetPixel01(){
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
        Image reference = new Image("images/reference.ppm");
        assert img.equals(reference);
    }

    @Test 
    public void TestImageSetPixel02(){
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
        Image reference = new Image("images/reference.ppm");
        assert img.equals(reference);
    }
}
