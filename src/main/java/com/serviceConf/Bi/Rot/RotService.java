package com.serviceConf.Bi.Rot;

import com.serviceConf.Bi.Rot.dto.RotDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class RotService {


    @Autowired
    RotRepository rotRepository;

    public void save(MultipartFile file) {
        try {
            List<RotDTO> rotDTOS = ExcelHelper.excelToRots(file.getInputStream());
            System.out.println("aki 2 "+rotDTOS);

            for(RotDTO rotDTO : rotDTOS){
                System.out.println(rotDTO.getFatura()+ " : ");
                String teste = "teste 2";
                 // rotRepository.cadastro(rotDTO);
                insert(rotDTO);
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public Rot insert(RotDTO rotDTO){
//        obj.setCodgDispositivo(null);
        Rot teste = new Rot();
        //teste.setCodgDispositivo();
        teste.setFatura(rotDTO.getFatura());

        teste = rotRepository.save(teste);
        System.out.println(teste);
        return teste;
    }
}
