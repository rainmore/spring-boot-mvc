package net.rainmore.platform.web.persistent.services;

import net.rainmore.platform.web.GenericTest;
import net.rainmore.platform.web.utils.TestApplicationContext;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;

@TransactionConfiguration(defaultRollback = true)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApplicationContext.class})
@ComponentScan(basePackages = {"net.rainmore.platform.web"})
public abstract class GenericServiceTest extends GenericTest {
}
