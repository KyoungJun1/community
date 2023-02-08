package com.oo.kj.community.repository;

import com.oo.kj.community.dto.COMMUMUNITY_USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<COMMUMUNITY_USER, Long> {

    //해당 KY를 가진 계정상태 'Y'로 변경
    @Modifying
    @Transactional
    @Query(value = "UPDATE COMMUMUNITY_USER SET user_status='Y' WHERE COMMUMUNITY_USER.user_eamil_code = :ky" ,nativeQuery = true)
    public int updateUserStatus(@Param("ky") String ky);
    
}