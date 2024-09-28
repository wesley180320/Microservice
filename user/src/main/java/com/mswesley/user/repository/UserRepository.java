package com.mswesley.user.repository;

import com.mswesley.user.models.UserModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<List<UserModel>> findByName(String name);

    Optional<List<UserModel>> findByEmail(String email);

    Optional<List<UserModel>> findBySenha(byte[] senha);

}
