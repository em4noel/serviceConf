package com.serviceConf.wooba.checkin;

import com.serviceConf.wooba.turReservasAereasTrecho.dto.CheckinRsVooDto;
import com.serviceConf.wooba.turReservasAereasTrecho.dto.CheckinVooDto;
import com.serviceConf.wooba.turReservasAereasTrecho.dto.TrechoVooDto;
import org.springframework.stereotype.Service;

@Service
public class CheckinVooService {
    /*public List<CheckinRsVooDto> transformToResponseDto(List<CheckinVooDto> checkinDtos) {
        Map<String, CheckinRsVooDto> checkinMap = new HashMap<>();

        for (CheckinVooDto checkinDto : checkinDtos) {
            String nomePax = checkinDto.getPassageiro();
            int reemissao = checkinDto.getReemissao();
            // Verifique se já existe uma entrada no mapa para esse nomePax
            if (checkinMap.containsKey(nomePax)) {
                CheckinRsVooDto existingResponseDto = checkinMap.get(nomePax);
                // Verifique se a reemissão atual é maior que a reemissão existente
                if (reemissao > existingResponseDto.getReemissao()) {
                    // Substitua o registro existente pelo novo com a maior reemissão
                    CheckinRsVooDto newResponseDto = createCheckinResponseDto(checkinDto);
                    newResponseDto.getTrechosMultiplaConexao().add(createTrechoDto(checkinDto));
                    checkinMap.put(nomePax, newResponseDto);
                } else if (reemissao == existingResponseDto.getReemissao()) {
                    // Se a reemissão for igual, verifique se o trecho já existe no registro existente
                    boolean trechoExists = false;

                    for (TrechoVooDto trecho : existingResponseDto.getTrechosMultiplaConexao()) {
                        if (areTrechosEqual(trecho, createTrechoDto(checkinDto))) {
                            trechoExists = true;
                            break;
                        }
                    }
                    // Se o trecho não existir, adicione-o ao registro existente
                    if (!trechoExists) {
                        existingResponseDto.getTrechosMultiplaConexao().add(createTrechoDto(checkinDto));
                    }
                }
            } else {
                // Se não existir, crie uma nova entrada no mapa
                CheckinRsVooDto newCheckinResponseDto = createCheckinResponseDto(checkinDto);
                newCheckinResponseDto.getTrechosMultiplaConexao().add(createTrechoDto(checkinDto));
                checkinMap.put(nomePax, newCheckinResponseDto);
            }
        }
        return new ArrayList<>(checkinMap.values());
    }*/

    private TrechoVooDto createTrechoDto(CheckinVooDto checkinDto) {
        TrechoVooDto trecho =null;

        return trecho;
    }

    private CheckinRsVooDto createCheckinResponseDto(CheckinVooDto checkinDto) {
      /*  String reserva = checkinDto.getVooId().toString();
        String numeroDoBilhete = checkinDto.getNumeroDoBilhete();
        String localizadorCompanhia = checkinDto.getLocalizadorCompanhia();
        Date data = checkinDto.getPartida();
        String companhiaInicio = checkinDto.getCompanhia();
        String nomeAgencia = checkinDto.getNomeAgencia();
        String nomeUnidade = checkinDto.getNomeUnidade();
        String logomarca = checkinDto.getLogomarca();
        String nomeCompleto = checkinDto.getNomeEmissor();
        String email = checkinDto.getEmail();
        String tipoTrecho = (checkinDto.getTrecho() == 1) ? "Domestico" : "Internacional";

        CheckinRsVooDto checkinResponseDto = null;

        return checkinResponseDto;*/
        return null;
    }

    private boolean areTrechosEqual(TrechoVooDto trecho1, TrechoVooDto trecho2) {
        // Compare os campos relevantes para determinar se os trechos são iguais
       /* return trecho1.getSegmento().equals(trecho2.getSegmento()) &&
                trecho1.getConexao() == trecho2.getConexao() &&
                trecho1.getDe().equals(trecho2.getDe()) &&
                trecho1.getPara().equals(trecho2.getPara()) &&
                trecho1.getCompanhia().equals(trecho2.getCompanhia()) &&
                trecho1.getDuracaoVoo().equals(trecho2.getDuracaoVoo()) &&
                trecho1.getHora().equals(trecho2.getHora()) &&
                trecho1.getVoo().equals(trecho2.getVoo()) &&
                trecho1.getHoraRetorno().equals(trecho2.getHoraRetorno()) &&
                trecho1.getStatus() == trecho2.getStatus() &&
                trecho1.getData().equals(trecho2.getData()) &&
                trecho1.getReemissao() == trecho2.getReemissao();*/
        return true;
    }
}
