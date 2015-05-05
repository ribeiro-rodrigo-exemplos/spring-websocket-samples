package hello.aspecto;

import org.springframework.stereotype.Component;

/**
 * Created by rodrigo on 23/04/15.
 */

@Component
public class Pessoa {

    private String nome;

    public Pessoa(){


    }

    public Pessoa(String nome){

        this.nome = nome;
    }

    public void setNome(String nome){

        this.nome = nome;
    }

    public String getNome(){

        return nome;
    }
}
