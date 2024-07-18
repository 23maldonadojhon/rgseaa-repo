package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.entity.AuthUserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRequestRepository extends JpaRepository<AuthUserRequest, Long> {
    Optional<AuthUserRequest> findByPetitionIdAndExpAfter(String petitionId, Long exp);

    Optional<AuthUserRequest> findByRelayIdAndExpAfter(String relayId, Long exp);

    Optional<AuthUserRequest> findByRelayId(String relayId);
}