package exportador;

import java.util.function.Function;

/**
 *
 * @author Jamylle
 */
public class ExportadorListaProdutoHtml extends AbstractExportadorListaProduto{
    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>\n";
    }

    @Override
    public String abrirLinha() {
        return "  <tr>";
    }

    @Override
    public String fecharLinha() {
        return "</tr>\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "";
    }

    @Override
    public void addNewColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
        addColuna(new ColunaHtml(obtemValorColuna,titulo));
    }
}
