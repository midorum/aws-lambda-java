package midorum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import midorum.aws.lambda.HelloWorldHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloWorldHandlerTest {

    private HelloWorldHandler instance;
    @Mock
    private LambdaLogger logger;
    @Mock
    private Context context;

    @BeforeEach
    void beforeEach() {
        instance = new HelloWorldHandler();
        when(context.getLogger()).thenReturn(logger);
    }

    @Test
    public void shouldAnswerWithTrue() {
        final String input = "test input";
        doAnswer(invocation -> {
            String arg = invocation.getArgument(0, String.class);
            System.out.println(arg);
            assertEquals("Input: " + input, arg);
            return null;
        }).when(logger).log(anyString());
        String result = instance.handleRequest(input, context);
        assertNotNull(result);
        System.out.println(result);
    }
}
