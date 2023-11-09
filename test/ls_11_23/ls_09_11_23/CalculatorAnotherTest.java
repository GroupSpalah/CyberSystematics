package ls_11_23.ls_09_11_23;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorAnotherTest {

    @Mock
    private CalculatorAnother newMock;

    @Spy
    private CalculatorAnother spy;

    @Test
    public void shouldMockMethod() {

        CalculatorAnother mock = Mockito.mock(CalculatorAnother.class);//create mock class CalculatorAnother

        Mockito.when(mock.getRandom()).thenReturn(15);

        Mockito.when(mock.sum(ArgumentMatchers.anyInt())).thenCallRealMethod();

        int sum = mock.sum(6);

        Assert.assertEquals(21, sum);

    }

    @Test
    public void shouldMockMethod1() {

        Mockito.when(newMock.getRandom()).thenReturn(15);

        Mockito.when(newMock.sum(ArgumentMatchers.anyInt())).thenCallRealMethod();

        int sum = newMock.sum(6);

        Assert.assertEquals(21, sum);

    }
    @Test
    public void shouldSpyMethod() {

        Mockito.when(spy.getRandom()).thenReturn(15);

        int sum = spy.sum(6);

        Assert.assertEquals(21, sum);

    }

    @Test
    public void shouldVerifyMethod() {

        Mockito.when(spy.getRandom()).thenReturn(15);

        int sum = spy.sum(6);

        Assert.assertEquals(21, sum);

        Mockito.verify(spy, Mockito.times(1)).sum(ArgumentMatchers.anyInt());
        Mockito.verify(spy, Mockito.times(1)).getRandom();
        Mockito.verifyNoMoreInteractions(spy);

    }
}
