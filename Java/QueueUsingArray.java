class Queue
{
    static int SIZE=10;
    static int front=-1;
    static int rear=-1;
    static int queArr[]=new int[SIZE];

    public void enqueue(int d)
    {
        if(rear==SIZE)
        {
            System.out.println("Overflow");
        }
        if(rear==-1 && front==-1)
        {
            front++;
            rear++;
            queArr[rear]=d;
        }
        else
        {
            rear++;
            queArr[rear]=d;
        }
        System.out.println(queArr[rear] + " enqueued to queue");
    }

    public int dequeue()
    {
        if(rear==-1)
        {
            System.out.println("Underflow");
            return -1;
        }
        else if(front==rear)
        {
            front=-1;
            rear=-1;
            System.out.println("Queue is emptied");
            return -1;
        }
        else
        {
            int item;
            item= queArr[front];
            front++;
            System.out.println(item + " dequeued from queue");
            return -1;
        }
    }

}

class Main
{
    public static void main(String args[])
    {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
    }
}