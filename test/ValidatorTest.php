<?php

class ValidatorTest extends \PHPUnit_Framework_TestCase {
    public static function getMethod($methodName) {
        $class = new ReflectionClass('\USDLRegex\Validator');
        $method = $class->getMethod($methodName);
        $method->setAccessible(TRUE);
        return $method;
    }


    public function test_constructor() {
        $validator = new \USDLRegex\Validator();

        $this->assertFalse($validator->verbose);
        $this->assertFalse($validator->caseInsensitive);
        $this->assertEquals(gettype($validator->rules), 'array');
        $this->assertCount(51, $validator->rules);
    }

    public function rule_override_params() {
        return array(
            array(NULL,  FALSE, NULL,  FALSE, NULL, 51, 'TX'),
            array(TRUE,  TRUE,  NULL,  FALSE, NULL, 51, 'TX'),
            array(FALSE, FALSE, NULL,  FALSE, NULL, 51, 'TX'),
            array(NULL,  FALSE, TRUE,  TRUE,  NULL, 51, 'TX'),
            array(TRUE,  TRUE,  TRUE,  TRUE,  NULL, 51, 'TX'),
            array(FALSE, FALSE, TRUE,  TRUE,  NULL, 51, 'TX'),
            array(NULL,  FALSE, FALSE, FALSE, NULL, 51, 'TX'),
            array(TRUE,  TRUE,  FALSE, FALSE, NULL, 51, 'TX'),
            array(FALSE, FALSE, FALSE, FALSE, NULL, 51, 'TX'),
            array(NULL,  FALSE, NULL,  FALSE, array('TEST_STATE' => array()), 1, 'TEST_STATE'),
            array(TRUE,  TRUE,  NULL,  FALSE, array('TEST_STATE' => array()), 1, 'TEST_STATE'),
            array(FALSE, FALSE, NULL,  FALSE, array('TEST_STATE' => array()), 1, 'TEST_STATE'),
            array(NULL,  FALSE, TRUE,  TRUE,  array('TEST_STATE' => array()), 1, 'TEST_STATE'),
            array(TRUE,  TRUE,  TRUE,  TRUE,  array('TEST_STATE' => array()), 1, 'TEST_STATE'),
            array(FALSE, FALSE, TRUE,  TRUE,  array('TEST_STATE' => array()), 1, 'TEST_STATE'),
            array(NULL,  FALSE, FALSE, FALSE, array('TEST_STATE' => array()), 1, 'TEST_STATE'),
            array(TRUE,  TRUE,  FALSE, FALSE, array('TEST_STATE' => array()), 1, 'TEST_STATE'),
            array(FALSE, FALSE, FALSE, FALSE, array('TEST_STATE' => array()), 1, 'TEST_STATE'),
        );
    }

    /**
     * @dataProvider rule_override_params
     */
    public function test_constructor_rule_override($verbose, $verboseTest, $caseInsensitive, $caseInsensitiveTest, $rules, $rulesLengthTest, $rulesKeyTest) {
        $options = array();

        if ($verbose !== NULL) {
            $options['verbose'] = $verbose;
        }
        if ($caseInsensitive !== NULL) {
            $options['caseInsensitive'] = $caseInsensitive;
        }
        if ($rules !== NULL) {
            $options['rules'] = $rules;
        }


        $validator = new \USDLRegex\Validator($options);

        $this->assertEquals($validator->verbose, $verboseTest);
        $this->assertEquals($validator->caseInsensitive, $caseInsensitiveTest);
        $this->assertEquals(gettype($validator->rules), 'array');
        $this->assertCount($rulesLengthTest, $validator->rules);
        $this->assertArrayHasKey($rulesKeyTest, $validator->rules);
    }

    public function test_validate() {
        $validator = new \USDLRegex\Validator();
        $this->assertTrue($validator->validate('TX', '12345678'));
    }

    public function test_validate_lowercase() {
        $validator = new \USDLRegex\Validator();
        $this->assertTrue($validator->validate('tx', '12345678'));
    }

    public function test_validate_output() {
        $validator = new \USDLRegex\Validator(array(
            'verbose' => TRUE,
            'rules' => array(
                'DUMMY_STATE' => array(
                    'rule' => "TEST_RULE",
                    'description' => array(
                        "I'm a description"
                    )
                )
            )
        ));
        $this->assertTrue($validator->validate('DUMMY_STATE', "TEST_RULE"));

        $this->expectOutputString("Validating TEST_RULE using rule TEST_RULE\n");
    }

    public function test_validate_output_failed() {
        $validator = new \USDLRegex\Validator(array(
            'verbose' => TRUE,
            'rules' => array(
                'DUMMY_STATE' => array(
                    'rule' => "TEST_RULE",
                    'description' => array(
                        "description1",
                        "description2"
                    )
                )
            )
        ));
        $this->assertFalse($validator->validate('DUMMY_STATE', "123"));
        $this->expectOutputRegex("/(\\n  description1\\n  description2\\n)+/");
    }

    public function test_getState() {
        $getState  = self::getMethod('__getState');
        $validator = new \USDLRegex\Validator(array(
            'rules' => array(
                'DUMMY_STATE' => array(
                    'rule' => "I'm a rule",
                    'description' => array(
                        "I'm a description"
                    )
                )
            )
        ));

        $state = $getState->invokeArgs($validator, array('DUMMY_STATE'));

        $this->assertArrayHasKey('rule', $state);
        $this->assertArrayHasKey('description', $state);
    }

    /**
     * @expectedException \USDLRegex\ValueException
     */
    public function test_getState_failure() {
        $getState  = self::getMethod('__getState');
        $validator = new \USDLRegex\Validator();

        $state = $getState->invokeArgs($validator, array());
    }

    /**
     * @expectedException \USDLRegex\StateNotFoundException
     */
    public function test_getState_not_found() {
        $getState  = self::getMethod('__getState');
        $validator = new \USDLRegex\Validator();

        $state = $getState->invokeArgs($validator, array('FAKE_STATE'));
    }

    public function test_getRule() {
        $getRule   = self::getMethod('__getRule');
        $validator = new \USDLRegex\Validator(array(
            'rules' => array(
                'DUMMY_STATE' => array(
                    'rule' => "I'm a rule",
                    'description' => array(
                        "I'm a description"
                    )
                )
            )
        ));

        $rule = $getRule->invokeArgs($validator, array('DUMMY_STATE'));

        $this->assertEquals("I'm a rule", $rule);
    }

    /**
     * @expectedException \USDLRegex\RuleFormatException
     */
    public function test_getRule_malformed() {
        $getRule   = self::getMethod('__getRule');
        $validator = new \USDLRegex\Validator(array(
            'rules' => array(
                'DUMMY_STATE' => array(
                    'description' => array(
                        "I'm a description"
                    )
                )
            )
        ));

        $rule = $getRule->invokeArgs($validator, array('DUMMY_STATE'));
    }

    public function test_getDescriptions() {
        $getDescriptions = self::getMethod('__getDescriptions');
        $validator = new \USDLRegex\Validator(array(
            'rules' => array(
                'DUMMY_STATE' => array(
                    'rule' => "I'm a rule",
                    'description' => array(
                        "I'm a description"
                    )
                )
            )
        ));

        $description = $getDescriptions->invokeArgs($validator, array('DUMMY_STATE'));

        $this->assertEquals(gettype($description), 'array');
        $this->assertEquals("I'm a description", $description[0]);
    }

    /**
     * @expectedException \USDLRegex\RuleFormatException
     */
    public function test_getDescription_malformed() {
        $getDescriptions   = self::getMethod('__getDescriptions');
        $validator = new \USDLRegex\Validator(array(
            'rules' => array(
                'DUMMY_STATE' => array(
                    'rule' => "I'm a rule",
                )
            )
        ));

        $rule = $getDescriptions->invokeArgs($validator, array('DUMMY_STATE'));
    }

    public function validatorFlagProvider() {
        return array(
            array(array('caseInsensitive' => FALSE), ''),
            array(array('caseInsensitive' => TRUE), 'i'),
        );
    }

    /**
     * @dataProvider validatorFlagProvider
     */
    public function test_getValidatorFlags($options, $expectedFlags) {
        $getValidatorFlags = self::getMethod('__getValidatorFlags');
        $validator = new \USDLRegex\Validator($options);

        $flagsString = $getValidatorFlags->invokeArgs($validator, array());

        $this->assertEquals($flagsString, $expectedFlags);
    }
}
