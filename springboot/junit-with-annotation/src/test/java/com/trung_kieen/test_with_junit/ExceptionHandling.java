package com.trung_kieen.test_with_junit;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@Profile("test")
@ControllerAdvice
public final class ExceptionHandling implements ProblemHandling {

}
