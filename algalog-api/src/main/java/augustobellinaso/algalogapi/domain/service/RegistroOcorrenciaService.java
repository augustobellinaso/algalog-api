package augustobellinaso.algalogapi.domain.service;

import augustobellinaso.algalogapi.domain.exception.NegocioException;
import augustobellinaso.algalogapi.domain.model.Entrega;
import augustobellinaso.algalogapi.domain.model.Ocorrencia;
import augustobellinaso.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }

}
