/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.controller;

import java.util.Arrays;
import java.util.Random;

/**
 * Classe que implementa o método de combate de acordo com as regras do jogo War na sua primeira versao
 * @author Darts
 */
public class CampoDeBatalha {
    
    private Random numberGenerator = new Random();
    /**
     * Implementa a logica do combate de dados
     * @param atacante quantidade de unidades de batalha do atacante
     * @param defensor quantidade de unidades de batalha do defensor
     * @return Array com dois ints, o primeiro representa a quantidade
     * soldados atacantes mortos em combate, e o segundo os do defensor
     */
    public int[] combate(int atacante, int defensor){//deveria receber so os exercitos ao inves dos estados?
        int soldadosDerrotados[] = {0, 0}; //[atacante, defensor]
        int dadosVermelhos[] = {0, 0, 0}; //vetor com os valores de 3 dados
        int dadosAmarelos[] = {0, 0, 0}; //inicializo com 0 pq é um valor fora do range
        
        //validação de quantidade suficiente para atacar já foi feita em State.getBattleUnitsForCombat()
        //o atacante tem direito ao 1º dado
        if (atacante >= 1){
            dadosVermelhos[0] = numberGenerator.nextInt(6)+1;
        }
        //o atacante tem direito ao 2º dado
        if (atacante >= 2){
            dadosVermelhos[1] = numberGenerator.nextInt(6)+1;
        }
        //o atacante tem direito ao 3º dado
        if (atacante == 3){
            dadosVermelhos[2] = numberGenerator.nextInt(6)+1;
        }
        
        //o defensor tem direito ao 1º dado
        if (defensor >= 1){
            dadosAmarelos[0] = numberGenerator.nextInt(6)+1;
        }
        //o defensor tem direito ao 2º dados
        if (defensor >= 2){
            dadosAmarelos[1] = numberGenerator.nextInt(6)+1;
        }
        //o defensor tem direito ao 3º dado
        if (defensor == 3){
            dadosAmarelos[2] = numberGenerator.nextInt(6)+1;
        }
        
        Arrays.sort(dadosVermelhos);
        Arrays.sort(dadosAmarelos);
        
        for (int i = 0; i < dadosVermelhos.length; i++) {
            if(dadosVermelhos[i] != 0 && dadosAmarelos[i] != 0){
                if (dadosVermelhos[i] <= dadosAmarelos[i]){
                    soldadosDerrotados[0]++;//red defeat
                } else {
                    soldadosDerrotados[1]++;//yellow defeat
                }
            }
        }
        
        return soldadosDerrotados;
    }
    
    public int[] combateAereo(int atacante, int defensor){
        int derrotados[] = {0, 0}; //[atacante, defensor]
        int dadoAtaque = numberGenerator.nextInt(6)+1;
        int dadoDefesa = numberGenerator.nextInt(6)+1; 
        
        if(dadoDefesa > 3){
            derrotados[0] = dadoDefesa -3;
            if(derrotados[0] > atacante){//poder mais do que suficiente pra derrubar tudo
                derrotados[0] = atacante;
            }
        }
        if(dadoAtaque > 3){
            derrotados[1] = dadoAtaque -3;
            if(derrotados[1] > defensor){//poder mais do que suficiente pra derrubar tudo
                derrotados[1] = defensor;
            }
        }
        return derrotados;
    }
    
}
