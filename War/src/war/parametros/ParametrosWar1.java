/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.parametros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * classe que contem os parametros do jogo
 * @author darts
 */
public class ParametrosWar1 extends Parametros{
    private static ParametrosWar1 instance;
    
    private String north[] = {"AC", "AP", "AM", "PA", "RO", "RR"};
    private String northeast[] = {"AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"};
    private String midest[] = {"GO", "MT"};
    private String southeast[] = {"ES", "MG", "SP", "RJ"};
    private String south[] = {"PR", "RS", "SC"};
    
    private HashMap<String, String[]> frontiers;
    
    private ParametrosWar1() {
        initFronteiras();
        initEstadosPorRegiao();
        initEstados();//deve seguir initEstadosPorRegiao()
    }
    
    public static ParametrosWar1 getInstance(){
        if (instance == null){
            instance = new ParametrosWar1();
        }
        return instance;
    }
    
    private void initEstados() {
        ArrayList<String> N = new ArrayList<String>(Arrays.asList(north));
        ArrayList<String> NE = new ArrayList<>(Arrays.asList(northeast));
        ArrayList<String> MW = new ArrayList<>(Arrays.asList(midest));
        ArrayList<String> SE = new ArrayList<>(Arrays.asList(southeast));
        ArrayList<String> S = new ArrayList<>(Arrays.asList(south));
        
        this.states = new ArrayList<>();
        states.addAll(N);
        states.addAll(NE);
        states.addAll(MW);
        states.addAll(SE);
        states.addAll(S);
    }
    
    /**
     * inicializa as regioes
     */
    private void initEstadosPorRegiao() {
        this.regions = new HashMap<>();
        
        regions.put("NORTE", north);
        regions.put("NORDESTE", northeast);
        regions.put("CENTRO-OESTE", midest);
        regions.put("SUDESTE", southeast);
        regions.put("SUL", south);
    }
    
    /**
     * inicializa os estados por regiao
     */
    private void initFronteiras() {        
        String AC[] = {"AM"};
        String AP[] = {"PA"};
        String PA[] = {"AM", "RR", "MT", "AP", "MA", "GO"};
        String RO[] = {"PA", "AM"};
        String RR[] = {"AM", "MT"};
        String AL[] = {"BA", "PE", "SE"};
        String BA[] = {"GO", "PI", "PE", "AL", "SE", "ES", "MG"};
        String CE[] = {"PI", "PE", "PB", "RN"};
        String MA[] = {"PA", "GO", "PI"};
        String PB[] = {"RN", "CE", "PE"};
        String PE[] = {"PB", "CE", "PI", "BA", "AL"};
        String PI[] = {"CE", "MA", "BA", "PE"};
        String RN[] = {"CE", "PB"};
        String SE[] = {"AL", "BA"};
        String GO[] = {"PA", "MT", "MG", "BA", "MA"};
        String MT[] = {"GO", "PA", "AM", "RO", "PR", "SP", "MG"};
        String ES[] = {"BA", "MG", "RJ"};
        String MG[] = {"BA", "GO", "MT", "SP", "RJ", "ES"};
        String SP[] = {"MG", "MT", "PR", "RJ"};
        String RJ[] = {"ES", "MG", "SP"};
        String PR[] = {"SP", "MT", "SC"};
        String RS[] = {"SC"};
        String SC[] = {"PR", "RS"};
        
        this.frontiers = new HashMap<>();
        
        this.frontiers.put("AC", AC);
        this.frontiers.put("AP", AP);
        this.frontiers.put("PA", PA);
        this.frontiers.put("RO", RO);
        this.frontiers.put("RR", RR);
        this.frontiers.put("AL", AL);
        this.frontiers.put("BA", BA);
        this.frontiers.put("CE", CE);
        this.frontiers.put("MA", MA);
        this.frontiers.put("PB", PB);
        this.frontiers.put("PE", PE);
        this.frontiers.put("PI", PI);
        this.frontiers.put("RN", RN);
        this.frontiers.put("SE", SE);
        this.frontiers.put("GO", GO);
        this.frontiers.put("MT", MT);
        this.frontiers.put("ES", ES);
        this.frontiers.put("MG", MG);
        this.frontiers.put("SP", SP);
        this.frontiers.put("RJ", RJ);
        this.frontiers.put("PR", PR);
        this.frontiers.put("RS", RS);
        this.frontiers.put("SC", SC);
    }

}
