import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class KellerautomatUPN {
    private static final Character PLUS = '+';
    private static final Character MINUS = '-';
    private static final Character DIVIDE = '/';
    private static final Character MULTIPLY = '*';
    private static final ArrayList<Character> operations = new ArrayList<>();

    static {
        operations.add(PLUS);
        operations.add(MINUS);
        operations.add(DIVIDE);
        operations.add(MULTIPLY);
    }

    public static void main(String[] args) {
        System.out.println("Bitte geben Sie ein gültige Operation in der UDP-Form ein: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        try{
             System.out.println("Das Resultat ist " + getResult(word));
        }
        catch (IOException e){
            System.out.println("Das Wort wurde nicht akzeptiert");
        }

    }

    public static int getResult(String word) throws IOException {
        ArrayList<Integer> visitedPositions = new ArrayList<>();
        MyStack<StackElement> stack = new MyStack<>(StackElement.class);
        ArrayList<Character> wordToCheck = new ArrayList<>();
        char[] symbols = word.trim().toCharArray();
        for(int i = 0; i < symbols.length; i++){
            String symbol = "" + symbols[i];
            wordToCheck.add(symbol.charAt(0));
        }
        if(Character.isDigit(wordToCheck.get(0))&&wordToCheck.size()==1){
            return Character.getNumericValue(wordToCheck.get(0));
        }
        for(int i=0; i < wordToCheck.size(); i++){
            if(Character.isDigit(wordToCheck.get(i))){
                stack.push(new StackElement(Character.getNumericValue(wordToCheck.get(i))));
            }
            else if(operations.contains(wordToCheck.get(i))&&null!=stack.peek()){
                Character operation = wordToCheck.get(i);
                int a = 0;
                int b = 0;
                a = stack.pop().getValue();

                    if(null!=stack.peek()){
                        b = stack.pop().getValue();
                        StackElement res = new StackElement(calculate(a,b,operation));
                        visitedPositions.add(res.getId());
                        stack.push(res);
                    }
                    else {throw  new IOException("Ungültiges Wort");}

            }
            stack.printStack();
            System.out.println("------------------------------");
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }

        }

        if (stack.length()==1){
            return stack.pop().getValue();
        }
        else {throw new IOException("Ungültiges Wort");}
    }

    private static int calculate(int a, int b, Character operation){
        int result = 0;
        switch (operation){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '/':
                result = a / b;
                break;
            case '*':
                result = a * b;
                break;
        }
        return result;
    }
}
