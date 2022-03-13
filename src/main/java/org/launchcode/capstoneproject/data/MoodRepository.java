package org.launchcode.capstoneproject.data;

import org.launchcode.capstoneproject.models.Mood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends CrudRepository<Mood, Integer> {
}
