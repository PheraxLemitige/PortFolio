import org.junit.Test;

public class CouleurTest {
    @Test
    public void TestCouleurConstructeurCopie(){
        Couleur p1 = new Couleur(128, 36, 49);
	    Couleur p2 = new Couleur(p1);
        assert p1.equals(p2);
    }
}
