package com.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PasswordVerifierTest {

    private PasswordVerifier passwordVerifier;

    @Before
    public void setUp() throws Exception {
        passwordVerifier = new PasswordVerifier();
    }

    @Test
    public void shouldBeValidWhenPasswordIsLargerThan8CharactersAndContainsOneUppercase() throws InvalidPasswordException {
        // when
        passwordVerifier.verify("A23456789");

        // then
        assertTrue(true);
    }

    @Test
    public void shouldBeValidWhenPasswordIsLargerThan8CharactersAndContainsOneUppercase2() throws InvalidPasswordException {
        // when
        passwordVerifier.verify("B23456789");

        // then
        assertTrue(true);
    }

    public Object[] invalidPasswords() {
        return new Object[]{
                new Object[]{"12345678", "Password should be larger than 8 characters"},
                new Object[]{null, "Password should be NOT null"},
                new Object[]{"123456789", "Password should have one uppercase letter at least"}
        };
    }

    @Test
    @Parameters(method = "invalidPasswords")
    @TestCaseName("should throw exception for password: '{0}' with message: '{1}'")
    public void shouldThrowExceptionForInvalidCases(String password, String exceptionMessage) {
        // when & then
        assertThatThrownBy(() -> passwordVerifier.verify(password))
                .isInstanceOf(InvalidPasswordException.class)
                .hasMessage(exceptionMessage);
    }

}
