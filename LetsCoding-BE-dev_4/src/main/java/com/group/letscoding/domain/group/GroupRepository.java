package com.group.letscoding.domain.group;

import com.group.letscoding.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query(value = "SELECT * FROM study_group g WHERE g.id IN " +
            "(SELECT group_id FROM group_member gm WHERE gm.user_id = :principalId) " +
            "ORDER BY g.id DESC", nativeQuery = true)
    Page<Group> mGroupList(Long principalId, Pageable pageable);
}
