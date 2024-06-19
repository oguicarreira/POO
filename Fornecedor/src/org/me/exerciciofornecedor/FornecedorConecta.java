package org.me.exerciciofornecedor;

import java.sql.*;
import java.util.*;

public class FornecedorConecta {
    private static final String URL = "jdbc:derby://localhost:1527/BDFornecedor";
    private static final String USERNAME = "EMPRESA";
    private static final String PASSWORD = "empresa";
    private Connection connection = null;
    private PreparedStatement insereFornecedor = null;
    private PreparedStatement selecionaFornecedor = null;
    private PreparedStatement alteraFornecedor = null;
    private PreparedStatement excluiFornecedor = null;
    public FornecedorConecta () throws ClassNotFoundException{
    try
    {
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    connection = DriverManager.getConnection (URL, USERNAME, PASSWORD);
    insereFornecedor = connection.prepareStatement ("INSERT INTO EMPRESA.TABFORNECEDOR " + "(NOME, CNPJ, EMAIL, ENDERECO, CIDADE, ESTADO, TELEFONE) " + "VALUES (?, ?, ?, ?, ?, ?, ?)");
    selecionaFornecedor = connection.prepareStatement("SELECT * FROM EMPRESA.TABFORNECEDOR WHERE NOME = ?");
    alteraFornecedor = connection.prepareStatement("UPDATE EMPRESA.TABFORNECEDOR SET NOME = ?, CNPJ = ?, EMAIL = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?, TELEFONE = ?" + "WHERE ID = ?");
    excluiFornecedor = connection.prepareStatement("DELETE FROM EMPRESA.TABFORNECEDOR " + "WHERE ID = ?");
    }
    catch (SQLException sqlException)
    {
    sqlException.printStackTrace();
    System.exit(1);
    }
   }
    public int adicionaFornecedor(String nome, String cnpj, String email, String endereco, String cidade, String estado, String telefone)
    {
       int result = 0;
       try
       {
           insereFornecedor.setString(1, nome);
           insereFornecedor.setString(2, cnpj);
           insereFornecedor.setString(3, email);
           insereFornecedor.setString(4, endereco);
           insereFornecedor.setString(5, cidade);
           insereFornecedor.setString(6, estado);
           insereFornecedor.setString(7, telefone);

           result = insereFornecedor.executeUpdate();
       }
       catch (SQLException sqlException)
       {
           sqlException.printStackTrace();
           close();
       }
       return result;
    }
    public int atualizaFornecedor(String nome, String cnpj, String email, String endereco, String cidade, String estado, String telefone, int id)
    {
        int result = 0;
        try{
            alteraFornecedor.setString(1, nome);
            alteraFornecedor.setString(2, cnpj);
            alteraFornecedor.setString(3, email);
            alteraFornecedor.setString(4, endereco);
            alteraFornecedor.setString(5, cidade);
            alteraFornecedor.setString(6, estado);
            alteraFornecedor.setString(7, telefone);
            alteraFornecedor.setInt(8, id);
            result = alteraFornecedor.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }
    public boolean deletaFornecedor(int id) {
        boolean exclui = false;
        try {
        excluiFornecedor.clearParameters();
        excluiFornecedor.setInt(1, id);
        excluiFornecedor.executeUpdate();
        exclui = true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
    }
    return exclui;
   }
    public List <Fornecedor> getNomeFornecedor (String nome)
    {
        List <Fornecedor> resultados = null;
        ResultSet resultSet = null;
        try {
            selecionaFornecedor.setString(1, nome);
            resultSet = selecionaFornecedor.executeQuery();
            resultados = new ArrayList <Fornecedor>();
            while (resultSet.next())
            {
                resultados.add(new Fornecedor(
                resultSet.getInt("ID"),
                resultSet.getString("Nome"),
                resultSet.getString("Cnpj"),
                resultSet.getString("Email"),
                resultSet.getString("Endereco"),
                resultSet.getString("Cidade"),
                resultSet.getString("Estado"),
                resultSet.getString("Telefone")));
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
        }
        return resultados;
   }
    public void close (){
        try
        {
           connection.close();
        }
        catch (SQLException sqlException)
        {
           sqlException.printStackTrace();
        }
    }
}