/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 * Utilizada para implementação do padrão \textit{Strategy}, é uma Classe abstrata contendo apenas a assinatura do método combate
 * @author Higor Vital
 * @author Tarles Walker
 */
public abstract class Combate {
    
    /**
    * 
    * 
    */
    public abstract void combate(Jogador j, Jogo jogo);
    
}