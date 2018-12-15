/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.models;

/**
 * Classe que armazena a quantidade de exércitos e suas fronteiras
 * @author Higor Vital
 * @author Tarles Walker
 */
public class Estado {
    private String nome;
    private int soldados = 0;
    private String cor;
    
    public Estado(String nome){
        this.nome = nome;
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
    * Retorna a quantidade de soldados
    * 
     * @return 
    */
    public int getSoldados() {
        return soldados;
    }
    /**
    * Remove uma quantidade de exércitos
    * 
    * @param numero - Valor que vai ser removido
    */    
    public void removerSoldados(int numero){
        soldados-=numero;
    }
    /**
    * Adiciona novos exércitos
    * 
    * @param numero - Valor que vai ser adicionado
    */
    public void addSoldados(int numero){
        soldados+=numero;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public int popSoldado(){
        removerSoldados(1);
        return (this.soldados>0)?1:0;
    }
    
    /**
     * retorna 0-3 unidades dependendo da disponibilidade e condicao 
     * de permanecia de uma unidade no territorio
     * @return colecao de unidade que vao a guerra
     */
    public int getSoldadosParaAtaque() {
        if (this.soldados >= 4){
            return 3;
        } else if (this.soldados == 3){
            return 2;
        } else if (this.soldados == 2){
            return 1;
        }
        return 0;
    }
    
    /**
     * retorna 0-3 unidades dependendo da disponibilidade
     * @return colecao de unidade que vao a guerra defender
     */
    public int getSoldadosParaDefesa() {
        if (this.soldados >= 3){
            return 3;
        } else if (this.soldados == 2){
            return 2;
        } else if (this.soldados == 1){
            return 1;
        }
        return 0;
    }
    
}
