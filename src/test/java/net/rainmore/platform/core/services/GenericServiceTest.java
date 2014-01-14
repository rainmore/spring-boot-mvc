package net.rainmore.platform.core.services;

import net.rainmore.platform.GenericTest;
import net.rainmore.platform.config.TestCoreConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;

@TransactionConfiguration(defaultRollback = true)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestCoreConfiguration.class})
public abstract class GenericServiceTest extends GenericTest {
}

