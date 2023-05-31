import java.util.Stack;

public class VerificarExpressaoMatematica {

    public static boolean verificarExpressao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty() || !verificarPar(pilha.peek(), caractere)) {
                    return false;
                }
                pilha.pop();
            }
        }

        return pilha.isEmpty();
    }

    private static boolean verificarPar(char caractereAberto, char caractereFechado) {
        return (caractereAberto == '(' && caractereFechado == ')')
                || (caractereAberto == '[' && caractereFechado == ']')
                || (caractereAberto == '{' && caractereFechado == '}');
    }

    public static void main(String[] args) {
        String expressao1 = "x+y*(3+z)";
        String expressao2 = "x+y*(3+";

        System.out.println(expressao1 + " está correta: " + verificarExpressao(expressao1));
        System.out.println(expressao2 + " está correta: " + verificarExpressao(expressao2));
    }
}
