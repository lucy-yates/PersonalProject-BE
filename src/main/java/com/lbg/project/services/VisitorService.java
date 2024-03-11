package com.lbg.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.project.domain.Visitor;
import com.lbg.project.repo.VisitorRepo;

@Service
public class VisitorService {
	private VisitorRepo repo;

	public VisitorService(VisitorRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Visitor> createVisitor(Visitor newVisitor) {
		Visitor created = this.repo.save(newVisitor);
		return new ResponseEntity<Visitor>(created, HttpStatus.CREATED);

	}

	public List<Visitor> getVisitors() {
		return this.repo.findAll();
	}

	public ResponseEntity<Visitor> getVisitor(int id) {
		Optional<Visitor> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Visitor>(HttpStatus.NOT_FOUND);
		}

		Visitor body = found.get();

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Visitor> updateVisitor(int id, Visitor newVisitor) {
		Optional<Visitor> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Visitor>(HttpStatus.NOT_FOUND);
		}

		Visitor existing = found.get();

		if (newVisitor.getName() != null) {
			existing.setName(newVisitor.getName());
		}

		if (newVisitor.getAge() != null && newVisitor.getAge() != 0) {

			existing.setAge(newVisitor.getAge());

		}

		if (newVisitor.getFavouriteNumber() != null && newVisitor.getFavouriteNumber() != 0) {

			existing.setFavouriteNumber(newVisitor.getFavouriteNumber());

		}

		Visitor updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

}