package br.com.rcosta.autobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rcosta.autobank.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
