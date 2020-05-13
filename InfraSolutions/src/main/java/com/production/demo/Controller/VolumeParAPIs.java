package com.production.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.production.demo.Exceptions.ResourceNotFoundException;
import com.production.demo.JsonHolder.ParClasseVariables;
import com.production.demo.JsonHolder.ParRouteVariables;
import com.production.demo.JsonHolder.ParVitesseVariables;
import com.production.demo.JsonHolder.RepeatingVariables;
import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.Service.PassageInfo;

@RestController
public class VolumeParAPIs {

	@Autowired
	private PassageInfo passageInfo;

	@PostMapping("/volumeParPeriode")
	public ResponseEntity<Object> volumeParPeriode(@Valid @RequestBody RepeatingVariables pr) {
		List<VolumeParResponseObject> m = passageInfo.volumeParPeriode(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParClasse")
	public ResponseEntity<Object> volumeParClasse(@Valid @RequestBody ParClasseVariables pCv) {
		List<VolumeParResponseObject> m = passageInfo.volumeParClasse(pCv.resId, pCv.equipId, pCv.modeUtil,
				pCv.debutTime, pCv.finTime, pCv.typePoid, pCv.classes, pCv.voie, pCv.sens);
		if (m.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant pour ces classe" + pCv.classes),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParPeriode")
	public ResponseEntity<Object> grapheVolumeParPeriode(@Valid @RequestBody RepeatingVariables pr) {
		List<Object[]> m = passageInfo.grapheVolumeParPeriode(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParClasse")
	public ResponseEntity<Object> grapheVolumeParClasse(@Valid @RequestBody ParClasseVariables pCv) {
		List<Object[]> m = passageInfo.grapheVolumeParClasse(pCv.resId, pCv.equipId, pCv.modeUtil, pCv.debutTime,
				pCv.finTime, pCv.typePoid, pCv.classes, pCv.voie, pCv.sens);
		if (m.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant pour ces classe" + pCv.classes),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParVitesse")
	public ResponseEntity<Object> grapheVolumeParVitesse(@Valid @RequestBody ParVitesseVariables pVv) {
		List<Object[]> m = passageInfo.grapheVolumeParVitesse(pVv.resId, pVv.equipId, pVv.modeUtil, pVv.debutTime,
				pVv.finTime, pVv.typePoid, pVv.voie, pVv.sens);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParRoute")
	public ResponseEntity<Object> grapheVolumeParRoute(@Valid @RequestBody ParRouteVariables pr) {
		List<Object[]> m = passageInfo.grapheVolumeParRoute( pr.debutTime,
				pr.finTime, pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette route durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}
}
