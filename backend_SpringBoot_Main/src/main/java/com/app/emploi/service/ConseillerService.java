package com.app.emploi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.app.emploi.model.ConseillerRH;
import com.app.emploi.repository.ConseillerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConseillerService {
    private final ConseillerRepository conseillerRepository;
@Transactional
public ConseillerRH createConseiller(ConseillerRH conseil){
    return conseillerRepository.save(conseil);
}
public List<ConseillerRH> getAllConseiller(){
    return conseillerRepository.findAll();  
}
public ConseillerRH updateConseiller(String id,ConseillerRH conseiller ){
    if (conseillerRepository.existsById(id)){
        conseiller.setNumEmp(id);
        return conseillerRepository.save(conseiller);
    }else{
        throw new RuntimeException("conseiller non trouver");
    }

}
@Transactional
    public void deleteConseiller(String id){
        conseillerRepository.deleteById(id);
    }
}
