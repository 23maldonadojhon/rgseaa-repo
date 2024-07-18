package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.service.repository.UserScopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserScopeService {

    @Autowired
    UserScopeRepository repository;

}
