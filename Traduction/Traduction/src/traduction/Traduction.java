/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package traduction;


/**
 *
 * @author PORET Quentin
 */
public class Traduction {
    
    public static void main(String[] args) {
        TraductionBloc trd = new TraductionBloc();
        String[] bloc = trd.RecupererBloc("test.txt");
        String trad = trd.AnalyserBloc(bloc);
        System.out.println(trad);
    }
}
    
    
