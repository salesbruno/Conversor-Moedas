public class ConversorMoeda {
    private ObterCambio obterCambio;

    public ConversorMoeda(ObterCambio obterCambio) {
        this.obterCambio = obterCambio;
    }

    public double converter(String de, String para, double valor) {
        double taxa = obterCambio.pegacambio(de, para);
        if (taxa == -1) return -1;
        return valor * taxa;
    }
}