/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportador;

import java.util.function.Function;

/**
 *
 * @author Jamylle
 */
public abstract class AbstractColuna implements Coluna {
    private String titulo;
    private Function<Produto, Object> obtemValorColuna;

    public AbstractColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
        this.titulo = titulo;
        this.obtemValorColuna = obtemValorColuna;
    }    
    
    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String exportarCabecalho() {
        return abrir() + titulo + fechar();
    }

    @Override
    public String exportarDado(Produto produto) {
        Object retorno = obtemValorColuna.apply(produto);
        return abrir() + retorno.toString() + fechar();
    }
    
}
