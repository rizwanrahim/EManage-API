package com.shared;

import com.shared.exception.AppResponseService;
import com.shared.exception.NotFoundException;
import com.shared.validators.IAppValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService<ID, T, TRepo extends JpaRepository<T, ID>> extends AppResponseService {
    protected final TRepo repo;
    protected IAppValidator<T> validator = null;
    @Autowired
    public AppService(TRepo repo) {
        this.repo = repo;
    }

    public AppResponse<List<T>> GetAll() {
        return Run(res -> res.setResponse(repo.findAll()));
    }
    public AppResponse<T> Save(T e) {
        return Run(res -> {
            if(validator != null) {
                validator.valid(e, res);

                if(!res.isValidated())
                    return;
            }

            repo.save(e);
            res.setResponse(e);
        });

    }
    public AppResponse<T> Find(ID id) {
        return Run(res -> {
            var result = repo.findById(id)
                    .orElseThrow(() -> new NotFoundException("User not found"));
            res.setResponse(result);
        });
    }

    public void Delete(ID id) {
        repo.deleteById(id);
    }
}
