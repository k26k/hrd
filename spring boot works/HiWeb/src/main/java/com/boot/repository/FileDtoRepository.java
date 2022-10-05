package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.dto.FileDto;

public interface FileDtoRepository extends JpaRepository<FileDto, String> {

}
