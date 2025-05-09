import java.util.Stack;

public class Etapa3{

    public boolean checkBrackets(Stack<Character> s1){
        Stack<Character> pilhaParenteses = new Stack<>();

        while(!s1.isEmpty()){
            char caracter = s1.pop();
            if(caracter == '('){
                pilhaParenteses.push(caracter);
            }
            else if(caracter == ')'){
                if(pilhaParenteses.isEmpty()){
                    return false;
                }
                pilhaParenteses.pop();
            }
        }
        return pilhaParenteses.isEmpty();
    }
}