package com.shar.casestudy.repositories;

import com.shar.casestudy.models.Status;
import com.shar.casestudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, String> {


}
