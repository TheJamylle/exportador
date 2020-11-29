/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jamylle
 */
public class Principal {

    public static void main(String[] args) {
        final List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("TV", "LG", "132-A", 120));
        produtos.add(new Produto("Notebook", "Asus", "New age", 341));
        produtos.add(new Produto("Smartphone", "Samsung", "Galaxy S10", 214));

        ExportadorListaProduto exportadorHtml = ExportadorListaProduto.newInstance();
        exportadorHtml.addNewColuna(Principal::desconto, "Preço com Desconto");

        System.out.println("HTML\n");
        System.out.println(exportadorHtml.exportar(produtos));

        ExportadorListaProduto exportadorMarkdown = ExportadorListaProduto.newInstance("md");
        exportadorMarkdown.addNewColuna(Principal::desconto, "Preço com Desconto");
        System.out.println("Markdown\n");
        System.out.println(exportadorMarkdown.exportar(produtos));
    }
    
    
    private static double desconto(Produto produto){
        return produto.getPreco() * 0.7;
    }
    
}
