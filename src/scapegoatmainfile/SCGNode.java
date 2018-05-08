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
public class SCGNode {
    SCGNode Right, Left, Parent;
    int Value;
    
    SCGNode(int val)
    {
        Value=val;
    }
}
