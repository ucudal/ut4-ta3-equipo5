package arbol;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public static int contador = 0;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        this.raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        TArbolBB.contador = 0;
        if (this.raiz == null) {
            this.raiz = unElemento;
            return true;
        }

        return this.raiz.insertar(unElemento);
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if(esVacio()) {
            return null;
        } else {
            return this.raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if (esVacio()){
            return "Arbol vacio";
        }else{
            return this.raiz.preOrden();
        }    }

    @Override
    public String inOrden() {
        if (esVacio()){
            return "Arbol vacio";
        }else{
            return this.raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (esVacio()){
            return null;
        }else{
            return this.raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(!esVacio())
            this.raiz = this.raiz.eliminar(unaEtiqueta);
    }


    @Override
    public int obtenerAltura()
    {
        return esVacio() ? -1 : raiz.obtenerAltura();
    }

    @Override
    public int obtenerTamanio()
    {
        return esVacio() ? -1 : raiz.obtenerTamanio();
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        return 0;
    }

    @Override
    public int obtenerCantidadHojas() {
        return 0;
    }

    public boolean esVacio(){
        return (this.raiz == null);
    }

}