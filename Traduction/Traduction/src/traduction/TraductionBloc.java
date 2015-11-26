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
public class TraductionBloc {
    
    /**
     *
     */
    public TraductionBloc (){
    }
    
    /**
     * Méthode permettant de récupérer un bloc de texte du fichier écrit en Fiacre.
     * Le but est donc d'identifier tout les types de blocs et les traduire.
     * Les différents blocs sont :
     * - Initialisation d'un process
     * - Transition
     * - Etats (States)
     * Un bloc est un ensemble de ligne qui est stocké dans un tableau de mots.
     * @param fichierFiacre
     * @return
     */
    public String[] RecupererBloc(String fichierFiacre){
        try{
            BufferedReader fichier = new BufferedReader(new FileReader(fichierFiacre));
            int j=0;
            String[] ligne = new String[3]; // TODO Changer le tableau en List ou autre
            ligne[j] = fichier.readLine();
            while (!"end".equals(ligne[j])){ // TO DO analyser tout les types de bloc et faire un switct
                j++;
                ligne[j]=fichier.readLine();
                
            }
            // String bloc = AnalyserBloc(ligne);
            return ligne;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * La méthode AnalyserBloc prend un entrée un bloc (tableau de mots)
     * Le premier mot sert à connaître le type de bloc (transition, process etc).
     * Ensuite on détecte différents mots clés et on traduit le reste de la ligne en fonction
     * A la fin on récupère tout les bouts de code et on les assemble dans un bloc de texte
     * @param ligne
     * @return
     */
    
    public String AnalyserBloc (String ligne[]){
        // TODO découper le paragraphe en ligne
        String bloc = null;
        String delimiteurs = " ,.;";
        
        
        StringTokenizer tokenizer = new StringTokenizer (ligne[0],delimiteurs);
        
        String debut = tokenizer.nextToken();
        
        String debutDeclarationTransition = "";
        String finDeclarationTransition = "";
        
        
        switch (debut) {
            
            case "from" :
                String States1 = tokenizer.nextToken();
                for (int j=1;j<ligne.length;j++){
                    tokenizer = new StringTokenizer(ligne[j],delimiteurs);
                    String suite = tokenizer.nextToken();
                    switch (suite) {
                        
                        case "if" :
                            
                            break;
                            
                        case "while" :
                            break;
                            
                        case "to" :
                            String States2 = tokenizer.nextToken();
                            
                            debutDeclarationTransition = "transition [intermediate {"+States1+"'"+States1+"="+States1+"'"+States1+" - 1;}]";
                            finDeclarationTransition = "{"+States1+"'"+States1+"="+States1+"'"+States1+" - 1,"+States2+"'"+States2+"="+States2+"'"+States2+" + 1;}";
                            break;
                            
                            
                            
                            
                    }
                    
                    
                }
                break;
            default :
                System.out.println("erreur");
        }
        
        bloc = debutDeclarationTransition + "When (a'a>=1)" + finDeclarationTransition;
        return bloc;
    }
}

