package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.TxLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxLogDao extends JpaRepository<TxLog, String> {
}
