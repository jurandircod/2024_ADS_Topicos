/*
 *k nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Cliente;

/**
 *Cria primeiro o pacote modelo - a classe cliente.java
 * 
 DAO - Data Acees Object
 */
public class ClienteDao {
   // METODOS QUE INSEREM DADOS EM CLIENTES - eCRTL + R em cima da variável altera todos as variáveis onde tem este nome
   // obj é a classe cliente com todas as variáveis
public int inserir(Cliente obj) throws Exception {
        int retorno;

        String sql = "insert into cliente (nome, cpfcnpj, tipo)"
                + "values (?, ?, ?)";

        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getCpfCnpj());
            ps.setString(3, obj.getTipo());

            retorno = ps.executeUpdate();
        }

        return retorno;
    }
    
    
}
