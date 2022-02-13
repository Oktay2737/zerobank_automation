package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",//hata raporları için maven icinde verify yapmalıyız
                  "html:target/default-html-reports"//diğer raporlar için cucumber icinde run etmemiz yeterli olur
        },//"pretty","html:target/html",
        features = "src/test/resources/features",
        glue = "com/zerobank/step_definitions",
        dryRun = false,
        tags ="@wip"
)
public final class CukesRunner {
}
/*
 When the user enters date range from “2012-09-01” to “2012-09-06”
    And clicks search
    Then results table should only show transactions dates between “2012-09-01” to “2012-09-06”
    And the results should be sorted by most recent date
    When the user enters date range from “2012-09-02” to “2012-09-06”
    And clicks search
    Then results table should only show transactions dates between “2012-09-02” to “2012-09-06”
    And the results table should only not contain transactions dated “2012-09-01”
 */