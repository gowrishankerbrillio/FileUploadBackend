package com.fileStorage.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fileStorage.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity,Integer>{
	
}
