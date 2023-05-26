package generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ryanha.generator.ArrayGenerator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayGeneratorTest {

    ArrayGenerator generator;

    @BeforeEach
    void setGenerator() {
        this.generator = new ArrayGenerator(100);
    }

    @Test
    @DisplayName("랜덤한 순서의 배열을 생성하는 기능")
    void generateTest() {
        generator.generate();

        int[] arr = new int[100];
        System.arraycopy(generator.getArray(), 0, arr, 0, generator.getArray().length);

        assertThat(generator.getArray())
                .hasSize(100)
                .isEqualTo(arr);
    }

    @Test
    @DisplayName("생성할 배열의 길이를 0이하로 할당한 경우")
    void invalidArraySizeTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new ArrayGenerator(0));
        assertThrows(IllegalArgumentException.class,
                () -> new ArrayGenerator(-1));
    }

    @Test
    @DisplayName("생성한 배열을 Deep Copy하여 반환하는 기능")
    void arrayDeepCopyTest() {
        ArrayGenerator generator = new ArrayGenerator(100);
        generator.generate();

        assertThat(generator.getClonedArray())
                .isEqualTo(generator.getArray())
                .isNotSameAs(generator.getArray());
    }
}
