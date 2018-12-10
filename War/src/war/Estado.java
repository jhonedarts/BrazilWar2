/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que armazena a quantidade de exércitos e suas fronteiras
 * @author Higor Vital
 * @author Tarles Walker
 */
public class Estado {
    private String nome;
    private int exercitos = 0;
    private HashSet<String> fronteiras = new HashSet();
    private List<Estado> fronteirass = new ArrayList();
    
    public Estado(String nome){
        this.nome = nome;
    }

    public void addFronteira(Estado f){
        fronteirass.add(f);
    }
    
    /**
    * Retorna nome do estado
    * 
    * @return 
    */    
    public String getNome() {
        return nome;
    }
    /**
    * Retorna a quantidade de exercitos
    * 
     * @return 
    */
    public int getExercitos() {
        return exercitos;
    }
    /**
    * Remove uma quantidade de exércitos
    * 
    * @param numero - Valor que vai ser removido
    */    
    public void removerExercito(int numero){
        exercitos-=numero;
    }
    /**
    * Adiciona novos exércitos
    * 
    * @param numero - Valor que vai ser adicionado
    */
    public void addExercito(int numero){
        exercitos+=numero;
    }
    /**
    * Adiciona uma nova fronteira
    * 
    * @param fronteira - String com o nome do estado
    */
    public void addFronteira(String fronteira){
        fronteiras.add(fronteira);
    }
    /**
    * Retorna se um estado é fronteira ou não
    * 
    * @param fronteira Estado que vai ser comparado
    * @return 
    */
    public boolean isFronteira(String fronteira){
        return fronteiras.contains(fronteira);
    }
    
    public boolean isFronteiras(String fronteira){
        Iterator it = fronteirass.iterator();
        while(it.hasNext()){
            Estado est = (Estado)it.next();
            if(fronteira.equals(est.getNome())){
               return true;
            }
        }
        return false;
    }
}
