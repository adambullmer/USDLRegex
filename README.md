US Driver's License Regex Repository
====================================

Below is a callback function for validating a dl field using CodeIgniter's `form_validation->set_rules()` function. If you are just interested in the array itself, feel free to copy and paste into your own code.

```php
/********************************************************
 * @DESCRIPTION: validation for the format of a driver's
 *   license list as of 2012 US Driver's Licenses formats
 * @author: Adam Bullmer
 * @date: 04/04/2013
 *
 * @PARAM: $string, automatic input from form_validation()
 * @EXPECTED-INPUT: alpha-numeric, trimmed
 *
 * @REQUIREMENTS: It is required to validate the DL State
 * field FIRST in order for us to choose which regex rules
 * we will use.
 *
 * @FIELD: 'dl_state'
 * @FIELD-VALUE: 2 uppercase character state abbreviation
 ********************************************************/
public function dl_format($string) {
    $dlformat = array(
                // 1-7 Numbers
        'AL' => "^[0-9]{1,7}$",
                // 1-7 Numbers
        'AK' => "^[0-9]{1,7}$",
                // 1 Alpha + 1-8 Numeric
                // 2 Alpha + 2-5 Numeric
                // 9 Numeric
        'AZ' => "(^[a-zA-Z]{1}[0-9]{8}$)|(^[a-zA-Z]{2}[0-9]{2,5}$)|(^[0-9]{9}$)",
                // 4-9 Numeric
        'AR' => "^[0-9]{4,9}$",
                // 1 Alpha + 7 Numeric
        'CA' => "^[a-zA-Z]{1}[0-9]{7}$",
                // 9 Numeric
                // 1 Alpha + 3-6 Numeric
                // 2 Alpha + 2-5 Numeric
        'CO' => "(^[0-9]{9}$)|(^[a-zA-Z]{1}[0-9]{3,6}$)|(^[a-zA-Z]{2}[0-9]{2,5}$)",
                // 9 Numeric
        'CT' => "^[0-9]{9}$",
                // 1-7 Numeric
        'DE' => "^[0-9]{1,7}$",
                // 7 Numeric
                // 9 Numeric
        'DC' => "(^[0-9]{7}$)|(^[0-9]{9}$)",
                // 1 Alpha + 12 Numeric
        'FL' => "^[a-zA-Z]{1}[0-9]{12}$",
                // 7-9 Numeric
        'GA' => "^[0-9]{7,9}$",
                // 1 Alpha + 8 Numeric
                // 9 Numeric
        'HI' => "(^[a-zA-Z]{1}[0-9]{8}$)|(^[0-9]{9}$)",
                // 2 Alpha + 6 Numeric + 1 Alpha
                // 9 Numeric
        'ID' => "(^[a-zA-Z]{2}[0-9]{6}[a-zA-Z]{1}$)|(^[0-9]{9}$)",
                // 1 Alpha + 11-12 Numeric
        'IL' => "^[a-zA-Z]{1}[0-9]{11,12}$",
                // 1 Alpha + 9 Numeric
                // 9-10 Numeric
        'IN' => "(^[a-zA-Z]{1}[0-9]{9}$)|(^[0-9]{9,10}$)",
                // 9 Numeric
                // 3 Numeric + 2 Alpha + 4 Numeric
        'IA' => "^[0-9]{9}|([0-9]{3}[a-zA-Z]{2}[0-9]{4}$)",
                // 1 Alpha + 1 Numeric + 1 Alpha + 1 Numeric + 1 Alpha
                // 1 Alpha + 8 Numeric
                // 9 Numeric
        'KS' => "(^([a-zA-Z]{1}[0-9]{1}){2}[a-zA-Z]{1}$)|(^[a-zA-Z]{1}[0-9]{8}$)|(^[0-9]{9}$)",
                // 1 Alpha + 8-9 Numeric
                // 9 Numeric
        'KY' => "(^[a-zA_Z]{1}[0-9]{8,9}$)|(^[0-9]{9}$)",
                // 1-9 Numeric
        'LA' => "^[0-9]{1,9}$",
                // 7-8 Numeric
                // 7 Numeric + 1 Alpha
        'ME' => "(^[0-9]{7,8}$)|(^[0-9]{7}[a-zA-Z]{1}$)",
                // 1Alpha+12Numeric
        'MD' => "^[a-zA-Z]{1}[0-9]{12}$",
                // 1 Alpha + 8 Numeric
                // 9 Numeric
        'MA' => "(^[a-zA-Z]{1}[0-9]{8}$)|(^[0-9]{9}$)",
                // 1 Alpha + 10 Numeric
                // 1 Alpha + 12 Numeric
        'MI' => "(^[a-zA-Z]{1}[0-9]{10}$)|(^[a-zA-Z]{1}[0-9]{12}$)",
                // 1 Alpha + 12 Numeric
        'MN' => "^[a-zA-Z]{1}[0-9]{12}$",
                // 9 Numeric
        'MS' => "^[0-9]{9}$",
                // 1 Alpha + 5-9 Numeric
                // 1 Alpha + 6 Numeric + 'R'
                // 8 Numeric + 2 Alpha
                // 9 Numeric + 1 Alpha
                // 9 Numeric
        'MO' => "(^[a-zA-Z]{1}[0-9]{5,9}$)|(^[a-zA-Z]{1}[0-9]{6}[R]{1}$)|(^[0-9]{8}[a-zA-Z]{2}$)|(^[0-9]{9}[a-zA-Z]{1}$)|(^[0-9]{9}$)",
                // 1 Alpha + 8 Numeric
                // 13 Numeric
                // 9 Numeric
                // 14 Numeric
        'MT' => "(^[a-zA-Z]{1}[0-9]{8}$)|(^[0-9]{13}$)|(^[0-9]{9}$)|(^[0-9]{14}$)",
                // 1-7 Numeric
        'NE' => "^[0-9]{1,7}$",
                // 9 Numeric
                // 10 Numeric
                // 12 Numeric
                // 'X' + 8 Numeric
        'NV' => "(^[0-9]{9,10}$)|(^[0-9]{12}$)|(^[X]{1}[0-9]{8}$)",
                // 2 Numeric + 3 Alpha + 5 Numeric
        'NH' => "^[0-9]{2}[a-zA-Z]{3}[0-9]{5}$",
                // 1 Alpha + 14 Numeric
        'NJ' => "^[a-zA-Z]{1}[0-9]{14}$",
                // 8 Numeric
                // 9 Numeric
        'NM' => "^[0-9]{8,9}$",
                // 1 Alpha + 7 Numeric
                // 1 Alpha + 18 Numeric
                // 8 Numeric
                // 9 Numeric
                // 16 Numeric
                // 8 Alpha
        'NY' => "(^[a-zA-Z]{1}[0-9]{7}$)|(^[a-zA-Z]{1}[0-9]{18}$)|(^[0-9]{8}$)|(^[0-9]{9}$)|(^[0-9]{16}$)|(^[a-zA-Z]{8}$)",
                // 1-12 Numeric
        'NC' => "^[0-9]{1,12}$",
                // 3 Alpha + 6 Numeric
                // 9 Numeric
        'ND' => "(^[a-zA-Z]{3}[0-9]{6}$)|(^[0-9]{9}$)",
                // 1 Alpha + 4-8 Numeric
                // 2 Alpha + 3-7 Numeric
                // 8 Numeric
        'OH' => "(^[a-zA-Z]{1}[0-9]{4,8}$)|(^[a-zA-Z]{2}[0-9]{3,7}$)|(^[0-9]{8}$)",
                // 1 Alpha + 9 Numeric
                // 9 Numeric
        'OK' => "(^[a-zA-Z]{1}[0-9]{9}$)|(^[0-9]{9}$)",
                // 1-9 Numeric
        'OR' => "^[0-9]{1,9}$",
                // 8 Numeric
        'PA' => "^[0-9]{8}$",
                // 7 Numeric
                // 1 Alpha + 6 Numeric
        'RI' => "^([0-9]{7}$)|(^[a-zA-Z]{1}[0-9]{6}$)",
                // 5-11 Numeric
        'SC' => "^[0-9]{5,11}$",
                // 6-10 Numeric
                // 12 Numeric
        'SD' => "(^[0-9]{6,10}$)|(^[0-9]{12}$)",
                // 7-9 Numeric
        'TN' => "^[0-9]{7,9}$",
                // 7-8 Numeric
        'TX' => "^[0-9]{7,8}$",
                // 4-10 Numeric
        'UT' => "^[0-9]{4,10}$",
                // 8 Numeric
                // 7 Numeric + 'A'
        'VT' => "(^[0-9]{8}$)|(^[0-9]{7}[A]$)",
                // 1 Alpha + 9 Numeric
                // 1 Alpha + 10 Numeric
                // 1 Alpha + 11 Numeric
                // 9 Numeric
        'VA' => "(^[a-zA-Z]{1}[0-9]{9,11}$)|(^[0-9]{9}$)",
                // 1-7 Alpha + any combination of Alpha, Numeric,
                // * for a total of 12 characters
        'WA' => "^(?=.{12}$)[a-zA-Z]{1,7}[a-zA-Z0-9\*]{4,11}$",
                // 7 Numeric
                // 1-2 Alpha + 5-6 Numeric
        'WV' => "(^[0-9]{7}$)|(^[a-zA-Z]{1,2}[0-9]{5,6}$)",
                // 1 Alpha + 13 Numeric
        'WI' => "^[a-zA-Z]{1}[0-9]{13}$",
                // 9-10 Numeric
        'WY' => "^[0-9]{9,10}$",
    );

    if (!preg_match('/' . $dlformat[$this->input->post('dlstate')] . '/', $string)) {
        $this->form_validation->set_message('dl_format', 'That does not appear to be a valid Driver\'s License');
        return FALSE;
    }

    return TRUE;
}
```
