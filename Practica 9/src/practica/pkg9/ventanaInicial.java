/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg9;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Bautista
 */
public final class ventanaInicial extends javax.swing.JFrame {

    ArrayList<String> txtIdiomas=new ArrayList<String>();//array con el txt idiomas
    ArrayList<Disco> datos=new ArrayList<Disco>();//array con los datos
    String idioma;//string para guardar el idioma seleccionado en el combobox
    int indiceIdioma;//variable para guardar la posicion del idioma en el txt
    int nIdiomas;
    
    //////////CONSTRUCTORES/////////////////
    public ventanaInicial(String _idioma) throws IOException {
        
        setResizable(false);//para que la pantalla no se pueda redimensionar
        setTitle("Albums Collector");
        idioma=_idioma;
        leerFichero();
        initComponents();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "English" ,"Français","Deutsche"}));
        if(idioma=="en"){
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English" ,"Español", "Français","Deutsche"}));
        }else if(idioma=="fr"){
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Français","English" ,"Español","Deutsche"}));
        }else if(idioma=="de"){
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Deutsche","Français","English" ,"Español"}));
        }
        
        traducir();
        mostrarDatos();
        setVisible(true);
    }
    
    public ventanaInicial(ArrayList<Disco> _datos,String _idioma) throws IOException {
        setResizable(false);//para que la pantalla no se pueda redimensionar
        setTitle("Album Collector");
        idioma=_idioma;
        datos=_datos;
        leerFichero();
        initComponents();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "English" ,"Français","Deutsche"}));
        if(idioma=="en"){
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English" ,"Español", "Français","Deutsche"}));
        }else if(idioma=="fr"){
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Français","English" ,"Español","Deutsche"}));
        }else if(idioma=="de"){
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Deutsche","Français","English" ,"Español"}));
        }
        
        traducir();
        mostrarDatos();
       
    }
    /////////////////FUNCIONES////////////////////
    public void traducir(){//método para asignar el texto e imagen en fucnión del idioma
        for(int i=0;i<txtIdiomas.size();i++){
            if(idioma.equals(txtIdiomas.get(i))){//cuando encontramos el idioma en el txt asignamos los botones
                indiceIdioma=i;
                int nBotones = Integer.parseInt(txtIdiomas.get(i+1));
                int nImagenes = Integer.parseInt(txtIdiomas.get(i+nBotones+2));
                System.out.println(nBotones);
                System.out.println(nImagenes);
                jButton1.setText(txtIdiomas.get(i+2));
                jButton2.setText(txtIdiomas.get(i+3));
                jButton4.setText(txtIdiomas.get(i+6));
                jButton5.setText(txtIdiomas.get(i+7));
                jButton6.setText(txtIdiomas.get(i+8));
                //jLabel3.setText(txtIdiomas.get(i+17));
                ImageIcon imgicon = new ImageIcon(txtIdiomas.get(i+nBotones+3));//imagen idioma
                jLabel1.setIcon(imgicon); 
                ImageIcon imgicon2 = new ImageIcon(txtIdiomas.get(i+nBotones+4));//imagen idioma
                jLabel2.setIcon(imgicon2);
            }
          
        }
    }
    
    public void leerFichero() throws IOException{
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
                archivo = new File ("idiomas.txt");
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
                String linea;
                
                while((linea=br.readLine())!=null){
                    txtIdiomas.add(linea);
                }
               
        }catch (FileNotFoundException e ){
            System.out.println("Archivo no encontrado");
        
      }
    }
    
    
    public void guardarEnTxt(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        
            try
            {
                fichero = new FileWriter("discos.txt");
                pw = new PrintWriter(fichero);

                for (int i = 0; i < datos.size(); i++){
                    pw.println(datos.get(i).nombre+";"+datos.get(i).autor+";"+datos.get(i).año);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != pw ){   
               pw.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }
    
    public void leerDeTxt() throws IOException{
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        datos.clear();
        try{
                archivo = new File ("discos.txt");
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
                String linea;
                
                while((linea=br.readLine())!=null){
                    String[] partes = linea.split(";");
                    Disco d=new Disco(partes[0],partes[1],partes[2]); 
                    datos.add(d);
                }
               
        }catch (FileNotFoundException e ){
            System.out.println("Archivo no encontrado");
        
        }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (IOException e2){ 
         }
      }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setAlignmentX(0.5F);

        jButton4.setText("jButton4");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton4)
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(83, 83, 83)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGap(78, 78, 78)
                        .addComponent(jButton5)
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 743, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(136, 136, 136))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(142, 142, 142))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton6)
                            .addComponent(jButton2))
                        .addGap(47, 47, 47)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void mostrarDatos(){
       jTextArea1.setText("");//vaciamos text area
            for(int i=0;i<datos.size();i++){
                
                jTextArea1.append("ID: ");
                jTextArea1.append(Integer.toString(i));
                jTextArea1.append("  ");
                jTextArea1.append(datos.get(i).nombre);
                jTextArea1.append("  -");
                jTextArea1.append(datos.get(i).autor);
                jTextArea1.append("-   -");
                jTextArea1.append(datos.get(i).año);
                jTextArea1.append("-");
                jTextArea1.append("\n");
            
            }
    }
    
  ////////////////////////BOTONES/////////////////////////////////
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ventanaAñadir v =new ventanaAñadir(datos,txtIdiomas,idioma);
        v.setTitle(txtIdiomas.get(indiceIdioma+2));
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      ventanaBorrar v =new ventanaBorrar(datos,txtIdiomas,idioma);
        v.setTitle(txtIdiomas.get(indiceIdioma+3));
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String select;
        select=jComboBox1.getSelectedItem().toString();
        switch (select){
            case "Español":
                idioma="es";
                break;
            case "English":
                idioma="en";
                break;
            case "Français":
                idioma="fr";
                break;
            case "Deutsche":
                idioma="de";
                break;
        }
        traducir();
        mostrarDatos();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         ventanaEditar v =new ventanaEditar(datos,txtIdiomas,idioma);
        v.setTitle(txtIdiomas.get(indiceIdioma+8));
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        if(datos.size()!=0){
            guardarEnTxt();
        
        JOptionPane.showOptionDialog(null, txtIdiomas.get(indiceIdioma+14)+" discos.txt ", //contenido de la ventana
                         txtIdiomas.get(indiceIdioma+22) , //titulo de la ventana
                         JOptionPane.YES_OPTION, 
                         JOptionPane.INFORMATION_MESSAGE, //tipo de ícono
                         null,    // null para icono por defecto.
                         new Object[] { txtIdiomas.get(indiceIdioma+16) },
                         null); //selección predeterminada
        
        }else{
             JOptionPane.showOptionDialog(null, txtIdiomas.get(indiceIdioma+15), //contenido de la ventana
                         txtIdiomas.get(indiceIdioma+23) , //titulo de la ventana
                         JOptionPane.YES_OPTION, 
                         JOptionPane.ERROR_MESSAGE, //tipo de ícono
                         null,    // null para icono por defecto.
                         new Object[] { txtIdiomas.get(indiceIdioma+16) },
                         null); //selección predeterminada
        
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         JOptionPane.showOptionDialog(null, txtIdiomas.get(indiceIdioma+13)+" discos.txt ", //contenido de la ventana
                         txtIdiomas.get(indiceIdioma+22) , //titulo de la ventana
                         JOptionPane.YES_OPTION, 
                         JOptionPane.INFORMATION_MESSAGE, //tipo de ícono
                         null,    // null para icono por defecto.
                         new Object[] { txtIdiomas.get(indiceIdioma+16) },
                         null); //selección predeterminada
        try {
            System.out.println("tamaño"+datos.size());
            leerDeTxt();
            mostrarDatos();
        } catch (IOException ex) {
            Logger.getLogger(ventanaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    public  void main(String args[]){
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

