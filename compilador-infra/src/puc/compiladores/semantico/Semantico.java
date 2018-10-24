package puc.compiladores.semantico;

public class Semantico {

    TabelaSimbolos tabelaSimbolos;

    public Semantico() {
        tabelaSimbolos = new TabelaSimbolos();
    }

    /**
     * Pesquisa declaracao de variavel na tabela de simbolos
     *
     * @return
     * true se variavel for encontrada na tabela de simbolos
     * false se nao for encontrada
     */
    public boolean pesquisaDeclaracaoVariavelTabelaSimbolos(final String lexema) {
        return tabelaSimbolos.existeVariavel(lexema);
    }

    /**
     * Pesquisa declaracao de funcao na tabela de simbolos
     *
     * @return
     * true se funcao for encontrada na tabela de simbolos
     * false se nao for encontrada
     */
    public boolean pesquisaDeclaracaoFuncaoTabelaSimbolos(final String lexema) {
        return tabelaSimbolos.existeFuncao(lexema);
    }

    /**
     * Pesquisa declaracao de procedimento na tabela de simbolos
     *
     * @return
     * true se procedimento for encontrado na tabela de simbolos
     * false se nao for encontrado
     */
    public boolean pesquisaDeclaracaoProcedimentoTabelaSimbolos(final String lexema) {
        return tabelaSimbolos.existeProcedimento(lexema);
    }

    /**
     * Pesquisa duplicidade de variavel na tabela de simbolos
     *
     * @return
     * true se houver duplicidade
     * false se nao houver duplicidade
     */
    public boolean pesquisaDuplicidadeVariavel(final String lexema) {
        return tabelaSimbolos.existeVariavel(lexema);
    }

    /**
     * Insere na tabela de simbolos
     *
     * @param simbolo
     */
    public void insereTabelaSimbolos(Simbolo simbolo) {
        tabelaSimbolos.add(simbolo);
        /*tabelaSimbolos.add(new SimboloVariavel("x", "sas", "", "booleano"));
        tabelaSimbolos.add(new SimboloVariavel("y", "sas", "", "inteiro"));
        tabelaSimbolos.add(new SimboloProcedimento("analisa1","",""));
        tabelaSimbolos.add(new SimboloProcedimento("analisa2","",""));
        tabelaSimbolos.add(new SimboloProcedimento("analisa3","",""));

        tabelaSimbolos.add(new SimboloVariavel("z", "sas", "", "inteiro"));
        tabelaSimbolos.add(new SimboloVariavel("a", "sas", "", "booleano"));
        tabelaSimbolos.add(new SimboloProcedimento("analisa1", "",""));*/
    }

    /**
     * TODO: apagar o método, uma vez que é apenas para debug
     * Imprime toda a tabela de simbolos
     */
    public void imprime() {
        tabelaSimbolos.imprime();
    }

    /**
     * Coloca tipo na tabela de simbolos
     *
     * @param lexema
     * @param tipo
     */
    public void colocaTipoTabela(final String lexema, final String tipo) {
        tabelaSimbolos.colocaTipo(lexema, tipo);
    }

}
