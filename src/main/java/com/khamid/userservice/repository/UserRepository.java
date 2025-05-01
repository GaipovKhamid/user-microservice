package com.khamid.userservice.repository;

import com.khamid.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.net.ContentHandler;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
