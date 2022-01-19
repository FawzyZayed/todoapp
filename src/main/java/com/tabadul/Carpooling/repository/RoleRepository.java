package com.tabadul.Carpooling.repository;

import com.tabadul.Carpooling.entity.Role;
import com.tabadul.Carpooling.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);

//    @Query("select * from Role r inner join Stack s on r.id = s.id where  r.id = :id")
//    Optional<Role> findById(@Param("id")Long id);
}
