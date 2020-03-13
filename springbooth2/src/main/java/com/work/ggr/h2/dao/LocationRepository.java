package com.work.ggr.h2.dao;

import com.work.ggr.h2.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/11 0:04
 */
@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

	List<Location> getLocationsByType(String type);
}
