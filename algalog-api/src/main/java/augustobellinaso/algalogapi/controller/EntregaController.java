package augustobellinaso.algalogapi.controller;

import augustobellinaso.algalogapi.domain.model.Entrega;
import augustobellinaso.algalogapi.domain.repository.EntregaRepository;
import augustobellinaso.algalogapi.domain.service.SolicitacaoEntregaService;
import augustobellinaso.algalogapi.model.DestinatarioModel;
import augustobellinaso.algalogapi.model.EntregaModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;

    private EntregaRepository entregaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
        return solicitacaoEntregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar() {
        return entregaRepository.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaModel entregaModel = new EntregaModel();
                    entregaModel.setId(entrega.getId());
                    entregaModel.setNomeCliente(entrega.getCliente().getNome());
                    entregaModel.setDestinario(new DestinatarioModel());
                    entregaModel.getDestinario().setNome(entrega.getDestinatario().getNome());
                    entregaModel.getDestinario().setLogradouro(entrega.getDestinatario().getLogradouro());
                    entregaModel.getDestinario().setNumero(entrega.getDestinatario().getNumero());
                    entregaModel.getDestinario().setComplemento(entrega.getDestinatario().getComplemento());
                    entregaModel.getDestinario().setBairro(entrega.getDestinatario().getBairro());
                    entregaModel.setTaxa(entrega.getTaxa());
                    entregaModel.setStatus(entrega.getStatus());
                    entregaModel.setDataPedido(entrega.getDataPedido());
                    entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());

                    return ResponseEntity.ok(entregaModel);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
