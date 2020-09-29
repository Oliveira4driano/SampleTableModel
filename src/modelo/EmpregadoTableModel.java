/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dev-2810
 */
public class EmpregadoTableModel extends AbstractTableModel {
    //constantes p/identificar colunas
    private final int NOME=0;
    private final int IDADE=1;
    private final int SEXO=2;
    private final int DATA_NASC=3;
    private final int SALARIO=4;
    private final int BENEFICIO=5;
 
    private final String colunas[]={"Nome:","Idade:","Sexo:","Data.Nasc:","Salário:","Beneficio:"};
    private final List<Empregado> dados;//usamos como dados uma lista genérica de Empregado
 
    public EmpregadoTableModel(List<Empregado> dados) {
        //seto os dados no construtor
        this.dados=dados;
    }
 
    @Override
    public int getColumnCount() {
        //retorna o total de colunas
        return colunas.length;
    }
 
    @Override
    public int getRowCount() {
        //retorna o total de linhas na tabela
        return dados.size();
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //retorna o tipo de dado, para cada coluna
        switch (columnIndex) {
        case NOME:
            return String.class;
        case IDADE:
            return int.class;
        case SEXO:
            return char.class;
        case DATA_NASC:
            return Date.class;
        case SALARIO:
            return double.class;
        case BENEFICIO:
            return Boolean.class;
        default:
            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //retorna o valor conforme a coluna e linha
 
        //pega o dados corrente da linha
        Empregado empregado=dados.get(rowIndex);
 
        //retorna o valor da coluna
        switch (columnIndex) {
        case NOME:
            return empregado.getNome();
        case IDADE:
            return empregado.getIdade();
        case SEXO:
            return empregado.getSexo();
        case DATA_NASC:
            return empregado.getDataNasc();
        case SALARIO:
            return empregado.getSalario();
        case BENEFICIO:
            return empregado.isBeneficio();
        default:
            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //metodo identifica qual coluna é editavel
 
        //só iremos editar a coluna BENEFICIO, 
        //que será um checkbox por ser boolean
        if(columnIndex == BENEFICIO)
            return true;
 
        return false;
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Empregado empregado=dados.get(rowIndex);
 
        if(columnIndex == BENEFICIO){
            empregado.setBeneficio(((boolean)aValue));
        }
    }
 
    //Métodos abaixo são para manipulação de dados
 
    /**
     * retorna o valor da linha indicada
     * @param rowIndex
     * @return
     */
    public Empregado getValue(int rowIndex){
        return dados.get(rowIndex);
    }
 
    /**
     * retorna o indice do objeto
     * @param empregado
     * @return
     */
    public int indexOf(Empregado empregado) {
        return dados.indexOf(empregado);
    }
 
    /**
     * add um empregado á lista
     * @param empregado
     */
    public void onAdd(Empregado empregado) {
        dados.add(empregado);
        fireTableRowsInserted(indexOf(empregado), indexOf(empregado));
    }
 
    /**
     * add uma lista de empregados
     * @param dadosIn
     */
    public void onAddAll(List<Empregado> dadosIn) {
        dados.addAll(dadosIn);
        fireTableDataChanged();
    }
 
    /**
     * remove um registro da lista, através do indice
     * @param rowIndex
     */
    public void onRemove(int rowIndex) {
        dados.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
 
    /**
     * remove um registro da lista, através do objeto
     * @param empregado
     */
    public void onRemove(Empregado empregado) {
        int indexBefore=indexOf(empregado);//pega o indice antes de apagar
        dados.remove(empregado);  
        fireTableRowsDeleted(indexBefore, indexBefore);
    }
 
    /**
     * remove todos registros da lista
     */
    public void onRemoveAll() {
        dados.clear();
        fireTableDataChanged();
    }
}
