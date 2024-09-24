package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.util.exception.NotFoundException;
import es.aesan.rgseaa.service.repository.BaseRepository;
import es.aesan.rgseaa.service.repository.QueryByCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Optional;




public abstract class AbstractService<
            E,
            ID,
            R extends BaseRepository<E,ID>,
            C extends FilterCriteria
        > {

    protected static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected R repository;

    AbstractService( R repository){
        this.repository = repository;
    }


    public E get(final ID id){
        logger.info("==== GET :"+this.getClass().getSimpleName());
        logger.info("id :"+id);

        Optional<E> optional = repository.findById(id);
        return optional.orElseThrow(NotFoundException::new);
    }

    public E find(C criteria){
        logger.info("==== FIND_BY_CRITERIA :"+this.getClass().getSimpleName());
        logger.info("criteria="+criteria);

        if(criteria.getState()==null)
            criteria.setState(1);

        QueryByCriteria<E, FilterCriteria> filterRepository = (QueryByCriteria<E, FilterCriteria>) repository;
        Optional<E> optional = filterRepository.find(criteria);
        return optional.orElseThrow(NotFoundException::new);
    }


    @Transactional
    public E add(final E entity){
        logger.info("==== ADD :"+this.getClass().getSimpleName());
        logger.info("entity :"+entity.toString());

        return repository.save(entity);
    }


    @Transactional
    public void addAll(Iterable<E> iterable){
        logger.info("==== ADD_ALL :"+this.getClass().getSimpleName());
        repository.saveAll(iterable);
    }


    @Transactional
    public E update(final E entity){
        logger.info("==== UPDATE :"+this.getClass().getSimpleName());
        logger.info("entity :"+entity.toString());

        return repository.save(entity);
    }


    @Transactional
    public void delete(final ID id){
        logger.info("==== DELETE_BY_ID :"+this.getClass().getSimpleName());
        logger.info("entity :"+id);

        repository.deleteById(id);
    }



    public Page<E> page(C criteria){
        logger.info("==== PAGE_CRITERIA :"+this.getClass().getSimpleName());
        logger.info("criteria="+criteria);

        if(criteria.getState()==null)
            criteria.setState(1);

        if(criteria.getPage()==null)
            criteria.setPage(0);

        if(criteria.getSize()==null)
            criteria.setSize(10);

        QueryByCriteria<E, FilterCriteria> filterRepository = (QueryByCriteria<E, FilterCriteria>) repository;

        Page<E> page =filterRepository.findAllByCriteria(criteria,criteria.toPageable());



        return page;
    }


    public Collection<E> list(C criteria){
        logger.info("==== LIST_CRITERIA :"+this.getClass().getSimpleName());
        logger.info("criteria="+criteria);

        if(criteria.getState()==null)
            criteria.setState(1);

        QueryByCriteria<E, FilterCriteria> filterRepository = (QueryByCriteria<E, FilterCriteria>) repository;
        Collection<E> list = filterRepository.findAll(criteria);
        return list;
    }


}
