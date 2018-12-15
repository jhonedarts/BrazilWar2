/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.controller;

import war.models.Jogador;
import war.models.Deck;
import war.models.Carta;
import java.util.ArrayList;
import war.parametros.Parametros;

/**
 *
 * @author lzricardo & darts
 */
public class Jogo {
    private Parametros parametros = Parametros.getInstance();
    private CampoDeBatalha campoDeBatalha;
    private Deck deck;
    private Mapa mapa;
    private Trocador trocador;
    private ArrayList<Jogador> jogadores;
    
    /**
     * inicializa os componentes principais do jogo war 1
     */
    public Jogo() {
        campoDeBatalha = new CampoDeBatalha();
        deck = new Deck();
        mapa = new Mapa();
        trocador = Trocador.getInstance();
        jogadores = new ArrayList<>();
    }
    
    /**
     * Inicia e sortea o mapaa para os jogadores
     */
    public void startGame() {
        mapa.shuffleMap(jogadores);
    }
    
    /**
     * Rodada com trocas de cartas, distribuição de tropas, 
     * e escolhas de ataque, remanejar tropas e ver as cartas
     * @param jogadores
     */
    public void gerarTropasPorRodada(ArrayList<Jogador> jogadores){
        mapa.gerarTropasPorRodada(jogadores);        
    }
    
    /**
     * Verica se @jogador tem a possibilidade de realizar uma troca
     * Se sim, pergunta se deseja trocar e quais cartas
     * Se as cartas informadas validarem uma troca, jogador recebe as tropas
     * @param jogador
     * @param cartas
     * @return 
     */
    public boolean troca(Jogador jogador, ArrayList<Carta> cartas){
        if(jogador.podeTrocarCartas()){
            if(trocador.canTradeCards(cartas)){
                jogador.addSoldados(trocador.getTrade(cartas));
                jogador.removeCartas(cartas); 
                return true;
            }
        }
        return false;
    }
    
    /**
     * Chama os metodos pra gerar as tropas por rodada
     * Jogador decide onde coloca-las 
     * @param jogador
     * @param estado
     * @param soldadosQtd
     * @return 
     */
    public boolean distribuir(Jogador jogador, String estado, int soldadosQtd ){
        String regiao = parametros.getRegionByEstado(estado);
        if(mapa.getCorDoEstado(estado).equals(jogador.getCor()) && soldadosQtd <= jogador.getBattleUnitsQttTotal()){
            mapa.addSoldados(estado, soldadosQtd);
            if(regiao != null && jogador.temRegiao(regiao)){                            
                if(jogador.getSoldadosPorRegiaoQtd(regiao) <= soldadosQtd){
                    soldadosQtd -= jogador.getSoldadosPorRegiaoQtd(regiao);
                    jogador.removeSoldadosPorRegiao(regiao, jogador.getSoldadosPorRegiaoQtd(regiao));
                }else{
                    jogador.removeSoldadosPorRegiao(regiao, soldadosQtd);
                    soldadosQtd = 0;
                }   
            }
            if(jogador.getSoldadosQtd()> 0) {
                jogador.removeSoldados(soldadosQtd);
            }
        }else{
            return false;
        }
        return jogador.getBattleUnitsQttTotal() <= 0;
    }
    
    
    /**
     * Pergunta qual as coordenadas do ataque, valida a posse e fronteira
     * Chama o @campoDeBatalha para realizar o combate
     * @param jogador
     * @param atacante
     * @param defensor
     * @return 
     */
    public boolean atacar(Jogador jogador, String atacante, String defensor){
        String atacanteCor = jogador.getCor();
        //se o jogador tem o estado..
        if(jogador.getCor().equals(atacanteCor) && mapa.temFronteira(atacante, defensor)){
            int result[] = campoDeBatalha.combate(mapa.getSoldadosForAttack(atacante), mapa.getSoldadosForDefense(defensor));
            mapa.removeBattleUnits(atacante, result[0]);
            mapa.removeBattleUnits(defensor, result[1]);
            return true;
        }
        return false;
    }
    
    /**
     * Permite a movimentação das tropas entre os estados pertencentes ao @jogador
     * @param jogador
     * @return 
     */
    public boolean remanejar(Jogador jogador, String stateA, String stateB, int qtd) {
        if(mapa.temFronteira(stateA, stateB) && mapa.getQtdSoldados(stateA) > qtd){
            mapa.moverSoldados(stateA, stateB, qtd);
            return true;
        }
        return false;
    }
}
