import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KellerautomatDO {

    public  static void main(String[] args) {
        System.out.println("Bitte geben Sie ein gültiges Wort ein: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        if(checkWord(word)){
            System.out.println("Das Wort wurde akzeptiert");
        }
        else {
            System.out.println("Das Wort wurde nicht akzeptiert");
        }
    }

    public static boolean checkWord(String word){
        //Initialize Stack with first symbol
        MyStack<Character> stack = new MyStack<>(Character.class);
        stack.push('$');
        ArrayList<Character> wordToCheck = new ArrayList<>();
        char[] symbols = word.trim().toCharArray();
        for(int i = 0; i < symbols.length; i++){
            String symbol = "" + symbols[i];
            wordToCheck.add(symbol.charAt(0));
        }
        wordToCheck.add('E');
        /*Check the case if only one D was type in then
        return true, else remove the first 'D' of the list
         */
        if(wordToCheck.get(0).equals('D')&&wordToCheck.size()==2){
            return true;
        }

        else if(wordToCheck.get(0).equals('D')&&wordToCheck.size()>2){
            wordToCheck.remove(0);
        }
        //loop as long as you get input
        for(int i=0; i < wordToCheck.size(); i++){
            if(wordToCheck.get(i).equals('D')){
                stack.push('D');
            }
           else if(wordToCheck.get(i).equals('O')&&null!=stack.peek()){
                if(stack.peek()=='D'){
                    stack.pop();
                }
                else if(stack.peek()=='$'){
                    return false;
                }
            }
            else if(wordToCheck.get(i).equals('E')&&null!=stack.peek()&&stack.peek()=='$')
            {
                stack.pop();
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

        //If stack is empty return true
        if (stack.empty()){
            return true;
        }
        else {return false;}
    }
}