package hello.aspecto;

import org.springframework.stereotype.Component;

/**
 * Created by rodrigo on 23/04/15.
 */
@Component
public class Empregado {

    private String nome;
    private String departamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
