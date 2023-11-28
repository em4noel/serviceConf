package com.serviceConf.wooba.turReservasAereasTrecho;

import com.serviceConf.wooba.turReservasAereasTrecho.dto.CheckinRsVooDto;
import com.serviceConf.wooba.turReservasAereasTrecho.dto.CheckinVooDto;
import com.serviceConf.wooba.turReservasAereasTrecho.dto.TrechoVooDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurReservasAereasTrechoService {
    public List<CheckinRsVooDto> transformToResponseDto(List<CheckinVooDto> checkinVooDtos) {
        Map<String, CheckinRsVooDto> checkinMap = new HashMap<>();
        for (CheckinVooDto checkinDto : checkinVooDtos) {
            String nomePax = checkinDto.getPassageiro();
            int reemissao = checkinDto.getReemissao();
            String numeroDoBilhete = checkinDto.getNumeroDaCompanhia() + checkinDto.getNumeroDoBilhete();
            // Verifique se já existe uma entrada no mapa para esse nomePax.

            if (checkinMap.containsKey(nomePax)) {
                CheckinRsVooDto existingResponseDto = checkinMap.get(nomePax);
                // Verifique se a reemissão atual é maior que a reemissão existente.
                if (!numeroDoBilhete.equals(existingResponseDto.getNumeroDoBilhete()) && reemissao > existingResponseDto.getReemissao()) {
                    // Substitua o registro existente pelo novo com a maior reemissão.
                    CheckinRsVooDto newResponseDto = createCheckinResponseDto(checkinDto);
                    TrechoVooDto novoTrecho = createTrechoDto(checkinDto);
                    if (!hasTrecho(existingResponseDto.getTrechosMultiplaConexao(), novoTrecho)) {
                        newResponseDto.getTrechosMultiplaConexao().add(novoTrecho);
                    }
                    checkinMap.put(nomePax, newResponseDto);
                } else if (reemissao == existingResponseDto.getReemissao()) {
                    boolean trechoExists = false;
                    TrechoVooDto novoTrecho = createTrechoDto(checkinDto);
                    boolean bilheteExiste = false;
                    // Verifique se o número do bilhete original é diferente
                    if (!numeroDoBilhete.trim().equals(existingResponseDto.getNumeroBilheteOriginal())) {
                        // Verifique se o trecho já existe no registro existente
                        for (TrechoVooDto trecho : existingResponseDto.getTrechosMultiplaConexao()) {
                            if (areTrechosEqual(trecho, novoTrecho)) {
                                trechoExists = true;
                                break;
                            }
                            if (numeroDoBilhete.trim().equals(existingResponseDto.getNumeroDoBilhete()) || numeroDoBilhete.equals(existingResponseDto.getNumeroBilheteOriginal())) {
                                bilheteExiste = true;
                                break;
                            }
                        }
                        if (!bilheteExiste) {
                            CheckinRsVooDto newCheckinResponseDto = createCheckinResponseDto(checkinDto);
                            TrechoVooDto novoTrecho2 = createTrechoDto(checkinDto);
                            newCheckinResponseDto.getTrechosMultiplaConexao().add(novoTrecho2);
                            checkinMap.put(nomePax, newCheckinResponseDto);
                        }
                        // Se o trecho não existir, adicione-o ao registro existente
                        if (!trechoExists) {
                            existingResponseDto.getTrechosMultiplaConexao().add(novoTrecho);
                        }
                    }
                }
            } else {
                // Se não existir, crie uma nova entrada no mapa.
                CheckinRsVooDto newCheckinResponseDto = createCheckinResponseDto(checkinDto);
                TrechoVooDto novoTrecho = createTrechoDto(checkinDto);
                newCheckinResponseDto.getTrechosMultiplaConexao().add(novoTrecho);
                checkinMap.put(nomePax, newCheckinResponseDto);

            }
        }
        return new ArrayList<>(checkinMap.values());
    }

    private boolean hasTrecho(List<TrechoVooDto> trechos, TrechoVooDto trecho) {
        for (TrechoVooDto existingTrecho : trechos) {
            if (areTrechosEqual(existingTrecho, trecho)) {
                return true;
            }
        }
        return false;
    }

    private CheckinRsVooDto createCheckinResponseDto(CheckinVooDto checkinVooDto) {
        String reserva = checkinVooDto.getReservaId().toString();
        String numeroDoBilhete = checkinVooDto.getNumeroDaCompanhia() + checkinVooDto.getNumeroDoBilhete();
        String numeroDoBilheteOriginal = checkinVooDto.getNumeroBilheteOriginal();
        String tktBilhete = checkinVooDto.getTktBilhete();
        String localizadorCompanhia = checkinVooDto.getLocalizadorCompanhia();
        String localizador = checkinVooDto.getLocalizador();
        Date data = checkinVooDto.getData();
        String companhiaInicio = checkinVooDto.getCompanhia();
        String nomeAgencia = checkinVooDto.getNomeAgencia();
        String nomeUnidade = checkinVooDto.getNomeUnidade();
        String logomarca = checkinVooDto.getLogomarca();
        String nomeCompleto = checkinVooDto.getNomeCompleto();
        String email = checkinVooDto.getEmail();
        String tipoTrecho = (checkinVooDto.getTrecho() == 1) ? "Domestico" : "Internacional";

        if (tipoTrecho.equalsIgnoreCase("Domestico")) {
            localizadorCompanhia = localizador;
        } else if (tipoTrecho.equalsIgnoreCase("Internacional") && checkinVooDto.getLocalizadorCompanhia() != null) {
            localizadorCompanhia = checkinVooDto.getLocalizadorCompanhia();
        }


        CheckinRsVooDto checkinResponseDto = new CheckinRsVooDto(
                reserva, numeroDoBilhete, numeroDoBilheteOriginal, tktBilhete, localizadorCompanhia, data, companhiaInicio, nomeAgencia,
                nomeUnidade, logomarca, nomeCompleto, email, checkinVooDto.getPassageiro(), tipoTrecho, checkinVooDto.getReemissao()
        );

        return checkinResponseDto;
    }

    private TrechoVooDto createTrechoDto(CheckinVooDto checkinDto) {
        TrechoVooDto trecho = new TrechoVooDto(
                checkinDto.getConexao(),
                checkinDto.getDe(),
                checkinDto.getDsOrigem(),
                checkinDto.getPara(),
                checkinDto.getDsDestino(),
                checkinDto.getCompanhia(),
                checkinDto.getDuracaoVoo(),
                checkinDto.getHora(),
                checkinDto.getVoo(),
                checkinDto.getHoraRetorno(),
                checkinDto.getStatus(),
                checkinDto.getData(),
                checkinDto.getReemissao(),
                checkinDto.getId()
        );

        return trecho;
    }

    private boolean areTrechosEqual(TrechoVooDto trecho1, TrechoVooDto trecho2) {
        // Compare os campos relevantes para determinar se os trechos são iguais
        return trecho1.getConexao() == trecho2.getConexao() &&
                trecho1.getDe().equals(trecho2.getDe()) &&
                trecho1.getPara().equals(trecho2.getPara()) &&
                trecho1.getCompanhia().equals(trecho2.getCompanhia()) &&
                trecho1.getDuracaoVoo().equals(trecho2.getDuracaoVoo()) &&
                trecho1.getHora().equals(trecho2.getHora()) &&
                trecho1.getVoo().equals(trecho2.getVoo()) &&
                trecho1.getHoraRetorno().equals(trecho2.getHoraRetorno()) &&
                trecho1.getStatus() == trecho2.getStatus() &&
                trecho1.getData().equals(trecho2.getData()) &&
                trecho1.getReemissao() == trecho2.getReemissao();
    }

}
