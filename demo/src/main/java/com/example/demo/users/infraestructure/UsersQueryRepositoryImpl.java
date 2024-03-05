package com.example.demo.users.infraestructure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.security.JWTAuthtenticationConfig;
import com.example.demo.users.domain.model.TokenQuery;
import com.example.demo.users.domain.repository.TokenQueryRepository;
import com.example.demo.users.infraestructure.outbound.database.UsersH2Repository;
import com.example.demo.users.infraestructure.outbound.database.entity.Users;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UsersQueryRepositoryImpl implements TokenQueryRepository {

	@Autowired
	private UsersH2Repository usersH2Repository;

	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;
	

	@Override
	public Optional<TokenQuery> login(String user, String password) {
		Optional<Users> usr = usersH2Repository.login(user, password);
		
        return usr.map(u -> new TokenQuery(
        		jwtAuthtenticationConfig.getJWTToken(u.getUsr())	//	For example of the implementation, this should be extremely wrong
        	)).map(Optional::of).orElse(Optional.empty());
	}
	
}
