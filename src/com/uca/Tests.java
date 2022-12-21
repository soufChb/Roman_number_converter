package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
        
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("LL")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IM")), instanceOf(IllegalArgumentException.class));

        assertThat(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(10)), equalTo(10));
        
	}
	
	


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
