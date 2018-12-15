/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.controller;

import war.models.Estado;
import war.models.Jogador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import war.parametros.Parametros;

/**
 *
 * @author darts
 */
public class Mapa {
    private HashMap<String, Estado> estados;
    private Parametros parametros = Parametros.getInstance(1);
    public Mapa() {
        this.estados = new HashMap<>();
        //inicializa com todos estados definidos em STATES 
        for (int i = 0; i < parametros.getEstadosTotal(); i++) {
            Estado estado = new Estado(parametros.getEstado(i)); //inicializa com a sigla
            this.estados.put(estado.getNome(), estado);
        }
        
    }
    
    /** parte de sortear um distribuidor e o primeiro a jogar ser o proximo 
    * do ultimo que recebeu a carta foi resumido pra sortear a ordem dos
    * jogadores e sortear e setar o mapa
    * 
    * distribui os soldados para começar o jogo
    * representa o verde, se o vlaor for 0, não temos o jogador verde, 1 temos.
     * @param jogadores correspondente a quatidade de jogadores
    */
    public void shuffleMap(ArrayList<Jogador> jogadores){
        //rodeia os estados
        ArrayList<Estado> estadosShuffle = new ArrayList<>();
        estadosShuffle.addAll(this.estados.values());
        Collections.shuffle(estadosShuffle); 
        
        //distribui entre os presentes
        int j = 0;
        for (Estado estado : estadosShuffle){
            if (j == jogadores.size()){
                j = 0;
            }
            estado.addSoldados(1);
            estado.setCor(jogadores.get(j).getCor());
            j++;
        }
    }
    
    /**
     * Adiciona soldados ao estado
     * @param intialsEstado sigla do estado
     * @param soldadosQtd quantidade de soldados
     */
    public void addSoldados(String intialsEstado, int soldadosQtd){
        this.estados.get(intialsEstado).addSoldados(soldadosQtd);
    }
    
    /**
     * retorna a cor do jogador tem posse do estado
     * @param estado é a sigla do estado
     * @return color cor do jogador que tem posse do estado
     */
    public String getCorDoEstado(String estado){
        if(this.estados.get(estado) != null)
            return this.estados.get(estado).getCor();
        else
            return null;
    }
    
    /**
     * Retorna de 0-3 soldados, respeitando as condições de permanecer um soldado no territorio
     * @param estado sigla do estado
     * @return quantidade de soldados
     */
    public int getSoldadosForAttack(String estado){
        return this.estados.get(estado).getSoldadosParaAtaque();
    }
    
    /**
     * Retorna de 0-3 soldados
     * @param estado sigla do estado
     * @return quantidade de soldados
     */
    public int getSoldadosForDefense(String estado){
        return this.estados.get(estado).getSoldadosParaDefesa();
    }
    
    /**
     * retorna a quantidade de unidades de batalha do estado
     * @param sigla sigla do estado
     * @return quantidade de unidades de batalha
     */
    public int getQtdSoldados(String sigla){
        return this.estados.get(sigla).getSoldados();
    }
    
    /**
     * 
     * @param sigla sigla do estado
     * @return siglas dos estados que fazem divisa com o estado informado
     */
    public String[] getFronteiras(String sigla){
        return parametros.getFronteiras(sigla);
    }
    
    /**
     * Verifica se há uma fronteira
     * @param estadoA 
     * @param estadoB
     * @return true se A possui fronteira com B
     */
    public boolean temFronteira(String estadoA, String estadoB){
        String[] frontiersA = parametros.getFronteiras(estadoA);
        if(frontiersA == null)
            return false;
        for (String estado : frontiersA) {
            if (estado.equals(estadoB)){
                return true;
            }           
        }
        return false;
    }
    /**
     * Move tropas do estado A para o estado B
     * @param estadoA estado a perder tropas
     * @param estadoB estado a ganhar tropas
     * @param quantidade quantidade de tropas a serem movidas
     */
    public void moverSoldados(String estadoA, String estadoB, int quantidade){
        if(temFronteira(estadoA, estadoB)){
            this.estados.get(estadoB).addSoldados(quantidade);
            this.estados.get(estadoA).removerSoldados(quantidade);
            this.estados.get(estadoB).setCor(this.estados.get(estadoA).getCor());
        }
    }
    
    public void removeBattleUnits(String estado, int qtt){
        this.estados.get(estado).removerSoldados(qtt);
    }
    /**
     * [talvez isso não devesse estar aqui...]
     * Checa a condição de fim de jogo
     * @return verdadeiro se todos territorios pertencem a somente um jogador
     */
    public boolean isGameOver(){
        String colorReference = null;
        for (String key : this.estados.keySet()) {
            if (colorReference == null) {
                colorReference = this.estados.get(key).getCor();
            } 
            else if (!colorReference.equals(this.estados.get(key).getCor())){
                return false;
            }
        }
        return true;
    }
    
    /**
     * logica de geração de tropas por rodada, considera as 
     * posses dos estados e das regiões.
     * as tropas são adicionadas nos jogadores para que possam distribuir
     * @param jogadores jogadores
     */
    public void gerarTropasPorRodada(ArrayList<Jogador> jogadores){
        HashMap<String, Integer> counters = new HashMap<>();
        String jogadorColor;
        String[] estadosNames;
        boolean regionHasOwner;
        
        for (Jogador jogador : jogadores){
            counters.put(jogador.getCor(), 0);
        }
        // trecho de codigo replicado................
        for (String region : parametros.getRegioes()){
            estadosNames = parametros.getEstadosPorRegiao(region);
            jogadorColor = this.estados.get(estadosNames[0]).getCor();
            regionHasOwner = true;

            String color = null;
            for (String estado : estadosNames){
                color = this.estados.get(estado).getCor();
                counters.replace(color, counters.get(color)+1);
                if(!jogadorColor.equals(color)){
                    regionHasOwner = false;
                }
            }
            if (regionHasOwner){
                for (Jogador jogador : jogadores){
                    if(color.equals(jogador.getCor())){
                        jogador.addSoldadosPorRegiao(region, 3);
                    }
                }
            }
        }
        
        for (Jogador jogador : jogadores){
            String key = jogador.getCor();
            if (counters.get(key) == null){
                continue;
            }
            //minimo de 3 unidades por rodada
            if (counters.get(key)<6){
                for (int i=counters.get(key)%2; i<3; i++){
                    counters.replace(key, counters.get(key)+1);
                }
                continue;
            }
            int prefix = counters.get(key)%2;
            int deleteRows = prefix - counters.get(key);
            for (int i=0; i<deleteRows; i++){
                counters.replace(key, counters.get(key)-prefix + i);
            }
        }
        for (int i=0; i<jogadores.size(); i++){
            jogadores.get(i).addSoldados(counters.get(jogadores.get(i).getCor()));
        }
    }
    
}
