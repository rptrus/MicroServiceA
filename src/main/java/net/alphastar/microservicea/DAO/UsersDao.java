package net.alphastar.microservicea.DAO;

import net.alphastar.microservicea.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {

    public List<Users> findAll();

}
