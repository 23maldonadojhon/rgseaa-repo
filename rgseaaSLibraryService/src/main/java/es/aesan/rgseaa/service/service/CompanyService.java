package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.CompanyCriteria;
import es.aesan.rgseaa.model.entity.Company;
import es.aesan.rgseaa.service.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CompanyService extends AbstractService<
        Company,
        Long,
        CompanyRepository,
        CompanyCriteria
        > {

    CompanyService(CompanyRepository repository) {
        super(repository);
    }

    public List<Company> findAllNameLike(List<String> wordsList){
        logger.info("==== findAllNameLike ====");
        logger.info("==== wordsList={}", wordsList);

        Set<Company> industrySet = new HashSet<>();

        for(String word : wordsList){
            Set<Company> setList = repository.findAllNameLike(word);
            industrySet.addAll(setList);
        }

        return new ArrayList<>(industrySet);
    }

}
