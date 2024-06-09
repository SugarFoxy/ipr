package perf.api.user.arguments;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static perf.api.user.template.UserTemplate.getCorrectUserData;
import static perf.api.user.template.UserTemplate.getDuplicateUserData;

public class UserCreateArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(getCorrectUserData(), 200),
                Arguments.of(getDuplicateUserData(), 409));
    }
}
