package puc.compiladores.posfixa;

import java.util.ArrayList;

public class Posfixa {

    private ArrayList<String> arrayInfixa;
    private ArrayList<String> arrayPosfixa;
    private ArrayList<String> arrayAux;

    public Posfixa() {
        arrayInfixa = new ArrayList<>();
        arrayAux = new ArrayList<>();
        arrayPosfixa = new ArrayList<>();
    }

    public ArrayList<String> trataPofixa(ArrayList<String> arrayExpressao) {
        arrayInfixa = arrayExpressao;
        trataPilha();
        return arrayPosfixa;
    }

    private ArrayList<String> trataPilha() {

        for (String elemento: arrayInfixa) {
            if(elemento.equals("*") || elemento.equals("div") ||
                    elemento.equals("+") || elemento.equals("-") ||
                    elemento.equals(">") || elemento.equals("<") ||
                    elemento.equals(">=") || elemento.equals("<=") ||
                    elemento.equals("=") || elemento.equals("!=") ||
                    elemento.equals("e") || elemento.equals("ou") ||
                    elemento.equals("+u") || elemento.equals("-u") ||
                    elemento.equals("nao")) {
                trataElemento(elemento);
            } else if (elemento.equals("(")) {
                arrayAux.add(elemento);
            } else if (elemento.equals(")")) {
                removeParenteses();
            } else {
                arrayPosfixa.add(elemento);
            }
        }
        desempilhaResto();
        return arrayPosfixa;
    }

    private void desempilhaResto() {
        int i;
        for (i = arrayAux.size() - 1; i >= 0; i--) {
            arrayPosfixa.add(arrayAux.get(i));
            arrayAux.remove(i);
        }
    }

    private void removeParenteses() {
        int i;
        for (i = arrayAux.size() - 1; i >= 0; i--) {
            if(arrayAux.get(i).equals("(")) {
                arrayAux.remove(i);
                break;
            } else {
                arrayPosfixa.add(arrayAux.get(i));
                arrayAux.remove(i);
            }
        }
    }

    private void trataElemento(String expressao) {
        for (String elemento: arrayAux) {
            if(elemento.equals("(")){
                break;
            } else if(pegaPrioridade(elemento) >= pegaPrioridade(expressao)) {
                desempilha(expressao);
                break;
            }
        }
        arrayAux.add(expressao);
    }

    private void desempilha(String expressao) {
        int i;
        for (i = arrayAux.size() - 1; i >= 0; i--) {
            if(arrayAux.get(i).equals("(")) {
                break;
            }else if(pegaPrioridade(arrayAux.get(i)) >= pegaPrioridade(expressao)) {
                arrayPosfixa.add(arrayAux.get(i));
                arrayAux.remove(i);
            }
        }
    }

    private int pegaPrioridade(String elemento){
        if(elemento.equals("+u") || elemento.equals("-u") ||
            elemento.equals("nao")){
            return 6;
        } else if(elemento.equals("*") || elemento.equals("div")) {
            return 5;
        } else if (elemento.equals("+") || elemento.equals("-")) {
            return 4;
        } else if (elemento.equals(">") || elemento.equals("<") ||
                elemento.equals(">=") || elemento.equals("<=") ||
                elemento.equals("=") || elemento.equals("!")) {
            return 3;
        } else if (elemento.equals("e")) {
            return 2;
        } else if (elemento.equals("ou")) {
            return 1;
        }
        return 0;
    }
}
