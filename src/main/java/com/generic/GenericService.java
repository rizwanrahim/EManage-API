package com.generic;

import com.exception.UserNotFoundException;
import com.model.Employee;
import com.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GenericService<ID, T, TRepo extends JpaRepository<T, ID>> {
    private final TRepo repo;

    @Autowired
    public GenericService(TRepo repo) {
        this.repo = repo;
    }

    public List<T> GetAll() {
        return repo.findAll();
    }
    public T Save(T e) {
        repo.save(e);
        return e;
    }
    public T Find(ID id) {
        var result = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return result;
    }

    public void Delete(ID id) {
        repo.deleteById(id);
    }
}
