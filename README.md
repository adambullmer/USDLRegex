US Driver's License Regex Repository
=========

Below is a callback function for validating a dl field using CodeIgniter's `form_validation->set_rules()` function. If you are just interested in the array itself, feel free to copy and paste into your own code.

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
     * @FIELD: 'dl_state'
     * @FIELD-VALUE: 2 uppercase character state abbreviation
     ********************************************************/
    public function dl_format($string) {
      $dlformat = array(
        'AL'=>"^[0-9]{7}$", //7Numeric
        'AK'=>"^[0-9]{7}$", //7Numeric
        'AZ'=>"^[a-zA-Z0-9][0-9]{8}$", //1AlphaNumeric+8Numeric
        'AR'=>"^[0-9]{9}$", //9Numeric
        'CA'=>"^[a-zA-Z][0-9]{7}$", //1Alpha+7Numeric
        'CO'=>"^[0-9]{9}$", //9Numeric
        'CT'=>"^[0-9]{9}$", //9Numeric
        'DE'=>"^[0-9]{1,7}$", //1-7Numeric
        'DC'=>"^(([0-9]{7})|([0-9]{9}))$", //7Numeric or 9Numeric
        'FL'=>"^[a-zA-Z][0-9]{12}$", //1Alpha+12Numeric
        'GA'=>"^[0-9]{9}$", //9Numeric
        'HI'=>"^[a-zA-Z0-9][0-9]{8}$", //1AlphaNumeric+8Numeric
        'ID'=>"^([0-9]{9}|[a-zA-Z]{2}[0-9]{6}[a-zA-Z])$", //9Numeric or 2Alpha+6Numeric+1Alpha
        'IL'=>"^[a-zA-Z][0-9]{11}$", //1Alpha+11Numeric
        'IN'=>"^[0-9]{10}$", //10Numeric
        'IA'=>"^[0-9]{9}$", //9Numeric
        'KS'=>"^K[0-9]{8}$", //'K'+8Numeric
        'KY'=>"^[a-zA-Z0-9][0-9]{8}$", //1AlphaNumeric+8Numeric
        'LA'=>"^0[0-9]{8}$", //'0'+8Numeric
        'ME'=>"^[0-9]{7}$", //7Numeric
        'MD'=>"^[a-zA-Z][0-9]{12}$", //1Alpha+12Numeric
        'MA'=>"^[a-zA-Z][0-9]{8}$", //1Alpha+8Numeric
        'MI'=>"^[a-zA-Z][0-9]{12}$", //1Alpha+12Numeric
        'MN'=>"^[a-zA-Z][0-9]{12}$", //1Alpha+12Numeric
        'MS'=>"^[0-9]{9}$", //9Numeric
        'MO'=>"^([0-9]{9}|[a-zA-Z][0-9]{5,9})$", //9Numeric or 1Alpha+5-9Numeric
        'MT'=>"^([0-9]{9}|[0-9]{13})$", //9Numeric or 13Numeric
        'NE'=>"^[a-zA-Z][0-9]{3,8}$", //1Alpha+3-8Numeric
        'NV'=>"^[0-9]{10}$", //10Numeric
        'NH'=>"^[0-9]{2}[a-zA-Z]{3}[0-9]{5}$", //2Numeric+3Alpha+5Numeric
        'NJ'=>"^[a-zA-Z][0-9]{14}$", //1Alpha+14Numeric
        'NM'=>"^[0-9]{9}$", //9Numeric
        'NY'=>"^[0-9]{9}$", //9Numeric
        'NC'=>"^[0-9]{1,12}$", //1-12Numeric
        'ND'=>"^([0-9]{9}|[a-zA-Z]{3}[0-9]{6})$", //9Numeric or 3Alpha+6Numeric
        'OH'=>"^[a-zA-Z]{2}[0-9]{6}$", //2Alpha+6Numeric
        'OK'=>"^([0-9]{9}|[a-zA-Z0-9]{10})$", //9Numeric or 10AlphaNumeric
        'OR'=>"^[a-zA-Z0-9][0-9]{6}$", //1AlphaNumeric+6Numeric
        'PA'=>"^[0-9]{8}$", //8Numeric
        'RI'=>"^[a-zA-Z0-9][0-9]{6}$", //1AlphaNumeric+6Numeric
        'SC'=>"^[0-9]{11}$", //11Numeric
        'SD'=>"^[0-9]{6,9}$", //6-9Numeric
        'TN'=>"^[0-9]{7,9}$", //7-9Numeric
        'TX'=>"^[0-9]{8}$", //8Numeric
        'UT'=>"^[0-9]{4,10}$", //4-10Numeric
        'VT'=>"^[0-9]{7}[0-9a-zA-Z]$", //7Numeric+1AlphaNumeric
        'VA'=>"^[a-zA-Z0-9][0-9]{8}$", //1AlphaNumeric+8Numeric
        'WA'=>"^[a-zA-Z]{2}[a-zA-Z\*]{3}[a-zA-Z][a-zA-Z\*][0-9]{3}[a-zA-Z0-9]{2}$", //2Alpha + 3(Alpha or *) + 1Alpha + 1(Alpha or *) + 3Numeric + 2AlphaNumeric
        'WV'=>"^[a-zA-Z0-9]{7}$", //7AlphaNumeric
        'WI'=>"^[a-zA-Z][0-9]{13}$", //1Alpha+13Numeric
        'WY'=>"^[0-9]{6}-?[0-9]{3}$", //9Numeric or 6Numeric+'-'+3Numeric
      );
		
      if (!preg_match('/'.$dlformat[$this->input->post('dlstate')].'/', $string)) {
        $this->form_validation->set_message('dl_format', 'That does not appear to be a valid Driver\'s License');
        return FALSE;
      }
      else
        return TRUE;
    }
