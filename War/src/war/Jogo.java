/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Classe que possui a maior parte das regras do jogo, cria o ambiente (mapa, estados, jogadores) com as cores, faz distribuição dos exércitos, verifica se o jogo possui um vencedor, efetua o rodízio entre os jogadores
 * @author Higor Vital
 * @author Tarles Walker
 */
public class Jogo {
    
    private static Jogo instancia;
    
    private static Jogador[] jogadores = new Jogador[6];
    private static int n_jogadores = 0;
    private static HashSet<String> cores = new HashSet<String>();
    private static Regiao[] regioes = new Regiao[5];
    private static int trocas = 0;
    private Combate combateStrategy;
    private boolean encerrar = false;
    private boolean voltar = false;

    private Jogo() {
    }

    public static synchronized Jogo getInstance(){
        if(instancia == null){
            instancia = new Jogo();
        }
        return instancia;
    }
    
    public void setWar1(){
        combateStrategy = new CombateWar1();
    }
    /**
    * Executa o jogo
    * 
    */
    public void iniciarJogo(){
        addCor();
        addMapa();
        addFronteira();
        inicializar();
        distribuirExecitosInicial();
        for(int x =0; x < n_jogadores;x++){
            distribuir(jogadores[x], 0, false);
        }
        while(!fimDeJogo() && !encerrar){
            for(int x =0; x < n_jogadores;x++){
                distribuir(jogadores[x], 0, false);
                do{
                    menuRodada(jogadores[x]);
                    if(encerrar){
                        break;
                    }
                    
                }while(voltar);
                    if(encerrar){
                        break;
                    }

            }
        }
    }
    /**
    * Adiciona uma cor a listas de cores possíveis
    * 
    */
    private void addCor(){
        cores.add("Branco");
        cores.add("Preto");
        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Amarelo");
        cores.add("Verde");        
    }    
    /**
    * Cria as regiões, estados e fronteiras
    * 
    */
    /*private void addMapa(){
        
        Regiao r = new Regiao("Norte");
        regioes[0] = r;
        r = new Regiao("Nordeste");
        regioes[1] = r;
        r = new Regiao("Sudeste");
        regioes[2] = r;
        r = new Regiao("Centro-Oeste");
        regioes[3] = r;
        r = new Regiao("Sul");
        regioes[4] = r;
        
        Estado est = new Estado("AC");
        est.addFronteira("AM");
        est.addFronteira("RO");
//        estados.add(est);
        regioes[0].addEstado(est);

        est = new Estado("AM");
        est.addFronteira("AC");
        est.addFronteira("PA");
        est.addFronteira("RO");
        est.addFronteira("RR");
//        estados.add(est);
        regioes[0].addEstado(est);

        est = new Estado("AP");
        est.addFronteira("PA");
//        estados.add(est);
        regioes[0].addEstado(est);

        est = new Estado("PA");
        est.addFronteira("AP");
        est.addFronteira("AM");
        est.addFronteira("GO");
        est.addFronteira("MA");
        est.addFronteira("MT");
        est.addFronteira("RR");
//        estados.add(est);
        regioes[0].addEstado(est);

        est = new Estado("RO");
        est.addFronteira("AC");
        est.addFronteira("AM");
        est.addFronteira("MT");
 //       estados.add(est);
        regioes[0].addEstado(est);

        est = new Estado("RR");
        est.addFronteira("AM");
        est.addFronteira("PA");
//        estados.add(est);
        regioes[0].addEstado(est);

        //////////////////////////////////////////

        est = new Estado("AL");
        est.addFronteira("BA");
        est.addFronteira("PE");
        est.addFronteira("SE");
  //      estados.add(est);
        regioes[1].addEstado(est);

        est = new Estado("BA");
        est.addFronteira("AL");
        est.addFronteira("ES");
        est.addFronteira("GO");
        est.addFronteira("MA");
        est.addFronteira("MG");
        est.addFronteira("PE");
        est.addFronteira("PI");
        est.addFronteira("SE");
    //    estados.add(est);
        regioes[1].addEstado(est);

        est = new Estado("CE");
        est.addFronteira("PB");
        est.addFronteira("PE");
        est.addFronteira("PI");
        est.addFronteira("SE");
      //  estados.add(est);
        regioes[1].addEstado(est);

        est = new Estado("MA");
        est.addFronteira("BA");
        est.addFronteira("GO");
        est.addFronteira("PA");
        est.addFronteira("PI");
        //estados.add(est);
        regioes[1].addEstado(est);

        est = new Estado("PE");
        est.addFronteira("AL");
        est.addFronteira("BA");
        est.addFronteira("CE");
        est.addFronteira("PB");
        est.addFronteira("PI");
        est.addFronteira("SE");
//        estados.add(est);
        regioes[1].addEstado(est);

        est = new Estado("PB");
        est.addFronteira("CE");
        est.addFronteira("PE");
        est.addFronteira("PN");
//        estados.add(est);
        regioes[1].addEstado(est);

        est = new Estado("PI");
        est.addFronteira("BA");
        est.addFronteira("CE");
        est.addFronteira("GO");
        est.addFronteira("MA");
        est.addFronteira("PE");
//        estados.add(est);
        regioes[1].addEstado(est);

        est = new Estado("RN");
        est.addFronteira("CE");
        est.addFronteira("PB");
//        estados.add(est);
        regioes[1].addEstado(est);

        est = new Estado("SE");
        est.addFronteira("AL");
        est.addFronteira("BA");
//        estados.add(est);
        regioes[1].addEstado(est);

        //////////////////////////////////////////

        est = new Estado("ES");
        est.addFronteira("BA");
        est.addFronteira("MG");
        est.addFronteira("RJ");
//        estados.add(est);
        regioes[2].addEstado(est);

        est = new Estado("MG");
        est.addFronteira("BA");
        est.addFronteira("ES");
        est.addFronteira("GO");
        est.addFronteira("MT");
        est.addFronteira("RJ");
        est.addFronteira("SP");
//        estados.add(est);
        regioes[2].addEstado(est);

        est = new Estado("RJ");
        est.addFronteira("ES");
        est.addFronteira("MG");
        est.addFronteira("SP");
//        estados.add(est);
        regioes[2].addEstado(est);

        est = new Estado("SP");
        est.addFronteira("MG");
        est.addFronteira("MT");
        est.addFronteira("PR");
        est.addFronteira("RJ");
//        estados.add(est);
        regioes[2].addEstado(est);

        //////////////////////////////////////////

        est = new Estado("GO");
        est.addFronteira("BA");
        est.addFronteira("MA");
        est.addFronteira("MG");
        est.addFronteira("MT");
        est.addFronteira("PA");
        est.addFronteira("PI");
//        estados.add(est);
        regioes[3].addEstado(est);

        est = new Estado("MT");
        est.addFronteira("AM");
        est.addFronteira("GO");
        est.addFronteira("MG");
        est.addFronteira("PA");
        est.addFronteira("PR");
        est.addFronteira("RO");
        est.addFronteira("SP");
//        estados.add(est);
        regioes[3].addEstado(est);

        //////////////////////////////////////////

        est = new Estado("PR");
        est.addFronteira("MT");
        est.addFronteira("SC");
        est.addFronteira("SP");
//        estados.add(est);
        regioes[4].addEstado(est);

        est = new Estado("RS");
        est.addFronteira("SC");
//        estados.add(est);
        regioes[4].addEstado(est);

        est = new Estado("SC");
        est.addFronteira("PR");
        est.addFronteira("SC");
//        estados.add(est);
        regioes[4].addEstado(est);       
    }*/
    private void addMapa(){
        
        Regiao r = new Regiao("Norte");
        regioes[0] = r;
        r = new Regiao("Nordeste");
        regioes[1] = r;
        r = new Regiao("Sudeste");
        regioes[2] = r;
        r = new Regiao("Centro-Oeste");
        regioes[3] = r;
        r = new Regiao("Sul");
        regioes[4] = r;
        
        Estado est = new Estado("AC");
        regioes[0].addEstado(est);

        est = new Estado("AM");
        regioes[0].addEstado(est);

        est = new Estado("AP");
        regioes[0].addEstado(est);

        est = new Estado("PA");
        regioes[0].addEstado(est);

        est = new Estado("RO");
        regioes[0].addEstado(est);

        est = new Estado("RR");
        regioes[0].addEstado(est);

        //////////////////////////////////////////

        est = new Estado("AL");
        regioes[1].addEstado(est);

        est = new Estado("BA");
        regioes[1].addEstado(est);

        est = new Estado("CE");
        regioes[1].addEstado(est);

        est = new Estado("MA");
        regioes[1].addEstado(est);

        est = new Estado("PE");
        regioes[1].addEstado(est);

        est = new Estado("PB");
        regioes[1].addEstado(est);

        est = new Estado("PI");
        regioes[1].addEstado(est);

        est = new Estado("RN");
        regioes[1].addEstado(est);

        est = new Estado("SE");
        regioes[1].addEstado(est);

        //////////////////////////////////////////

        est = new Estado("ES");
        regioes[2].addEstado(est);

        est = new Estado("MG");
        regioes[2].addEstado(est);

        est = new Estado("RJ");
        regioes[2].addEstado(est);

        est = new Estado("SP");
        regioes[2].addEstado(est);

        //////////////////////////////////////////

        est = new Estado("GO");
        regioes[3].addEstado(est);

        est = new Estado("MT");
        regioes[3].addEstado(est);

        //////////////////////////////////////////

        est = new Estado("PR");
        regioes[4].addEstado(est);

        est = new Estado("RS");
        regioes[4].addEstado(est);

        est = new Estado("SC");
        regioes[4].addEstado(est);       
    }
    /**
    * Cria as regiões, estados e fronteiras
    * 
    */
    private void addFronteira(){
        Estado est1;
        Estado est = getEstado("AC");
        est1 = getEstado("AM");
        est.addFronteira(est1);
        est1 = getEstado("RO");
        est.addFronteira(est1);

        est = getEstado("AM");
        est1 = getEstado("AC");
        est.addFronteira(est1);
        est1 = getEstado("PA");
        est.addFronteira(est1);
        est1 = getEstado("RO");
        est.addFronteira(est1);
        est1 = getEstado("RR");
        est.addFronteira(est1);

        est = new Estado("AP");
        est1 = getEstado("PA");
        est.addFronteira(est1);

        est = getEstado("PA");
        est1 = getEstado("AP");
        est.addFronteira(est1);
        est1 = getEstado("AM");
        est.addFronteira(est1);
        est1 = getEstado("GO");
        est.addFronteira(est1);
        est1 = getEstado("MA");
        est.addFronteira(est1);
        est1 = getEstado("MT");
        est.addFronteira(est1);
        est1 = getEstado("RR");
        est.addFronteira(est1);



        est = getEstado("RO");
        est1 = getEstado("AC");
        est.addFronteira(est1);
        est1 = getEstado("AM");
        est.addFronteira(est1);
        est1 = getEstado("MT");
        est.addFronteira(est1);

        est = getEstado("RR");
        est1 = getEstado("AM");
        est.addFronteira(est1);
        est1 = getEstado("PA");
        est.addFronteira(est1);
        //////////////////////////////////////////

        est = getEstado("AL");
        est1 = getEstado("BA");
        est.addFronteira(est1);
        est1 = getEstado("PE");
        est.addFronteira(est1);
        est1 = getEstado("SE");
        est.addFronteira(est1);

        est = getEstado("BA");
        est1 = getEstado("AL");
        est.addFronteira(est1);
        est1 = getEstado("ES");
        est.addFronteira(est1);
        est1 = getEstado("GO");
        est.addFronteira(est1);
        est1 = getEstado("MA");
        est.addFronteira(est1);
        est1 = getEstado("MG");
        est.addFronteira(est1);
        est1 = getEstado("PI");
        est.addFronteira(est1);
        est1 = getEstado("SE");
        est.addFronteira(est1);

        est = getEstado("CE");
        est1 = getEstado("PB");
        est.addFronteira(est1);
        est1 = getEstado("PE");
        est.addFronteira(est1);
        est1 = getEstado("PI");
        est.addFronteira(est1);
        est1 = getEstado("SE");
        est.addFronteira(est1);

        est = getEstado("MA");
        est1 = getEstado("BA");
        est.addFronteira(est1);
        est1 = getEstado("GO");
        est.addFronteira(est1);
        est1 = getEstado("PA");
        est.addFronteira(est1);
        est1 = getEstado("PI");
        est.addFronteira(est1);

        est = getEstado("PE");
        est1 = getEstado("AL");
        est.addFronteira(est1);
        est1 = getEstado("BA");
        est.addFronteira(est1);
        est1 = getEstado("CE");
        est.addFronteira(est1);
        est1 = getEstado("PB");
        est.addFronteira(est1);
        est1 = getEstado("PI");
        est.addFronteira(est1);
        est1 = getEstado("SE");
        est.addFronteira(est1);

        est = getEstado("PB");
        est.addFronteira("CE");
        est.addFronteira("PE");
        est.addFronteira("PN");

        est = getEstado("PI");
        est1 = getEstado("BA");
        est.addFronteira(est1);
        est1 = getEstado("CE");
        est.addFronteira(est1);
        est1 = getEstado("GO");
        est.addFronteira(est1);
        est1 = getEstado("MA");
        est.addFronteira(est1);
        est1 = getEstado("PE");
        est.addFronteira(est1);

        est = getEstado("RN");
        est1 = getEstado("CE");
        est.addFronteira(est1);
        est1 = getEstado("PB");
        est.addFronteira(est1);

        est = getEstado("SE");
        est1 = getEstado("AL");
        est.addFronteira(est1);
        est1 = getEstado("BA");
        est.addFronteira(est1);

        //////////////////////////////////////////

        est = getEstado("ES");
        est1 = getEstado("BA");
        est.addFronteira(est1);
        est1 = getEstado("MG");
        est.addFronteira(est1);
        est1 = getEstado("RJ");
        est.addFronteira(est1);

        est = getEstado("MG");
        est1 = getEstado("BA");
        est.addFronteira(est1);
        est1 = getEstado("ES");
        est.addFronteira(est1);
        est1 = getEstado("GO");
        est.addFronteira(est1);
        est1 = getEstado("MT");
        est.addFronteira(est1);
        est1 = getEstado("RJ");
        est.addFronteira(est1);
        est1 = getEstado("SP");
        est.addFronteira(est1);

        est = getEstado("RJ");
        est1 = getEstado("ES");
        est.addFronteira(est1);
        est1 = getEstado("MG");
        est.addFronteira(est1);
        est1 = getEstado("SP");
        est.addFronteira(est1);

        est = getEstado("SP");
        est1 = getEstado("MG");
        est.addFronteira(est1);
        est1 = getEstado("MT");
        est.addFronteira(est1);
        est1 = getEstado("PR");
        est.addFronteira(est1);
        est1 = getEstado("RJ");
        est.addFronteira(est1);

        //////////////////////////////////////////

        est = getEstado("GO");
        est1 = getEstado("BA");
        est.addFronteira(est1);
        est1 = getEstado("MA");
        est.addFronteira(est1);
        est1 = getEstado("MG");
        est.addFronteira(est1);
        est1 = getEstado("MT");
        est.addFronteira(est1);
        est1 = getEstado("PA");
        est.addFronteira(est1);
        est1 = getEstado("PI");
        est.addFronteira(est1);

        est = getEstado("MT");
        est1 = getEstado("AM");
        est.addFronteira(est1);
        est1 = getEstado("GO");
        est.addFronteira(est1);
        est1 = getEstado("MG");
        est.addFronteira(est1);
        est1 = getEstado("PA");
        est.addFronteira(est1);
        est1 = getEstado("PR");
        est.addFronteira(est1);
        est1 = getEstado("RO");
        est.addFronteira(est1);
        est1 = getEstado("SP");
        est.addFronteira(est1);

        //////////////////////////////////////////

        est = getEstado("PR");
        est1 = getEstado("MT");
        est.addFronteira(est1);
        est1 = getEstado("SC");
        est.addFronteira(est1);
        est1 = getEstado("SP");
        est.addFronteira(est1);

        est = getEstado("RS");
        est1 = getEstado("SC");
        est.addFronteira(est1);

        est = getEstado("SC");
        est1 = getEstado("PR");
        est.addFronteira(est1);
        est1 = getEstado("SC");
        est.addFronteira(est1);
    }
    /**
    * Verifica se uma cor faz parte da lista de cores
    * 
    * @param cor
    * @return
    */
    private boolean contemCor(String cor){
        if(cores.contains(cor)){
            cores.remove(cor);
            return true;
        }
        return false;
    }        
    /**
    * Ler a quantidade de exercitos que o usuário quer distribuir, os estados para onde ele que distribuir
    * Verifica se os dados recebidos foram válidos e distribui os exércitos
    * No caso, variável 'cart' ser true, distribui os exercitos passados como parâmentro, 
    * caso contrário, pega os valores de acordo com a quantidade de regiões e estados que o jogador tem
    * @param j Jogador que receberá os exércitos
    * @param exercito a quantidade de exercitos (só é utilizada no caso da variavél 'cart' ser true
    * @param cart valor que diz se devem ser usados os exercitos passados como parâmetro
    */
    private void distribuir(Jogador j, int exercito, boolean cart){
                
        int n_exercito_disponivel;
        String[] escolhas;
        String[] estadoNumero;
        String est;
        printarMapa();

        if(j.isVivo()){
        boolean tudoCerto = true;
        do{
            tudoCerto = true;
            if(cart){
                n_exercito_disponivel = exercito;
            }else{
                if(((j.estadoSize()+getQtdEstadoRegiaoDominadas(j))/2)>=3){
                    n_exercito_disponivel = (j.estadoSize()+getQtdEstadoRegiaoDominadas(j))/2;
                }else{
                    n_exercito_disponivel = 3;                        
                }
            }
            System.out.println("Jogador "+(j.getId()+1)+" ("+j.getCor()+"), você tem " +n_exercito_disponivel+" exércitos para distribuir: (Ex: AC-2, SP-1)");
            Scanner s = new Scanner(System.in);
            s = new Scanner(System.in);
            escolhas = s.nextLine().split(Pattern.quote(", "));
            int total_exercito = 0;
            for(int y = 0; y < escolhas.length;y++){
                estadoNumero = escolhas[y].split(Pattern.quote("-"));
                est = estadoNumero[0];
                if(!j.temEstado(est)){
                    System.out.println("DIGITE UM ESTADO VÁLIDO");
                    tudoCerto = false;
                    break;
                }
                total_exercito += Integer.parseInt(estadoNumero[1]);
                if(total_exercito>n_exercito_disponivel){
                    System.out.println("DIGITE UM NÚMERO DE EXERCITO VÁLIDO");
                    tudoCerto = false;
                }
            }
            if(total_exercito<n_exercito_disponivel){
                    System.out.println("DIGITE UM NÚMERO DE EXERCITO VÁLIDO");
                    tudoCerto = false;
            }
        }while(!tudoCerto);

            for(int y = 0; y < escolhas.length;y++){
                estadoNumero = escolhas[y].split(Pattern.quote("-"));
                est = estadoNumero[0];
                int n_exercito = Integer.parseInt(estadoNumero[1]);
                j.addExercito(est, n_exercito);
            }
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("FIM DA DISTRIBUIÇÃO DE EXERCITOS DO JOGADOR "+(j.getId()+1));
        System.out.println("--------------------------------------------------------------");
    }
    /**
    * Distribui os territórios no inicio do jogo
    * 
    */
    private void distribuirExecitosInicial(){
        int x = 0;        
        for(int y = 0; y < regioes.length; y++){
            Iterator it  = regioes[y].getEstados().iterator();
            while(it.hasNext()){
                Estado est  = (Estado)it.next();
                est.addExercito(1);
                jogadores[x].addEstado(est);
                x++;
                if(x==n_jogadores){
                    x=0;
                }
            }            
        }
    }
    /**
    * Verifica se algum jogador dominou todas as regiões, caso sim, parabeniza o jogador e encerra o jogo
    * 
    * @param return
    */
    private boolean fimDeJogo(){
    
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
    /**
    * Dar uma carta a um jogador
    * 
     * @param j Jogador que recebe a carta
    */
    protected void ganharCarta(Jogador j){
        Random rand = new Random();
        int forma = rand.nextInt(3) + 1;
        
        if(forma==1){
            Carta c = new Carta("Quadrado");
            j.addCarta(c);
        }else if(forma==2){
            Carta c = new Carta("Circulo");
            j.addCarta(c);            
        }else{
            Carta c = new Carta("Triangulo");
            j.addCarta(c);            
        }
    }    
    /**
    * Retorna o objeto Estado de acordo com o Nome do mesmo
    * 
     * @param esta Nome do estado
     * @return 
    */
    protected Estado getEstado(String esta){
        for(int y = 0; y < regioes.length; y++){
            Iterator it = regioes[y].getEstados().iterator();
            while(it.hasNext()){
                Estado est = (Estado)it.next();
                if(est.getNome().equals(esta)){
                   return est;
                }
            }

        }
        return null;
    }   
    /**
    * Retorna o Jogador que domina um dado estado
    * 
     * @param est Estado
     * @return 
    */
    protected Jogador getJogador(Estado est){
        for(int x = 0; x < n_jogadores;x++){
            if(jogadores[x].temEstado(est.getNome())){
                return jogadores[x];
            }
        }
        return null;
    }    
    /**
    * Retorna a quantidade de estados nas regiões que um jogador domina
    * 
    * @param j Jogador
    */
    private int getQtdEstadoRegiaoDominadas(Jogador j){
        int total = 0;
        for(int x = 0; x < regioes.length; x++){
            if(isDominada(regioes[x],j)){
                total+=regioes[x].estadoSize();
            }
        }
        return total;
    }    
    /**
    * Retorna a Região a qual o estado faz parte 
    * 
     * @param est Estado
     * @return 
    */
    protected Regiao getRegiao(Estado est){
        for(int x = 0; x < regioes.length;x++){
            if(regioes[x].getEstado(est)!=null){
                return regioes[x];
            }
        }
        return null;
    }    
    /**
    * Pega as informações iniciais, como número de jogadores e cor de cada jogador
    * 
    */
    private void inicializar(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("TELAS DE INICIALIZAÇÃO DO JOGO\n");
        System.out.println("--------------------------------------------------------------");
        Scanner s;
        while(n_jogadores<3){
            System.out.println("Digite o número de jogadores (min: 3):");    
            s = new Scanner(System.in);
            n_jogadores = Integer.parseInt(s.nextLine());
        }
        
        for(int x = 0; x < n_jogadores; x++){
            System.out.println("Associe uma cor ao jogador "+(x+1));
            s = new Scanner(System.in);
            String str = s.nextLine();
            while(!contemCor(str)){
                System.out.println("Cor inválida. Associe uma cor ao jogador "+(x+1));
                s = new Scanner(System.in);
                str = s.nextLine();                
            }
            Jogador j = new Jogador(str);
            jogadores[x] = j;
//            jogadores.add(j);
        }
        System.out.println("--------------------------------------------------------------\n");
    }    
    /**
    * Retorn se um Regiao e dominada por um Jogador
    * 
     * @param r Regiao
     * @param j Jogador
     * @return 
    */
    protected boolean isDominada(Regiao r, Jogador j){
        Iterator it = r.getEstados().iterator();
        while(it.hasNext()){
            Estado est = (Estado)it.next();
            if(!j.temEstado(est.getNome())){
               return false;
            }
        }
        return true;
    }
    /**
    * Percorre o array de Jogadores dando a eles as opções: 1 - ir a combate, 2 - encerrar a jogada;
    * no caso se escolher a opção 2, ele pode trocar suas cartas, ou encerrar a jogada de vez
    * 
    */
    private void menuRodada(Jogador j){
            voltar = false;
            System.out.println("--------------------------------------------------------------");
            System.out.println("RODADA JOGADOR "+(j.getId()+1));
            System.out.println("--------------------------------------------------------------");

            if(j.isVivo()){

                printarMapa();
//                System.out.println("1 - Distribuição");
                System.out.println("1 - Combate");
                System.out.println("2 - Encerrar\n");
                System.out.println("3 - Fim do Jogo\n");
                System.out.println("Jogador "+(j.getId()+1)+" ("+j.getCor()+"), digite a opção desejada");

                Scanner s = new Scanner(System.in);
                int opcao = Integer.parseInt(s.nextLine());
                switch(opcao){
                    case 1: combateStrategy.combate(j, this);
                            //x--;
                            voltar = true;
                            break;
                    case 2: System.out.println("1 - Carta-estado");
                            System.out.println("2 - Fim da jogada");
                            System.out.println("3 - Fim do Jogo\n");
                            System.out.println("Jogador "+(j.getId()+1)+", digite a opção desejada");
                            s = new Scanner(System.in);
                            int opcao2 = Integer.parseInt(s.nextLine());
                            switch(opcao2){
                                case 1: trocarCartas(j);
                                        break;
                                case 2: if(j.getCartas().size()>=5){
                                            System.out.println("Voçê tem 5 cartas, portanto é obrigatório trocá-las");
                                            trocarCartas(j);
                                        }
                                        System.out.println("--------------------------------------------------------------");
                                        System.out.println("FIM ATAQUE JOGADOR "+(j.getId()+1));
                                        System.out.println("--------------------------------------------------------------");
                                        break;
                                default: encerrar = true;
                                        break;

                            };
                            break;
                    default: encerrar = true;
                            break;
                 }
            }
        
    }    
    /**
    * Printa o mapa
    * 
    */
    protected void printarMapa(){
        System.out.println("Mapa\n");
        for(int x = 0; x < regioes.length;x++){
            System.out.print(regioes[x].getNome()+" - ");
            Iterator it = regioes[x].getEstados().iterator();
            while(it.hasNext()){
                Estado est = (Estado)it.next();
                System.out.print(est.getNome()+"("+getJogador(est).getCor()+"-"+est.getExercitos()+")");
                if(it.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }    
    /**
    * Verifica se um Jogador tem a quantidade de cartas sufucientes para para serem trocadas, caso sim, as troca
    * 
     * @param j Jogador
    */
    protected void trocarCartas(Jogador j){
        int quadrado = 0, triangulo = 0, circulo = 0;
        if(j.getCartas().size()<3){
            System.out.println("\nVoce não tem cartas o suficiente\n");
        }else{
            List<Carta> cartas = j.getCartas();
            Iterator it = cartas.iterator();
            while(it.hasNext()){
                Carta c = (Carta)it.next();
                if(c.getForma().equals("Quadrado")){
                    quadrado++;
                }else if(c.getForma().equals("Triangulo")){
                    triangulo++;
                }else if(c.getForma().equals("Circulo")){
                    circulo++;
                }
            }
            if((quadrado>=3 || triangulo >=3 || circulo >= 3)||(quadrado>=1 && circulo>=1 && triangulo>=1)){
                distribuir(j, trocas+1, true);
                trocas++;
                j.zerarCartas();
            }else{
                System.out.println("\nVoçê não conseguiu exercitos\n");
            }
        }
        
        
    }
    
}