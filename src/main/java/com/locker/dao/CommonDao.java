package com.locker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.LockModeType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

/**
 * 公共DAO
 * 
 * @author tianxh
 *
 */
@NoRepositoryBean
public interface CommonDao<T, ID extends Serializable> extends JpaRepository<T, ID> {
	/**
	 * 获取行锁方法：
	 * 	  select ... for update
	 *
	 * @param id
	 * @return
	 */
	@Override
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<T> findById(ID id);
	
	/**
	 * 获取行锁
	 *
	 * @param id
	 * @return
	 */
	default T getLock(ID id) {
		return findById(id).orElse(null);
	}

	/**
	 * getById
	 *
	 * @param id
	 * @return
	 */
	default T getById(ID id) {
		Iterator<T> it = findAllById(Arrays.asList(id)).iterator();
		if (it.hasNext()) {
			return it.next();
		}
		return null;
	}
}
