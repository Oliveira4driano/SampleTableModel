/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modelo.Empregado;
import modelo.EmpregadoTableModel;

/**
 *
 * @author Dev-2810
 */
public class GUIPrincipal extends javax.swing.JFrame {

   private JTable table=new JTable();
    private EmpregadoTableModel tableModel;
 
    private JButton btnAdd=new JButton("Adicionar Linha");
    private JButton btnRem=new JButton("Remover Linha");
    private JButton btnAddAll=new JButton("Adicionar Dados");
    private JButton btnRemAll=new JButton("Remover Dados");;
 
    public GUIPrincipal() {
        //setando respectivamente...
        //titulo
        this.setTitle("Exemplo de Table Model");
        //layout
        this.setLayout(new FlowLayout());
        //tamanho do JFrame
        this.setSize(new Dimension(600, 400));
        //tipo de fechamento da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //centralizando a janela
        this.setLocationRelativeTo(null);
 
        //neste ponto é criado o modelo da JTable
        tableModel=new EmpregadoTableModel(getListaEmpregados());
 
        //setando propriedades da tabela...
 
        //modelo
        table.setModel(tableModel);
        //barra de rolagem
        table.setPreferredScrollableViewportSize(new Dimension(500,300));
        //auto ajuste na altura da tabela
        table.setFillsViewportHeight(true);
        //selecionar somente uma linha
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        //add a table ao scroll pane
        JScrollPane scrollPane=new JScrollPane(table);
        this.add(scrollPane);
 
        //add eventos aos botões
        btnAdd.addActionListener(btnAddListener);
        btnRem.addActionListener(btnRemListener);
        btnAddAll.addActionListener(btnAddAllListener);
        btnRemAll.addActionListener(btnRemAllListener);
 
        //add botões ao JFrame
        this.add(btnAdd);
        this.add(btnRem);
        this.add(btnAddAll);
        this.add(btnRemAll);
    }
 
    /**
     * retorna uma lista de empregados
     * @return {@link List} {@link Empregado}
     */
    private List<Empregado> getListaEmpregados(){
        //criado lista e seu conteudo os empregados
        //setando suas propriedades
        List<Empregado> empregados=new ArrayList<>();
 
        Empregado emp1=new Empregado();
        emp1.setNome("Jack");
        emp1.setIdade(19);
        emp1.setSexo('M');
        emp1.setSalario(2500);
 
        Empregado emp2=new Empregado();
        emp2.setNome("Eddie");
        emp2.setIdade(56);
        emp2.setSexo('M');
        emp2.setSalario(7500);
 
        Empregado emp3=new Empregado();
        emp3.setNome("Gina");
        emp3.setIdade(34);
        emp3.setSexo('F');
        emp3.setSalario(5500);
 
        Empregado emp4=new Empregado();
        emp4.setNome("Klaus");
        emp4.setIdade(18);
        emp4.setSexo('M');
        emp4.setSalario(1500);
 
        Empregado emp5=new Empregado();
        emp5.setNome("Erick");
        emp5.setIdade(20);
        emp5.setSexo('F');
        emp5.setSalario(1600);
 
        Empregado emp6=new Empregado();
        emp6.setNome("Robert");
        emp6.setIdade(30);
        emp6.setSexo('M');
        emp6.setSalario(4500);
 
        Empregado emp7=new Empregado();
        emp7.setNome("Mary");
        emp7.setIdade(30);
        emp7.setSexo('F');
        emp7.setSalario(4500);
 
        //add á lista os empregados criados
        empregados.add(emp1);
        empregados.add(emp2);
        empregados.add(emp3);
        empregados.add(emp4);
        empregados.add(emp5);
        empregados.add(emp6);
        empregados.add(emp7);
 
        return empregados;
    }
 
    /*
     * Eventos do botões, poderia ser criado classes que fossem "extends ActionListener"
     * mas como se trata de um exemplo, vamos simplificar 😉
     * */
 
    //evento p/adicionar um registro á tabela
    private ActionListener btnAddListener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //sorteia um indice do tamanho da lista para baixo
            //exemplo se a lista tiver o tamanho 10 , então vai de 0 até 9
            int randomIndex=(int)(Math.random()* (tableModel.getRowCount()-1));
            Empregado empregado=tableModel.getValue(randomIndex);
            tableModel.onAdd(empregado);
        }

       
    };
 
    //evento p/remover um registro da tabela
    private ActionListener btnRemListener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(table.getSelectedRow() != -1 && table.getSelectedRow() < tableModel.getRowCount()){
                tableModel.onRemove(table.getSelectedRow());
            }else
                JOptionPane.showMessageDialog(null, "Selecione um registro da tabela!");
        }
    };
 
    //evento p/adicionar um vários registros á tabela
    private ActionListener btnAddAllListener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.onAddAll(getListaEmpregados());
        }
    };
 
    //evento p/remover vários registros á tabela
    private ActionListener btnRemAllListener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.onRemoveAll();
        }
    };
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
