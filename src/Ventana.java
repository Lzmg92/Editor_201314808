import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;

/**
 * Created by lezs on 4/03/15.
 */
public class Ventana extends JFrame{

    Main m = new Main();

    String nombre = "";
    String ruta;

    JFrame ven = new JFrame("Editor de Texto");
    JMenuBar barra = new JMenuBar();
    JMenu archivo = new JMenu("Archivo");
    JMenu analizar = new JMenu("Analizar");

    JMenuItem optabrir = new JMenuItem("Abrir");
    JMenuItem optnuevo = new JMenuItem("Nuevo");
    JMenuItem optguardar = new JMenuItem("Guardar");

    JMenuItem correr = new JMenuItem("Run");

    JTextArea texto = new JTextArea();


    JFileChooser fc = new JFileChooser();

    public Ventana() {
        ven.setSize(700, 600);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ven.setLayout(null);

        ven.setJMenuBar(barra);
        ven.add(texto);
        barra.add(archivo);
        barra.add(analizar);

        archivo.add(optabrir);
        archivo.add(optguardar);
        archivo.add(optnuevo);

        analizar.add(correr);

       //
        texto.setBounds(0, 0, ven.getWidth(), ven.getHeight());
        texto.setBackground(Color.black);
        texto.setForeground(Color.white);
        texto.setMargin(new Insets(10, 20, 30, 40));
        texto.setFont(new Font("Arial Rounded", Font.PLAIN, 15));
        texto.setEditable(false);

        ven.setVisible(true);

        optabrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fc.showSaveDialog(fc);
                    int rest = fc.APPROVE_OPTION;
                    if (rest == JFileChooser.APPROVE_OPTION) {
                        File o = fc.getSelectedFile();
                        String b = o.toString();
                        String nombre2 = o.getName();
                        char[] nuevo = nombre2.toCharArray();
                        for (int i = 0; i < (nuevo.length - 4); i++) {
                            nombre = nombre + nuevo[i];
                        }
                        texto.setText(leer(b));
                        ruta = o.getParent();
                    }
                    texto.setEditable(true);
                } catch (Exception m){}
            }
        });

        optguardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               try{
                   escribir(nombre, ruta, texto.getText());
                   JOptionPane.showMessageDialog(ven, "Los cambios han sido guardados");

               }catch (Exception l){

                   JOptionPane.showMessageDialog(ven,
                           "Error al guardar",
                           "Inane error",
                           JOptionPane.ERROR_MESSAGE);

               }


            }
        });

        optnuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                nombre = JOptionPane.showInputDialog("Ingrese el nombre con el \nque desea guardar el archivo");
                fc.showSaveDialog(fc);
                int rest = fc.APPROVE_OPTION;
                if(rest==JFileChooser.APPROVE_OPTION)
                {
                    File o=fc.getSelectedFile();
                    ruta = o.getParent();
                }
                escribir(nombre, ruta, " ");
                texto.setEditable(true); }
                catch (Exception f){
                    JOptionPane.showMessageDialog(ven,
                            "Error al guardar",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        correr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = 0;
                int b = 0;
                int  b1 = 0;
                try {
                    System.out.println("entro");
                    System.out.println("--------------------------------");
                    new AnalizadorSin(new AnalizadorLex(new FileInputStream("ejemplo.cyd"))).parse();

                } catch (FileNotFoundException e1) {
                    System.out.println("no entro no encontrado");
                    e1.printStackTrace();
                } catch (Exception e1) {
                    System.out.println("no entro no se x q");
                    e1.printStackTrace();
                }

                for(int i = 0; i< m.EstructuraTotal.size(); i++){
                    System.out.println(m.EstructuraTotal.get(i).edireccion);
                    a=0;
                    b=0;

                    while (a < m.EstructuraTotal.get(i).getEcarpetas().size()){
                        System.out.println(m.EstructuraTotal.get(i).getEcarpetas().get(a).cnombre);
                        a++;
                    }

                    while (b < m.EstructuraTotal.get(i).getEdocumentos().size()){
                        System.out.println(m.EstructuraTotal.get(i).getEdocumentos().get(b).dnombre);
                        System.out.println(m.EstructuraTotal.get(i).getEdocumentos().get(b).dformato);
                        System.out.println(m.EstructuraTotal.get(i).getEdocumentos().get(b).dcontenido);
                        b++;

                    }
                }

            }
        });



     //   m.EstructuraTotal.set(n, new NodoEstructura(pal, new LinkedList<NodoCarpeta>(), new LinkedList<NodoDocumento>()));

      /*  int n = 0;
         m.EstructuraTotal.get(0).getEcarpetas().get(0).getcarpetas().add(new NodoCarpeta(null, null, null));

        m.EstructuraTotal.get(n).setEcarpetas(new LinkedList<NodoCarpeta>());


        m.EstructuraTotal.add(new NodoEstructura(null, null, null));

        m.EstructuraTotal.get(0).setEcarpetas(new LinkedList<NodoCarpeta>());
        m.EstructuraTotal.get(0).setEdireccion("fsa");

        NodoDocumento docto = new NodoDocumento(null, null, null);

        m.EstructuraTotal.get(n).getEdocumentos().get(nc).setdcontenido("");


        m.EstructuraTotal.get(n).getEcarpetas().get(nc).setcarpetas(new LinkedList<NodoCarpeta>());

        m.EstructuraTotal.get(n).getEcarpetas().get(nc).getdocumentos.add(new LinkedList<NodoDocumento>()); */

    }










    //////////////////////////////////////////////////////// metodo para leer
    public String leer(String nombre){

        try{File f;
            FileReader lectorArchivo;

            f = new File(nombre);
            lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);

            String l="";
            String aux="";

            while(true)
            {   aux=br.readLine();
                if(aux!=null)  l=l+aux+"\n";
                else break;}

            br.close();
            lectorArchivo.close();
            return l;

        }catch(IOException e){
            System.out.println("Error:"+e.getMessage());}
        return null;}

    ////////////////////////////////////////////////////////////// metodo actualizar

    public void escribir(String nombreArchivo, String ruta, String contenido)
   	    {

   	File f;
   	f = new File(ruta+"/"+nombreArchivo+".cyd");

   	try{
   	 FileWriter w = new FileWriter(f);
   	 BufferedWriter bw = new BufferedWriter(w);
   	 PrintWriter wr = new PrintWriter(bw);
   	 wr.write(contenido);

   	 wr.close();
     bw.close();
     }catch(IOException e){};
    }



}
