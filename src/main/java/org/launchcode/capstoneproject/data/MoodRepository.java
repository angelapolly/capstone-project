package org.launchcode.capstoneproject.data;

import org.launchcode.capstoneproject.models.Mood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Repository
public interface MoodRepository extends CrudRepository<Mood, Integer> {
}
