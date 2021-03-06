package com.production.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.production.demo.Exceptions.ResourceNotFoundException;
import com.production.demo.JsonHolder.ParClasseVariables;
import com.production.demo.JsonHolder.ParClasseVariablesTable;
import com.production.demo.JsonHolder.ParRouteVariables;
import com.production.demo.JsonHolder.ParSensVariables;
import com.production.demo.JsonHolder.ParVitesseVariables;
import com.production.demo.JsonHolder.ParVoieVariables;
import com.production.demo.JsonHolder.RepeatingVariables;
import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.JsonHolder.VolumeParResponseParRoute;
import com.production.demo.Repository.Equipement;
import com.production.demo.Repository.ReseauRepo;
import com.production.demo.Service.PassageInfo;

@RestController
public class VolumeParAPIs {

	@Autowired
	private PassageInfo passageInfo;

	@Autowired
	private Equipement equipRepo;

	@Autowired
	private ReseauRepo resRepo;

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
	public ResponseEntity<Object> volumeParClasse(@Valid @RequestBody ParClasseVariablesTable pCv) {
		List<VolumeParResponseObject> m = passageInfo.volumeParClasse(pCv.resId, pCv.equipId, pCv.modeUtil,
				pCv.debutTime, pCv.finTime, pCv.typePoid, pCv.classes, pCv.sens);
		if (m.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant pour ces classe" + pCv.classes),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParRoute")
	public ResponseEntity<Object> volumeParRoute(@Valid @RequestBody ParRouteVariables pr) {
		List<VolumeParResponseParRoute> m = passageInfo.volumeParRoute(pr.resId, pr.equipIds, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParVoie")
	public ResponseEntity<Object> volumeParVoie(@Valid @RequestBody ParVoieVariables pr) {
		List<VolumeParResponseParRoute> m = passageInfo.volumeParVoie(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid, pr.vNums);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParSens")
	public ResponseEntity<Object> volumeParSens(@Valid @RequestBody ParSensVariables pr) {
		List<VolumeParResponseParRoute> m = passageInfo.volumeParSens(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid, pr.sense);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
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
		Map<String, List<Object[]>> map = new HashMap<>();
		for (String classe : pCv.classes) {
			map.put(classe, passageInfo.grapheVolumeParClasse(pCv.resId, pCv.equipId, pCv.modeUtil, pCv.debutTime,
					pCv.finTime, pCv.typePoid, classe, pCv.sens));
		}
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant pour ces classe" + pCv.classes),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParVitesse")
	public ResponseEntity<Object> grapheVolumeParVitesse(@Valid @RequestBody ParVitesseVariables pVv) {
		Map<Integer,Integer> m = passageInfo.grapheVolumeParVitesse(pVv.resId, pVv.equipId, pVv.modeUtil, pVv.debutTime,
				pVv.finTime, pVv.typePoid, pVv.sens);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParRoute")
	public ResponseEntity<Object> grapheVolumeParRoute(@Valid @RequestBody ParRouteVariables pr) {
		Map<Long, List<Object[]>> map = new HashMap<>();
		for (Long eId : pr.equipIds) {
			map.put(eId, passageInfo.grapheVolumeParRoute(pr.resId, pr.modeUtil, eId, pr.debutTime, pr.finTime,
					pr.typePoid));
		}
		;
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant dans cette route durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/grapheVolumeParVoie")
	public ResponseEntity<Object> grapheVolumeParVoie(@Valid @RequestBody ParVoieVariables rV) {
		Map<Integer, List<Object[]>> map = new HashMap<>();
		for (int vNum : rV.vNums) {
			map.put(vNum, passageInfo.grapheVolumeParVoie(rV.resId, rV.modeUtil, rV.equipId, vNum, rV.debutTime,
					rV.finTime, rV.typePoid));
		}
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant dans cette route durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/grapheVolumeParSens")
	public ResponseEntity<Object> grapheVolumePar(@Valid @RequestBody ParSensVariables rV) {
		Map<String, List<Object[]>> map = new HashMap<>();
		for (String sens : rV.sense) {
			map.put(sens, passageInfo.grapheVolumeParSens(rV.resId, rV.modeUtil, rV.equipId, sens, rV.debutTime,
					rV.finTime, rV.typePoid));
		}
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant dans cette route durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	@PostMapping("/vehiculeTable")
	public ResponseEntity<Object> volumeTable(@Valid @RequestBody RepeatingVariables pr) {
		List<VolumeParResponseObject> m = passageInfo.vehiculeTable(pr.resId, pr.modeUtil, pr.equipId, pr.debutTime,
				pr.finTime, pr.speed1, pr.speed2, pr.long1, pr.long2);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/graphePlPt")
	public ResponseEntity<Object> graphePlPt(@Valid @RequestBody RepeatingVariables pr) {
		Map<String, List<Object[]>> m = passageInfo.graphePlPt(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@GetMapping("/{id}/equipements")
	public List<Long> allEquip(@Valid @PathVariable("id") Long i) {
		return equipRepo.equipParRes(i);
	}

	@GetMapping("/reseaux")
	public List<Long> allReseau() {
		return resRepo.allReseau();
	}
}
