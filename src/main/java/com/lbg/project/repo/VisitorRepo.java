package com.lbg.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.project.domain.Visitor;

public interface VisitorRepo extends JpaRepository<Visitor, Integer> {

}
