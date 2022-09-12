package arbol;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author alfonsoLeandro
 */
public class TArbolBBTest extends TestCase {

    TArbolBB<Integer> arbol;

    @BeforeEach
    public void setUp(){
        arbol = new TArbolBB<>();
    }

    @Test
    public void testObtenerAlturaArbolVacio() {
        Assert.assertEquals(0, arbol.obtenerAltura());
    }

    @Test
    public void testObtenerAlturaConUnNodo() {
        arbol.insertar(new TElementoAB<>(4,4));

        Assert.assertEquals(1, arbol.obtenerAltura());
    }

    @Test
    public void testObtenerAlturaConMasDeUnNodo() {
        for(int e : new int[]{1,2,3}){
            arbol.insertar(new TElementoAB<>(e, e));
        }
        Assert.assertEquals(3, arbol.obtenerAltura());
    }


}