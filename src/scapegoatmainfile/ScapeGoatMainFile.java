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
        SGT.Insert(7);
        SGT.Insert(6);
        SGT.Insert(3);
        SGT.Insert(1);
        SGT.Insert(0);
        SGT.Insert(8);
        SGT.Insert(9);
        SGT.Insert(4);
        SGT.Insert(5);
        SGT.Insert(2);
        SGT.Insert(3);
        SGT.PreOrder();
    }
    
}
