package org.example;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    BuddyInfo findById(long id);
    BuddyInfo findByName(String name);
    BuddyInfo findByPhoneNum(String phoneNum);
}