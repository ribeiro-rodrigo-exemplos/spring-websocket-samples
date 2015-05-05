package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by rodrigo on 18/03/15.
 */

//@Controller
public class EchoController {

    //@MessageMapping("/echo")
    //@SendTo("/queue/echos")
    public String echo(String frase){

        return frase;
    }

}
