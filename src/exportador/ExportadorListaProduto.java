package exportador;

import java.util.List;
import java.util.function.Function;

/**
 *
 * @author Jamylle
 */
public interface ExportadorListaProduto {
    void addNewColuna(Function<Produto,Object> obtemValorColuna, String titulo);
    
    String abrirTabela();
    String fecharTabela();
    String abrirLinha();
    String fecharLinha();
    String fecharLinhaTitulos();
    String exportar(List<Produto> produtos);

    static ExportadorListaProduto newInstance(){
        return newInstance("html");
    }

    static ExportadorListaProduto newInstance(String extensaoArquivoExportacao){
        switch (extensaoArquivoExportacao){
            case "html": return (ExportadorListaProduto) new ExportadorListaProdutoHtml();
            case "md": return (ExportadorListaProduto) new ExportadorListaProdutoMarkdown();
            default: throw new UnsupportedOperationException("Formato de arquivo não suportado: " + extensaoArquivoExportacao);
        }
    }
}
