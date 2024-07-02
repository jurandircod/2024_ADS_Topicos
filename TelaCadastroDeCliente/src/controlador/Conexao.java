package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/*
   FAZER A CONEXÃO COM O BANCO DE DADOS

  * Classe de conexão usando o padrão de projetos singleton
  * O padrão Singleton: permite instanciar apenas uma única classe
  * de conexão no projeto inteiro. Nunca haverá mais de que uma conexão 
  * (nunca haverá 2 conexão) conexões abertas no projeto.
  (mesmo que criar uma outra conexão, irá direcionar para a mesma conexão)
 */
public class Conexao {

    private static Connection conexao;

    /*
    construtor privado - consegue restringir a classe conexão
    consegue acessar por um método auxiliar para instanciar para uma unica conexao
     */
    private Conexao() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver"; // muda esta classe para outros bancos - classe driver que a gente colocou dentro da livraria
            String url = "jdbc:mysql://127.0.0.1/ifpr";// jdbc: nome do bd /    / nome do banco
            String usuario = "root";
            String senha = "";

            Class.forName(driver); // carrega a classe conexao acima no conector que foi instalado - instalar o mysqlconector
            conexao = DriverManager.getConnection(url, usuario, senha); // conecta e grava na conexao
            conexao.setAutoCommit(true); // ele já faz o commit automático pois foi colocado a opção (true)
        } catch (Exception e) {
            throw e;
        }
    }

    public static Connection getConexao() throws Exception {
        if (conexao == null) { // na primeira vez ele entra e cria a conexao
            new Conexao();
        }
        return conexao;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Conexao.getConexao()); // acessa o metodo static - não precisa instanciar,ele pega da classe getConexao

    }

}
