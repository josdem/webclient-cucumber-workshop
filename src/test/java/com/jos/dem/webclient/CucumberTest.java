package com.jos.dem.webclient;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/user.feature", "src/test/resources/label.feature"})
public class CucumberTest {}
