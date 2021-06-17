package org.perscholas.viwi.DAO;

import org.perscholas.viwi.models.Bottle;
import org.perscholas.viwi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BottleRepository extends JpaRepository<Bottle, Long> {
    @Query("SELECT b FROM Bottle b WHERE b.bottleId = ?1")
    Optional<Bottle> findBottleById(long bottle_id);
}
