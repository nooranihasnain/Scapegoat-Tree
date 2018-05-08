/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scapegoatmainfile;

/**
 *
 * @author Hasnain Noorani
 */
public class ScapeGoatMainFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ScapeGoatTree SGT= new ScapeGoatTree();
        SGT.Insert(34);
        SGT.Insert(67);
        SGT.Insert(11);
        SGT.Insert(24);
        SGT.InOrder();
    }
    
}
