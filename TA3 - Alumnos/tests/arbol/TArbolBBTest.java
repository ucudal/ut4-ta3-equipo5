package arbol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author alfonsoLeandro
 */
public class TArbolBBTest {

    TArbolBB<Integer> arbol;

    @BeforeEach
    public void setUp(){
        arbol = new TArbolBB<>();
    }

    @Test
    public void testObtenerAlturaArbolVacio() {
        assertEquals(-1, arbol.obtenerAltura());
    }

    @Test
    public void testObtenerAlturaConUnNodo() {
        arbol.insertar(new TElementoAB<>(4,4));

        assertEquals(0, arbol.obtenerAltura());
    }

    @Test
    public void testObtenerAlturaConMasDeUnNodo() {
        for(int e : new int[]{1,2,3}){
            arbol.insertar(new TElementoAB<>(e, e));
        }
        assertEquals(2, arbol.obtenerAltura());
    }

    @Test
    public void testTamanioArbolVacio() {
        assertEquals(0, arbol.obtenerTamanio());
    }

    @Test
    public void testObtenerTamanioConUnNodo() {
        arbol.insertar(new TElementoAB<>(4,4));
        assertEquals(1, arbol.obtenerTamanio());
    }

    @Test
    public void testObtenerTamanioConMasDeUnNodo() {
        for(int e : new int[]{1,2,3}){
            arbol.insertar(new TElementoAB<>(e, e));
        }
        assertEquals(3, arbol.obtenerTamanio());
    }

}