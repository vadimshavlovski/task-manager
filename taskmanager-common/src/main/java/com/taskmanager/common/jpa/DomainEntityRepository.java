package com.taskmanager.common.jpa;

import org.mapstruct.Named;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface DomainEntityRepository<T extends DomainEntity<ID>, ID extends Serializable> extends JpaRepository<T, ID>,
    JpaSpecificationExecutor<T> {

    Optional<T> findByGuid(String guid);

    void deleteByGuid(String guid);

    @Named("getOneByGuid")
    default T getOneByGuid(String guid) {
        final Optional<T> domainEntityOptional = findByGuid(guid);
        return domainEntityOptional.orElseThrow(() -> new JpaObjectRetrievalFailureException(
            new EntityNotFoundException("Enitity with guid " + guid + " not found")));
    }
}
