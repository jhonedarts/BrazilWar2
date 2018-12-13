/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.HashMap;

/**
 *
 * @author jhone
 */
public class Mapa {
    private HashMap<String, Regiao> regioes;
    private Parameters parameters = Parameters.getInstance(1);
    
    // bad things
    
    
    
    /**
    * Verifica se algum jogador dominou todas as regiões, caso sim, parabeniza o jogador e encerra o jogo
    * 
    * @param return
    */
    public boolean fimDeJogo(){
        parameters.
        for(int x = 0; x < n_jogadores;x++){
            for(int y =0; y < regioes.length; y++){
                if(!isDominada(regioes[y],jogadores[x])){
                    break;
                }else if(y==regioes.length-1){
                    System.out.println("Parabéns, "+jogadores[x]+"!! Voçê venceu o jogo");
                    return true;
                }
            }
        }
        return false;
    }
}
