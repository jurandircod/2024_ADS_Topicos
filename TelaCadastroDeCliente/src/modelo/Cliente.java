/*
 * colocar a regra do cliente
 */
package modelo;

/**
 *
 * @author aluno
 */
public class Cliente {
 
    private String nome;
    private String cpfCnpj;
    private String tipo;

// criar para os demais campos depois

      
        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
    
    
}
