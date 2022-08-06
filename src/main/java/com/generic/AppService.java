package com.generic;

import com.exception.AppResponseService;
import com.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService<ID, T, TRepo extends JpaRepository<T, ID>> extends AppResponseService {
    protected final TRepo repo;

    @Autowired
    public AppService(TRepo repo) {
        this.repo = repo;
    }

    public AppResponse<List<T>> GetAll() {
        return Run(res -> res.setResponse(repo.findAll()));
    }
    public AppResponse<T> Save(T e) {
        return Run(res -> {
            repo.save(e);
            res.setResponse(e);
        });

    }
    public AppResponse<T> Find(ID id) {
        return Run(res -> {
            var result = repo.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("User not found"));
            res.setResponse(result);
        });
    }

    public void Delete(ID id) {
        repo.deleteById(id);
    }
}
