package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.entity.AuthUserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserTokenRepository extends JpaRepository<AuthUserToken, Long> {
    Optional<AuthUserToken> findByPetitionIdAndExpAfter(String petitionId, Long exp);
}

