package com.nicotinator.flavouring;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface FlavouringRepository extends JpaRepository<Flavouring, Long> {

    @Query("SELECT f FROM Flavouring AS f WHERE f.name LIKE :term")
    List<Flavouring> findByNameLike(@Param("term") String term);

}
