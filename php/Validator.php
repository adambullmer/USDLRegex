<?php
namespace USDLRegex;

/**
 * Validation class.
 */
class Validator {
    /**
     * Map of states and their rules
     * @var array
     */
    public $rules = array();

    /**
     * Flag for adding verbosity to output
     * @var boolean
     */
    public $verbose         = FALSE;

    /**
     * Flag for making regex comparisons case insensitive. e.g. the `i` flag
     * @var boolean
     */
    public $caseInsensitive = FALSE;

    function __construct($options = array()) {
        $defaults = array(
            'rules'           => json_decode(file_get_contents(__DIR__.'/../regex.json'), TRUE),
            'verbose'         => FALSE,
            'caseInsensitive' => FALSE,
        );

        $options = array_merge($defaults, $options);

        $this->rules           = $options['rules'];
        $this->verbose         = $options['verbose'];
        $this->caseInsensitive = $options['caseInsensitive'];
    }

    /**
     * Takes the passed state to lookup the regex rules, and tries to match
     * in the provided string.
     *
     * @param  String $state     2 letter abbreviation of the state
     * @param  String $dlString  string representatino of the driver license number
     *
     * @return Bool              TRUE/FALSE if the number is valid
     */
    public function validate($state, $dlString) {
        $rule       = $this->__getRule($state);
        $regexFlags = $this->__getValidatorFlags();

        if ($this->verbose === TRUE) {
            echo "Validating $dlString using rule $rule\n";
        }

        $isValid = (bool)preg_match("/$rule/$regexFlags", $dlString);

        if ($isValid === FALSE && $this->verbose === TRUE) {
            echo "Didn't match against the following criteria:\n";
            foreach ($this->__getDescriptions($state) as $description) {
                echo "  $description\n";
            }
        }

        return $isValid;
    }

    /**
     * Finds and returns the registered state definition.
     *
     * @param  String $key State to lookup rules for
     *
     * @return Array       Array of Rule and Descriptions
     *
     * @throws USDLRegex\ValueException         No State key was provided
     * @throws USDLRegex\StateNotFoundException Passed state doesn't exist in key
     */
    private function __getState($key=NULL) {
        if ($key === NULL) {
            throw new ValueException('Must provide a key to get a rule');
        }

        $key = strtoupper($key);

        if (!array_key_exists($key, $this->rules)) {
            throw new StateNotFoundException("State '$key' not found in rule set");
        }

        return $this->rules[$key];
    }

    /**
     * Finds and returns the validation rule for the state.
     *
     * @param  String $key State to lookup rules for
     *
     * @return String      String representation of regex
     *
     * @throws USDLRegex\RuleFormatException 'rule' key doesn't exist for the passed
     *                                       state.
     */
    private function __getRule($key=NULL) {
        $state = $this->__getState($key);

        if (!array_key_exists('rule', $state)) {
            throw new RuleFormatException("Malformed rules JSON: State '$key' does not have a 'rule' key.");
        }

        return $state['rule'];
    }

    /**
     * Finds and returns the list of friendly descriptions for the state rule regex.
     *
     * @param  String $key State to lookup rules for
     *
     * @return Array       Array of strings with friendly regex rules
     *
     * @throws USDLRegex\RuleFormatException 'description' key doesn't exist for the
     *                                       passed state.
     */
    private function __getDescriptions($key=NULL) {
        $state = $this->__getState($key);

        if (!array_key_exists('description', $state)) {
            throw new RuleFormatException("Malformed rules JSON: State '$key' does not have a 'description' key.");
        }

        return $state['description'];
    }

    /**
     * Compiles a list of regex directives to be used while validating.
     *
     * @return String string of regex directives
     */
    private function __getValidatorFlags() {
        $validatorFlags = '';

        if ($this->caseInsensitive === TRUE) {
            $validatorFlags .= 'i';
        }

        return $validatorFlags;
    }
}
