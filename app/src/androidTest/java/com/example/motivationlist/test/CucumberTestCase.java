package com.example.motivationlist.test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(features = "features",
        glue = "com.example.motivationlist.steps",
        tags = {"@e2e","@smoke"})
@SuppressWarnings("unused")

@RunWith(Cucumber.class)
public class CucumberTestCase {
}
