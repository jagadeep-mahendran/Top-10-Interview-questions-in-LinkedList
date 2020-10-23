// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
     
     static Node reverse(Node head)
      {
          if(head==null)
             return null;
            Node prev=null;
            Node cur =head;
            Node nxt=null;
            while(cur!=null)
             {
                 nxt=cur.next;
                 cur.next=prev;
                 prev=cur;
                 cur=nxt;
                 
             }
             head=prev;
             return head;
      }
    static Node addLists(Node first, Node second){
        
          if(first==null&&second==null) return null;
          else if(first==null)          return second;
          else if(second==null)         return first;
          
          first=reverse(first);
          second=reverse(second);
          Node res=null;
          Node resend=null;
          int c=0;
          while(first!=null&&second!=null)
           {  
                int x= first.data+second.data+c;
                   if(x>9)
                       x=x%10;
                        
                if(res==null)
                 {   
                      
                     res=new Node(x);
                     resend=res;
                 }
                 else
                 {
                     resend.next=new Node(x);
                     resend=resend.next;
                 }
                 if((first.data+second.data+c)>9)   c=1;
                 else                               c=0; 
                     
                  first=first.next;
                  second=second.next;
           }
           while(first!=null){
               int x=first.data+c;
              if((first.data+c)>9)
                 x=x%10;
                resend.next=new Node(x);
                resend=resend.next;
                if((first.data+c)>9)   c=1;
                 else                   c=0; 
                 first=first.next;
           }
              while(second!=null)
              {
                  int x=second.data+c;
                  if((second.data+c)>9)
                    x=x%10;
                resend.next=new Node(x);
                resend=resend.next;
                if((second.data+c)>9)   c=1;
                 else                    c=0; 
                 second=second.next;
              }
               
              if(c==1)
                    resend.next=new Node(1);
                    
        return reverse(res);  
          
   }
}
