<?php

//
// Require 3rd-party libraries here:
//
//   require_once 'PHPUnit/Autoload.php';
//   require_once 'PHPUnit/Framework/Assert/Functions.php';
//

/**
 * Features context.
 */
class FeatureContext extends \Behat\Behat\Context\BehatContext {
    private $state = NULL;

    private $driversLicense = NULL;

    private $results = NULL;

    /**
     * @Given /^I have the state (.*)$/
     */
    public function iHaveAState($state) {
        $this->state = $state;
    }

    /**
     * @Given /^I have a drivers license (.*)$/
     */
    public function iHaveADriversLicense($license) {
        $this->driversLicense = $license;
    }

    /**
     * @When /^I validate the license$/
     */
    public function iValidateTheLicense() {
        $validator = new \USDLRegex\Validator();
        $this->results = $validator->validate($this->state, $this->driversLicense);
    }

    /**
     * @Then /^the result is (.*)$/
     */
    public function theResultIs($expected) {
        $expectedBool = ($expected === 'TRUE') ? TRUE : FALSE;

        if ($expectedBool !== $this->results) {
            throw new \Exception('The results were not ' . $expected);
        }
    }
}

