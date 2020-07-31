package com.intocables.rulesly.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intocables.rulesly.entity.UserPunishEntity;

@Repository
public interface IUserPunishRepository extends JpaRepository<UserPunishEntity, Date> {
	//String USER_PUNISH_CACHE = "userpunishchebyall";
	
	//@Cacheable(cacheNames=USER_PUNISH_CACHE )
	@Query(value = "SELECT DATE_FORMAT(up.added, '%Y-%m-%d %T') AS added, up.type, up.reason FROM user_punish as up ORDER BY up.added DESC", nativeQuery = true)
	List<UserPunishEntity> findSqlAll();
}
