package com.example.demo.users.domain.repository;

import java.util.Optional;

import com.example.demo.users.domain.model.TokenQuery;

public interface TokenQueryRepository {
	
	Optional<TokenQuery> login(String user, String password);

}
