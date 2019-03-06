import java.util.Scanner;

// This is used to allocate memory dynamically whenever a new element is inserted
class Node
{
    Node next = null, prev = null;
    long data;

    Node(long data)
    {
        this.data = data;
    }
}

/*
    Structure of stack is built similar to doubly linked list, so it becomes convinient to traverse on both sides
    Push,pop and inc operations are performed in this class
*/

class Stack
{
    Node top = null,root =null;

    //Pushes the data into the stack
    void push(long data)
    {
        Node node = new Node(data);
        if(top == null)
        {
            top = node;
            root = node;
        }
        else
        {
            top.next = node;
            node.prev = top;
            top = node;
        }
    }

    //Removes a element from stack
    void pop()
    {
        // Null check is not made since it is guaranteed that pop is never called on a empty stack (constraint 4 from question)
        top = top.prev;
        if(top != null) {
            top.next = null;
        }
    }

    //Adds k to the e bottom elements
    void increment(int e , long k)
    {
        Node temp = root;
        while(e != 0 && temp != null)
        {
            temp.data = temp.data + k;
            temp = temp.next;
            e--;
        }
    }

    void print()
    {
        if(top == null)
        {
            System.out.println("EMPTY");
        }
        else {
            System.out.println(top.data);
        }
    }
}

public class SuperStack {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            // Get input for n and arr[n]
            int n = Integer.valueOf(input.nextLine());
            String[] arr = new String[n];

            Stack stack = new Stack();
            long data;

            // Based on the input push , pop and inc will be performed
            for(int i=0 ; i<n ; i++)
            {
                arr[i] = input.nextLine();
                String token[] = arr[i].split(" ");
                if(token[0].equalsIgnoreCase("push"))
                {
                    data = Long.parseLong(token[1]);
                    stack.push(data);
                }
                else if(token[0].equalsIgnoreCase("pop"))
                {
                    stack.pop();
                }
                else if(token[0].equalsIgnoreCase("inc"))
                {
                    int e = Integer.parseInt(token[1]);
                    long k = Long.parseLong(token[2]);

                    stack.increment(e,k);
                }

                stack.print();
            }



        }
        catch(Exception ex)
        {
            System.out.println("Invalid input is given");
            ex.printStackTrace();
        }


    }
}
