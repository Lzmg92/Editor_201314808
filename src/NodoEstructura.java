import java.util.LinkedList;

/**
 * Created by lezs on 8/03/15.
 */
public class NodoEstructura {
    String edireccion;
    LinkedList<NodoCarpeta> ecarpetas;
    LinkedList<NodoDocumento> edocumentos;

    public NodoEstructura(String edireccion, LinkedList<NodoCarpeta> ecarpetas, LinkedList<NodoDocumento> edocumentos){
        this.edireccion = edireccion;
        this.ecarpetas = ecarpetas;
        this.edocumentos = edocumentos;
    }

    public String getEdireccion() {
        return edireccion;
    }

    public void setEdireccion(String edireccion) {
        this.edireccion = edireccion;
    }

    public LinkedList<NodoCarpeta> getEcarpetas() {
        return ecarpetas;
    }

    public void setEcarpetas(LinkedList<NodoCarpeta> ecarpetas) {
        this.ecarpetas = ecarpetas;
    }

    public LinkedList<NodoDocumento> getEdocumentos() {
        return edocumentos;
    }

    public void setEdocumentos(LinkedList<NodoDocumento> edocumentos) {
        this.edocumentos = edocumentos;
    }
}
