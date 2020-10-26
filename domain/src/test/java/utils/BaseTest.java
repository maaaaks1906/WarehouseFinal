package utils;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class BaseTest {
    @Before
    public void baseSetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
