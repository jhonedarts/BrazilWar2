/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import war.parametros.Parametros;

/**
 * Representa o monte de cartas
 * @author darts
 */
public class Deck {
    
    //o monte de cartas embaralhados 
    private Random gerador = new Random();
    private Parametros parametros = Parametros.getInstance();
    private ArrayList<Carta> cartas;
    private int iteratorIndex = 0;

    public Deck() {
        //inicializar
        this.cartas = new ArrayList<>();
        init();
    }
    
    /**
     * intancia as cartas definidas pelo estados
     */
    private void init(){
        Carta carta;
        int i = 0, j = 0;
        
        while (i < parametros.getEstadosTotal()) { //percorre todos os estados
            if(j >= parametros.getSimbolos().length){ //reseta o contador do simbolo
                j = 0;
            }
            //cria um carta com simbolo e estado
            carta = new Carta(parametros.getSimbolos()[j], parametros.getEstado(i));
            this.cartas.add(carta);
            
            i++;j++;
        }
        // + 2 coringas
        carta = new Carta("", parametros.getJokerSimbolo());
        this.cartas.add(carta);
        carta = new Carta("", parametros.getJokerSimbolo());
        this.cartas.add(carta);
        
        Collections.shuffle(cartas); 
    }
    
    /**
     * quando todas cartas sao "removidas" elas voltam ao deck reembaralhadas
     * @return Uma carta, sendo esta "removida" do deck
     */
    public Carta proximaCarta(){
        if (iteratorIndex == cartas.size()){//quando o deck acabar, ele será embaralhado
            Collections.shuffle(cartas); 
            iteratorIndex = 0; //reset
        }
        return cartas.get(++iteratorIndex);
    }
}
