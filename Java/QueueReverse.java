// Reverse a given queue

import java.util.*;
class QueueArray
{
  int SIZE=10;
  int front=-1;
  int rear=-1;
  int array[]=new int[SIZE];

  // Method to add an item to the queue.
  void enqueue(int item)
  {
    if (rear == SIZE)   // Queue is full
      return;
    if(front == -1 && rear == -1){
      front++;
      rear++;
    }
    else
      rear++;
    array[rear] = item;
  }

  // Method to remove an item from queue.
  int dequeue()
  {
    if (front > rear)
    {
      return -1;
    }
    int item = array[front];
    front++;
    return item;
  }  
}

class Main
{

    static void reverseQueue(QueueArray q)
    {
      Stack<Integer> s = new Stack<Integer>();
      while(q.front<q.rear)
      {
        s.push(q.dequeue());
      }
      s.push(q.dequeue());
      
     while(s.size()>0)
        q.enqueue(s.pop());
    }



    public static void main(String[] args)
    {
      Scanner s=new Scanner(System.in);
      int t, n, q1, q2;
      t = s.nextInt();
      while(t>0)
      {
        QueueArray ob1=new QueueArray();
        n = s.nextInt();
        q2=n;
        while(n>0)
        {
          q1 = s.nextInt();
          ob1.enqueue(q1);
          n--;
        }
        reverseQueue(ob1);
        while(q2>0)
        {
          System.out.print(ob1.dequeue() + " ");
          q2--;
        }
        t--;
        System.out.println();
      }
     
    }
}