/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package traduction;

import java.io.*;
import java.util.StringTokenizer;


/**
 *
 * @author PORET Quentin
 */
public class Traduction {
    
    private String fichierFiacre;
    private BufferedReader reader;
    
    /**
     * Methode permettant de récupérer un bloc de texte du fichier écrit en Fiacre.
     * Le but est donc d'identifier tout les types de blocs et les traduire.
     * Les différents blocs sont : 
     * - Initialisation d'un process
     * - Transition
     * - Etats (States)
     * 
     * @param fichierFiacre
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
    public String RecupererBloc (String fichierFiacre) throws FileNotFoundException,IOException{
        BufferedReader fichier = new BufferedReader(new FileReader(fichierFiacre));
        String ligne = fichier.readLine();
        while (ligne!="end"){ // TO DO analyser tout les types de bloc et faire un switch
            AnalyserBloc(ligne); // TO DO analyser un paragraphe
            ligne=fichier.readLine();
        }
        return ligne;
    }
    
/**
 * Methode permettant d'analyser un bloc de language Fiacre.
 * Le but est d'identifer chaque marqueur (if, while, from, to...) puis traduire la condition dans un mot.
 * Chaque ligne est ensuite ajouté à un bloc.
 * On écrira chaque bloc les uns à la suite des autres dans un fichier .cts .
 * @param ligne
 * @return 
 */
    
    public String AnalyserBloc (String ligne){
        // TODO découper le paragraphe en ligne
        String bloc="";
        String delimiteurs = " ,.;";
        StringTokenizer tokenizer = new StringTokenizer (ligne,delimiteurs);
        
        String debut = tokenizer.nextToken();
        
        while (debut!=null){ //TODO revoir
            
            switch (debut) {
                
                case "from" :
                    String States1 = tokenizer.nextToken();
                    String suite = tokenizer.nextToken();
                    switch (suite) {
                        
                        case "if" :
                            
                            break;
                            
                        case "while" :
                            break;
                            
                        case "to" :
                            String States2 = tokenizer.nextToken();
                            
                            String debutDeclarationTransition = "transition [intermediate {"+States1+"'"+States1+"="+States1+"'"+States1+" - 1;}]";
                            String finDeclarationTransition = "{"+States1+"'"+States1+"="+States1+"'"+States1+" - 1,"+States2+"'"+States2+"="+States2+"'"+States2+" + 1;}";
                            
                            break;
                            
                        default :
                            suite = tokenizer.nextToken();
                            
                            
                    }
                    break;
                    
            }
        }
        return bloc;
    }
    
}
