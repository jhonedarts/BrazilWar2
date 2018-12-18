/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.parametros;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jhone
 */
public abstract class Parametros {
    protected HashMap<String, String[]> regions;
    protected ArrayList<String> states;
    protected HashMap<String, String[]> frontiers;
    protected int versao = 0;
    private static Parametros parameters;
    
    private final String jokerSimbolo = "CORINGA";
    private final String symbols[] = {"TRIANGULO", "QUADRADO", "CIRCULO"};
    private final int cardsLimitInHands = 5;
    private final int firstTroca = 4;
    private final int accumulatorTroca = 2;
    
    public static Parametros getInstance(int version) {
        if(version == 1){
            parameters = ParametrosWar1.getInstance();
        }else if (version == 2){
            parameters = ParametrosWar2.getInstance();
        }
        return parameters;
    }
    
    public static Parametros getInstance() {
        return parameters;
    }
    
    public int getVersao(){
        return versao;
    }
    /**
     * 
     * @return a colecao de siglas de todos estados
     */
    public ArrayList<String> getEstados() {
        return this.states;
    }
    
    /**
     * 
     * @return quantidade total de estados
     */
    public int getEstadosTotal(){
        return this.states.size();
    }
    
    /**
     * retorna um estado a partir da possicao na colecao
     * @param index indice
     * @return sigla do estado
     */
    public String getEstado(int index){
        return this.states.get(index);
    }
    
    
    /**
     * 
     * @return nomes das regioes
     */
    public String[] getRegioes(){
        ArrayList<String> regionsNames = new ArrayList<>();
        for (String key : this.regions.keySet()){
            regionsNames.add(key);
        }
        return regionsNames.toArray(new String[regionsNames.size()]);
    }
    
    /**
     * 
     * @param region regiao
     * @return estados da regiao
     */
    public String[] getEstadosPorRegiao(String region){
        return regions.get(region);
    }
    
    /**
     * 
     * @param state estado (sigla)
     * @return retorna a regiao a qual o estado pertence
     */
    public String getRegionByEstado(String state){
        for(String region : regions.keySet()){
            for(String st : regions.get(region)){
                if(st.equals(state)){
                    return region;
                }
            }
        }
        return null;
    }
    
    /**
     * 
     * @return quantidade total de regioes
     */
    public int getRegioesTotal(){
        return this.regions.size();
    }
    
    /**
     * retorna os estados que fazem fronteiras com o estado informado
     * @param initials sigla do estado
     * @return colecao de siglas de estados
     */
    public String[] getFronteiras(String initials) {
        return this.frontiers.get(initials);
    }
    
    
    public String getJokerSimbolo() {
        return jokerSimbolo;
    }

    public String[] getSimbolos() {
        return symbols;
    }

    public int getLimiteDeCartasNaMao() {
        return cardsLimitInHands;
    }

    public int getPrimeiraTroca() {
        return firstTroca;
    }

    public int getAcumuladorTroca() {
        return accumulatorTroca;
    }
    
        
}
