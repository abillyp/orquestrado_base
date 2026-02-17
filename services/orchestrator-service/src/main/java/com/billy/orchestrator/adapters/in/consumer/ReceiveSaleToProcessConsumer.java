package com.billy.orchestrator.adapters.in.consumer;

import com.billy.orchestrator.adapters.out.message.SaleMessage;
import com.billy.orchestrator.application.ports.in.WorkFlowInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ReceiveSaleToProcessConsumer {

    @Autowired
    private List<WorkFlowInputPort> workFlows;


    @KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
    public void receive(SaleMessage saleMessage){
        var workFlow = workFlows.stream()
                .filter(w -> w.isCalledByTheEvent(saleMessage.getEvent()))
                .findFirst()
                .orElse(null);

        if (workFlow != null) {
            workFlow.execute(saleMessage.getSale());
        } else {
            log.error("Evento Não encontrado");
        }


    }

}
