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
class SCGNode {
    protected SCGNode Right, Left, Parent;
    protected int Value;
    
    SCGNode(int val)
    {
        Right=Left=Parent=null;
        Value=val;
    }
}
