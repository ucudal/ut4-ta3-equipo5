package arbol;

public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operacián
     */

    boolean insertar(TElementoAB<T> unElemento);



    /**
     * Busca un elemento dentro del árbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    String preOrden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    String inOrden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    String postOrden();


    /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta
     */
    void eliminar(Comparable unaEtiqueta);

    /**
     * Retorna la altura del arbol.
     * @return Altura del arbol.
     */
    public int obtenerAltura();

    /**
     * Retorna el tama�o del arbol.
     * @return Tama�o del arbol.
     */
    public int obtenerTamanio();

    /**
     * Retorna el nivel del arbol a partir de la etiqueta indicada
     * @param unaEtiqueta
     * @return Nivel
     */
    public int obtenerNivel(Comparable unaEtiqueta);

    /**
     * Retorna la cantidad de hojas del arbol.
     * @return Cantidad de hojas del arbol.
     */
    public int obtenerCantidadHojas();

}

