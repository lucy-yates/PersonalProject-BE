package com.lbg.project.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.project.domain.Visitor;
import com.lbg.project.services.VisitorService;

@RestController

@RequestMapping("/visitor")
public class VisitorController {

	private VisitorService service;

	public VisitorController(VisitorService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Visitor> createVisitors(@RequestBody Visitor newVisitors) {
		return this.service.createVisitor(newVisitors);
	}

	@GetMapping("/get")
	public List<Visitor> getVisitor() {
		return this.service.getVisitors();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Visitor> getVisitor(@PathVariable int id) {
		return this.service.getVisitor(id);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Visitor> updateVisitor(@PathVariable int id, @RequestBody Visitor newVisitor) {
		return this.service.updateVisitor(id, newVisitor);
	}

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);
	}

}