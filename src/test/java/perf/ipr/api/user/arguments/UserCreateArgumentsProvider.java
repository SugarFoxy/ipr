package perf.ipr.api.user.arguments;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static perf.ipr.api.user.template.UserTemplate.*;

public class UserCreateArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(getCorrectUserData(), 200),
                Arguments.of(getDuplicateUserData(), 409));
    }
}
