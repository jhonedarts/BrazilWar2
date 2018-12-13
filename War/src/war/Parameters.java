/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 *
 * @author jhone
 */
public abstract class Parameters {

    public static Parameters getInstance(int map) {
        Parameters parameters = null;
        if(map == 1){
            parameters = ParametersWar1.getInstance();
        }else if (map == 2){
            parameters = ParametersWar2.getInstance();
        }
        return parameters;
    }
    
}
