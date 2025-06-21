package midorum.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @see <a href="https://docs.aws.amazon.com/lambda/latest/dg/lambda-java.html">Building Lambda functions with Java</a>
 */
public class HelloWorldHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        return "Hello from AWS Lambda!";
    }

}
