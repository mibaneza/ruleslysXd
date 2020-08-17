package com.intocables.rulesly.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intocables.rulesly.entity.UserPunishEntity;

@Repository
public interface IUserPunishRepository extends JpaRepository<UserPunishEntity, Date> {
	
	

	@Query(value = "SELECT DATE_FORMAT(up.added, '%Y-%m-%d %T') AS added, up.type, up.reason FROM user_punish as up ORDER BY up.added", nativeQuery = true)
	Optional<List<UserPunishEntity>> findSqlAll();
	
	@Query(value = "SELECT count(*) as quantitys, DATE_FORMAT(added, '%Y-%m-%d') AS addeds FROM user_punish GROUP BY addeds", nativeQuery = true)
	Optional<List<Object[]>>findSQLByQuantityAndAddeds();
	  
	@Query(value = "SELECT count(*) as quantity FROM user_punish WHERE (added >= (CURDATE() - INTERVAL 3 MONTH))", nativeQuery = true)
	Optional<BigInteger> findSQLByQuantity();

}
