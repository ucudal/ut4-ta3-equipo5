import arbol.TArbolBB;
import arbol.TElementoAB;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBB<Integer> arbol = new TArbolBB<>();

        for(int e : new int[]{12, 25, 14, 1, 33, 88, 45, 2, 7, 66,5, 99}){
            arbol.insertar(new TElementoAB<>(e, e));
        }
        System.out.println("Recorrido pre orden: "+arbol.preOrden());
        System.out.println("Recorrido in orden: "+arbol.inOrden());
        System.out.println("Recorrido post orden: "+arbol.postOrden());

        System.out.println();

        arbol.eliminar(99);
        arbol.eliminar(2);
        arbol.eliminar(12);
        arbol.eliminar(33);

        System.out.println("Recorrido pre orden: "+arbol.preOrden());
        System.out.println("Recorrido in orden: "+arbol.inOrden());
        System.out.println("Recorrido post orden: "+arbol.postOrden());

    }

}
