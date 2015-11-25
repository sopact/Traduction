/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package traduction;

import java.io.*;

/**
 *
 * @author PORET Quentin
 */
public class TransitionTrad {
    
    private String fichierRomeo;
    private BufferedWriter writer;
    
    public TransitionTrad (String fichierRomeo){
        try {
            this.fichierRomeo=fichierRomeo;
            this.writer = new BufferedWriter (new FileWriter(fichierRomeo));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public TransitionTrad(){
        try {
            String fichierRomeo ="fichierRomeo";
            this.fichierRomeo = fichierRomeo;
            this.writer = new BufferedWriter(new FileWriter (new File(this.fichierRomeo)));
            
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void TraduireUneTransition (){
        
        
        // this.writer.write();
        // this.writer.newLine();
    }
    
}
