/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import war.parametros.Parametros;

/**
 * Classe responsável por guardar informações de identificação, seus estados pertencentes e suas cartas
 * @author Higor Vital
 * @author Tarles Walker
 */
public class Jogador {
    private Parametros parametros = Parametros.getInstance();
    private String cor;
    private List<String> estados;
    private List<Carta> cartas;
    private int avioes;
    private int soldadosParaDistribuir;
    private HashMap<String, Integer> soldadosParaDistribuirPorRegiao;

    
    public Jogador(String cor){
        this.cor = cor;
        estados = new ArrayList();
        cartas = new ArrayList();
        this.soldadosParaDistribuir = 0;
        this.avioes = 0;
        for (String regiao : parametros.getRegioes()){
            soldadosParaDistribuirPorRegiao.put(regiao, 0);
        }
    }

    /**
    * Retorna a quantidade de estados que o jogador domina
    * 
     * @return 
    */
    public int estadoSize(){
        return estados.size();
    }

    /**
    * Retorna cor do jogador
    * 
    * @return 
    */
    public String getCor(){
        return cor;
    }    
    
    /**
    * Adiciona um estado a lista de estados que o jogador domina
    * 
    * @param sigla Estado a ser adicionado
    */
    public void addEstado(String sigla){
        estados.add(sigla);
    }
    
    /**
    * Verifica de um jogador tem aquele estado
    * 
    * @param estado - Estado a ser verificado
    * @return 
    */
    public boolean temEstado(String estado){
        Iterator it = estados.iterator();
        while(it.hasNext()){
            String est = (String)it.next();
            if(est.equals(estado)){
               return true;
            }
        }
        return false;
    }
    
    /**
    * Verifica se um jogador ainda tem estados
    * @return 
    */
    public boolean isVivo(){
        return estados.size() > 0;
    }
    
    /**
    * Remove um estado da lista de estado
     * @param est Estado a ser removido
    */
    public void removeEstado(String est){
        estados.remove(est);
    }
    
    /**
     * remove a carta informada da mao do jogador
     * @param carta carta a ser removida
     */
    public void removeCarta(Carta carta) {
        this.cartas.remove(carta);
    } 
    
    /**
     * remove as cartas informadas da mao do jogador
     * @param cartas cartas a serem removidas
     */
    public void removeCartas(ArrayList<Carta> cartas) {
        for(Carta carta : cartas){
            this.cartas.remove(carta);
        }
    }    
    
    /**
     * checa o limite de cartas que jogador pode ter
     * @return
     */
    public boolean canAddCarta() {
        return this.cartas.size() < parametros.getLimiteDeCartasNaMao(); 
    }

    /**
     * adiciona uma carta a mao do jogador
     * @param carta
     */
    public void addCarta(Carta carta) {
        this.cartas.add(carta);
    }
    
    /**
     * 
     * @param index posicao
     * @return carta
     */
    public Carta getCarta(int index){
        return this.cartas.get(index);
    }
    
    /**
     * 
     * @return quantidade de cartas que jogador tem
     */
    public int getCartasQtt(){
        return this.cartas.size();
    }
    
    /**
     * checa se há uma possibilidade de troca de cartas
     * @return
     */
    public boolean podeTrocarCartas(){
        //será contado as ocorrencias de cada simbolo
        int occurrences[] = new int[parametros.getSimbolos().length]; 
        
        //impossivel ter uma combinação
        if (this.cartas.size() < parametros.getSimbolos().length){
            return false;
        }
        else if(hasJoker()){//tem 3 ou mais cartas e um coringa entre elas
            return true;
        }
        //impossivel não ter uma combinação
        else if(this.cartas.size() > (parametros.getSimbolos().length-1)*parametros.getSimbolos().length-1){
            return true;
        }
        
        for (int i = 0; i < parametros.getSimbolos().length; i++) {
            for (int j = 0; j < this.cartas.size(); j++) {
                if(parametros.getSimbolos()[i].equals(this.cartas.get(j).getSimbolo())){
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
     * checa de tem um coringa
     * @return 
     */
    private boolean hasJoker(){
        for(Carta carta : this.cartas){
            if (carta.getSimbolo().equals(parametros.getJokerSimbolo())){
                return true;
            }
        }
        return false;
    }
    
    
     /**
     * adiciona unidades de batalha para distribuir a mao do jogador
     * @param units 
     */
    public void addSoldados(int units){
        this.soldadosParaDistribuir += units;
    }
    
    public void addAvioes(int units){
        this.avioes += units;
    }
    
    /**
     * adiciona unidades de batalha para distribuir restritas a uma regiao a mao do jogador
     * @param region regiao  
     * @param units unidades de batalha
     */
    public void addSoldadosPorRegiao(String region, int units){
        this.soldadosParaDistribuirPorRegiao.replace(region, this.soldadosParaDistribuirPorRegiao.get(region) +units);
    }
    
    /**
     * remove soldados para distribuicao
     * @param units qauntidade
     */
    public void removeSoldados(int units){
        this.soldadosParaDistribuir -= units;        
    }
    
    public void removeAvioes(int units){
        this.avioes -= units;        
    }
    
    /**
     * remove soldados para distribuicao restritos ao uma regiao
     * @param region regiao
     * @param units quantidade
     */
    public void removeSoldadosPorRegiao(String region, int units){
        for (int i = 0; i < units; i++) {
            this.soldadosParaDistribuirPorRegiao.replace(region, this.soldadosParaDistribuirPorRegiao.get(region) -units);
        }
    }
    
    /**
     * quantidade de unidades para distribuir desconsiderando as restritas as regioes
     * @return quantidade de unidades
     */
    public int getSoldadosQtd() {
        return this.soldadosParaDistribuir;
    }
    
    /**
     * 
     * @param region regiao
     * @return se tem dominio da regiao informada
     */
    public boolean temRegiao(String region) {
        return this.soldadosParaDistribuirPorRegiao.get(region) > 0;
    }
    
    /**
     * quantidade de unidades para distribuir restritas a regiao
     * @param region regiao
     * @return quantidade de unidades
     */
    public int getSoldadosPorRegiaoQtd(String region) {
        return this.soldadosParaDistribuirPorRegiao.get(region);
    }
    
    /**
     * 
     * @return quantidade total de unidades para distribuir
     */
    public int getBattleUnitsQttTotal() {
        int units = 0;
        for(String region : parametros.getRegioes()){
            units += this.soldadosParaDistribuirPorRegiao.get(region);
        }
        return this.soldadosParaDistribuir + units;
    }
}
