package com.production.demo.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Passage extends JpaRepository<com.production.demo.Model.Passage,Long> {
	
	@Query("SELECT ve.id,ve.longueur,ve.numEssieu,"
				 + "p.date,p.time,p.classe,p.speed,p.headway,"
				 + "v.numero,v.sens  "
			
				+ "FROM Passage p "
			
				+ "JOIN p.vehicule ve "
				+ "JOIN p.voie v "
				+ "JOIN p.equip e "
				+ "JOIN e.reseau r "
			
				+ "WHERE r.id=:rId "
				+ "AND e.id=:id "
				+ "AND e.mode=:mode "
				+ "AND p.date between :date1 AND:date2 "
				+ "AND p.time between :time1 AND :time2"
			)
	public List<Object> findVolumeByPeriode(@Param("id")Long id ,@Param("mode") String mode, @Param("rId")Long rId, @Param("date1")Date date1, @Param("date2")Date date2,
			@Param("time1")Date time1, @Param("time2") Date time2);
}
