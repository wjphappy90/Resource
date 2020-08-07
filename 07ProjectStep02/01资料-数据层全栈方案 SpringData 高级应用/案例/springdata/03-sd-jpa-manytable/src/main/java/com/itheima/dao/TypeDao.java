package com.itheima.dao;

import com.itheima.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeDao extends JpaRepository<Type, Integer>, JpaSpecificationExecutor<Type> {

}
