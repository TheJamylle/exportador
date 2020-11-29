package exportador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jamylle
 */
public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto{
    private List<Coluna> colunas;

    protected List<Coluna> getColunas() {
        return colunas;
    }

    public AbstractExportadorListaProduto() {
        colunas = new ArrayList<>();
        addNewColuna(Produto::getId, "Codigo");
        addNewColuna(Produto::getDescricao, "Descricao");
        addNewColuna(Produto::getPreco, "Preço");
    }
    
            
    @Override
    public final String exportar(List<Produto> listaProdutos) {
        final StringBuilder builder = new StringBuilder();
        builder.append(abrirTabela());

        builder.append(abrirLinha());
        for (Coluna coluna: colunas ){
            builder.append(coluna.exportarCabecalho());
        }
        builder.append(fecharLinha());
        builder.append("\n");
        builder.append(fecharLinhaTitulos());
        gerarLinhasProdutos(builder, listaProdutos);

        builder.append(fecharTabela());
        return builder.toString();
    }

    private void gerarLinhasProdutos(StringBuilder builder, List<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            builder.append(gerarColunasLinha(produto));
        }
    }

    protected void addColuna(Coluna coluna) {
        colunas.add(coluna);
    }
    
    protected String gerarColunasLinha(Produto produto) {
        StringBuilder builder = new StringBuilder();
        builder.append(abrirLinha());
        for (Coluna coluna: colunas){
            builder.append(coluna.exportarDado(produto));
        }
        builder.append(fecharLinha());
        return builder.toString();
    }
}
