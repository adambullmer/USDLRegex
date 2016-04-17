<?php
namespace USDLRegex;

$string = file_get_contents(__DIR__.'/../regex.json');
$rules = json_decode($string, TRUE);

/**
 * Validation class.
 */
class Validator {
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
            'verbose'         => FALSE,
            'caseInsensitive' => FALSE,
        );

        $options = array_merge($defaults, $options);

        $this->verbose         = $options['verbose'];
        $this->caseInsensitive = $options['caseInsensitive'];
    }

    /**
     * Takes the passed state to lookup the regex rules, and tries to match
     * in the provided string.
     *
     * @param  String $state     2 letter abbreviation of the state
     * @param  String $dl_string string representatino of the driver license number
     *
     * @return Bool              TRUE/FALSE if the number is valid
     */
    public function validate($state, $dl_string) {
        global $rules;

        $state = strtoupper($state);
        $rule = $rules[$state]['rule'];
        $regexFlags = '';

        if ($this->verbose === TRUE) {
            echo "Validating $dl_string using rule $rule\n";
        }

        if ($this->caseInsensitive === TRUE) {
            $regexFlags .= 'i';
        }

        if (!preg_match("/$rule/$regexFlags", $dl_string)) {
            if ($this->verbose === TRUE) {
                echo "Didn't match against the following criteria:\n";
                foreach ($rules[$state]['description'] as $description) {
                    echo "  $description \n";
                }
            }

            return FALSE;
        }

        return TRUE;
    }
}
