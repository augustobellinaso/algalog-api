package augustobellinaso.algalogapi.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class OcorrenciaInput {

    @NotBlank
    private String descricao;
}
