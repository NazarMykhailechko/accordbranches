package app.dao;


import app.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionDao extends JpaRepository<Division, Integer> {

}