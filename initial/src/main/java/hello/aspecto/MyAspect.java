package hello.aspecto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by rodrigo on 22/04/15.
 */

@Aspect
@Component
public class MyAspect {

    @AfterReturning(pointcut = "meuPointcut()",returning = "valorRetornado")
    public void pointcutEnviar(JoinPoint joinPoint,String valorRetornado){

        System.out.println("chamando pointcut retornando normalmente "+joinPoint.getSignature().getName()+" com o valor retornado "+valorRetornado);

    }

    @After("meuPointcut()")
    public void depoisDeEnviar(JoinPoint joinPoint){

        System.out.println("chamando pointcut after "+joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "meuPointcut()",throwing = "excecao")
    public void depoisDeEnviarComExcecao(JoinPoint joinPoint,RuntimeException excecao){

        System.out.println("chamando pointcut em casos de excecao "+excecao.getMessage());
    }

    @Before("antesDeRodarQualquerMetodoNaClassePessoa()")
    public void advicePessoa(JoinPoint joinPoint){

        System.out.println("advice qualquer metodo da classe pessoa");
    }

    @Before("antesDoGetDepartamentoNoEmpregado()")
    public void antesDeObterDepartamento(JoinPoint joinPoint){

        Empregado empregado = (Empregado) joinPoint.getTarget();

        System.out.println("advice antes de obter departameto do empregado "+empregado.getDepartamento());
    }

    @Before("execution(* hello.*.Empregado.get*())")
    public void antesDeObterQualquerValor(JoinPoint joinPoint){

        Empregado empregado = (Empregado) joinPoint.getTarget();

        System.out.println("advice antes de obter qualquer valor do empregado "+empregado.getDepartamento());

    }

    @Before("execution(* hello.aspecto.Pessoa.set*(..)) && args(nome)")
    public void argumentos(JoinPoint joinPoint, String nome){

        System.out.println("argumento no nome " + nome);
    }

    @Around("execution(* obterPessoa(..))")
    public Pessoa envolveEnvia(ProceedingJoinPoint joinPoint){

        try{

            System.out.println("antes de executar envia dentro do around");

           Pessoa pessoa = (Pessoa) joinPoint.proceed(new Object[]{"Maria"});

            pessoa.setNome("Rodrigo - Aspecto");

            return pessoa;

        }catch(Throwable throwable){

            throwable.printStackTrace();
        }

        return null;
    }

    @Before("@annotation(hello.aspecto.MinhaAnotacao)")
    public  void chamaMetodoComAnotacao(JoinPoint joinPoint){

        System.out.println("antes de invocar o metodo com anotacao");

    }

    @Pointcut("execution(* envia(..))")
    public void meuPointcut(){}

    @Pointcut("execution(public String getDepartamento())")
    public void antesDoGetDepartamentoNoEmpregado(){}

    @Pointcut("within(hello.aspecto.Pessoa)")
    public void antesDeRodarQualquerMetodoNaClassePessoa(){}
}
