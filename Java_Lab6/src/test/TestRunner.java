package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.TestLetterService.TestLetterService;
import test.TestPerson.TestPerson;
import test.TestPersonService.TestPersonService;

@RunWith(value= Suite.class)
@Suite.SuiteClasses(value={TestPersonService.class, TestLetterService.class, TestPerson.class})
public class TestRunner {

}
