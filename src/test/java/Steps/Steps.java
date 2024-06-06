package Steps;

import Config.Properties;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.StringUtils;

public class Steps {
    @Before
    public void doBefore(Scenario scenario) throws Exception {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Getting started - " + scenario.getName() + " Status - " + scenario.getStatus());
        Properties.pathtakeScreenshot += "tc_"+StringUtils.removeSpaces(scenario.getName()) + ".png";
        System.out.println("--------------------------------------------------------------");
    }

    @After
    public void doAfter(Scenario scenario) throws Exception {

        System.out.println("--------------------------------------------------------------");
        System.out.println("Ending - " + scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("--------------------------------------------------------------");
    }
}
