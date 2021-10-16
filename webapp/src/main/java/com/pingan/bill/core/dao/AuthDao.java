package com.pingan.bill.core.dao;

import com.pingan.bill.core.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthDao extends JpaRepository<Authority,Long> {

}
