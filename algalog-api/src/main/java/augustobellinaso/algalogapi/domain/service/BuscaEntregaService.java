package augustobellinaso.algalogapi.domain.service;

import augustobellinaso.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import augustobellinaso.algalogapi.domain.exception.NegocioException;
import augustobellinaso.algalogapi.domain.model.Entrega;
import augustobellinaso.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
