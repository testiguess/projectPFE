package com.production.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.Repository.PassageRepo;

@Service
public class PassageInfo {

	@Autowired
	private PassageRepo passageRepo;

	// VolumeParPeriode
	public List<VolumeParResponseObject> volumeParPeriode(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<VolumeParResponseObject> m = passageRepo.findVolumeParPeriode(rId, eId, mode, debutTime, finTime, typeP);
		return m;
	}

	// VolumeParClasse
	public List<VolumeParResponseObject> volumeParClasse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String[] classes, int voie, String sens) {
		List<VolumeParResponseObject> m = passageRepo.findVolumeParClasse(rId, eId, mode, debutTime, finTime, typeP,
				classes, voie, sens);
		return m;
	}

	// ***** Graphes

	// GrapheVolumeParPeriode
	public List<Object[]> grapheVolumeParPeriode(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParPeriode(rId, eId, mode, debutTime, finTime, typeP);
		return m;
	}

	// GrapheVolumeParClasse
	public List<Object[]> grapheVolumeParClasse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String[] classes, int voie, String sens) {
		List<Object[]> m = passageRepo.grapheVolumeParClasse(rId, eId, mode, debutTime, finTime, typeP, classes, voie,
				sens);
		return m;
	}

	// GrapheVolumeParVitesse
	public List<Object[]> grapheVolumeParVitesse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, int voie, String sens) {
		List<Object[]> m = passageRepo.grapheVolumeParVitesse(rId, eId, mode, debutTime, finTime, typeP, voie, sens);
		return m;
	}

	// GrapheVolumeParRoute
	public List<Object[]> grapheVolumeParRoute( LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParRoute( debutTime, finTime, typeP);
		return m;
	}
}
