package hello.aspecto;

import org.springframework.stereotype.Service;

/**
 * Created by rodrigo on 22/04/15.
 */
@Service
public class Servico {

    public String envia(){

        System.out.println("servico enviando algo");

        //throw  new RuntimeException("excecao no serviço");

        return "Retorno do serviço";
    }

    public Pessoa obterPessoa(String nome){

        System.out.println("Nome da pessoa obtido como argumento "+nome);

        return new Pessoa(nome);
    }

    @MinhaAnotacao
    public void chamaServico(){

        System.out.println("chamou metodo com anotacao");
    }
}
