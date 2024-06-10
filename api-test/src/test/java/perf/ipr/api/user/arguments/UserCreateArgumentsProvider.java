package perf.ipr.api.user.arguments;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import perf.ipr.api.user.template.UserTemplate;

import java.util.stream.Stream;

public class UserCreateArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(UserTemplate.getCorrectUserData(), 200),
                Arguments.of(UserTemplate.getDuplicateUserData(), 409));
    }
}
