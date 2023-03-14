package ru.dgcim.drooltask.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dgcim.drooltask.entity.RequestBean;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PromotionController {
    private final KieContainer kieContainer;

    @PostMapping(path = "/api/promo/calc_amount")
    public Object calcAmountWithPromotion(@RequestBody RequestBean requestBean) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(requestBean);
        int ruleFiredCount = kieSession.fireAllRules();
        kieSession.destroy();
        log.info(ruleFiredCount + " rules were applied");
        return new Object() {
            @Getter @JsonProperty("discounted_amount")
            final BigDecimal discountedAmount = requestBean.getAmount();
        };
    }
}
