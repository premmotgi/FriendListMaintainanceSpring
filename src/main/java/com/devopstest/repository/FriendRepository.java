package com.devopstest.repository;

import com.devopstest.dao.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FriendRepository extends MongoRepository<Friend, Long> {

    public Friend findByName(String name);

    public List<Friend> findByIsAuthorised(Boolean isAuthorised);


}
