package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modell.Usuario;

//todo DAO faz as transações de BD. Este DAO é o usuario. Logo, fará apenas transações com a tabela usuario;

public class UsuarioDao {
    public void inserir (Usuario u) throws Exception{
        //insere no BD
        String sql = "insert into usuario (nome, email, senha)"
                + "values (?, ?, ?)";
        
        try {
            //conecta no bd
            Connection conexao = Conexao.getConexao();
            //prepara a instrução sql
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            //seta  na sql os atributos do usuario            
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            
            //executa a sql
            ps.execute();
            ps.close();
            
            //limparCampos();
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public List<Usuario> buscar (String nome) throws Exception{
        List<Usuario> lista = new ArrayList<>();
        
        String sql = "select * from usuario";
        sql += (!nome.equals("")) ? " where nome like ?" : "";
        
        Connection conexao = Conexao.getConexao();
        
        //try-with-resourses fecha o recurso automaticamente, dispensa o uso de .close()
        try(PreparedStatement ps = conexao.prepareStatement(sql)){
            if(!nome.equals("")){
                ps.setString(1,"%" + nome + "%");
            }
            
            try (java.sql.ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    
                    lista.add(u);
                }
            }
            
        }catch (Exception e){
            throw e;
        }

        
        
        
        return lista;                
    }
    
    
    
}
