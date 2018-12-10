/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 * Classe que armazena apenas sua forma (Ex.: círculo, triangulo...
 * @author Higor Vital
 * @author Tarles Walker
 */
public class Carta {
    private String forma;
    public Carta(String forma) {
        this.forma = forma;
    }

    /**
    * Retorna a forma da carta
    * 
    */
    public String getForma() {
        return forma;
    }

}
