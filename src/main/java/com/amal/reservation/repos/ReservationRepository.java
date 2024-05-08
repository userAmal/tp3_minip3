package com.amal.reservation.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.amal.reservation.entities.Reservation;
import com.amal.reservation.entities.Type;
@RepositoryRestResource(path = "rest")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByNomClient(String nom);
    List<Reservation> findByNomClientContains(String nom); 
    /*@Query("select r from Reservation r where r.nomClient like %?1 and r.prixSejour > ?2")
    List<Reservation> findByNomPrix (String nom, Double prix);*/
    @Query("select r from Reservation r where r.nomClient like %:nom and r.prixSejour > :prix")
    List<Reservation> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
    @Query("select r from Reservation r where r.type = ?1")
    List<Reservation> findByType (Type type);
    List<Reservation> findByTypeIdTy(Long id);
    List<Reservation> findByOrderByNomClientAsc();
    @Query("select r from Reservation r order by r.nomClient ASC, r.prixSejour DESC")
    List<Reservation> trierReservationsNomsPrix ();
}
