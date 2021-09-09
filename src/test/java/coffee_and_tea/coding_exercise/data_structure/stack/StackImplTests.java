package coffee_and_tea.coding_exercise.data_structure.stack;

import org.junit.jupiter.api.Test;

class StackImplTests {

    @Test
    public void StackLinkedListImplTest() {

        Stack<String> stack = new StackImplWithLinkedList<>();

        stack.push("Hello");
        stack.push("Wei");

        for(String item : stack){
            System.out.println(item);
            System.out.println("\\");
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
            System.out.println("/");
        }
    }

    @Test
    public void QueueArrayImplTest() {

        Stack<String> stack = new StackImplWithArray<>();

        stack.push("Hello");
        stack.push("Wei");

        for(int i = 'A'; i <= 'Z'; i++) {
            stack.push(String.valueOf(i));
        }

        for(String item : stack){
            System.out.println(item);
            System.out.println("\\");
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
            System.out.println("/");
        }
    }

}