package com.converter.currencyconverter.repository;

import com.converter.currencyconverter.entity.StoryOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOperationRepository extends JpaRepository<StoryOperation, Long> {

    boolean existsByLogin(String login);

    StoryOperation findByLogin(String login);

    List<StoryOperation> findAllByLogin(String login);
}
