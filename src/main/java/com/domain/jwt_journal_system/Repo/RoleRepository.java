package com.domain.jwt_journal_system.Repo;

import com.domain.jwt_journal_system.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
    Role findByName(String name);
}
