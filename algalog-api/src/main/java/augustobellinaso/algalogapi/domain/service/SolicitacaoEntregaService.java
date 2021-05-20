package augustobellinaso.algalogapi.domain.service;

import augustobellinaso.algalogapi.domain.exception.NegocioException;
import augustobellinaso.algalogapi.domain.model.Cliente;
import augustobellinaso.algalogapi.domain.model.Entrega;
import augustobellinaso.algalogapi.domain.model.StatusEntrega;
import augustobellinaso.algalogapi.domain.repository.ClienteRepository;
import augustobellinaso.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;

    private CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
