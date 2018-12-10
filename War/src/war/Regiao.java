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
 * Classe que representa um conjunto de estados
 * @author Higor Vital
 * @author Tarles Walker
 */
public class Regiao {
    
    private List<Estado> estados = new ArrayList();
    private String nome;
    
    public Regiao(String nome){
        this.nome = nome;
    }
    
    /**
    * Retorna a lista de estados daquela região
    * 
    * @return 
    */
    public List<Estado> getEstados() {
        return estados;
    }

    /**
    * Retorna nome da região
    * 
    * @return 
    */
    public String getNome() {
        return nome;
    }
    
    /**
    * Adiciona um estado a região
    * 
    * @param estado Estado a ser adicionado
    */
    public void addEstado(Estado estado){
        estados.add(estado);
    }
    
    /**
    * Retorna a quantidade de estado naquela região
    * 
    * @return 
    */
    public int estadoSize(){
        return estados.size();
    }

    /**
    * Retorna o estado de acordo com o nome passado
    * 
    * @param esta Estado
    * @return 
    */
    public Estado getEstado(Estado esta){
        Iterator it = estados.iterator();
        while(it.hasNext()){
            Estado est = (Estado)it.next();
            if(esta.getNome().equals(est.getNome())){
               return est;
            }
        }
        return null;
    }
       
}
