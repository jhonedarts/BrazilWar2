/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.controller;

import war.models.Carta;
import java.util.ArrayList;
import java.util.Arrays;
import war.parametros.Parametros;

/**
 * classe responsavel pelas trocas e suas regras
 * @author darts
 */
public class Trocador {
    private Parametros parametros = Parametros.getInstance();
    private static Trocador instance = null;
    private int count;

    private Trocador() {
        this.count = 0;
    }
        
    public static Trocador getInstance(){
        if(instance == null){
            instance = new Trocador();
        }
        return instance;
    }
        
    /**
     * realiza a troca das cartas por tropas
     * @param cartas colecao de cartas
     * @return quantidade de tropas a serem recebidas
     */
    public int getTrade(ArrayList<Carta> cartas){
        int units = 0;
        if (isValidTrade(cartas)){
            units = parametros.getPrimeiraTroca() + parametros.getAcumuladorTroca()*count;
            count++;            
        }
        return units;
    }
    
    public int getTradeAirplane(Carta carta){        
        return 1;
    }
    
    /**
     * checa se as cartas recebidas são uma troca valida
     * @param cartas
     * @return
     */
    public boolean isValidTrade(ArrayList<Carta> cartas){
        return canTradeCards(cartas) && cartas.size() == parametros.getSimbolos().length;
    }
    
    //checa se existe alguma combinação de troca nas cartas recebidas
    public boolean canTradeCards(ArrayList<Carta> cartas){
        //será contado as ocorrencias de cada simbolo
        int occurrences[] = new int[parametros.getSimbolos().length]; 
        
        //impossivel ter uma combinação
        if (cartas.size() < parametros.getSimbolos().length){
            return false;
        }
        else if(hasJoker(cartas)){//tem 3 ou mais cartas e um coringa entre elas
            return true;
        }
        //impossivel não ter uma combinação
        else if(cartas.size() > (parametros.getSimbolos().length-1)*parametros.getSimbolos().length-1){
            return true;
        }
        
        for (int i = 0; i < parametros.getSimbolos().length; i++) {
            for (int j = 0; j < cartas.size(); j++) {
                if(parametros.getSimbolos()[i].equals(cartas.get(j).getSimbolo())){
                    occurrences[i]++;
                }
            }
        }
        Arrays.sort(occurrences);
        if ((occurrences[0] < parametros.getSimbolos().length) || (occurrences[occurrences.length-1] == 0)){
            return false;
        }
        return true;
    }
    
    /**
     * checa se existe um coringa entre as cartas
     * @param cartas
     * @return
     */
    private boolean hasJoker(ArrayList<Carta> cartas){
        for(Carta carta : cartas){
            if (carta.getSimbolo().equals(parametros.getJokerSimbolo())){
                return true;
            }
        }
        return false;
    }
}
