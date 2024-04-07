import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestingMySchul {

	@Test
	void test() {
		SchulMember member =  new SchulMember("Zidele", "Yossi", 1982, "Adeena", "Erlbaum", new String[]{}, 1);
		member.setBirthDateOfMember(2001);
		assertEquals(2001,member.getBirthDateOfMember());
	}

}
