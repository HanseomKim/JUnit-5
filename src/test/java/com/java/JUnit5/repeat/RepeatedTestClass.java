package com.java.JUnit5.repeat;

import com.java.JUnit5.Start;
import com.java.JUnit5.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RepeatedTestClass {

    @DisplayName("반복")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" +
                repetitionInfo.getTotalRepetitions());
    }

    // 단일 인자
    @ParameterizedTest(name = "{index} argument={0}")
    @ValueSource(strings = {"Java", "Spring", "Kafka", "Redis"})
    @NullSource
    @EmptySource
    void parameterizedTest(String argument) {
        System.out.println(argument);
    }

    // 다중 인자
    @ParameterizedTest
    @CsvSource({"1, Java", "2, Spring"})
    void csvSourceTest(Integer index, String language) {
        System.out.println(index + ": " + language);
    }

    // 타입 변환
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    void typeConverterTest(@ConvertWith(StartConverter.class) Start start) {
        System.out.println(start.getLimit());
    }

    static class StartConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            return new Start(Integer.parseInt(o.toString()));
        }
    }

    // 인자 값 조합
    @ParameterizedTest
    @CsvSource({"1, Java", "2, Spring"})
    void argumentsAccessorTest(ArgumentsAccessor argumentsAccessor) {
        System.out.println(argumentsAccessor.getInteger(0) + ": " +
                argumentsAccessor.getString(1));
    }

    // 인자 값 조합 (Custom)
    @ParameterizedTest
    @CsvSource({"1, Java", "2, Spring"})
    void aggregateTest(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }
}
