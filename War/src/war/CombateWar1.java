/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Classe que implementa o método de combate de acordo com as regras do jogo War na sua primeira versao
 * @author Higor Vital
 * @author Tarles Waker
 */
public class CombateWar1 extends Combate{

    /**
    * Realiza o combate: o jogador informa a origmem e o destino do ataque, e o número de exércitos que vão atacar
    * Os valores da ataque e da defesa são comparados, e os exercitos são removidos de acordo com esses resultados
    * Se o jogador conquistar o território, ele informa quantos exercitos irá redistribuir, e ganha uma carta
    * Também é verificado de o jogador conquistou uma região
    * Se a quantidade de cartas que o jogador tem for maior ou igual a 5, ele é forçado a trocar
    * 
     * @param j Jogador que está atacando
     * @param jogo Instãncia do Jogo
    */
    @Override
    public void combate(Jogador j, Jogo jogo) {
        boolean tudoCerto = true;
        Estado est_origem;
        String[] origem_destino;
        do{
            tudoCerto = true;
            System.out.println("Indique o estado origem e destino do ataque: (Ex.: AC-AM ) ");
            Scanner s = new Scanner(System.in);
            origem_destino = s.next().split(Pattern.quote("-"));
            est_origem = jogo.getEstado(origem_destino[0]);;
            if(!j.temEstado(origem_destino[0]) || !est_origem.isFronteiras(origem_destino[1])){
                tudoCerto = false;
                System.out.println("ESTADOS INVÁLIDOS (S/ FRONTEIRA OU ORIGEM NÃO PERTENCE AO JOGADOR)");                
            }else if(j.temEstado(origem_destino[1])){
                tudoCerto = false;
                System.out.println("ESTADOS INVÁLIDOS (DESTINO JÁ PERTENCE)");                
            }else if(est_origem.getExercitos()<=1){
                tudoCerto = false;                
                System.out.println("EXERCITOS INVÁLIDOS (QTD MÍNIMA DE EXERCITOS)");                
            }
        }while(!tudoCerto);
        
        System.out.println("Indique o numero de exercitos que atacarão:");
        Scanner s = new Scanner(System.in);
        int n_exercito_ataque = Integer.parseInt(s.nextLine());    
        if(n_exercito_ataque>est_origem.getExercitos()-1 && est_origem.getExercitos()<=4){
            n_exercito_ataque = est_origem.getExercitos()-1;
        }else if(n_exercito_ataque>est_origem.getExercitos()-1 && est_origem.getExercitos()>4){
            n_exercito_ataque = 3;
        }
        
        Estado est_destino = jogo.getEstado(origem_destino[1]);        
        int n_exercito_defesa;
        if(est_destino.getExercitos()<n_exercito_ataque){
            n_exercito_defesa = est_destino.getExercitos();
        }else{
            n_exercito_defesa = n_exercito_ataque;            
        }
                
        int vitorias = 0;
        int[] ataque = new int[3];
        int[] defesa = new int[3];

        for(int x = 0; x < n_exercito_ataque;x++){
            Random rand = new Random();
            ataque[x] = rand.nextInt(6) + 1;
        }
        
        for(int x = 0; x < n_exercito_defesa;x++){
            Random rand = new Random();
            defesa[x] = rand.nextInt(6) + 1;
        }
        
        for(int x = 1; x < n_exercito_ataque; x++){
            if(ataque[x]>ataque[x-1]){
                int a = ataque[x-1];
                ataque[x-1] = ataque[x];
                ataque[x] = a;
            }
        }
        for(int x = 1; x < n_exercito_defesa; x++){
            if(defesa[x]>defesa[x-1]){
                int a = defesa[x-1];
                defesa[x-1] = defesa[x];
                defesa[x] = a;
            }
        }
        
        for(int x = 0; x < n_exercito_defesa;x++){
            if(ataque[x]>defesa[x]){
                vitorias++;
            }
        }
        
        est_destino.removerExercito(vitorias);
        est_origem.removerExercito(n_exercito_defesa-vitorias);
        if(est_destino.getExercitos()<=0){
            jogo.getJogador(est_destino).isVivo();
            jogo.printarMapa();
            System.out.println("Você venceu, indique quantos exércitos moverá:");
            jogo.ganharCarta(j);
            s = new Scanner(System.in);
            int exercito_mover = Integer.parseInt(s.nextLine());
            if(exercito_mover>n_exercito_ataque){
                exercito_mover = n_exercito_ataque;
            }
            if(exercito_mover>est_origem.getExercitos()-1){
                exercito_mover = est_origem.getExercitos()-1;
            }
            if(exercito_mover<=0){
                exercito_mover = 1;
            }
            est_origem.removerExercito(exercito_mover);
            est_destino.addExercito(exercito_mover);
            Jogador perdeu  = jogo.getJogador(est_destino);
            perdeu.removeEstado(est_destino);
            j.addEstado(est_destino);
            
            Regiao reg = jogo.getRegiao(est_destino);
            if(jogo.isDominada(reg, j)){
                jogo.ganharCarta(j);
//                j.addRegiao(reg);
                System.out.println("Voçê dominou a região "+reg.getNome());
            }
            if(j.getCartas().size()>=5){
                System.out.println("Voçê já tem 5 cartas, elas serão trocadas");
                jogo.trocarCartas(j);
            }
        }
    }
    
}
