package com.production.demo.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.Model.Passage;

@Repository
public interface PassageRepo extends JpaRepository<Passage, Long> {

	// ******** Resultat sous forme Tableau ********

	// VolumeParPeiode Result
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseObject( ve.id, ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time, p.classe, p.speed as vitesse, p.headway, p.overloaded, " + "v.numero as voie, v.sens) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid")
	public List<VolumeParResponseObject> findVolumeParPeriode(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP);

	// VolumeParClasse Result
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseObject( ve.id, ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time, p.classe, p.speed as vitesse, p.headway, p.overloaded, " + "v.numero as voie, v.sens) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "
			+ "AND p.classe in :classes " + "AND v.numero=:voie " + "AND v.sens=:sens")
	public List<VolumeParResponseObject> findVolumeParClasse(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP,
			@Param("classes") String[] classes, @Param("voie") int voie, @Param("sens") String sens);

	// ******** Resultat sous forme Graphique ********

	// VolumeParClasse
	@Query("SELECT p.classe, count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "
			+ "AND v.numero=:voie " + "AND v.sens=:sens " + "GROUP BY p.classe " + "HAVING p.classe in :classes")
	public List<Object[]> grapheVolumeParClasse(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP,
			@Param("classes") String[] classes, @Param("voie") int voie, @Param("sens") String sens);

	// VolumeParVitesse
	@Query("SELECT p.speed , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "
			+ "AND v.numero=:voie " + "AND v.sens=:sens"

			+ "GROUP BY p.speed ")
	public List<Object[]> grapheVolumeParVitesse(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP, @Param("voie") int voie,
			@Param("sens") String sens);

	// VolumeParPeriode
	@Query("SELECT p.date , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "

			+ "GROUP BY p.date ")
	public List<Object[]> grapheVolumeParPeriode(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP);

	// VolumeParRoute
	@Query("SELECT r.route , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "

			+ "GROUP BY r.route "
			+ "HAVING r.route IN :routes")
	public List<Object[]> grapheVolumeParRoute( @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP, @Param("routes") String[] routes);

}
