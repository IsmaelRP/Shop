package com.example.demo.users.application.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.users.domain.model.TokenQuery;
import com.example.demo.users.domain.repository.TokenQueryRepository;

@Service
public class LoginUseCase {

	@Autowired
	private TokenQueryRepository tokenQueryRepository;

    public Optional<TokenQuery> login(String user, String password){
        return this.tokenQueryRepository.login(user, password);
    }

}
