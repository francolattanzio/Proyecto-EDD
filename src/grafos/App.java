/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class App {

    LinkedList<String> nombresUsuarios = new LinkedList<String>();
    LinkedList<String> conexionesUsuarios = new LinkedList<String>();

    public String abrirArchivo() throws Exception {
        String aux="";   
        String texto = "";
        GrafoMatriz MatrizP = new GrafoMatriz();

        try{
            JFileChooser file=new JFileChooser();
            file.showOpenDialog(null);
            File abre=file.getSelectedFile();
            if(abre!=null){     
                FileReader archivos=new FileReader(abre);
                BufferedReader lee=new BufferedReader(archivos);
                while((aux=lee.readLine())!=null){
                    if(aux.contains("@") && aux.contains(",")){
                        String[] auxSeparado = aux.split(", ");
                        String User1 = auxSeparado[0];
                        String User2 = auxSeparado[1];
                        MatrizP.nuevoArco(User1, User2);
                        conexionesUsuarios.addLast(User1 + ", " + User2);
                    }
                    else if(aux.contains("@")|| aux.contains(",")){
                        MatrizP.nuevoVertice(aux);
                        nombresUsuarios.addLast(aux);
                    }
                    texto+= aux+ "\n";
                }
            nombresUsuarios.print();
            conexionesUsuarios.print();
            lee.close();
            }    
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null,ex+"" + "\nNo se ha encontrado el archivo", "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }
        return texto;//El texto se almacena en el JTextArea
    }
    
    private void guardarArchivo() {
        try{
            String nombre="";
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(null);
            File guarda =file.getSelectedFile();
            if(guarda !=null) {
   /*guardamos el archivo y le damos el formato directamente,
    * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter  save=new FileWriter(guarda+".txt");

                save.write("usuarios");
                for (int i = 0; i < nombresUsuarios.size(); i++) {
                    save.append(nombresUsuarios);
                }
                save.close();
                JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente", "Información",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }



    
    
    
    
    
    
    
    
    

    

}