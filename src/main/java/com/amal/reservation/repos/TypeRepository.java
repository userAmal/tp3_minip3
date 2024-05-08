package com.amal.reservation.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.amal.reservation.entities.Type;
public interface TypeRepository extends JpaRepository<Type, Long> 
{
}
