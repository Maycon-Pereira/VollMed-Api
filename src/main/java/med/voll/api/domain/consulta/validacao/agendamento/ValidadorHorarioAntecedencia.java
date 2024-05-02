package med.voll.api.domain.consulta.validacao.agendamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentosDeConsultas {

	public void validar(DadosAgendamentoConsulta dados) {
		var dataConsulta = dados.data();
		
		var agora = LocalDateTime.now();
		var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
		
		if( diferencaEmMinutos < 30 ) {
			throw new ValidacaoException("Consulta deve ser agendada com antecedencia mínima de 30 minutos");
		}
		
	}
}
