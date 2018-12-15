/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.models;

/**
 * Classe que armazena apenas sua simbolo (Ex.: círculo, triangulo...
 * @author Higor Vital
 * @author Tarles Walker
 */
public class Carta {
    private String simbolo;
    private String estado;
    
    public Carta(String simbolo, String estado) {
        this.simbolo = simbolo;
    }

    /**
    * Retorna a simbolo da carta
    * 
    */
    public String getSimbolo() {
        return simbolo;
    }

    public String getEstado() {
        return estado;
    }

}
