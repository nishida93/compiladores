package conversor;

import java.util.ArrayList;
import java.util.List;

public class Conversor {

    List<String> pilhaInFixa = new ArrayList();
    List<String> pilhaPosFixa = new ArrayList();
    List<String> pilhaAux = new ArrayList();

    public Conversor() {
        setup();

        trataPilha();

        System.out.println("pilha = " + pilhaInFixa);
        System.out.println("pilha Pos = " + pilhaPosFixa);
    }

    private List<String> trataPilha() {
        String auxElemento = "";
        int aux = 0;
        for (String elemento: pilhaInFixa) {
            if(elemento.equals("+") || elemento.equals("-") ||
                elemento.equals("*") || elemento.equals("div") ||
                elemento.equals(">") || elemento.equals("<") ||
                elemento.equals(">=") || elemento.equals("<=") ||
                elemento.equals("=") || elemento.equals("!") ||
                elemento.equals("e") || elemento.equals("ou")) {
                auxElemento = elemento;
                trataElemento(elemento);
            } else if(elemento.equals(")")){
                auxElemento = elemento;
                desempilhaParenteses();
            } else if(elemento.equals("+u") ||
                    elemento.equals("-u") || elemento.equals("nao")) {
                auxElemento = elemento;
            } else {
                pilhaPosFixa.add(elemento);
                if(auxElemento.equals("+u") ||
                        auxElemento.equals("-u") || auxElemento.equals("nao")){
                    pilhaPosFixa.add(auxElemento);
                }
            }
            aux++;
        }
        desempilha(0);

        return pilhaPosFixa;
    }

    private void desempilhaParenteses() {
        int i;
        for (i = pilhaAux.size(); i > 0; i--) {
            pilhaPosFixa.add(pilhaAux.get(i - 1));
            if(pilhaPosFixa.get(i - 1).equals("(")){
                pilhaAux.remove(i - 1);
                pilhaPosFixa.remove(i - 1);
                break;
            }
            pilhaAux.remove(i - 1);
        }
    }

    private void desempilha(int parada) {
        int i;
        for (i = pilhaAux.size(); i > 0; i--) {
            pilhaPosFixa.add(pilhaAux.get(i - 1));
            if(prioridade(pilhaAux.get(i - 1)) == parada){
                pilhaAux.remove(i - 1);
                break;
            }
            pilhaAux.remove(i - 1);
        }
    }
    private void trataElemento(String elemento) {
        if(elemento.equals("+") || elemento.equals("-")){
            verificaPilha(elemento, 4);
        } else if(elemento.equals("*") || elemento.equals("div")) {
            verificaPilha(elemento, 5);

        } else if(elemento.equals(">") || elemento.equals("<") ||
                elemento.equals(">=") || elemento.equals("<=") ||
                elemento.equals("=") || elemento.equals("!")) {
            verificaPilha(elemento, 3);

        } else if(elemento.equals("e")) {
            verificaPilha(elemento, 2);

        } else if(elemento.equals("ou")){
            verificaPilha(elemento, 1);

        }
    }

    private void verificaPilha(String elemento, int prioridadeElemento) {
        int aux = 0;
        boolean flag = true;
        if(pilhaAux.size() != 0) {
            for (String expressao: pilhaAux) {
                int prioridadeAux = prioridade(expressao);
                if(prioridadeAux >= prioridadeElemento) {
                    desempilha(prioridadeElemento);
                    pilhaAux.add(elemento);
                    flag = false;
                }
                aux++;
            }
        } else {
            pilhaAux.add(elemento);
            flag = false;
        }

        if(flag) {
            pilhaAux.add(elemento);
        }
    }

    private int prioridade(String expressao) {
        if(expressao.equals("+") || expressao.equals("-")){
            return 4;
        } else if(expressao.equals("*") || expressao.equals("div")) {
            return 5;
        } else if(expressao.equals(">") || expressao.equals("<") ||
                expressao.equals(">=") || expressao.equals("<=") ||
                expressao.equals("=") || expressao.equals("!")) {
            return 3;
        } else if(expressao.equals("e")) {
            return 2;
        } else if(expressao.equals("ou")){
            return 1;
        }
        return 0;
    }

    private List<String> setup() {

        pilhaInFixa.add("(");
        pilhaInFixa.add("(");
        pilhaInFixa.add("-u");
        pilhaInFixa.add("a");
        pilhaInFixa.add("+");
        pilhaInFixa.add("b");
        pilhaInFixa.add(")");
        pilhaInFixa.add("-");
        pilhaInFixa.add("45");
        pilhaInFixa.add(")");
        pilhaInFixa.add("*");
        pilhaInFixa.add("c");
        pilhaInFixa.add("*");
        pilhaInFixa.add("10");

        return pilhaInFixa;
    }
}
