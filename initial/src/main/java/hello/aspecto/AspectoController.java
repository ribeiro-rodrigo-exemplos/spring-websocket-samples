package hello.aspecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rodrigo on 22/04/15.
 */

@RestController
@RequestMapping("/aspecto")
public class AspectoController {

    @Autowired
    Servico servico;

    @Autowired
    Empregado empregado;

    @Autowired
    Pessoa pessoa;

    @RequestMapping("/envia")
    @ResponseBody
    public String enviaDoController(){

        servico.envia();

        return "aaaa";
    }

    @RequestMapping("/empregado")
    @ResponseBody
    public String criaEmpregado(){

        empregado.setNome("Rodrigo");
        empregado.setDepartamento("Desenvolvimento");

        String departamento = empregado.getDepartamento();
        String nome = empregado.getNome();
        System.out.println("depois de obter departamento do empregado "+departamento);

        return departamento;
    }

    @RequestMapping("/pessoa")
    @ResponseBody
    public Pessoa criaPessoa(){

       // pessoa.setNome("Amarildo");

        //return pessoa.getNome();

        servico.chamaServico();

        return servico.obterPessoa("Rodrigo");
    }

}
