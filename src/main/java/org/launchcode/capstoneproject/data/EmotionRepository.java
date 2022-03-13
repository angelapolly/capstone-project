package org.launchcode.capstoneproject.data;

import org.launchcode.capstoneproject.models.Emotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface EmotionRepository extends CrudRepository<Emotion, Integer> {
}
