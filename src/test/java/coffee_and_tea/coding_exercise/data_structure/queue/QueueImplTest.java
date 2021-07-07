package coffee_and_tea.coding_exercise.data_structure.queue;

import org.junit.jupiter.api.Test;

class QueueImplTest {

    @Test
    public void QueueLinkedListImplTest() {

        Queue<String> queue = new QueueImplWithLinkedList<String>();

        queue.enqueue("Hello");
        queue.enqueue("Wei");

        for(String item : queue){
            System.out.println(item);
            System.out.println("\\");
        }

        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
            System.out.println("/");
        }
    }

    @Test
    public void QueueArrayImplTest() {

        Queue<String> queue = new QueueImplWithArray<>();

        queue.enqueue("Hello");
        queue.enqueue("Wei");

        for(int i = 'A'; i <= 'Z'; i++) {
            queue.enqueue(String.valueOf(i));
        }

        for(String item : queue){
            System.out.println(item);
            System.out.println("\\");
        }

        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
            System.out.println("/");
        }
    }
}