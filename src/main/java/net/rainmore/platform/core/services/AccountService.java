package net.rainmore.platform.core.services;

import net.rainmore.platform.core.models.Account;
import net.rainmore.platform.core.repositories.AccountRepository;
import net.rainmore.platform.core.repositories.GenericModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService  extends GenericModelService<Account, Long>{

    @Autowired
    private AccountRepository repository;

    @Override
    protected GenericModelRepository<Account, Long> getRepository() {
        return repository;
    }
}
