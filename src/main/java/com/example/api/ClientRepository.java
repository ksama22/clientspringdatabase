package com.example.api;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface ClientRepository extends CrudRepository<Client, Integer>{
    public List<Client> findAll();
    
}
