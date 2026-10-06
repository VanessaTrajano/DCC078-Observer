package org.example;

import java.util.Observable;

public class Produto extends Observable {
    private Integer codigo;
    private String produto;
    private String loja;

    public Produto(Integer codigo, String produto, String loja) {
        this.codigo = codigo;
        this.produto = produto;
        this.loja = loja;
    }

    public void emitirComprovanteEntrega() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", produto='" + produto +
                "', loja='" + loja + '\'' +
                '}';
    }
}
