package com.voxus.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voxus.test.model.Postagem;

public interface PostDao extends JpaRepository<Postagem, Integer> {

}
