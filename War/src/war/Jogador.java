/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe responsável por guardar informações de identificação, seus estados pertencentes e suas cartas
 * @author Higor Vital
 * @author Tarles Walker
 */
public class Jogador {
    
    private String cor;
    private static int n_jogadores = 0;
    private int id;
    private List<Estado> estados;
    private List<Carta> cartas;
    private boolean vivo = true;

    
    public Jogador(String cor){
        this.cor = cor;
        estados = new ArrayList();
        cartas = new ArrayList();
        id = n_jogadores++;
    }
    /**
    * Retorna id do jogador
    * 
    * @return 
    */
    public int getId(){
        return id;
    }
    
    /**
    * Zera as cartas do jogador
    * 
    */
    public void zerarCartas(){
        cartas = new ArrayList();
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
    * Adiciona exercitos a um estado
    * 
    * @param estado - Estado que o jogador vai adicionar exercitos
    * @param n_exercito - Quantidade de exércitos
    */
    public void addExercito(String estado, int n_exercito){
        Iterator it = estados.iterator();
        while(it.hasNext()){
            Estado est = (Estado)it.next();
            if(est.getNome().equals(estado)){
                est.addExercito(n_exercito);
                return;
            }
        }
    }
    
    /**
    * Adiciona um estado a lista de estados que o jogador domina
    * 
    * @param e Estado a ser adicionado
    */
    public void addEstado(Estado e){
        estados.add(e);
    }

    /**
    * Retorna a lista de cartas do jogador
    * 
     * @return
    */
    public List<Carta> getCartas(){
        return cartas;
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
            Estado est = (Estado)it.next();
            if(est.getNome().equals(estado)){
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
        if(estados.size()>0){
            vivo = true;
            return true;
        }else{
            vivo = false;
            return false;
        }
    }
    /**
    * Adiciona uma carta a lista de cartas
     * @param c Carta a ser adicionada
    */
    public void addCarta(Carta c){
        cartas.add(c);
    }
    
    /**
    * Remove um estado da lista de estado
     * @param est Estado a ser removido
    */
    public void removeEstado(Estado est){
        estados.remove(est);
    }
    
}
