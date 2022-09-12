package arbol;

public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private final T datos;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        this.etiqueta = unaEtiqueta;
        this.datos = unosDatos;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(this.etiqueta) == 0) {
            return this;

        } else if(unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if(this.hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            }
            return null;

        } else if(this.hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        }

        return null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        TArbolBB.contador++;
        if(unElemento.getEtiqueta().compareTo(this.etiqueta) < 0) {
            if(this.hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);

            } else {
                this.hijoIzq = unElemento;
                return true;
            }
        } else if(unElemento.getEtiqueta().compareTo(this.etiqueta) > 0) {
            if(this.hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                this.hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    @Override
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(etiqueta.toString());
        if(hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        if(hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if(this.hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(this.etiqueta.toString());
        if(this.hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }
        return tempStr.toString();
    }

    @Override
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if(this.hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if(this.hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(this.etiqueta.toString());
        return tempStr.toString();
    }

    @Override
    public T getDatos() {
        return this.datos;
    }

    @Override
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if(this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if(unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if(this.hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }

        return quitaElNodo();
    }

    @Override
    public TElementoAB<T> quitaElNodo() {
        if(this.hijoIzq == null) {
            return this.hijoDer;
        }
        if(this.hijoDer == null) {
            return this.hijoIzq;
        }
        //es un nodo completo
        TElementoAB<T> elPadre = this;
        TElementoAB<T> elHijo = this.hijoIzq;
        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }

        if (elPadre != this){
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = this.hijoIzq;
        }

        elHijo.hijoDer = this.hijoDer;
        return elHijo;

    }

    @Override
    public int obtenerAltura() {
        int altIzq = -1;
        int altDer = -1;
        if (this.hijoIzq != null) {
            altIzq = this.hijoIzq.obtenerAltura();
        }

        if (this.hijoDer != null) {
            altDer = this.hijoDer.obtenerAltura();
        }

        return Math.max(altDer, altIzq) + 1;
    }

    @Override
    public int obtenerTamanio() {
        int tamSubArboles = 0;
        if (this.hijoIzq != null) {
            tamSubArboles += this.hijoIzq.obtenerTamanio();
        }

        if (this.hijoDer != null) {
            tamSubArboles += this.hijoDer.obtenerTamanio();
        }
        return tamSubArboles + 1;
    }


    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        return 0;
    }

    @Override
    public int obtenerCantidadHojas() {
        return 0;
    }
}
