package com.example.GenAi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GenAi.entity.CommissionHistory;

public interface CommissionHistoryRepository extends JpaRepository<CommissionHistory, Long> {}
