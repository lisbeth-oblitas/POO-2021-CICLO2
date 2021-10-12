package crudVector01;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;

public class crudFrame extends JFrame{
    MetodosSistema metodos=new MetodosSistema();
   JLabel lb_nombre=new JLabel("Nombres");
   JTextField txt_nombres=new JTextField();
   JLabel lb_apellido_paterno=new JLabel("A-paterno");
   JTextField txt_apellido_paterno=new JTextField();
   JLabel lb_apellido_materno=new JLabel("A-materno");
   JTextField txt_apellido_materno=new JTextField();
   JLabel lb_codigo=new JLabel("Codigo");
   JTextField txt_codigo=new JTextField();
 public crudFrame(){
     JMenuBar menuBar=new JMenuBar();
     
     JMenu menuFile=new JMenu();
     JMenu menuMantenimiento= new JMenu();
     JMenu menuReportes= new JMenu();
     
     JMenuItem menuFile_Exit=new JMenuItem();
     
     JMenuItem menuMantenimiento_Ingresar=new JMenuItem();
     JMenuItem menuMantenimiento_Eliminar=new JMenuItem();
     
     JMenuItem menuReportes_General=new JMenuItem();
     JMenuItem menuReportes_Detallado=new JMenuItem();
     
     menuFile.setText("File");
     menuFile_Exit.setText("Salir");
     
     menuMantenimiento.setText("Crud");
     menuMantenimiento_Ingresar.setText("Registrar");
     menuMantenimiento_Eliminar.setText("Eliminar");
     
     menuReportes.setText("Reportes");
     menuReportes_General.setText("Global");
     menuReportes_Detallado.setText("Detalle");
     
     menuFile.add(menuFile_Exit);
     
     menuMantenimiento.add(menuMantenimiento_Ingresar);
     menuMantenimiento.add(menuMantenimiento_Eliminar);
     
     
     menuReportes.add(menuReportes_General);
     menuReportes.add(menuReportes_Detallado);
     
     menuBar.add(menuFile);
     menuBar.add(menuMantenimiento);
     menuBar.add(menuReportes);
     setTitle("Practicando Crud con Vector");
     setJMenuBar(menuBar);
     setSize(new Dimension(700,700));
     
     menuFile_Exit.addActionListener(
             new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                     //CrudVectorFrame.this.windowsClosed();
                     System.exit(0);
                 }
             }
     );
     menuMantenimiento_Ingresar.addActionListener(
     new ActionListener(){
         public void actionPerformed(ActionEvent e){
             JPanel pan1=new JPanel(new GridLayout(1,2));
             pan1.add(lb_nombre);
             pan1.add(txt_nombres);
             
             JPanel pan2=new JPanel(new GridLayout(1,2));
             pan2.add(lb_apellido_paterno);
             pan2.add(txt_apellido_paterno);
             
             JPanel pan3=new JPanel(new GridLayout(1,2));
             pan3.add(lb_apellido_materno);
             pan3.add(txt_apellido_materno);
             
             JPanel pan4=new JPanel(new GridLayout(1,2));
             pan4.add(lb_codigo);
             pan4.add(txt_codigo);
             
             Object msg [][]={{pan1,pan2,pan3,pan4}};
             
              if(JOptionPane.showOptionDialog(null, msg, "Registrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){

                       DatosPersona dp=new DatosPersona();
                       dp.nombres=txt_nombres.getText();
                       dp.ap_paterno=txt_apellido_paterno.getText();
                       dp.ap_materno=txt_apellido_materno.getText();
                       dp.codigo=txt_codigo.getText();
                       System.out.println("insertando"+dp.nombres);
                       metodos.registrarPersona(dp);
                       
                       JOptionPane.showMessageDialog(null, "Se registro con exito", "Registro", JOptionPane.INFORMATION_MESSAGE );
                   }
                 
             }
                 
         }
     );
        
    menuReportes_General.addActionListener(
             new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                     String columnas[]={"Nombres","Paterno","Materno","codigo"};
                     Object filas[][]=new Object[metodos.listaPersonas.size()][4];
                     
                     ArrayList<DatosPersona> nuevaMatriz=metodos.listaPersonas;
                     for (int i = 0; i < nuevaMatriz.size(); i++) {
                         for (int j = 0; j < 1; j++) {
                             DatosPersona v=(DatosPersona)metodos.listaPersonas.get(i);
                         filas[i][j]=v.nombres;
                         filas[i][j+1]=v.ap_paterno;
                         filas[i][j+2]=v.ap_materno;
                         filas[i][j+3]=v.codigo;
                        
                         }
                         
                      
                     }
                    JTable table=new JTable(filas,columnas);
                    JScrollPane tabla1=new JScrollPane(table);
                    JPanel reporte =new JPanel();
                    reporte.add(tabla1);
                    
                    Object msg []={reporte};
                    JOptionPane.showMessageDialog(null,msg, "Reporte", JOptionPane.QUESTION_MESSAGE);
                 }
             }
     );
    //
    
    
 }
    
    
    
    
}