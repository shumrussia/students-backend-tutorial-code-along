package ru.azatnuriakhmetov.springboot.validators;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

class EmailValidatorTest {

	private final EmailValidator underTest = new EmailValidator();
	
	@Test
	public void itShouldValidateCorrectEmail() {
		assertThat(underTest.test("dummy@dummy.com")).isTrue();
	}
	
	@Test
	public void itShouldValidateIncorrectEmail() {
		assertThat(underTest.test("dummydummy.com")).isFalse();
	}
	
	@Test
	public void itShouldValidateIncorrectEmailWithoutDotAtTheEnd() {
		assertThat(underTest.test("dummydummy@com")).isFalse();
	}

}
