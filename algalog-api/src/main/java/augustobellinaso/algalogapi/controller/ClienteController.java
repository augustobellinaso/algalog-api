package augustobellinaso.algalogapi.controller;

import augustobellinaso.algalogapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente c1 = new Cliente();
        c1.setId(1L);
        c1.setNome("João");
        c1.setEmail("joao@joao.com");
        c1.setTelefone("5151515");

        Cliente c2 = new Cliente();
        c2.setId(2L);
        c2.setNome("Maria");
        c2.setEmail("Maria@joao.com");
        c2.setTelefone("51515151241515");


        return Arrays.asList(c1, c2);
    }
}
