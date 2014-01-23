package net.rainmore.platform.core.services.auth;

import net.rainmore.platform.core.models.auth.Role;
import net.rainmore.platform.core.repository.GenericRepository;
import net.rainmore.platform.core.repository.auth.RoleRepository;
import net.rainmore.platform.core.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Role, Long> {

    @Autowired
    RoleRepository repository;

    @Override
    protected GenericRepository<Role, Long> getRepository() {
        return repository;
    }

}
