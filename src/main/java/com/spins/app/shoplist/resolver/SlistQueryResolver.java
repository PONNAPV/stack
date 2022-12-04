package com.spins.app.shoplist.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import com.spins.app.shoplist.model.Slist;
import com.spins.app.shoplist.repository.SlistRepository;

@Slf4j
@AllArgsConstructor
@Component
public class SlistQueryResolver implements GraphQLQueryResolver {
    private SlistRepository slistRepository;

    public Optional<Slist> getSlist(final String slistId){
        log.info("Get shopping list by ID: {}", slistId);
        return slistRepository.findById(slistId);
    }

    public List<Slist> getSlists(){
        log.info("Get all shopping lists");
        return slistRepository.findAll();
    }
}
