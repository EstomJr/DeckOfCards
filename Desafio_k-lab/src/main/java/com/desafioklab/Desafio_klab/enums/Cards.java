package com.desafioklab.Desafio_klab.enums;

public enum Cards {
    QUEEN(12),
    ACE(1),
    JACK(11),
    KING(13);

    private int valor;
     Cards(int valor){
        this.valor = valor;
    }
    public int getValor(){
         return this.valor;
    }


}
