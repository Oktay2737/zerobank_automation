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
