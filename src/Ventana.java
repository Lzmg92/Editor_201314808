import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by lezs on 4/03/15.
 */
public class Ventana extends JFrame{

    String nombre;
    String ruta;

    JFrame ven = new JFrame("Editor de Texto");
    JMenuBar barra = new JMenuBar();
    JMenu archivo = new JMenu("Archivo");
    JMenuItem optabrir = new JMenuItem("Abrir");
    JMenuItem optnuevo = new JMenuItem("Nuevo");
    JMenuItem optguardar = new JMenuItem("Guardar");

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
        archivo.add(optabrir);
        archivo.add(optguardar);
        archivo.add(optnuevo);

       //
        texto.setBounds(0,0, ven.getWidth(), ven.getHeight());
        texto.setBackground(Color.black);
        texto.setForeground(Color.white);
        texto.setMargin(new Insets(10, 20, 30, 40));
        texto.setFont(new Font("Arial Rounded", Font.PLAIN, 15));
        texto.setEditable(false);

        ven.setVisible(true);

        optabrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fc.showSaveDialog(fc);
                int rest = fc.APPROVE_OPTION;
                if(rest==JFileChooser.APPROVE_OPTION)
                {
                    File o=fc.getSelectedFile();
                    String b = o.toString();
                    texto.setText(leer(b));
                    ruta = o.getParent();
                }
                texto.setEditable(true);
            }
        });

        optguardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nombre = JOptionPane.showInputDialog("Ingrese El Nombre Con El Que Desea Guardar");
                escribir(nombre, ruta, texto.getText());

            }
        });

        optnuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nombre = JOptionPane.showInputDialog("Ingrese El Nombre Con El Que Desea Guardar");
                fc.showSaveDialog(fc);
                int rest = fc.APPROVE_OPTION;
                if(rest==JFileChooser.APPROVE_OPTION)
                {
                    File o=fc.getSelectedFile();
                    ruta = o.getParent();
                }
                escribir(nombre, ruta, " ");
            }
        });
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
