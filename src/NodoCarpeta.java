import java.util.LinkedList;

/**
 * Created by lezs on 8/03/15.
 */
public class NodoCarpeta {

    String cnombre;
    LinkedList <NodoDocumento>documentos;
    LinkedList <NodoCarpeta>carpetas;

    public NodoCarpeta(String cnombre, LinkedList<NodoDocumento> documentos, LinkedList<NodoCarpeta> carpetas){
        this.cnombre = cnombre;
        this.carpetas = carpetas;
        this.documentos = documentos;
    }

    public LinkedList<NodoDocumento> getdocumentos() {
        return documentos;
    }

    public void setdocumentos(LinkedList<NodoDocumento> documentos) {
        this.documentos = documentos;
    }

    public LinkedList<NodoCarpeta> getcarpetas() {
        return carpetas;
    }

    public void setcarpetas(LinkedList<NodoCarpeta> carpetas) {
        this.carpetas = carpetas;
    }

    public String getcnombre() {
        return cnombre;
    }

    public void setcnombre(String cnombre) {
        this.cnombre = cnombre;
    }
}
