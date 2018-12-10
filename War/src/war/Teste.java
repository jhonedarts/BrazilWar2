/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.regex.Pattern;

/**
 *
 * @author Higor Vital
 */
public class Teste {


    public static void main(String[] args) {
        String abc = "a;b;c";
        String nu = "1;2;3;4;5";
        
        String[] escolha = abc.split(Pattern.quote(";"));
        System.out.println(escolha.length);
        escolha = nu.split(Pattern.quote(";"));
        System.out.println(escolha.length);
    }
    
    
}
