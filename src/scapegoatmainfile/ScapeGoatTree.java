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
public class ScapeGoatTree {
    SCGNode Root;
    int n;    //n is the size of tree
    int q;  //Overestimate of n
    
    ScapeGoatTree()
    {
        Root=null;
        n=0;
    }
    
    boolean IsEmpty()
    {
        if(Root==null)
        {
            return true;
        }
        return false;
    }
    
    void EmptyTree()
    {
        Root=null;
        n=0;
    }
    
    int GetSize(SCGNode Rt)
    {
        if(Rt==null)
        {
            return 0;
        }
        else
        {
            int n=1;
            n+=GetSize(Rt.Left);
            n+=GetSize(Rt.Right);
            return n;
        }
    }
    
    int SearchKey(int Key)
    {
        return SearchKey(Root, Key);
    }
    
    private int SearchKey(SCGNode Rt, int Key)
    {
        if(Rt==null || Rt.Value==Key)
        {
            return Rt.Value;
        }
        else if(Rt.Value>Key)
        {
            return SearchKey(Rt.Left,Key);
        }
        else
        {
            return SearchKey(Rt.Right,Key);
        }
    }
    
    private static final int Log32(int Val)
    {
        final double lg32=2.4663034623764317;
        return (int)Math.ceil(lg32*Math.log(Val));
    }
    
    int InsertWithDepth(SCGNode N)
    {
        SCGNode Rt= Root;
        if(Rt==null)
        {
            Root=N;
            n++;
            q++;
            return 0;
        }
        boolean inserted=false;
        int depth=0;
        do
        {
            if(N.Value<Rt.Value)
            {
                if(Rt.Left==null)
                {
                    Rt.Left=N;
                    N.Parent=Rt;
                    inserted=true;
                }
                else 
                {
                    Rt=Rt.Left;
                }
            }
            else if(N.Value>Rt.Value)
            {
                if(Rt.Right==null)
                {
                    Rt.Right=N;
                    N.Parent=Rt;
                    inserted=true;
                }
                else
                {
                    Rt=Rt.Right;
                }
            }
            else
            {
                return -1;
            }
            depth++;
        }
        while(!inserted);
        n++;
        q++;
        return depth;
    }
    
    void Insert(int Key)
    {
        SCGNode n= new SCGNode(Key);
        int depth=InsertWithDepth(n);
        if(depth>Log32(q))  //n can be used as well
        {
            //Depth exceeded, find scapegoat
            SCGNode temp= n.Parent;
            while(3*GetSize(temp)<=2*GetSize(temp.Parent))
            {
                temp=temp.Parent;
                Rebuild(temp.Parent);
            }
        }
    }
    
    void Rebuild(SCGNode N)
    {
        int NodeSize=GetSize(N);
        SCGNode Parent=N.Parent;
        SCGNode[] Arr= new SCGNode[NodeSize];
        PackIntoArr(N,Arr,0);
        if(Parent==null)
        {
            Root=BuildBalanced(Arr,0,NodeSize);
            Root.Parent=null;
        }
        else if(Parent.Right==N)
        {
            Parent.Right=BuildBalanced(Arr,0,NodeSize);
            Parent.Right.Parent=Parent;
        }
        else
        {
            Parent.Left= BuildBalanced(Arr,0,NodeSize);
            Parent.Left.Parent=Parent;
        }
    }
    
    int PackIntoArr(SCGNode N, SCGNode[] Arr,int i)
    {
        if(N==null)
        {
            return i;
        }
        i=PackIntoArr(N.Left,Arr,i);
        Arr[i++]=N;
        return PackIntoArr(N.Right,Arr,i);
    }
    
    SCGNode BuildBalanced(SCGNode[] Arr, int i, int NodeSize)
    {
        if(NodeSize==0)
        {
            return null;
        }
        int m=NodeSize/2;
        Arr[i+m].Left=BuildBalanced(Arr,i,m);
        if(Arr[i+m].Left!=null)
        {
            Arr[i+m].Left.Parent=Arr[i+m];
        }
        Arr[i+m].Right=BuildBalanced(Arr,i+m+1,NodeSize-m-1);
        if(Arr[i+m].Right!=null)
        {
            Arr[i+m].Right.Parent=Arr[i+m];
        }
        return Arr[i+m];
    }
    
    void InOrder()
    {
        InOrder(Root);
    }
    
    private void InOrder(SCGNode Rt)
    {
        if(Rt!=null)
        {
            InOrder(Rt.Left);
            System.out.println(Rt.Value);
            InOrder(Rt.Right);
        }
    }
}
