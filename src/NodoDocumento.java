

/**
 * Created by lezs on 8/03/15.
 */
public class NodoDocumento {
    String dformato;
    String dcontenido;
    String dnombre;

    public NodoDocumento(String dnombre, String dformato, String dcontenido){
        this.dnombre = dnombre;
        this.dformato = dformato;
        this.dcontenido = dcontenido;
    }

    public String getdformato() {
        return dformato;
    }

    public String getdcontenido() {
        return dcontenido;
    }

    public String getdnombre() {
        return dnombre;
    }

    public void setdformato(String dformato) {
        this.dformato = dformato;
    }

    public void setdcontenido(String dcontenido) {
        this.dcontenido = dcontenido;
    }

    public void setdnombre(String dnombre) {
        this.dnombre = dnombre;
    }
}
