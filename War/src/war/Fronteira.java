/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 *
 * @author Higor Vital
 */
public class Fronteira {
    
    private String pais1;
    private String pais2;
    
    public Fronteira(String pais1, String pais2){
        this.pais1 = pais1;
        this.pais2 = pais2;
    }
    /**
    * metodo principal da aplicacao responsavel por executar a mesma
    * 
    * 
    * @return 
    */
    public String getPais1() {
        return pais1;
    }

    public String getPais2() {
        return pais2;
    }
    
     
}
